package com.bank.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;


@Entity
public class EtatBCMFluxEntrants {

    @Id
    private Long id;

    @Column
    private String banque;

    @Column
    private String referenceTransaction;

    @Column
    private Date dateTransaction;

    @Column
    private String typeSwfit;

    @Column
    private String modeReglement;
    @Column
    private String devise;
    @Column
    private BigDecimal montantTransaction;
    @Column
    private BigDecimal tauxDeChange;
    @Column
    private String nomDonneurOrdre;
    @Column
    private String nifNni;

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

    public String getReferenceTransaction() {
        return referenceTransaction;
    }

    public void setReferenceTransaction(String referenceTransaction) {
        this.referenceTransaction = referenceTransaction;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getTypeSwfit() {
        return typeSwfit;
    }

    public void setTypeSwfit(String typeSwfit) {
        this.typeSwfit = typeSwfit;
    }

    public String getModeReglement() {
        return modeReglement;
    }

    public void setModeReglement(String modeReglement) {
        this.modeReglement = modeReglement;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public BigDecimal getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(BigDecimal montantTransaction) {
        this.montantTransaction = montantTransaction;
    }

    public BigDecimal getTauxDeChange() {
        return tauxDeChange;
    }

    public void setTauxDeChange(BigDecimal tauxDeChange) {
        this.tauxDeChange = tauxDeChange;
    }

    public String getNomDonneurOrdre() {
        return nomDonneurOrdre;
    }

    public void setNomDonneurOrdre(String nomDonneurOrdre) {
        this.nomDonneurOrdre = nomDonneurOrdre;
    }

    public String getNifNni() {
        return nifNni;
    }

    public void setNifNni(String nifNni) {
        this.nifNni = nifNni;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public String getNatureEconomique() {
        return natureEconomique;
    }

    public void setNatureEconomique(String natureEconomique) {
        this.natureEconomique = natureEconomique;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Column
    private String beneficiaire;
    @Column
    private String produit;
    @Column
    private String natureEconomique;
    @Column
    private String pays;

}
