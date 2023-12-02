package org.bedu.java.proyecto.veterinaria.services;

import org.bedu.java.proyecto.veterinaria.DAO.IMascotaRepository;
import org.bedu.java.proyecto.veterinaria.entities.Mascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository mascotaRepository;


    @Override
    public void save(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> findAll() {
        return (List<Mascota>) mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> findById(Long id) {
        return Optional.ofNullable(mascotaRepository.findById(id).orElse(null));
    }

    @Override
    public List<Mascota> findByName(String nombre) {
        return mascotaRepository.findByNombre(nombre);
    }

    @Override
    public void update(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public void deleteById(Long id) {
        mascotaRepository.deleteById(id);
    }
}
