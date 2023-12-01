package org.bedu.java.proyecto.veterinaria.services;

import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Veterinario;

import java.util.List;

public interface IVeterinarioService {

    public void save(Veterinario veterinario);
    public List<Veterinario> findAll();
    public Veterinario findById(Long id);
    public void delete (Long id);
    public List<Veterinario> findByName(String nombre);
    public void update(Veterinario veterinario);
}
