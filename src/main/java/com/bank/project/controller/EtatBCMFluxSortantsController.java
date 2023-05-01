package com.bank.project.controller;

import com.bank.project.dto.FluxSortantsDto;
import com.bank.project.mapper.FluxSortantsMapper;
import com.bank.project.mapper.FluxSortantsPublishMapper;
import com.bank.project.model.EtatBCMFluxSortants;
import com.bank.project.service.EtatBCMFluxSortantsService;
import com.bank.project.service.PublishService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCMFluxSortants", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMFluxSortantsController {
    private final EtatBCMFluxSortantsService etatBCMFluxSortantsService;

    private final FluxSortantsMapper mapper;
    private final FluxSortantsPublishMapper publishMapper;

    private final PublishService publishService;

    public EtatBCMFluxSortantsController(EtatBCMFluxSortantsService etatBCMFluxSortantsService, FluxSortantsMapper mapper, FluxSortantsPublishMapper publishMapper, PublishService publishService) {
        this.etatBCMFluxSortantsService = etatBCMFluxSortantsService;
        this.mapper = mapper;
        this.publishMapper = publishMapper;
        this.publishService = publishService;
    }


    @GetMapping
    public ResponseEntity<List<FluxSortantsDto>> getAllEtatBCMFluxSortants() {
        List<EtatBCMFluxSortants> etatBCMFluxSortants = etatBCMFluxSortantsService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMFluxSortants));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FluxSortantsDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMFluxSortants etatBCMFluxSortants = etatBCMFluxSortantsService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMFluxSortants));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMFluxSortants> etatBCMFluxSortants = etatBCMFluxSortantsService.findAll();
        boolean published = publishService.publishFluxSortant(publishMapper.toDto(etatBCMFluxSortants));
        return ResponseEntity.ok(published);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody FluxSortantsDto fluxSortantsDto) {
        return ResponseEntity.ok(etatBCMFluxSortantsService.update(this.mapper.toModel(fluxSortantsDto)));
    }

}
