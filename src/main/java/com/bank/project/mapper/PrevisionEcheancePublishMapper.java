package com.bank.project.mapper;

import com.bank.project.dto.PrevisionEcheancePublishDto;
import com.bank.project.model.EtatBCMPrevisionEcheance;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrevisionEcheancePublishMapper {
    PrevisionEcheancePublishDto toDto(EtatBCMPrevisionEcheance etatBCMPrevisionEcheance);
    List<PrevisionEcheancePublishDto> toDto(List<EtatBCMPrevisionEcheance> etatBCMPrevisionEcheanceList);

}
