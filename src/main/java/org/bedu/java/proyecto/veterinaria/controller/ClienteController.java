package org.bedu.java.proyecto.veterinaria.controller;

import jakarta.validation.Valid;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Veterinario;
import org.bedu.java.proyecto.veterinaria.services.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/newcliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@Valid @RequestBody Cliente cliente){
        clienteService.save(cliente);
        return cliente;
    }

    @GetMapping("/allclientes")
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Cliente findById(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @GetMapping("/buscarn/{nombre}")
    public List<Cliente> findByName(@PathVariable String nombre){
        return clienteService.findByName(nombre);
    }

    @PutMapping("/actualizar")
    public void updateCliente(@Valid @RequestBody Cliente cliente){
        clienteService.update(cliente);
    }

    @DeleteMapping("/eliminar/{id}")
    public Cliente deleteById(@PathVariable Long id){
        return clienteService.deleteById(id);
    }

}
