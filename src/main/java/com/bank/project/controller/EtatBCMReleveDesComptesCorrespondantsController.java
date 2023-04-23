package com.bank.project.controller;

import com.bank.project.dto.EtatBCMReleveDesComptesCorrespondantsDto;
import com.bank.project.mapper.EtatBCMReleveDesComptesCorrespondantsMapper;
import com.bank.project.model.EtatBCMReleveDesComptesCorrespondants;
import com.bank.project.service.EtatBCMReleveDesComptesCorrespondantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_ReleveDesComptesCorrespondants", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMReleveDesComptesCorrespondantsController {
    private final EtatBCMReleveDesComptesCorrespondantsService etatBCMReleveDesComptesCorrespondantsService;

    private final EtatBCMReleveDesComptesCorrespondantsMapper mapper;

    public EtatBCMReleveDesComptesCorrespondantsController(
            @Autowired final EtatBCMReleveDesComptesCorrespondantsService etatBCMReleveDesComptesCorrespondantsService, @Autowired EtatBCMReleveDesComptesCorrespondantsMapper etatBCMReleveDesComptesCorrespondantsMapper) {
        this.etatBCMReleveDesComptesCorrespondantsService = etatBCMReleveDesComptesCorrespondantsService;
        this.mapper = etatBCMReleveDesComptesCorrespondantsMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCMReleveDesComptesCorrespondantsDto>> getAllEtatBCMReleveDesComptesCorrespondants() {
        List<EtatBCMReleveDesComptesCorrespondants> etatBCMReleveDesComptesCorrespondants = etatBCMReleveDesComptesCorrespondantsService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMReleveDesComptesCorrespondants));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCMReleveDesComptesCorrespondantsDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMReleveDesComptesCorrespondants etatBCMReleveDesComptesCorrespondants = etatBCMReleveDesComptesCorrespondantsService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMReleveDesComptesCorrespondants));
    }


}
