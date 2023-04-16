package com.bank.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;


@Entity
public class EtatBCM_ReleveDesComptesCorrespondants {

    @Id
    private Long id;

    @Column
    private String banque;

    @Column
    private String nomCorrespondant;
    @Column
    private String numCompte;
    @Column
    private String devise;
    @Column
    private Date date_ap_cloture;
    @Column
    private BigDecimal soldeDebutJournee;

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

    public Date getDate_ap_cloture() {
        return date_ap_cloture;
    }

    public void setDate_ap_cloture(Date date_ap_cloture) {
        this.date_ap_cloture = date_ap_cloture;
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

    @Column
    private BigDecimal totalMvtsDebiteursJournee;
    @Column
    private BigDecimal totalMvtsCrediteurs;
    @Column
    private BigDecimal soldeFinJournee;


}
