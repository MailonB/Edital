package com.example.demo.Servico;

import com.example.demo.Model.Edital;
import com.example.demo.Repository.EditalRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditalServico {

    @Autowired
    private final EditalRepository editalRepository;

    public EditalServico(EditalRepository editalRepository) {
        this.editalRepository = editalRepository;
    }
    @Transactional
    public Edital SalvarEdital(Edital edital) {
            return editalRepository.saveAndFlush(edital);
        }

    public List<Edital> buscarTodosEditais() {
        return editalRepository.findAll();
    }

}

