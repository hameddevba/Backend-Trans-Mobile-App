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
}
