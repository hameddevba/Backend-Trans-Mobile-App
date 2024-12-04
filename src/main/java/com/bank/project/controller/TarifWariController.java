package com.bank.project.controller;

import com.bank.project.service.TarifWariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TarifWariController {

    @Autowired
    private TarifWariService tarifWariService;

    @GetMapping("/api/tarif-wari")
    public List<Object[]> getTarifWari(
            @RequestParam String prefix,
            @RequestParam Double montant) {
        return tarifWariService.getTarifWari(prefix, montant);
    }
}
