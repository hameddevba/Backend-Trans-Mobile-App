package com.bank.project.mapper;

import com.bank.project.dto.EtatBCMOuvertureCreditDocumentaireDto;
import com.bank.project.model.EtatBCMOuvertureCreditDocumentaire;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMOuvertureCreditDocumentaireMapper {
    EtatBCMOuvertureCreditDocumentaireDto toDto(EtatBCMOuvertureCreditDocumentaire etatBCMOuvertureCreditDocumentaire);
    List<EtatBCMOuvertureCreditDocumentaireDto> toDto(List<EtatBCMOuvertureCreditDocumentaire> etatBCMOuvertureCreditDocumentaireList);
}
