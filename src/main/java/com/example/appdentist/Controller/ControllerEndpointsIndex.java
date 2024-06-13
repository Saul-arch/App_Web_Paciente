package com.example.appdentist.Controller;

import com.example.appdentist.Models.Consulta;
import com.example.appdentist.Models.Dentistas;
import com.example.appdentist.Models.Servicios;
import com.example.appdentist.dao.DaoDentistas;
import org.apache.tomcat.websocket.DecoderEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerEndpointsIndex {
    @Autowired
    DaoDentistas daoDentistas;

    @RequestMapping(value = "/getDentistas", method = RequestMethod.GET)
    public List<Dentistas> getDentistas(){

        return daoDentistas.getDentistas();
    }

    @RequestMapping(value = "/saveCita/cita", method = RequestMethod.POST)
    public void setSaveCita(@RequestBody Consulta consulta){
        daoDentistas.setSaveCita(consulta);

    }

    @RequestMapping(value = "/saveCita/{nombreDentist}", method = RequestMethod.GET)
    public int getIdDentsita(@PathVariable String nombreDentist){

        return daoDentistas.getIdDentist(nombreDentist);
    }

    @RequestMapping(value = "/saveCita/extraIdServ/{nombreServicio}", method = RequestMethod.GET)
    public int getIdServicio(@PathVariable String nombreServicio){

        return daoDentistas.getIdServicio(nombreServicio);
    }

    @RequestMapping(value = "/getConsultas", method = RequestMethod.GET)
    public List<Consulta> getConsultas(){

        return daoDentistas.getConsultas();
    }

    @RequestMapping(value = "/deleteConsulta/{id_consulta}", method = RequestMethod.DELETE)
    public void borrarConsulta(@PathVariable int id_consulta){
        daoDentistas.borraConsulta(id_consulta);

    }
    @RequestMapping(value = "/getServicios", method = RequestMethod.GET)
    public List<Servicios> getServicios(){

        return daoDentistas.getServicios();
    }
    @RequestMapping(value = "/getConsultasR/{id}", method = RequestMethod.GET)
    public List<Consulta> getConsultas(@PathVariable int id){

        return daoDentistas.getConsultas(id);
    }

    @RequestMapping(value = "/setUpdateConsulta/{consulta}", method = RequestMethod.PUT)
    public void actualizarConsulta(@RequestBody Consulta consulta) {
        try {
            System.out.println("El bojeto llegado es: "+consulta.toString());
            // Llamar al método en el DAO para actualizar la consulta
            daoDentistas.updateRegistroConsulta(consulta);
            System.out.println("Consulta actualizada exitosamente.");
            // Manejar la respuesta exitosa, si es necesario
        } catch (Exception e) {
            System.out.println("Error al actualizar la consulta: " + e.getMessage());
            // Manejar la excepción, si es necesario
        }
    }

}
