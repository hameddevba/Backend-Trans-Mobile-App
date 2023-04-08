package com.bank.project.dto;

import java.math.BigDecimal;
import java.util.Date;


public class EtatBCMFluxSortantsDto {
    private Long id;


    private String referenceTransaction;


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

    private String pays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
