package com.bank.project.mapper;

import com.bank.project.dto.EtatBCMFluxEntrantsPublishDto;
import com.bank.project.model.EtatBCMFluxEntrants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMFluxEntrantsPublishMapper {
    EtatBCMFluxEntrantsPublishDto toDto(EtatBCMFluxEntrants etatBCMFluxEntrants);
    List<EtatBCMFluxEntrantsPublishDto> toDto(List<EtatBCMFluxEntrants> etatBCMFluxEntrants);

}
