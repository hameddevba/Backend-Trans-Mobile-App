package com.bank.project.controller;

import com.bank.project.dto.EtatBCMBalanceGeneraleDto;
import com.bank.project.dto.EtatBCMFluxSortantsDto;
import com.bank.project.mapper.EtatBCMBalanceGeneraleMapper;
import com.bank.project.mapper.EtatBCMFluxSortantsMapper;
import com.bank.project.model.EtatBCMBalanceGenerale;
import com.bank.project.model.EtatBCMFluxSortants;
import com.bank.project.service.EtatBCMBalanceGeneraleService;
import com.bank.project.service.EtatBCMFluxSortantsService;
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
    private final EtatBCMFluxSortantsService etatBCMFluxSortantsService;

    private final EtatBCMFluxSortantsMapper mapper;

    public EtatBCMFluxSortantsController(
            @Autowired final EtatBCMFluxSortantsService etatBCMFluxSortantsService, @Autowired EtatBCMFluxSortantsMapper etatBCMFluxSortantsMapper) {
        this.etatBCMFluxSortantsService = etatBCMFluxSortantsService;
        this.mapper = etatBCMFluxSortantsMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCMFluxSortantsDto>> getAllEtatBCMFluxSortants() {
        List<EtatBCMFluxSortants> etatBCMFluxSortants = etatBCMFluxSortantsService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMFluxSortants));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCMFluxSortantsDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMFluxSortants etatBCMFluxSortants = etatBCMFluxSortantsService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMFluxSortants));
    }


}
