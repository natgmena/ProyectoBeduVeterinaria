package org.bedu.java.proyecto.veterinaria.services;

import org.bedu.java.proyecto.veterinaria.entities.Cliente;

import java.util.List;

public interface IClienteService {
    public void save(Cliente cliente);
    public List<Cliente> findAll();
    public Cliente findById(Long id);
    public void delete (Long id);
    public List<Cliente> findByName(String nombre);
    public void update(Cliente cliente);
    public Cliente deleteById(Long id);
}
