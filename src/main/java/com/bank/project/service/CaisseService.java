package com.bank.project.service;

import com.bank.project.dao.CaisseDao;
import com.bank.project.model.Caisse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaisseService {

    @Autowired
    private CaisseDao repository;

    public Caisse getCAModifTauByCAUSCODE(int CAUSCODE) {
        Caisse entity = repository.findByCAUSCODE(CAUSCODE);
        return entity ;
    }
}
