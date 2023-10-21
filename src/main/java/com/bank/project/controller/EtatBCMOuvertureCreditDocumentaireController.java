package com.bank.project.controller;

import com.bank.project.dto.OuvertureCreditDocumentaireDto;
import com.bank.project.dto.PagebaleDataDto;
import com.bank.project.mapper.OuvertureCreditDocumentaireMapper;
import com.bank.project.mapper.OuvertureCreditDocumentairePublishMapper;
import com.bank.project.model.EtatBCMOuvertureCreditDocumentaire;
import com.bank.project.service.EtatBCMOuvertureCreditDocumentaireService;
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
@RequestMapping(value = "/api/etatBCM_OuvertureCreditDocumentaire", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasRole('ADMIN') || hasRole('ROLE_OUVERTURECREDOC')")
public class EtatBCMOuvertureCreditDocumentaireController {
    private final EtatBCMOuvertureCreditDocumentaireService service;

    private final OuvertureCreditDocumentaireMapper mapper;
    private final OuvertureCreditDocumentairePublishMapper publishMapper;

    private final PublishService publishService;

    public EtatBCMOuvertureCreditDocumentaireController(EtatBCMOuvertureCreditDocumentaireService service, OuvertureCreditDocumentaireMapper mapper, OuvertureCreditDocumentairePublishMapper publishMapper, PublishService publishService) {
        this.service = service;
        this.mapper = mapper;
        this.publishMapper = publishMapper;
        this.publishService = publishService;
    }

    @GetMapping
    public ResponseEntity<PagebaleDataDto<OuvertureCreditDocumentaireDto>> getAllEtatBCMOuvertureCreditDocumentaire(@Param("page") int page, @Param("size") int size) {
        Page<EtatBCMOuvertureCreditDocumentaire> etatBCMBalanceGenerales = service.findEchantillon(page,size);
        PagebaleDataDto<OuvertureCreditDocumentaireDto> pages = new PagebaleDataDto<>();
        pages.setTotal(etatBCMBalanceGenerales.getTotalPages());
        pages.setData(mapper.toDto(etatBCMBalanceGenerales.getContent()));
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OuvertureCreditDocumentaireDto> getEtatBCMOuvertureCreditDocumentaire(
            @PathVariable final Long id) {
        EtatBCMOuvertureCreditDocumentaire etatBCMOuvertureCreditDocumentaire = service.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMOuvertureCreditDocumentaire));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMOuvertureCreditDocumentaire> etatBCMOuvertureCreditDocumentaire = service.findAll();
        boolean published = publishService.publishOuvertureCreditDocumentaire(publishMapper.toDto(etatBCMOuvertureCreditDocumentaire));
        return ResponseEntity.ok(published);
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> export(String param) throws IOException {
        String filename = new SimpleDateFormat("'OuvertureCreditDocumentaire_'yyyyMMddHHmm'.csv'").format(new Date());
        StringWriter sw = service.exportData();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE); // (3) Content-Type: application/octet-stream
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(filename).build().toString()); // (4) Content-Disposition: attachment; filename="demo-file.txt"
        return ResponseEntity.ok().headers(httpHeaders).body(sw.toString().getBytes());
    }
    @PutMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('MODIFICATION')")
    public ResponseEntity<Boolean> update(@RequestBody OuvertureCreditDocumentaireDto ouvertureCreditDocumentaireDto) {
        return ResponseEntity.ok(service.update(this.mapper.toModel(ouvertureCreditDocumentaireDto)));
    }

}
