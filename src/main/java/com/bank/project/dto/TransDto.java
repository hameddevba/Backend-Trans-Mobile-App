package com.bank.project.dto;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


public class TransDto {
    private Integer tRCODE;

    private EnvoyeurDto envoyeur;

    private BenefDto benef;
    private Integer tRAGEN;
    private Integer tRAGBN;
    private Integer tRUSCODE;
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
    private byte[] tRAVIS;
    private String tRDEMANEN;
    private String tRDEMANBEN;
    private String tRVALIDAN;
    private String tRREJET;

    public String getTrdatcr() {
        return trdatcr;
    }

    public void setTrdatcr(String trdatcr) {
        this.trdatcr = trdatcr;
    }

    private String trdatcr;
    private Date tRDATE;
    private Integer trtyp;


    public Integer getTRCODE(){
        return tRCODE;
    }

    public void setTRCODE(Integer tRCODE){
        this.tRCODE=tRCODE;
    }

    public EnvoyeurDto getEnvoyeur() {
        return envoyeur;
    }

    public void setEnvoyeur(EnvoyeurDto envoyeur) {
        this.envoyeur = envoyeur;
    }

    public BenefDto getBenef() {
        return benef;
    }

    public void setBenef(BenefDto benef) {
        this.benef = benef;
    }

    public Integer getTRAGEN(){
        return tRAGEN;
    }

    public void setTRAGEN(Integer tRAGEN){
        this.tRAGEN=tRAGEN;
    }

    public Integer getTRAGBN(){
        return tRAGBN;
    }

    public void setTRAGBN(Integer tRAGBN){
        this.tRAGBN=tRAGBN;
    }

    public Integer getTRUSCODE(){
        return tRUSCODE;
    }

    public void setTRUSCODE(Integer tRUSCODE){
        this.tRUSCODE=tRUSCODE;
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

//    public String getTRDATCR(){
//        return tRDATCR;
//    }
//
//    public void setTRDATCR(String tRDATCR){
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