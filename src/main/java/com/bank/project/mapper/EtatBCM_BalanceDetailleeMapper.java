package com.bank.project.mapper;

import com.bank.project.dto.EtatBCM_BalanceDetailleeDto;
import com.bank.project.model.EtatBCM_BalanceDetaillee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EtatBCM_BalanceDetailleeMapper {
    EtatBCM_BalanceDetailleeDto toDto(EtatBCM_BalanceDetaillee etatBCM_BalanceDetaillee);
    List<EtatBCM_BalanceDetailleeDto> toDto(List<EtatBCM_BalanceDetaillee> etatBCM_BalanceDetailleeList);
}
