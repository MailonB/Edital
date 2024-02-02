package com.example.demo.Servico;

import com.example.demo.Model.Edital;
import com.example.demo.Repository.EditalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditalServico {

    @Autowired
    private EditalRepository editalRepository;

    public Edital SalvarEdital(Edital edital){

        return editalRepository.save(edital);
    }


}