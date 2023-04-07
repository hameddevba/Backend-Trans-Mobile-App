package com.bank.project.controller;

import com.bank.project.dto.EtatBCMBalanceGeneraleDto;
import com.bank.project.mapper.EtatBCMBalanceGeneraleMapper;
import com.bank.project.model.EtatBCMBalanceGenerale;
import com.bank.project.service.EtatBCMBalanceGeneraleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCMFluxSortants", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMFluxSortantsController {
    private final EtatBCMBalanceGeneraleService etatBCMBalanceGeneraleService;

    private final EtatBCMBalanceGeneraleMapper mapper;

    public EtatBCMFluxSortantsController(
            @Autowired final EtatBCMBalanceGeneraleService etatBCMBalanceGeneraleService, @Autowired EtatBCMBalanceGeneraleMapper etatBCMBalanceGeneraleMapper) {
        this.etatBCMBalanceGeneraleService = etatBCMBalanceGeneraleService;
        this.mapper = etatBCMBalanceGeneraleMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCMBalanceGeneraleDto>> getAllEtatBCMBalanceGenerales() {
        List<EtatBCMBalanceGenerale> etatBCMBalanceGenerales = etatBCMBalanceGeneraleService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMBalanceGenerales));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCMBalanceGeneraleDto> getEtatBCMBalanceGenerale(
            @PathVariable final Long id) {
        EtatBCMBalanceGenerale etatBCMBalanceGenerale = etatBCMBalanceGeneraleService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMBalanceGenerale));
    }


}
