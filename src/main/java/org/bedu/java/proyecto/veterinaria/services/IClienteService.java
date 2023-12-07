package org.bedu.java.proyecto.veterinaria.services;

import org.bedu.java.proyecto.veterinaria.DTO.ClienteDTO;
import org.bedu.java.proyecto.veterinaria.DTO.NewClienteDTO;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;

import java.util.List;

public interface IClienteService {

    public void save(Cliente cliente);
    public List<Cliente> findAll();
    public Cliente findById(Cliente cliente);
    public List<Cliente> findByName(String nombre);
    public void update(Cliente cliente);
    public void delete(Cliente cliente);
    public Cliente deleteById(Long id);
    public Cliente findById(Long id);

}
