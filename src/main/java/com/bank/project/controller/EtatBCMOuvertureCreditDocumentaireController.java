package com.bank.project.controller;

import com.bank.project.dto.FluxSortantsDto;
import com.bank.project.dto.OuvertureCreditDocumentaireDto;
import com.bank.project.mapper.OuvertureCreditDocumentaireMapper;
import com.bank.project.mapper.OuvertureCreditDocumentairePublishMapper;
import com.bank.project.model.EtatBCMFluxSortants;
import com.bank.project.model.EtatBCMOuvertureCreditDocumentaire;
import com.bank.project.service.EtatBCMFluxSortantsService;
import com.bank.project.service.EtatBCMOuvertureCreditDocumentaireService;
import com.bank.project.service.PublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_OuvertureCreditDocumentaire", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMOuvertureCreditDocumentaireController {
    private final EtatBCMOuvertureCreditDocumentaireService etatBCMOuvertureCreditDocumentaireService;

    private final OuvertureCreditDocumentaireMapper mapper;
    private final OuvertureCreditDocumentairePublishMapper publishMapper;

    private final PublishService publishService;

    public EtatBCMOuvertureCreditDocumentaireController(EtatBCMOuvertureCreditDocumentaireService etatBCMOuvertureCreditDocumentaireService, OuvertureCreditDocumentaireMapper mapper, OuvertureCreditDocumentairePublishMapper publishMapper, PublishService publishService) {
        this.etatBCMOuvertureCreditDocumentaireService = etatBCMOuvertureCreditDocumentaireService;
        this.mapper = mapper;
        this.publishMapper = publishMapper;
        this.publishService = publishService;
    }

    @GetMapping
    public ResponseEntity<List<OuvertureCreditDocumentaireDto>> getAllEtatBCMOuvertureCreditDocumentaire() {
        List<EtatBCMOuvertureCreditDocumentaire> etatBCMOuvertureCreditDocumentaire = etatBCMOuvertureCreditDocumentaireService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMOuvertureCreditDocumentaire));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OuvertureCreditDocumentaireDto> getEtatBCMOuvertureCreditDocumentaire(
            @PathVariable final Long id) {
        EtatBCMOuvertureCreditDocumentaire etatBCMOuvertureCreditDocumentaire = etatBCMOuvertureCreditDocumentaireService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMOuvertureCreditDocumentaire));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMOuvertureCreditDocumentaire> etatBCMOuvertureCreditDocumentaire = etatBCMOuvertureCreditDocumentaireService.findAll();
        boolean published = publishService.publishOuvertureCreditDocumentaire(publishMapper.toDto(etatBCMOuvertureCreditDocumentaire));
        return ResponseEntity.ok(published);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody OuvertureCreditDocumentaireDto ouvertureCreditDocumentaireDto) {
        return ResponseEntity.ok(etatBCMOuvertureCreditDocumentaireService.update(this.mapper.toModel(ouvertureCreditDocumentaireDto)));
    }

}
