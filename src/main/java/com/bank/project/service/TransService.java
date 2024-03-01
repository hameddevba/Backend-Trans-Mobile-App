package com.bank.project.service;

import com.bank.project.dao.TransDao;
import com.bank.project.model.Envoyeur;
import com.bank.project.model.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransService {
    @Autowired
    private TransDao transDao;

    private EnvoyeurService envoyeurService;


    private BenefService benefService;

    public List<Trans> find() {
        return transDao.findAll();
    }

    public Trans findById(long id) {
        return transDao.findById(id).orElse(null);
    }

    public Trans save(Trans trans) {
        return transDao.save(trans);
    }

}
