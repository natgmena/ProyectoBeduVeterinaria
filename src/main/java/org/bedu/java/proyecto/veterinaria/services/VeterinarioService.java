package org.bedu.java.proyecto.veterinaria.services;

import org.bedu.java.proyecto.veterinaria.DAO.IVeterinarioRepository;
import org.bedu.java.proyecto.veterinaria.entities.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioService implements IVeterinarioService{

    @Autowired
    private IVeterinarioRepository veterinarioRepository;

    @Override
    public void save(Veterinario veterinario) {
        veterinarioRepository.save(veterinario);
    }

    @Override
    public List<Veterinario> findAll() {
        return (List<Veterinario>) veterinarioRepository.findAll();
    }

    @Override
    public Veterinario findById(Long id) {
        return veterinarioRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        veterinarioRepository.deleteById(id);
    }

    @Override
    public List<Veterinario> findByName(String nombre) {
        return veterinarioRepository.findByNombre(nombre);
    }

    @Override
    public void update(Veterinario veterinario) {
        veterinarioRepository.save(veterinario);
    }
}
