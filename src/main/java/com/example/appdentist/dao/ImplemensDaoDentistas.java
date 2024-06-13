package com.example.appdentist.dao;

import com.example.appdentist.Models.Consulta;
import com.example.appdentist.Models.Dentistas;
import com.example.appdentist.Models.Servicios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ImplemensDaoDentistas implements DaoDentistas{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Dentistas> getDentistas() {
        String consulta = "FROM Dentistas";

        return entityManager.createQuery(consulta).getResultList();
    }

    @Override
    public void setSaveCita(Consulta consulta) {
        try {

            entityManager.merge(consulta);

        }catch (Exception e){
            System.out.println("Error al cargar la nueva cita");
        }

    }

    @Override
    public int getIdDentist(String nombreDentist) {
        // Reemplazar los '+' con espacios en blanco
        System.out.println("EL NOMBRE RECIBIDO EN PRIMERA ES: "+nombreDentist);
        String nombreDentistSinMas = nombreDentist.replace("+", " ");

        System.out.println("El nombre recibido es: " + nombreDentistSinMas);

        String query = "SELECT id FROM Dentistas WHERE CONCAT(nombre, ' ', app, ' ', apm) LIKE :nombreDentist";
        Integer id = entityManager.createQuery(query, Integer.class)
                .setParameter("nombreDentist", "%" + nombreDentistSinMas + "%")
                .getSingleResult();

        return id;
    }

    @Override
    public int getIdServicio(String nombreServicio) {
        System.out.println("EL NOMBRE DEL SERVICIO ES: " + nombreServicio);

        String nombreServicioSinMas = nombreServicio.replace("+", " ");

        System.out.println("El nombre del servicio quita mas: "+nombreServicioSinMas);
        // La consulta debería comparar `nombreServicio` con el parámetro `:nombreServicio`
        String query = "SELECT id_servicio FROM Servicios s WHERE s.servicio = :nombreServicioSinMas";

        // Crear la consulta
        TypedQuery<Integer> typedQuery = entityManager.createQuery(query, Integer.class);

        // Establecer el valor del parámetro
        typedQuery.setParameter("nombreServicioSinMas", nombreServicioSinMas);

        // Ejecutar la consulta
        int resultado = typedQuery.getSingleResult();
        System.out.println("EL ID DEL SERVICIO SELECCIONADO ES: " + resultado);
        return resultado;
    }

    @Override
    public List<Consulta> getConsultas() {
        String Consulta = "FROM Consulta";

        return entityManager.createQuery(Consulta).getResultList();
    }

    @Override
    public List<Consulta> getConsultas(int id) {
        String consulta = "FROM Consulta c WHERE c.id = :id";

        return entityManager.createQuery(consulta)
                .setParameter("id", id)
                .getResultList();
    }


    @Override
    public void borraConsulta(int clav_consult) {
        Consulta consulta =  entityManager.find(Consulta.class, clav_consult);

        entityManager.remove(consulta);

    }

    @Override
    public List<Servicios> getServicios() {
        String Consultas = "FROM Servicios";


        return entityManager.createQuery(Consultas).getResultList();
    }

    @Override
    public void updateRegistroConsulta(Consulta Consulta) {
        try {
            Consulta existingConsulta = entityManager.find(Consulta.class, Consulta.getCon_clave());

            if (existingConsulta != null) {
                existingConsulta.setCon_clave(Consulta.getCon_clave());
                existingConsulta.setDen_clave(Consulta.getDen_clave());
                existingConsulta.setPac_clave(Consulta.getPac_clave());
                existingConsulta.setFecha(Consulta.getFecha());
                existingConsulta.setObservaciones(Consulta.getObservaciones());
                existingConsulta.setHora(Consulta.getHora());
                existingConsulta.setPendiente(Consulta.getPendiente());
                existingConsulta.setServicio(Consulta.getServicio());
                // Actualiza otros campos según sea necesario

                entityManager.merge(existingConsulta);
            } else {
                System.out.println("La consulta con ID " + Consulta.getCon_clave() + " no existe en la base de datos.");
                // Maneja el caso en el que la consulta no exista
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar la cita: " + e.getMessage());
            // Maneja la excepción según sea necesario
        }
    }

}
