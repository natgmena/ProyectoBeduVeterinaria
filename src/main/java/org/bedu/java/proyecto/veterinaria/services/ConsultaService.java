package org.bedu.java.proyecto.veterinaria.services;

import org.bedu.java.proyecto.veterinaria.DAO.IClienteRepository;
import org.bedu.java.proyecto.veterinaria.DAO.IConsultaRepository;
import org.bedu.java.proyecto.veterinaria.entities.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService implements IConsultaService{

    @Autowired
    private IConsultaRepository consultaRepository;

    @Override
    public void save(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    @Override
    public List<Consulta> findAll() {
        return (List<Consulta>) consultaRepository.findAll();
    }

    @Override
    public Consulta findById(Long id) {
        return consultaRepository.findById(id).orElse(null);
    }

    @Override
    public Consulta findById(Consulta consulta) {
        return consultaRepository.findById(consulta.getId()).orElse(null);
    }

    @Override
    public List<Consulta> findByMascota_Nombre(String nombre) {
        return consultaRepository.findByMascota_Nombre(nombre);
    }


    @Override
    public void update(Consulta consulta) {
        consultaRepository.save(consulta);
    }

    @Override
    public Consulta deleteById(Long id) {
        consultaRepository.deleteById(id);
        return null;
    }

    @Override
    public void delete(Consulta consulta) {
        consultaRepository.delete(consulta);
    }
}
