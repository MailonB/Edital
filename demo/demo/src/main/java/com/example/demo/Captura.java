package com.example.demo;

import com.example.demo.EditalControler.HttpRequester;
import com.example.demo.Model.Anexo;
import com.example.demo.Model.Edital;
import com.example.demo.Portal.Floripa;
import com.example.demo.Repository.AnexoRepository;
import com.example.demo.Repository.EditalRepository;
import com.example.demo.Servico.AnexoServico;
import com.example.demo.Servico.EditalServico;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpResponse;

import static com.example.demo.EditalControler.Util.*;
import static com.example.demo.Portal.Floripa.*;

@Component
public class Captura {


    private static EditalRepository editalRepository;
    private static EditalServico editalServico;

    private static AnexoRepository anexoRepository;
    private static AnexoServico anexoServico;

    @Autowired
    public Captura(EditalRepository editalRepository, EditalServico editalServico,
                   AnexoRepository anexoRepository, AnexoServico anexoServico) {
        this.editalRepository = editalRepository;
        this.editalServico = editalServico;
        this.anexoRepository = anexoRepository;
        this.anexoServico = anexoServico;
    }
    public static void iniciaCaptura() throws IOException {



        // carregar html principal
        String urlHome = "https://wbc.pmf.sc.gov.br/Portal/Mural.aspx?nNmTela=E";
        HttpRequester client = new HttpRequester();
        HttpResponse<String> response = client.get(urlHome);

        // fazer o parser do html
        Document document = toParser(response.body());

        // requisita os processos
        String urlPesquisa = "https://wbc.pmf.sc.gov.br/Portal/WebService/Servicos.asmx/PesquisarProcessosPorSituacoesAgrupadas";
        response = client.post(urlPesquisa, getParams());

        // fazer o parser do json
        JsonObject processos = toJSON(response.body());

        // iterar os processos e requisitar os anexos
        for (JsonElement element : processos.get("d").getAsJsonArray()) {
            JsonObject editais = element.getAsJsonObject();



            // requisitar os detalhes do edital
            String urlDetalhe = "https://wbc.pmf.sc.gov.br/portal/WebService/Servicos.asmx/PesquisarProcessoDetalhes";
            response = client.post(urlDetalhe, getParamDetalhe(editais.get("nCdProcesso").getAsInt()));

            JsonObject processosDet = toJSON(response.body());
            JsonObject editalDet = processosDet.get("d").getAsJsonObject();


            Edital edital = new Edital();

            edital.setLicitacao(editalDet.get("nCdProcesso").getAsInt());
            edital.setEdital(editalDet.get("sNrEdital").getAsString());
            edital.setObjeto(editalDet.get("sDsObjeto").getAsString());
            edital.setModalidade(editalDet.get("sNmModalidade").getAsString());
            edital.setTipo(editalDet.get("sNmModalidadeTipo").getAsString());
            edital.setDtPublicacao(dateToString(editalDet.get("tDtPublicacao").getAsString()));
            edital.setPortal(Floripa.getNomePortal());

            editalServico.SalvarEdital(edital);




            // Buscar os anexos de cada edital
            // tem o parametro nCdEdital: 981 que tem que ser mandado na requisição

            String urlAnexos = "https://wbc.pmf.sc.gov.br/portal/WebService/Servicos.asmx/PesquisarAnexos";
            response = client.post(urlAnexos, getParamsAnexos(editalDet.get("nCdAnexo").getAsInt(),
                    editalDet.get("nCdModulo").getAsInt(),
                    editalDet.get("nCdOrigem").getAsInt()));


            JsonObject anexo = toJSON(response.body());

            for (JsonElement elementAnexo : anexo.get("d").getAsJsonArray()) {
                JsonObject anexos = elementAnexo.getAsJsonObject();

                //Criando o anexo e enviando pro banco
                Anexo ane = new Anexo(anexos.get("sNmArquivo").getAsString(),anexos.get("sDsParametroCriptografado").getAsString(),editalDet.get("nCdProcesso").getAsInt());

                AnexoServico.SalvarAnexo(ane);


            }
        }

    }


}
