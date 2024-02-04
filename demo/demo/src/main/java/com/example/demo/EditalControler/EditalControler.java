package com.example.demo.EditalControler;

import com.example.demo.Captura;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class EditalControler {


    @GetMapping("/")
    public String ListarEditais(){

        return "/Listar-Editais";
    }

    @GetMapping("/BuscarEditais")
    public static boolean  BuscarEditais() throws IOException {
        Captura captura = new Captura();

        captura.iniciaCaptura();

        return true;
    }

}
