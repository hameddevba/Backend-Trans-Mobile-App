package com.bank.project.mapper;

import com.bank.project.dto.EtatBCM_ReleveDesComptesCorrespondantsDto;
import com.bank.project.model.EtatBCM_ReleveDesComptesCorrespondants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCM_ReleveDesComptesCorrespondantsMapper {
    EtatBCM_ReleveDesComptesCorrespondantsDto toDto(EtatBCM_ReleveDesComptesCorrespondants etatBCM_ReleveDesComptesCorrespondants);
    List<EtatBCM_ReleveDesComptesCorrespondantsDto> toDto(List<EtatBCM_ReleveDesComptesCorrespondants> etatBCM_ReleveDesComptesCorrespondantsList);
}
