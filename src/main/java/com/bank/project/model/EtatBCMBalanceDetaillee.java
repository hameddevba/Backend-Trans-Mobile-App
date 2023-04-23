package com.bank.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class EtatBCMBalanceDetaillee {

    @Id
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column
    private String banque;

    @Column
    private Date dateClotureBalance;

    @Column(length = 13)
    private String compte;

    @Column
    private String intituleCompteComptable;

    @Column(length = 13)
    private String compteBancaireClient;

    @Column
    private String intituleCompteBancaire;

    @Column(length = 2)
    private String resident;

    @Column(length = 1)
    private String estClientApparente;

    @Column(length = 3)
    private String devise;

    @Column
    private String activiteClient;

    @Column
    private String secteurActiviteClient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
