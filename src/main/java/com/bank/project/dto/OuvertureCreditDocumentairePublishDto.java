package com.bank.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.Date;


public class OuvertureCreditDocumentairePublishDto {


    private String banque;


    private String numCredoc;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateOuverture;


    private String nomDonneurOrdre;


    private BigDecimal montantOuverture;


    private String devise;

    private String beneficiaire;

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getNumCredoc() {
        return numCredoc;
    }

    public void setNumCredoc(String numCredoc) {
        this.numCredoc = numCredoc;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public String getNomDonneurOrdre() {
        return nomDonneurOrdre;
    }

    public void setNomDonneurOrdre(String nomDonneurOrdre) {
        this.nomDonneurOrdre = nomDonneurOrdre;
    }

    public BigDecimal getMontantOuverture() {
        return montantOuverture;
    }

    public void setMontantOuverture(BigDecimal montantOuverture) {
        this.montantOuverture = montantOuverture;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }

    public String getNomCorrespondant() {
        return nomCorrespondant;
    }

    public void setNomCorrespondant(String nomCorrespondant) {
        this.nomCorrespondant = nomCorrespondant;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public BigDecimal getDeposite() {
        return deposite;
    }

    public void setDeposite(BigDecimal deposite) {
        this.deposite = deposite;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }


    private String nomCorrespondant;

    private String produit;

    private BigDecimal deposite;

    private String pays;

}
