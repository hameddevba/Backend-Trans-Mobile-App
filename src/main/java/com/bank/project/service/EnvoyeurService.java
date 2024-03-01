package com.bank.project.service;

import com.bank.project.dao.BenefDao;
import com.bank.project.dao.EnvoyeurDao;
import com.bank.project.model.Benef;
import com.bank.project.model.Envoyeur;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EnvoyeurService {
    @Autowired
    private EnvoyeurDao envoyeurDao;

    public Envoyeur save(Envoyeur envoyeur) {
        return envoyeurDao.save(envoyeur);
    }
    public List<Envoyeur> findAll() {
        return envoyeurDao.findAll();
    }
}
