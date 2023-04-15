package com.bank.project.service;

import com.bank.project.dao.EtatBCM_OuvertureCreditDocumentaireDao;
import com.bank.project.model.EtatBCM_OuvertureCreditDocumentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCM_OuvertureCreditDocumentaireService {
    @Autowired
    private EtatBCM_OuvertureCreditDocumentaireDao etatBCM_OuvertureCreditDocumentaireDao;


    public List<EtatBCM_OuvertureCreditDocumentaire> findAll() {
        return etatBCM_OuvertureCreditDocumentaireDao.findAll(Sort.by("id"));
    }

    public EtatBCM_OuvertureCreditDocumentaire findById(final Long id) {
        return etatBCM_OuvertureCreditDocumentaireDao.findById(id).get();
    }

}
