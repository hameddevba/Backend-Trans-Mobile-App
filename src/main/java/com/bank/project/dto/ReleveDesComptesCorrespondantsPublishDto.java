package com.bank.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;


public class ReleveDesComptesCorrespondantsPublishDto {


    private String banque;

    private String nomCorrespondant;
    private String numCompte;
    private String devise;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateApCloture;
    private BigDecimal soldeDebutJournee;
    private BigDecimal totalMvtsDebiteursJournee;
    private BigDecimal totalMvtsCrediteurs;
    private BigDecimal soldeFinJournee;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateFinJournee;
    public Date getDateFinJournee() {
        return dateFinJournee;
    }

    public void setDateFinJournee(Date dateFinJournee) {
        this.dateFinJournee = dateFinJournee;
    }


    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getNomCorrespondant() {
        return nomCorrespondant;
    }

    public void setNomCorrespondant(String nomCorrespondant) {
        this.nomCorrespondant = nomCorrespondant;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public Date getDateApCloture() {
        return dateApCloture;
    }

    public void setDateApCloture(Date dateApCloture) {
        this.dateApCloture = dateApCloture;
    }

    public BigDecimal getSoldeDebutJournee() {
        return soldeDebutJournee;
    }

    public void setSoldeDebutJournee(BigDecimal soldeDebutJournee) {
        this.soldeDebutJournee = soldeDebutJournee;
    }

    public BigDecimal getTotalMvtsDebiteursJournee() {
        return totalMvtsDebiteursJournee;
    }

    public void setTotalMvtsDebiteursJournee(BigDecimal totalMvtsDebiteursJournee) {
        this.totalMvtsDebiteursJournee = totalMvtsDebiteursJournee;
    }

    public BigDecimal getTotalMvtsCrediteurs() {
        return totalMvtsCrediteurs;
    }

    public void setTotalMvtsCrediteurs(BigDecimal totalMvtsCrediteurs) {
        this.totalMvtsCrediteurs = totalMvtsCrediteurs;
    }

    public BigDecimal getSoldeFinJournee() {
        return soldeFinJournee;
    }

    public void setSoldeFinJournee(BigDecimal soldeFinJournee) {
        this.soldeFinJournee = soldeFinJournee;
    }



}
