package com.bank.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "trans")
public class Trans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trcode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TRENCODE")
    private Envoyeur envoyeur;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "TRBNCODE")
    private Benef benef;
    private Integer tragen;
    private Integer tragbn;
    private Integer truscode;
    private Integer tRVAUSCODE;
    private Integer tRTACODE;
    private Integer tRCACODET;
    private Integer tRCACODEPEY;
    private String tRDEV;
    private String trdeven;
    private BigDecimal tRMONE;
    private BigDecimal tRMONTTC;
    private BigDecimal tRMONT;
    private BigDecimal tRNETPAY;
    private String tRDEVPAY;
    private String tRCODEPAY;
    private String tRCODETRANS;
    @Lob
//    @Column(length = 4433112)
    private byte[] tRAVIS;
    private String tRDEMANEN;
    private String tRDEMANBEN;
    private String tRVALIDAN;
    private String tRREJET;

    public LocalDateTime getTrdatcr() {
        return trdatcr;
    }

    public void setTrdatcr(LocalDateTime trdatcr) {
        this.trdatcr = trdatcr;
    }

    private LocalDateTime trdatcr;
    private Date tRDATE;
    private Integer trtyp;


    public Integer getTRCODE(){
        return trcode;
    }

    public void setTRCODE(Integer tRCODE){
        this.trcode=tRCODE;
    }

    public Envoyeur getEnvoyeur() {
        return envoyeur;
    }

    public void setEnvoyeur(Envoyeur envoyeur) {
        this.envoyeur = envoyeur;
    }

    public Benef getBenef() {
        return benef;
    }

    public void setBenef(Benef benef) {
        this.benef = benef;
    }

    public Integer getTRAGEN(){
        return tragen;
    }

    public void setTRAGEN(Integer tRAGEN){
        this.tragen=tRAGEN;
    }

    public Integer getTRAGBN(){
        return tragbn;
    }

    public void setTRAGBN(Integer tRAGBN){
        this.tragbn=tRAGBN;
    }

    public Integer getTRUSCODE(){
        return truscode;
    }

    public void setTRUSCODE(Integer tRUSCODE){
        this.truscode=tRUSCODE;
    }

    public Integer getTRVAUSCODE(){
        return tRVAUSCODE;
    }

    public void setTRVAUSCODE(Integer tRVAUSCODE){
        this.tRVAUSCODE=tRVAUSCODE;
    }

    public Integer getTRTACODE(){
        return tRTACODE;
    }

    public void setTRTACODE(Integer tRTACODE){
        this.tRTACODE=tRTACODE;
    }

    public Integer getTRCACODET(){
        return tRCACODET;
    }

    public void setTRCACODET(Integer tRCACODET){
        this.tRCACODET=tRCACODET;
    }

    public Integer getTRCACODEPEY(){
        return tRCACODEPEY;
    }

    public void setTRCACODEPEY(Integer tRCACODEPEY){
        this.tRCACODEPEY=tRCACODEPEY;
    }

    public String getTRDEV(){
        return tRDEV;
    }

    public void setTRDEV(String tRDEV){
        this.tRDEV=tRDEV;
    }

    public String getTrdeven(){
        return trdeven;
    }

    public void setTrdeven(String trdeven){
        this.trdeven=trdeven;
    }

    public BigDecimal getTRMONE(){
        return tRMONE;
    }

    public void setTRMONE(BigDecimal tRMONE){
        this.tRMONE=tRMONE;
    }

    public BigDecimal getTRMONTTC(){
        return tRMONTTC;
    }

    public void setTRMONTTC(BigDecimal tRMONTTC){
        this.tRMONTTC=tRMONTTC;
    }


    public BigDecimal getTRMONT(){
        return tRMONT;
    }

    public void setTRMONT(BigDecimal tRMONT){
        this.tRMONT=tRMONT;
    }


    public BigDecimal getTRNETPAY(){
        return tRNETPAY;
    }

    public void setTRNETPAY(BigDecimal tRNETPAY){
        this.tRNETPAY=tRNETPAY;
    }


    public String getTRDEVPAY(){
        return tRDEVPAY;
    }

    public void setTRDEVPAY(String tRDEVPAY){
        this.tRDEVPAY=tRDEVPAY;
    }

    public String getTRCODEPAY(){
        return tRCODEPAY;
    }

    public void setTRCODEPAY(String tRCODEPAY){
        this.tRCODEPAY=tRCODEPAY;
    }

    public String getTRCODETRANS(){
        return tRCODETRANS;
    }

    public void setTRCODETRANS(String tRCODETRANS){
        this.tRCODETRANS=tRCODETRANS;
    }

    public byte[] getTRAVIS(){
        return tRAVIS;
    }

    public void setTRAVIS(byte[] tRAVIS){
        this.tRAVIS=tRAVIS;
    }

    public String getTRDEMANEN(){
        return tRDEMANEN;
    }

    public void setTRDEMANEN(String tRDEMANEN){
        this.tRDEMANEN=tRDEMANEN;
    }

    public String getTRDEMANBEN(){
        return tRDEMANBEN;
    }

    public void setTRDEMANBEN(String tRDEMANBEN){
        this.tRDEMANBEN=tRDEMANBEN;
    }

    public String getTRVALIDAN(){
        return tRVALIDAN;
    }

    public void setTRVALIDAN(String tRVALIDAN){
        this.tRVALIDAN=tRVALIDAN;
    }

    public String getTRREJET(){
        return tRREJET;
    }

    public void setTRREJET(String tRREJET){
        this.tRREJET=tRREJET;
    }

//    public LocalDateTime getTRDATCR(){
//        return tRDATCR;
//    }
//
//    public void setTRDATCR(LocalDateTime tRDATCR){
//        this.tRDATCR=tRDATCR;
//    }

    public Date getTRDATE(){
        return tRDATE;
    }

    public void setTRDATE(Date tRDATE){
        this.tRDATE=tRDATE;
    }

    public Integer getTrtyp(){
        return trtyp;
    }

    public void setTrtyp(Integer trtyp){
        this.trtyp=trtyp;
    }



}