package org.bedu.java.proyecto.veterinaria.controller;

import jakarta.validation.Valid;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/newcliente")
    public String save(@Valid @RequestBody Cliente cliente){
        clienteService.save(cliente);
        return "clientes";
    }

    @GetMapping("/agregar")
    public String agregar(Cliente cliente){
        return "modificar";
    }

    @GetMapping()
    public String clientes(Model model){
        var clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes";
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
