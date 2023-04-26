package com.bank.project.controller;

import com.bank.project.dto.ReleveDesComptesCorrespondantsDto;
import com.bank.project.mapper.ReleveDesComptesCorrespondantsMapper;
import com.bank.project.mapper.ReleveDesComptesCorrespondantsPublishMapper;
import com.bank.project.model.EtatBCMReleveDesComptesCorrespondants;
import com.bank.project.service.EtatBCMReleveDesComptesCorrespondantsService;
import com.bank.project.service.PublishService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCM_ReleveDesComptesCorrespondants", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMReleveDesComptesCorrespondantsController {
    private final EtatBCMReleveDesComptesCorrespondantsService etatBCMReleveDesComptesCorrespondantsService;

    private final ReleveDesComptesCorrespondantsMapper mapper;

    private final PublishService publishService;
    private final ReleveDesComptesCorrespondantsPublishMapper publishMapper;

    public EtatBCMReleveDesComptesCorrespondantsController(EtatBCMReleveDesComptesCorrespondantsService etatBCMReleveDesComptesCorrespondantsService,
                                                           ReleveDesComptesCorrespondantsMapper mapper, PublishService publishService,
                                                           ReleveDesComptesCorrespondantsPublishMapper publishMapper) {
        this.etatBCMReleveDesComptesCorrespondantsService = etatBCMReleveDesComptesCorrespondantsService;
        this.mapper = mapper;
        this.publishService = publishService;
        this.publishMapper = publishMapper;
    }

    @GetMapping
    public ResponseEntity<List<ReleveDesComptesCorrespondantsDto>> getAllEtatBCMReleveDesComptesCorrespondants() {
        List<EtatBCMReleveDesComptesCorrespondants> etatBCMReleveDesComptesCorrespondants = etatBCMReleveDesComptesCorrespondantsService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMReleveDesComptesCorrespondants));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReleveDesComptesCorrespondantsDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMReleveDesComptesCorrespondants etatBCMReleveDesComptesCorrespondants = etatBCMReleveDesComptesCorrespondantsService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMReleveDesComptesCorrespondants));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMReleveDesComptesCorrespondants> etatBCMPrevisionEcheances = etatBCMReleveDesComptesCorrespondantsService.findAll();
        boolean published = publishService.publishEtatBCMReleveDesComptesCorrespondants(publishMapper.toDto(etatBCMPrevisionEcheances));
        return ResponseEntity.ok(published);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody ReleveDesComptesCorrespondantsDto releveDesComptesCorrespondantsDto) {
        return ResponseEntity.ok(etatBCMReleveDesComptesCorrespondantsService.update(this.mapper.toModel(releveDesComptesCorrespondantsDto)));
    }

}
