package com.bank.project.mapper;

import com.bank.project.dto.EtatBCMBalanceDetailleeDto;
import com.bank.project.model.EtatBCMBalanceDetaillee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCMBalanceDetailleeMapper {
    EtatBCMBalanceDetailleeDto toDto(EtatBCMBalanceDetaillee etatBCMBalanceDetaillee);
    List<EtatBCMBalanceDetailleeDto> toDto(List<EtatBCMBalanceDetaillee> etatBCMBalanceDetaillees);
}
