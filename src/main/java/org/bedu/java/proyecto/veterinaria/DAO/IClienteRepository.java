package org.bedu.java.proyecto.veterinaria.DAO;

import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findByNombre(String nombre);
}
