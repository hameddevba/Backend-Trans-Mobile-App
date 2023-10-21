package com.bank.project.controller;

import com.bank.project.dto.PagebaleDataDto;
import com.bank.project.dto.ReleveDesComptesCorrespondantsDto;
import com.bank.project.mapper.ReleveDesComptesCorrespondantsMapper;
import com.bank.project.mapper.ReleveDesComptesCorrespondantsPublishMapper;
import com.bank.project.model.EtatBCMReleveDesComptesCorrespondants;
import com.bank.project.service.EtatBCMReleveDesComptesCorrespondantsService;
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
@RequestMapping(value = "/api/etatBCM_ReleveDesComptesCorrespondants", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasRole('ADMIN') || hasRole('ROLE_RELEVECPTCOR')")
public class EtatBCMReleveDesComptesCorrespondantsController {
    private final EtatBCMReleveDesComptesCorrespondantsService service;

    private final ReleveDesComptesCorrespondantsMapper mapper;

    private final PublishService publishService;
    private final ReleveDesComptesCorrespondantsPublishMapper publishMapper;

    public EtatBCMReleveDesComptesCorrespondantsController(EtatBCMReleveDesComptesCorrespondantsService service,
                                                           ReleveDesComptesCorrespondantsMapper mapper, PublishService publishService,
                                                           ReleveDesComptesCorrespondantsPublishMapper publishMapper) {
        this.service = service;
        this.mapper = mapper;
        this.publishService = publishService;
        this.publishMapper = publishMapper;
    }

    @GetMapping
    public ResponseEntity<PagebaleDataDto<ReleveDesComptesCorrespondantsDto>> getAllEtatBCMReleveDesComptesCorrespondants(@Param("page") int page, @Param("size") int size) {
        Page<EtatBCMReleveDesComptesCorrespondants> etatBCMBalanceGenerales = service.findEchantillon(page,size);
        PagebaleDataDto<ReleveDesComptesCorrespondantsDto> pages = new PagebaleDataDto<>();
        pages.setTotal(etatBCMBalanceGenerales.getTotalPages());
        pages.setData(mapper.toDto(etatBCMBalanceGenerales.getContent()));
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReleveDesComptesCorrespondantsDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMReleveDesComptesCorrespondants etatBCMReleveDesComptesCorrespondants = service.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMReleveDesComptesCorrespondants));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMReleveDesComptesCorrespondants> etatBCMPrevisionEcheances = service.findAll();
        boolean published = publishService.publishEtatBCMReleveDesComptesCorrespondants(publishMapper.toDto(etatBCMPrevisionEcheances));
        return ResponseEntity.ok(published);
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> export(String param) throws IOException {
        String filename = new SimpleDateFormat("'releveDesComptes_'yyyyMMddHHmm'.csv'").format(new Date());
        StringWriter sw = service.exportData();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE); // (3) Content-Type: application/octet-stream
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(filename).build().toString()); // (4) Content-Disposition: attachment; filename="demo-file.txt"
        return ResponseEntity.ok().headers(httpHeaders).body(sw.toString().getBytes());
    }
    @PutMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('MODIFICATION')")
    public ResponseEntity<Boolean> update(@RequestBody ReleveDesComptesCorrespondantsDto releveDesComptesCorrespondantsDto) {
        return ResponseEntity.ok(service.update(this.mapper.toModel(releveDesComptesCorrespondantsDto)));
    }

}
