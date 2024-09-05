package com.bank.project.dto;

import java.time.LocalDateTime;

public class AgenceDto {

    private int agCode;
    private int agEtCode;
    private int agUsCode;
    private String agLib;
    private String agTel;
    private String agEmail;
    private String agAdd;
    private LocalDateTime agDate;
    private String agDest;
    private int agCpDep;
    private int agCpProd;
    private String agValidLm;
    private String agSansValid;
    private int agCpProv1;

    // Getters and Setters

    public int getAgCode() {
        return agCode;
    }

    public void setAgCode(int agCode) {
        this.agCode = agCode;
    }

    public int getAgEtCode() {
        return agEtCode;
    }

    public void setAgEtCode(int agEtCode) {
        this.agEtCode = agEtCode;
    }

    public int getAgUsCode() {
        return agUsCode;
    }

    public void setAgUsCode(int agUsCode) {
        this.agUsCode = agUsCode;
    }

    public String getAgLib() {
        return agLib;
    }

    public void setAgLib(String agLib) {
        this.agLib = agLib;
    }

    public String getAgTel() {
        return agTel;
    }

    public void setAgTel(String agTel) {
        this.agTel = agTel;
    }

    public String getAgEmail() {
        return agEmail;
    }

    public void setAgEmail(String agEmail) {
        this.agEmail = agEmail;
    }

    public String getAgAdd() {
        return agAdd;
    }

    public void setAgAdd(String agAdd) {
        this.agAdd = agAdd;
    }

    public LocalDateTime getAgDate() {
        return agDate;
    }

    public void setAgDate(LocalDateTime agDate) {
        this.agDate = agDate;
    }

    public String getAgDest() {
        return agDest;
    }

    public void setAgDest(String agDest) {
        this.agDest = agDest;
    }

    public int getAgCpDep() {
        return agCpDep;
    }

    public void setAgCpDep(int agCpDep) {
        this.agCpDep = agCpDep;
    }

    public int getAgCpProd() {
        return agCpProd;
    }

    public void setAgCpProd(int agCpProd) {
        this.agCpProd = agCpProd;
    }

    public String getAgValidLm() {
        return agValidLm;
    }

    public void setAgValidLm(String agValidLm) {
        this.agValidLm = agValidLm;
    }

    public String getAgSansValid() {
        return agSansValid;
    }

    public void setAgSansValid(String agSansValid) {
        this.agSansValid = agSansValid;
    }

    public int getAgCpProv1() {
        return agCpProv1;
    }

    public void setAgCpProv1(int agCpProv1) {
        this.agCpProv1 = agCpProv1;
    }
}
