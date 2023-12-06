package org.bedu.java.proyecto.veterinaria.controller;

import jakarta.validation.Valid;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Veterinario;
import org.bedu.java.proyecto.veterinaria.services.ClienteService;
import org.bedu.java.proyecto.veterinaria.services.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
    private final IClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //Metodos para vista web con thymeleaf

    @PostMapping("/guardar")
    public String save(@Valid Cliente cliente, Errors errors){
        if(errors.hasErrors()){
            return "modificarcliente";
        }
        clienteService.save(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/agregar")
    public String agregar(Cliente cliente){
        return "modificarcliente";
    }

    @GetMapping()
    public String clientes(Model model){
        var clientes = clienteService.findAll();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }


    @GetMapping("/buscarn/{nombre}")
    public List<Cliente> findByName(@PathVariable String nombre){
        return clienteService.findByName(nombre);
    }

    @GetMapping("/editar/{id}")
    public String update(Cliente cliente, Model model){
        cliente = clienteService.findById(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarcliente";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/clientes";
    }


    //Metodospara  usar con postman

    @PostMapping("/newcliente")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody void guardar(@Valid @RequestBody Cliente cliente){
        clienteService.save(cliente);
    }

    @PutMapping("/actualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody void actualizar(@PathVariable("id") Long id, @Valid @RequestBody Cliente cliente){
        clienteService.update(cliente);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody Cliente deleteById(@PathVariable Long id){
        return clienteService.deleteById(id);
    }

    @GetMapping("/allclientes")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Cliente> findAll(Cliente cliente){
        return clienteService.findAll();
    }

    @GetMapping("/buscar/{id}")
    public @ResponseBody Cliente findById(@PathVariable Long id){
        return clienteService.findById(id);
    }
}
