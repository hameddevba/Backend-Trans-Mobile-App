package com.bank.project.model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.Objects;
import java.util.List;

@Entity
public class Envoyeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eNCODE;


    private Integer enagcode;
    private String eNNOM;
    private String eNPRE;
    private String eNPI;
    private String eNTYPP;

    public String getEntel() {
        return entel;
    }

    public void setEntel(String entel) {
        this.entel = entel;
    }

    private String entel;
    private String eNADD;
    private Timestamp eNDATE;
    private Integer eNUSCODE;


    public Integer getENCODE(){
        return eNCODE;
    }

    public void setENCODE(Integer eNCODE){
        this.eNCODE=eNCODE;
    }

    public Integer getEnagcode(){
        return enagcode;
    }

    public void setEnagcode(Integer eNAGCODE){
        this.enagcode=eNAGCODE;
    }

    public String getENNOM(){
        return eNNOM;
    }

    public void setENNOM(String eNNOM){
        this.eNNOM=eNNOM;
    }

    public String getENPRE(){
        return eNPRE;
    }

    public void setENPRE(String eNPRE){
        this.eNPRE=eNPRE;
    }

    public String getENPI(){
        return eNPI;
    }

    public void setENPI(String eNPI){
        this.eNPI=eNPI;
    }

    public String getENTYPP(){
        return eNTYPP;
    }

    public void setENTYPP(String eNTYPP){
        this.eNTYPP=eNTYPP;
    }

//    public String getENTEL(){
//        return eNTEL;
//    }
//
//    public void setENTEL(String eNTEL){
//        this.eNTEL=eNTEL;
//    }

    public String getENADD(){
        return eNADD;
    }

    public void setENADD(String eNADD){
        this.eNADD=eNADD;
    }

    public Timestamp getENDATE(){
        return eNDATE;
    }

    public void setENDATE(Timestamp eNDATE){
        this.eNDATE=eNDATE;
    }

    public Integer getENUSCODE(){
        return eNUSCODE;
    }

    public void setENUSCODE(Integer eNUSCODE){
        this.eNUSCODE=eNUSCODE;
    }


}
