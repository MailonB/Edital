package com.example.demo.EditalControler;

import com.example.demo.Captura;
import com.example.demo.Model.Edital;
import com.example.demo.Servico.EditalServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@Controller
public class EditalControler {
    @Autowired
    private final EditalServico editalServico;
    private final Captura captura;

    @Autowired
    public EditalControler(EditalServico editalServico, Captura captura) {
        this.editalServico = editalServico;
        this.captura = captura;
    }

    @PostMapping("/capturarEProcessar")
    public ResponseEntity<Void> capturarEProcessarInformacoes() throws IOException {
        Captura.iniciaCaptura();
        System.out.println("iniciou a captura");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Edital>> buscarTodosEditais() {
        List<Edital> editais = editalServico.buscarTodosEditais();
        return new ResponseEntity<>(editais, HttpStatus.OK);
    }
}


