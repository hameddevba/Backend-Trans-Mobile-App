package com.bank.project.controller;

import com.bank.project.model.Caisse;
import com.bank.project.service.CaisseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CaisseController {

    @Autowired
    private CaisseService service;

    @GetMapping("/ca-modif-tau/{causcode}")
    public Caisse getCAModifTau(@PathVariable int causcode) {
        return service.getCAModifTauByCAUSCODE(causcode);
    }
}
