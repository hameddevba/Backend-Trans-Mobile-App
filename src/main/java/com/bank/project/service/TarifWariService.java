package com.bank.project.service;

import com.bank.project.dao.TarifWariRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarifWariService {

    @Autowired
    private TarifWariRepository tarifWariRepository;

    public List<Object[]> getTarifWari(String prefix, Double montant) {
        return tarifWariRepository.findTarifWari(prefix, montant);
    }
}
