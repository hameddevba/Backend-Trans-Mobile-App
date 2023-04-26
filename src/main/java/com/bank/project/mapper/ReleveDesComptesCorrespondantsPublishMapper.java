package com.bank.project.mapper;

import com.bank.project.dto.ReleveDesComptesCorrespondantsPublishDto;
import com.bank.project.model.EtatBCMReleveDesComptesCorrespondants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReleveDesComptesCorrespondantsPublishMapper {
    ReleveDesComptesCorrespondantsPublishDto toDto(EtatBCMReleveDesComptesCorrespondants etatBCMReleveDesComptesCorrespondants);
    List<ReleveDesComptesCorrespondantsPublishDto> toDto(List<EtatBCMReleveDesComptesCorrespondants> etatBCMReleveDesComptesCorrespondants);
}
