package com.bank.project.service;

import com.bank.project.dao.EtatBCMFluxEntrantsDao;
import com.bank.project.model.EtatBCMFluxEntrants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCFluxEntrantsService {
    @Autowired
    private EtatBCMFluxEntrantsDao etatBCMFluxEntrantsDao;


    public List<EtatBCMFluxEntrants> findAll() {
        return etatBCMFluxEntrantsDao.findAll(Sort.by("id"));
    }

    public EtatBCMFluxEntrants findById(final Long id) {
        return etatBCMFluxEntrantsDao.findById(id).get();
    }

}
