package org.bedu.java.proyecto.veterinaria.DAO;

import org.bedu.java.proyecto.veterinaria.entities.Mascota;
import org.springframework.data.repository.CrudRepository;

public interface IMascotaRepository extends CrudRepository<Mascota, Long> {
}
