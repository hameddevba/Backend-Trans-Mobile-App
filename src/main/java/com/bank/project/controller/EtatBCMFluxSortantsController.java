package com.bank.project.controller;

import com.bank.project.dto.FluxSortantsDto;
import com.bank.project.dto.PagebaleDataDto;
import com.bank.project.mapper.FluxSortantsMapper;
import com.bank.project.mapper.FluxSortantsPublishMapper;
import com.bank.project.model.EtatBCMFluxSortants;
import com.bank.project.service.EtatBCMFluxSortantsService;
import com.bank.project.service.PublishService;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/api/etatBCMFluxSortants", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasRole('ADMIN')|| hasRole('ROLE_FLUXSORTANT')")
public class EtatBCMFluxSortantsController {
    private final EtatBCMFluxSortantsService service;

    private final FluxSortantsMapper mapper;
    private final FluxSortantsPublishMapper publishMapper;

    private final PublishService publishService;

    public EtatBCMFluxSortantsController(EtatBCMFluxSortantsService service, FluxSortantsMapper mapper, FluxSortantsPublishMapper publishMapper, PublishService publishService) {
        this.service = service;
        this.mapper = mapper;
        this.publishMapper = publishMapper;
        this.publishService = publishService;
    }


    @GetMapping
    public ResponseEntity<PagebaleDataDto<FluxSortantsDto>> getAllEtatBCMFluxSortants(@Param("page") int page, @Param("size") int size) {
        Page<EtatBCMFluxSortants> etatBCMFluxSortants = service.findEchantillon(page,size);
        PagebaleDataDto<FluxSortantsDto> pages = new PagebaleDataDto<>();
        pages.setTotal(etatBCMFluxSortants.getTotalPages());
        pages.setData(mapper.toDto(etatBCMFluxSortants.getContent()));
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FluxSortantsDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMFluxSortants etatBCMFluxSortants = service.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMFluxSortants));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMFluxSortants> etatBCMFluxSortants = service.findAll();
        boolean published = publishService.publishFluxSortant(publishMapper.toDto(etatBCMFluxSortants));
        return ResponseEntity.ok(published);
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> export(String param) throws IOException {
        String filename = new SimpleDateFormat("'fluxSortant_'yyyyMMddHHmm'.csv'").format(new Date());
        StringWriter sw = service.exportData();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE); // (3) Content-Type: application/octet-stream
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(filename).build().toString()); // (4) Content-Disposition: attachment; filename="demo-file.txt"
        return ResponseEntity.ok().headers(httpHeaders).body(sw.toString().getBytes());
    }
    @PutMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('MODIFICATION')")
    public ResponseEntity<Boolean> update(@RequestBody FluxSortantsDto fluxSortantsDto) {
        return ResponseEntity.ok(service.update(this.mapper.toModel(fluxSortantsDto)));
    }

}
