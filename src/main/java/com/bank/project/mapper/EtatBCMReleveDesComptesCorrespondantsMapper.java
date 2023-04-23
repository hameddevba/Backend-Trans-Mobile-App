package com.bank.project.mapper;

import com.bank.project.dto.EtatBCMReleveDesComptesCorrespondantsDto;
import com.bank.project.model.EtatBCMReleveDesComptesCorrespondants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMReleveDesComptesCorrespondantsMapper {
    EtatBCMReleveDesComptesCorrespondantsDto toDto(EtatBCMReleveDesComptesCorrespondants etatBCMReleveDesComptesCorrespondants);
    List<EtatBCMReleveDesComptesCorrespondantsDto> toDto(List<EtatBCMReleveDesComptesCorrespondants> etatBCMReleveDesComptesCorrespondants);
}
