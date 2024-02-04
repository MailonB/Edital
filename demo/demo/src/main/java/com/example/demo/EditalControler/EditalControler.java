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

    @Autowired
    public EditalControler(EditalServico editalServico) {
        this.editalServico = editalServico;
    }

    @PostMapping("/capturarEProcessar")
    public ResponseEntity<Void> capturarEProcessarInformacoes() throws IOException {
        Captura.iniciaCaptura();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<List<Edital>> buscarTodosEditais() {
        List<Edital> editais = editalServico.buscarTodosEditais();
        return new ResponseEntity<>(editais, HttpStatus.OK);
    }
}


