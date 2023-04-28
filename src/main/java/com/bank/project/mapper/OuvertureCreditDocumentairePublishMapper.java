package com.bank.project.mapper;

import com.bank.project.dto.OuvertureCreditDocumentairePublishDto;
import com.bank.project.model.EtatBCMOuvertureCreditDocumentaire;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OuvertureCreditDocumentairePublishMapper {
    OuvertureCreditDocumentairePublishDto toDto(EtatBCMOuvertureCreditDocumentaire etatBCMOuvertureCreditDocumentaire);
    List<OuvertureCreditDocumentairePublishDto> toDto(List<EtatBCMOuvertureCreditDocumentaire> etatBCMOuvertureCreditDocumentaireList);
}
