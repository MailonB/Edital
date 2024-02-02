package com.example.demo.EditalControler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditalControler {


    @GetMapping("/")
    public String ListarEditais(){
        return "/Listar-Editais";
    }


}
