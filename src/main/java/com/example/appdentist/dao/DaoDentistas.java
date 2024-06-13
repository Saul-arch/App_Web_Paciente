package com.example.appdentist.dao;

import com.example.appdentist.Models.Consulta;
import com.example.appdentist.Models.Dentistas;
import com.example.appdentist.Models.Servicios;

import java.util.List;

public interface DaoDentistas {
    List<Dentistas> getDentistas();

    void setSaveCita(Consulta consulta);

    int getIdDentist(String nombreDentist);
    int getIdServicio(String nombreServicio);

    List<Consulta> getConsultas();
    List<Consulta> getConsultas(int id);

    void borraConsulta(int clav_consult);
    List<Servicios> getServicios();
    void updateRegistroConsulta(Consulta consulta);


}
