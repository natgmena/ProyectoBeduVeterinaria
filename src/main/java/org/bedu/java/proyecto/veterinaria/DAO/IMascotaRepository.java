package org.bedu.java.proyecto.veterinaria.DAO;

import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Mascota;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMascotaRepository extends CrudRepository<Mascota, Long> {

    List<Mascota> findByNombre(String nombre);
}
