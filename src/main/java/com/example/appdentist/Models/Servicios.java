package com.example.appdentist.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "servicios")
public class Servicios {
    @Id @Getter @Setter @Column(name = "id_servicio")
    public int id_servicio;
    @Getter @Setter @Column(name = "servicio")
    public String servicio;
}
