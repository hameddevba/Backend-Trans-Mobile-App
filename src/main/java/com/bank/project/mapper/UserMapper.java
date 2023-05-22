package com.bank.project.mapper;

import com.bank.project.dto.UserDetailDto;
import com.bank.project.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDetailDto toDto(User user);
    List<UserDetailDto> toDto(List<User> user);
    User toModel(UserDetailDto userDto);


}
