package com.bank.project.controller;

import com.bank.project.dto.JourneePublicDto;
import com.bank.project.dto.UserDetailDto;
import com.bank.project.mapper.EtatBCMJourneePublicMapper;
import com.bank.project.model.EtatBCMJourneePublic;
import com.bank.project.model.User;
import com.bank.project.service.EtatBCMJourneePublicService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCMJourneePublic", produces = MediaType.APPLICATION_JSON_VALUE)
public class EtatBCMJourneePublicController {
    private final EtatBCMJourneePublicService service;

    private final EtatBCMJourneePublicMapper mapper;

    public EtatBCMJourneePublicController(EtatBCMJourneePublicService service, EtatBCMJourneePublicMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public ResponseEntity<List<JourneePublicDto>> getAllJournees() {
        List<EtatBCMJourneePublic> etatBCMJourneePublic = service.findAll();
        return ResponseEntity.ok(mapper.toDto(etatBCMJourneePublic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<JourneePublicDto> getEtatBCMJourneePublic(
            @PathVariable final Long id) {
        EtatBCMJourneePublic etatBCMJourneePublic = service.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMJourneePublic));
    }

}
