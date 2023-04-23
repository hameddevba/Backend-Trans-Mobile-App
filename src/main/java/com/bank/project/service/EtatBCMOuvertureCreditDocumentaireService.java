package com.bank.project.service;

import com.bank.project.dao.EtatBCMOuvertureCreditDocumentaireDao;
import com.bank.project.model.EtatBCMOuvertureCreditDocumentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCMOuvertureCreditDocumentaireService {
    @Autowired
    private EtatBCMOuvertureCreditDocumentaireDao etatBCMOuvertureCreditDocumentaireDao;


    public List<EtatBCMOuvertureCreditDocumentaire> findAll() {
        return etatBCMOuvertureCreditDocumentaireDao.findAll(Sort.by("id"));
    }

    public EtatBCMOuvertureCreditDocumentaire findById(final Long id) {
        return etatBCMOuvertureCreditDocumentaireDao.findById(id).get();
    }

}
