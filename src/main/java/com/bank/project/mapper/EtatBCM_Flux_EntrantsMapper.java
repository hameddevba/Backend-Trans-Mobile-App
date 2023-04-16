package com.bank.project.mapper;

import com.bank.project.dto.EtatBCM_Flux_EntrantsDto;
import com.bank.project.model.EtatBCM_Flux_Entrants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCM_Flux_EntrantsMapper {
    EtatBCM_Flux_EntrantsDto toDto(EtatBCM_Flux_Entrants etatBCM_Flux_Entrants);
    List<EtatBCM_Flux_EntrantsDto> toDto(List<EtatBCM_Flux_Entrants> etatBCM_Flux_EntrantsList);
}
