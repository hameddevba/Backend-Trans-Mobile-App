package com.bank.project.controller;

import com.bank.project.dto.EtatBCM_Flux_EntrantsDto;
import com.bank.project.mapper.EtatBCM_Flux_EntrantsMapper;
import com.bank.project.model.EtatBCM_Flux_Entrants;
import com.bank.project.service.EtatBCM_Flux_EntrantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/etatBCM_Flux_Entrants", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCM_Flux_EntrantsController {
    private final EtatBCM_Flux_EntrantsService etatBCM_Flux_EntrantsService;

    private final EtatBCM_Flux_EntrantsMapper mapper;

    public EtatBCM_Flux_EntrantsController(
            @Autowired final EtatBCM_Flux_EntrantsService etatBCM_Flux_EntrantsService, @Autowired EtatBCM_Flux_EntrantsMapper etatBCM_Flux_EntrantsMapper) {
        this.etatBCM_Flux_EntrantsService = etatBCM_Flux_EntrantsService;
        this.mapper = etatBCM_Flux_EntrantsMapper;
    }

    @GetMapping
    public ResponseEntity<List<EtatBCM_Flux_EntrantsDto>> getAllEtatBCM_Flux_Entrants() {
        List<EtatBCM_Flux_Entrants> etatBCM_Flux_Entrants = etatBCM_Flux_EntrantsService.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCM_Flux_Entrants));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatBCM_Flux_EntrantsDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCM_Flux_Entrants etatBCM_Flux_Entrants = etatBCM_Flux_EntrantsService.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCM_Flux_Entrants));
    }


}
