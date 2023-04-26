package com.bank.project.mapper;

import com.bank.project.dto.ReleveDesComptesCorrespondantsDto;
import com.bank.project.model.EtatBCMReleveDesComptesCorrespondants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReleveDesComptesCorrespondantsMapper {
    ReleveDesComptesCorrespondantsDto toDto(EtatBCMReleveDesComptesCorrespondants etatBCMReleveDesComptesCorrespondants);
    List<ReleveDesComptesCorrespondantsDto> toDto(List<EtatBCMReleveDesComptesCorrespondants> etatBCMReleveDesComptesCorrespondants);
    EtatBCMReleveDesComptesCorrespondants toModel(ReleveDesComptesCorrespondantsDto releveDesComptesCorrespondantsDto);

}
