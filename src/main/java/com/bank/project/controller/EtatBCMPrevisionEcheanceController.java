package com.bank.project.controller;

import com.bank.project.dto.EtatBCMPrevisionEcheanceDto;
import com.bank.project.mapper.EtatBCMPrevisionEcheanceMapper;
import com.bank.project.model.EtatBCMPrevisionEcheance;
import com.bank.project.service.EtatBCMPrevisionEcheanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_PrevisionEcheance", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMPrevisionEcheanceController {
    private final EtatBCMPrevisionEcheanceService etatBCMPrevisionEcheanceService;

    private final EtatBCMPrevisionEcheanceMapper mapper;

    public EtatBCMPrevisionEcheanceController(
            @Autowired final EtatBCMPrevisionEcheanceService etatBCMPrevisionEcheanceService, @Autowired EtatBCMPrevisionEcheanceMapper etatBCMPrevisionEcheanceMapper) {
        this.etatBCMPrevisionEcheanceService = etatBCMPrevisionEcheanceService;
        this.mapper = etatBCMPrevisionEcheanceMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCMPrevisionEcheanceDto>> getAllEtatBCMPrevisionEcheance() {
        List<EtatBCMPrevisionEcheance> etatBCMPrevisionEcheance = etatBCMPrevisionEcheanceService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMPrevisionEcheance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCMPrevisionEcheanceDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMPrevisionEcheance etatBCMPrevisionEcheance = etatBCMPrevisionEcheanceService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMPrevisionEcheance));
    }


}
