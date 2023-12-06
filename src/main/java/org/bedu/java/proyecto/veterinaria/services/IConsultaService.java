package org.bedu.java.proyecto.veterinaria.services;

import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Consulta;

import java.util.List;

public interface IConsultaService {
    public void save(Consulta consulta);
    public List<Consulta> findAll();
    public Consulta findById(Long id);
    public Consulta findById(Consulta consulta);
    public List<Consulta> findByMascota_Nombre(String nombre);
    public void update(Consulta consulta);
    public Consulta deleteById(Long id);
    public void delete(Consulta consulta);
}
