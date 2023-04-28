package com.bank.project.mapper;

import com.bank.project.dto.BalanceDetailleeDto;
import com.bank.project.model.EtatBCMBalanceDetaillee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BalanceDetailleeMapper {
    BalanceDetailleeDto toDto(EtatBCMBalanceDetaillee etatBCMBalanceDetaillee);
    List<BalanceDetailleeDto> toDto(List<EtatBCMBalanceDetaillee> etatBCMBalanceDetailleeList);
    EtatBCMBalanceDetaillee toModel(BalanceDetailleeDto balanceDetailleeDto);
}
