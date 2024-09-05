package com.bank.project.mapper;

import com.bank.project.dto.TransDto;
import com.bank.project.model.Trans;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper(uses = {EnvoyeurMapper.class, BenefMapper.class})
@Mapper(componentModel = "spring")
public interface TransMapper {
    TransMapper INSTANCE = Mappers.getMapper(TransMapper.class);
    TransDto toDto(Trans trans);
    List<TransDto> toDto(List<Trans> trans);
    @Mapping(target="trdatcr", source="transDto.trdatcr",
            dateFormat="dd-MM-yyyy HH:mm:ss")
    Trans toModel(TransDto transDto);


}