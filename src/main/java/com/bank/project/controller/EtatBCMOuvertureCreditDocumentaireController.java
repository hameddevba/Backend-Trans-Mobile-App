package com.bank.project.controller;

import com.bank.project.dto.EtatBCMOuvertureCreditDocumentaireDto;
import com.bank.project.mapper.EtatBCMOuvertureCreditDocumentaireMapper;
import com.bank.project.model.EtatBCMOuvertureCreditDocumentaire;
import com.bank.project.service.EtatBCMOuvertureCreditDocumentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_OuvertureCreditDocumentaire", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMOuvertureCreditDocumentaireController {
    private final EtatBCMOuvertureCreditDocumentaireService etatBCMOuvertureCreditDocumentaireService;

    private final EtatBCMOuvertureCreditDocumentaireMapper mapper;

    public EtatBCMOuvertureCreditDocumentaireController(
            @Autowired final EtatBCMOuvertureCreditDocumentaireService etatBCMOuvertureCreditDocumentaireService, @Autowired EtatBCMOuvertureCreditDocumentaireMapper etatBCMOuvertureCreditDocumentaireMapper) {
        this.etatBCMOuvertureCreditDocumentaireService = etatBCMOuvertureCreditDocumentaireService;
        this.mapper = etatBCMOuvertureCreditDocumentaireMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCMOuvertureCreditDocumentaireDto>> getAllEtatBCMOuvertureCreditDocumentaire() {
        List<EtatBCMOuvertureCreditDocumentaire> etatBCMOuvertureCreditDocumentaire = etatBCMOuvertureCreditDocumentaireService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMOuvertureCreditDocumentaire));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCMOuvertureCreditDocumentaireDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMOuvertureCreditDocumentaire etatBCMOuvertureCreditDocumentaire = etatBCMOuvertureCreditDocumentaireService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMOuvertureCreditDocumentaire));
    }


}
