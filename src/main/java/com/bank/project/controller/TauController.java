package com.bank.project.controller;

import com.bank.project.dto.TauDTO;
import com.bank.project.model.Tau;
import com.bank.project.service.TauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TauController {

    @Autowired
    private TauService tauService;

    @GetMapping("/api/tau")
    public List<TauDTO> getByCriteria(
            @RequestParam Double montant,
            @RequestParam String prefix) {
        return tauService.getByCriteria(montant, prefix);
    }
}


