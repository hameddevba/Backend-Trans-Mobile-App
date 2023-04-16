package com.bank.project.service;

import com.bank.project.dao.EtatBCM_Flux_EntrantsDao;
import com.bank.project.model.EtatBCM_Flux_Entrants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCM_Flux_EntrantsService {
    @Autowired
    private EtatBCM_Flux_EntrantsDao etatBCM_Flux_EntrantsDao;


    public List<EtatBCM_Flux_Entrants> findAll() {
        return etatBCM_Flux_EntrantsDao.findAll(Sort.by("id"));
    }

    public EtatBCM_Flux_Entrants findById(final Long id) {
        return etatBCM_Flux_EntrantsDao.findById(id).get();
    }

}
