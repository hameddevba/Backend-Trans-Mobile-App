package com.bank.project.model;

import jakarta.persistence.*;
@Entity
public class Tau {

    @Id
    private Long id;

    @Column(name = "TAMON")
    private Double tamon;

    @Column(name = "TADIV")
    private String tadiv;

    @Column(name = "TAB1")
    private Double tab1;

    @Column(name = "TAB2")
    private Double tab2;

    @Column(name = "taav")
    private String taav;

    @Column(name = "tacat")
    private String tacat;

    @Column(name = "TADEV")
    private String tadev;

    @Column(name = "TADEVEN")
    private String tadeven;

    // Getters and setters
}
