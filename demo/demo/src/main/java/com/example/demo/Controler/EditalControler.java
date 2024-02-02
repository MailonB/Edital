package com.example.demo.Controler;

import com.example.demo.Model.Edital;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Editais")
public class EditalControler {

    @GetMapping
    public List<Edital> listarEditais(){



        return ;
    }

}
