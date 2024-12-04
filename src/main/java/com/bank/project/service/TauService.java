package com.bank.project.service;

import com.bank.project.dao.TauRepository;
import com.bank.project.dto.TauDTO;
import com.bank.project.model.Tau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TauService {

    @Autowired
    private TauRepository tauRepository;

    public List<TauDTO> getByCriteria(Double montant, String prefix) {
        return tauRepository.findByCriteria(montant, prefix);
    }
}

