package com.bank.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import java.math.BigDecimal;
import java.util.Date;


public class FluxSortantsPublishDto {


    private String banque;

    private String referenceTransaction;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateTransaction;


    private String typeSwfit;


    private String modeReglement;

    private String devise;

    private BigDecimal montantTransaction;

    private BigDecimal tauxDeChange;

    private String nomDonneurOrdre;

    private String nifNni;

    private String sourceDevise;

    private String beneficiaire;

    private String produit;



    private String natureEconomique;
    private String pays;


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

    public String getSourceDevise() {
        return sourceDevise;
    }

    public void setSourceDevise(String sourceDevise) {
        this.sourceDevise = sourceDevise;
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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getNatureEconomique() {
        return natureEconomique;
    }

    public void setNatureEconomique(String natureEconomique) {
        this.natureEconomique = natureEconomique;
    }
}
