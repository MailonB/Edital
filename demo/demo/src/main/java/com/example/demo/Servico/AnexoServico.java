package com.example.demo.Servico;

import com.example.demo.Model.Anexo;
import com.example.demo.Model.Edital;
import com.example.demo.Repository.AnexoRepository;
import com.example.demo.Repository.EditalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnexoServico {

    @Autowired
    private static AnexoRepository anexoRepository = new AnexoRepository();

    public AnexoServico(AnexoRepository anexoRepositor) {
        this.anexoRepository = anexoRepositor;
    }

    public static Edital SalvarAnexo(Anexo S){

        return anexoRepository.save(S);
    }


}
