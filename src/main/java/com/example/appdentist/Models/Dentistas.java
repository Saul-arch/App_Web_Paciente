package com.example.appdentist.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dentistas")
public class Dentistas {
    @Id @Column(name = "den_clave") @Getter @Setter
    private int den_clave;
    @Column(name = "nombre") @Setter @Getter
    private String nombre;
    @Column(name = "app") @Setter @Getter
    private String app;
    @Column(name = "apm") @Setter @Getter
    private String apm;
    @Column(name = "rfc") @Setter @Getter
    private String rfc;
    @Column(name = "curp") @Setter @Getter
    private String curp;
    @Column(name = "celular") @Setter @Getter
    private int celular;


}
