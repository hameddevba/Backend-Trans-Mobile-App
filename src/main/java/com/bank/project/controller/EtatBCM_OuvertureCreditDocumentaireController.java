package com.bank.project.controller;

import com.bank.project.dto.EtatBCM_OuvertureCreditDocumentaireDto;
import com.bank.project.mapper.EtatBCM_OuvertureCreditDocumentaireMapper;
import com.bank.project.model.EtatBCM_OuvertureCreditDocumentaire;
import com.bank.project.service.EtatBCM_OuvertureCreditDocumentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/etatBCM_OuvertureCreditDocumentaire", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCM_OuvertureCreditDocumentaireController {
    private final EtatBCM_OuvertureCreditDocumentaireService etatBCM_OuvertureCreditDocumentaireService;

    private final EtatBCM_OuvertureCreditDocumentaireMapper mapper;

    public EtatBCM_OuvertureCreditDocumentaireController(
            @Autowired final EtatBCM_OuvertureCreditDocumentaireService etatBCM_OuvertureCreditDocumentaireService, @Autowired EtatBCM_OuvertureCreditDocumentaireMapper etatBCM_OuvertureCreditDocumentaireMapper) {
        this.etatBCM_OuvertureCreditDocumentaireService = etatBCM_OuvertureCreditDocumentaireService;
        this.mapper = etatBCM_OuvertureCreditDocumentaireMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCM_OuvertureCreditDocumentaireDto>> getAllEtatBCM_OuvertureCreditDocumentaire() {
        List<EtatBCM_OuvertureCreditDocumentaire> etatBCM_OuvertureCreditDocumentaire = etatBCM_OuvertureCreditDocumentaireService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCM_OuvertureCreditDocumentaire));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCM_OuvertureCreditDocumentaireDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCM_OuvertureCreditDocumentaire etatBCM_OuvertureCreditDocumentaire = etatBCM_OuvertureCreditDocumentaireService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCM_OuvertureCreditDocumentaire));
    }


}
