package org.bedu.java.proyecto.veterinaria.DAO;

import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Veterinario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVeterinarioRepository extends CrudRepository<Veterinario, Long> {
    List<Veterinario> findByNombre(String nombre);
}
