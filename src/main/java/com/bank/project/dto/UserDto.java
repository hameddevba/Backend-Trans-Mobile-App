package com.bank.project.dto;

public class UserDto {
    String banque;
    String password;

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDto(String banque, String password) {
        this.banque = banque;
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                "banque='" + banque + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
