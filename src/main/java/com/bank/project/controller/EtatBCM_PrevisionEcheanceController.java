package com.bank.project.controller;

import com.bank.project.dto.EtatBCM_PrevisionEcheanceDto;
import com.bank.project.mapper.EtatBCM_PrevisionEcheanceMapper;
import com.bank.project.model.EtatBCM_PrevisionEcheance;
import com.bank.project.service.EtatBCM_PrevisionEcheanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/etatBCM_PrevisionEcheance", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCM_PrevisionEcheanceController {
    private final EtatBCM_PrevisionEcheanceService etatBCM_PrevisionEcheanceService;

    private final EtatBCM_PrevisionEcheanceMapper mapper;

    public EtatBCM_PrevisionEcheanceController(
            @Autowired final EtatBCM_PrevisionEcheanceService etatBCM_PrevisionEcheanceService, @Autowired EtatBCM_PrevisionEcheanceMapper etatBCM_PrevisionEcheanceMapper) {
        this.etatBCM_PrevisionEcheanceService = etatBCM_PrevisionEcheanceService;
        this.mapper = etatBCM_PrevisionEcheanceMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCM_PrevisionEcheanceDto>> getAllEtatBCM_PrevisionEcheance() {
        List<EtatBCM_PrevisionEcheance> etatBCM_PrevisionEcheance = etatBCM_PrevisionEcheanceService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCM_PrevisionEcheance));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCM_PrevisionEcheanceDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCM_PrevisionEcheance etatBCM_PrevisionEcheance = etatBCM_PrevisionEcheanceService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCM_PrevisionEcheance));
    }


}
