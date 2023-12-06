package org.bedu.java.proyecto.veterinaria.services;

import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Mascota;

import java.util.List;
import java.util.Optional;

public interface IMascotaService {
    public void save(Mascota mascota);
    public List<Mascota> findAll();
    public Mascota findById(Long id);
    public Mascota findById(Mascota mascota);
    public List<Mascota> findByName(String nombre);
    public void update(Mascota mascota);
    public void delete(Mascota mascota);
    public Mascota deleteById(Long id);
}
