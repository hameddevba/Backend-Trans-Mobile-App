package com.bank.project.mapper;

import com.bank.project.dto.EtatBCM_OuvertureCreditDocumentaireDto;
import com.bank.project.model.EtatBCM_OuvertureCreditDocumentaire;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCM_OuvertureCreditDocumentaireMapper {
    EtatBCM_OuvertureCreditDocumentaireDto toDto(EtatBCM_OuvertureCreditDocumentaire etatBCM_OuvertureCreditDocumentaire);
    List<EtatBCM_OuvertureCreditDocumentaireDto> toDto(List<EtatBCM_OuvertureCreditDocumentaire> EtatBCM_OuvertureCreditDocumentaireList);
}
