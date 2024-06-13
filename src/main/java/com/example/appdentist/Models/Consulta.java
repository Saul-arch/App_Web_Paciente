package com.example.appdentist.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "consulta")
public class Consulta {
    @Id @Column(name = "con_clave") @Getter @Setter
    private int con_clave;
    @Column(name = "den_clave") @Getter @Setter
    private int den_clave;
    @Column(name = "pac_clave") @Getter @Setter
    private int pac_clave;
    @Column(name = "fecha") @Getter @Setter
    private String fecha;
    @Column(name = "observaciones") @Getter @Setter
    private String observaciones;
    @Column(name = "hora") @Getter @Setter
    private String hora;
    @Column(name = "pendiente") @Getter @Setter
    private String pendiente;
    @Column(name = "id_servicio") @Getter @Setter
    private int servicio;


    @Override
    public String toString() {
        return "Consulta{" +
                "con_clave=" + con_clave +
                ", den_clave=" + den_clave +
                ", pac_clave=" + pac_clave +
                ", fecha='" + fecha + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", hora='" + hora + '\'' +
                ", pendiente='" + pendiente + '\'' +
                ", servicio=" + servicio +
                '}';
    }
}
