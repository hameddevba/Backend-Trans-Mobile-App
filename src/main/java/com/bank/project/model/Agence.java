package com.bank.project.dto;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "agence")
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AGCODE")
    private int agCode;

    @Column(name = "AGETCODE", nullable = false)
    private int agEtCode;

    @Column(name = "AGUSCODE", nullable = false)
    private int agUsCode;

    @Column(name = "AGLIB", length = 50, nullable = false)
    private String agLib;

    @Column(name = "AGTEL", length = 15)
    private String agTel;

    @Column(name = "AGEMAIL", length = 50)
    private String agEmail;

    @Column(name = "AGADD", length = 50)
    private String agAdd;

    @Column(name = "AGDATE", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime agDate;

    @Column(name = "AGDEST", length = 1, nullable = false)
    private String agDest;

    @Column(name = "agcpdep", nullable = false)
    private int agCpDep;

    @Column(name = "agcpprod", nullable = false)
    private int agCpProd;

    @Column(name = "agvalidlm", length = 1, nullable = false)
    private String agValidLm;

    @Column(name = "agsansvalid", length = 1, nullable = false)
    private String agSansValid;

    @Column(name = "agcpprov1", nullable = false)
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
