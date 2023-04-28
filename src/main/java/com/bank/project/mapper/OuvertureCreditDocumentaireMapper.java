package com.bank.project.mapper;

import com.bank.project.dto.FluxSortantsDto;
import com.bank.project.dto.OuvertureCreditDocumentaireDto;
import com.bank.project.model.EtatBCMFluxSortants;
import com.bank.project.model.EtatBCMOuvertureCreditDocumentaire;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OuvertureCreditDocumentaireMapper {
    OuvertureCreditDocumentaireDto toDto(EtatBCMOuvertureCreditDocumentaire etatBCMOuvertureCreditDocumentaire);
    List<OuvertureCreditDocumentaireDto> toDto(List<EtatBCMOuvertureCreditDocumentaire> etatBCMOuvertureCreditDocumentaireList);
    EtatBCMOuvertureCreditDocumentaire toModel(OuvertureCreditDocumentaireDto ouvertureCreditDocumentaireDto);
}
