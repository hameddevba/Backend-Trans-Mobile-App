package com.bank.project.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

public class BalanceDetailleePublishDto {



    private String banque;


    private Date dateClotureBalance;


    private String compte;


    private String intituleCompteComptable;


    private String compteBancaireClient;


    private String intituleCompteBancaire;


    private String resident;


    private String estClientApparente;


    private String devise;


    private String activiteClient;


    private String secteurActiviteClient;


    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

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

    public String getIntituleCompteComptable() {
        return intituleCompteComptable;
    }

    public void setIntituleCompteComptable(String intituleCompteComptable) {
        this.intituleCompteComptable = intituleCompteComptable;
    }

    public String getCompteBancaireClient() {
        return compteBancaireClient;
    }

    public void setCompteBancaireClient(String compteBancaireClient) {
        this.compteBancaireClient = compteBancaireClient;
    }

    public String getIntituleCompteBancaire() {
        return intituleCompteBancaire;
    }

    public void setIntituleCompteBancaire(String intituleCompteBancaire) {
        this.intituleCompteBancaire = intituleCompteBancaire;
    }

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }

    public String getEstClientApparente() {
        return estClientApparente;
    }

    public void setEstClientApparente(String estClientApparente) {
        this.estClientApparente = estClientApparente;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getActiviteClient() {
        return activiteClient;
    }

    public void setActiviteClient(String activiteClient) {
        this.activiteClient = activiteClient;
    }

    public String getSecteurActiviteClient() {
        return secteurActiviteClient;
    }

    public void setSecteurActiviteClient(String secteurActiviteClient) {
        this.secteurActiviteClient = secteurActiviteClient;
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

    @Column(precision = 10, scale = 2)
    private BigDecimal soldeDebiteur;

    @Column(precision = 10, scale = 2)
    private BigDecimal soldeCrediteur;
}
