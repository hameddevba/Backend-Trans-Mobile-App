package com.bank.project.service;

import com.bank.project.dao.EtatBCMFluxSortantsDao;
import com.bank.project.model.EtatBCMFluxSortants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EtatBCMFluxSortantsService {
    @Autowired
    private EtatBCMFluxSortantsDao etatBCMFluxSortantsDao;


    public List<EtatBCMFluxSortants> findAll() {
        return etatBCMFluxSortantsDao.findAll(Sort.by("id"));
    }

    public EtatBCMFluxSortants findById(final Long id) {
        return etatBCMFluxSortantsDao.findById(id).get();
    }

}
