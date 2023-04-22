package com.bank.project.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class EtatBCMBalanceGenerale {

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
    private String intituleCompte;

    @Column(length = 3)
    private String devise;

    @Column
    private String resident;

    @Column(precision = 10, scale = 2)
    private BigDecimal soldeDebiteur;

    @Column(precision = 10, scale = 2)
    private BigDecimal soldeCrediteur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
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
