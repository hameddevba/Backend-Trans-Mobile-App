package com.bank.project.dto;

import com.bank.project.model.enums.ResidentEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.Date;

public class BalanceGeneralePublishDto {

    @Column
    private String banque;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateClotureBalance;

    private String compte;


    private String intituleCompte;

    private String devise;

    private ResidentEnum resident;

    private BigDecimal soldeDebiteur;

    private BigDecimal soldeCrediteur;


    public Date getDateClotureBalance() {
        return dateClotureBalance;
    }

    public void setDateClotureBalance(Date dateClotureBalance) {
        this.dateClotureBalance = dateClotureBalance;
    }

    public String getCompte() {
        return compte;
    }

    public void setCompte(String compte) {
        this.compte = compte;
    }

    public String getIntituleCompte() {
        return intituleCompte;
    }

    public void setIntituleCompte(String intituleCompte) {
        this.intituleCompte = intituleCompte;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public ResidentEnum getResident() {
        return resident;
    }

    public void setResident(ResidentEnum resident) {
        this.resident = resident;
    }

    public BigDecimal getSoldeDebiteur() {
        return soldeDebiteur;
    }

    public void setSoldeDebiteur(BigDecimal soldeDebiteur) {
        this.soldeDebiteur = soldeDebiteur;
    }

    public BigDecimal getSoldeCrediteur() {
        return soldeCrediteur;
    }

    public void setSoldeCrediteur(BigDecimal soldeCrediteur) {
        this.soldeCrediteur = soldeCrediteur;
    }
    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }
}
