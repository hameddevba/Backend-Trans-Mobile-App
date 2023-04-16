package com.bank.project.controller;

import com.bank.project.dto.EtatBCM_ReleveDesComptesCorrespondantsDto;
import com.bank.project.mapper.EtatBCM_ReleveDesComptesCorrespondantsMapper;
import com.bank.project.model.EtatBCM_ReleveDesComptesCorrespondants;
import com.bank.project.service.EtatBCM_ReleveDesComptesCorrespondantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/etatBCM_ReleveDesComptesCorrespondants", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCM_ReleveDesComptesCorrespondantsController {
    private final EtatBCM_ReleveDesComptesCorrespondantsService etatBCM_ReleveDesComptesCorrespondantsService;

    private final EtatBCM_ReleveDesComptesCorrespondantsMapper mapper;

    public EtatBCM_ReleveDesComptesCorrespondantsController(
            @Autowired final EtatBCM_ReleveDesComptesCorrespondantsService etatBCM_ReleveDesComptesCorrespondantsService, @Autowired EtatBCM_ReleveDesComptesCorrespondantsMapper etatBCM_ReleveDesComptesCorrespondantsMapper) {
        this.etatBCM_ReleveDesComptesCorrespondantsService = etatBCM_ReleveDesComptesCorrespondantsService;
        this.mapper = etatBCM_ReleveDesComptesCorrespondantsMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCM_ReleveDesComptesCorrespondantsDto>> getAllEtatBCM_ReleveDesComptesCorrespondants() {
        List<EtatBCM_ReleveDesComptesCorrespondants> etatBCM_ReleveDesComptesCorrespondants = etatBCM_ReleveDesComptesCorrespondantsService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCM_ReleveDesComptesCorrespondants));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCM_ReleveDesComptesCorrespondantsDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCM_ReleveDesComptesCorrespondants etatBCM_ReleveDesComptesCorrespondants = etatBCM_ReleveDesComptesCorrespondantsService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCM_ReleveDesComptesCorrespondants));
    }


}
