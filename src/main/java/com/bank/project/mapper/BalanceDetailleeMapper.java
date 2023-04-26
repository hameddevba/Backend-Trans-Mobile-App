package com.bank.project.mapper;

import com.bank.project.dto.BalanceDetailleeDto;
import com.bank.project.dto.BalanceGeneraleDto;
import com.bank.project.model.EtatBCMBalanceDetaillee;
import com.bank.project.model.EtatBCMBalanceGenerale;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BalanceDetailleeMapper {
    BalanceDetailleeDto toDto(EtatBCMBalanceDetaillee EtatBCMBalanceDetaillee);
    List<BalanceDetailleeDto> toDto(List<EtatBCMBalanceDetaillee> etatBCMBalanceDetailleeList);
    EtatBCMBalanceDetaillee toModel(BalanceDetailleeDto balanceDetailleeDto);
}
