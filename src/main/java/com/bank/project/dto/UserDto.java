package com.bank.project.dto;

public class UserDto {
    String banque;
    String password;

    public UserDto(String banque, String password) {
        this.banque = banque;
        this.password = password;
    }
}
