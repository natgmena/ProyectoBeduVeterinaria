package org.bedu.java.proyecto.veterinaria.DAO;

import org.bedu.java.proyecto.veterinaria.entities.Consulta;
import org.bedu.java.proyecto.veterinaria.entities.Mascota;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IConsultaRepository extends CrudRepository<Consulta, Long> {
    List<Consulta> findByMascota_Nombre(String nombre);
}
