package com.bank.project.controller;

import com.bank.project.dto.PagebaleDataDto;
import com.bank.project.dto.PrevisionEcheanceDto;
import com.bank.project.mapper.PrevisionEcheanceMapper;
import com.bank.project.mapper.PrevisionEcheancePublishMapper;
import com.bank.project.model.EtatBCMPrevisionEcheance;
import com.bank.project.service.EtatBCMPrevisionEcheanceService;
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
@RequestMapping(value = "/api/etatBCM_PrevisionEcheance", produces = MediaType.APPLICATION_JSON_VALUE)
@PreAuthorize("hasRole('ADMIN') || hasRole('ROLE_PREVISIONECH')")
public class EtatBCMPrevisionEcheanceController {
    private final EtatBCMPrevisionEcheanceService service;
    private final PublishService publishService;
    private final PrevisionEcheanceMapper mapper;
    private final PrevisionEcheancePublishMapper publishMapper;

    public EtatBCMPrevisionEcheanceController(EtatBCMPrevisionEcheanceService service, PublishService publishService,
                                              PrevisionEcheanceMapper mapper, PrevisionEcheancePublishMapper publishMapper) {
        this.service = service;
        this.publishService = publishService;
        this.mapper = mapper;
        this.publishMapper = publishMapper;
    }

    @GetMapping
    public ResponseEntity<PagebaleDataDto<PrevisionEcheanceDto>> getAllEtatBCMPrevisionEcheance(@Param("page") int page, @Param("size") int size) {
        Page<EtatBCMPrevisionEcheance> etatBCMBalanceGenerales = service.findEchantillon(page,size);
        PagebaleDataDto<PrevisionEcheanceDto> pages = new PagebaleDataDto<>();
        pages.setTotal(etatBCMBalanceGenerales.getTotalPages());
        pages.setData(mapper.toDto(etatBCMBalanceGenerales.getContent()));
        return ResponseEntity.ok(pages);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrevisionEcheanceDto> getEtatBCMFluxSortant(
            @PathVariable final Long id) {
        EtatBCMPrevisionEcheance etatBCMPrevisionEcheance = service.findById(id);
        return ResponseEntity.ok(mapper.toDto(etatBCMPrevisionEcheance));
    }

    @PostMapping("/publish")
    public ResponseEntity<Boolean> publish() {
        List<EtatBCMPrevisionEcheance> etatBCMPrevisionEcheances = service.findAll();
        boolean published = publishService.publishEtatBCMPrevisionEcheance(publishMapper.toDto(etatBCMPrevisionEcheances));
        return ResponseEntity.ok(published);
    }
    @GetMapping("/export")
    public ResponseEntity<byte[]> export(String param) throws IOException {
        String filename = new SimpleDateFormat("'provisionEcheance_'yyyyMMddHHmm'.csv'").format(new Date());
        StringWriter sw = service.exportData();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE); // (3) Content-Type: application/octet-stream
        httpHeaders.set(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition.attachment().filename(filename).build().toString()); // (4) Content-Disposition: attachment; filename="demo-file.txt"
        return ResponseEntity.ok().headers(httpHeaders).body(sw.toString().getBytes());
    }
    @PutMapping
    @PreAuthorize("hasRole('ADMIN') || hasRole('MODIFICATION')")
    public ResponseEntity<Boolean> update(@RequestBody PrevisionEcheanceDto previsionEcheanceDto) {
        return ResponseEntity.ok(service.update(this.mapper.toModel(previsionEcheanceDto)));
    }
}
