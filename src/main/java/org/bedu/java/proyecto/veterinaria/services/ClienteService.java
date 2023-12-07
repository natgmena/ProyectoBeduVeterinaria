package org.bedu.java.proyecto.veterinaria.services;

import org.bedu.java.proyecto.veterinaria.DAO.IClienteRepository;
import org.bedu.java.proyecto.veterinaria.DTO.ClienteDTO;
import org.bedu.java.proyecto.veterinaria.DTO.NewClienteDTO;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.mapper.ClienteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;


    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Cliente cliente) {
        return clienteRepository.findById(cliente.getId()).orElse(null);
    }


    @Override
    public List<Cliente> findByName(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }

    @Override
    public void update(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteRepository.delete(cliente);
    }
    @Override
    public Cliente deleteById(Long id) {
        clienteRepository.deleteById(id);
        return null;
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

}
