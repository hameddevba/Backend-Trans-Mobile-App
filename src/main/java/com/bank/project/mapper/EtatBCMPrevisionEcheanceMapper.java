package com.bank.project.mapper;

import com.bank.project.dto.EtatBCMPrevisionEcheanceDto;
import com.bank.project.model.EtatBCMPrevisionEcheance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMPrevisionEcheanceMapper {
    EtatBCMPrevisionEcheanceDto toDto(EtatBCMPrevisionEcheance etatBCMPrevisionEcheance);
    List<EtatBCMPrevisionEcheanceDto> toDto(List<EtatBCMPrevisionEcheance> etatBCMPrevisionEcheanceList);
}
