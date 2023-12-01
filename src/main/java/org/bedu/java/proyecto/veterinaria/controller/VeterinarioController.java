package org.bedu.java.proyecto.veterinaria.controller;

import jakarta.validation.Valid;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Veterinario;
import org.bedu.java.proyecto.veterinaria.services.IVeterinarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    private IVeterinarioService veterinarioService;

    public VeterinarioController(IVeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @PostMapping("/newveterinario")
    @ResponseStatus(HttpStatus.CREATED)
    public Veterinario guardar(@Valid @RequestBody Veterinario veterinario){
        veterinarioService.save(veterinario);
        return veterinario;
    }

    @GetMapping
    public List<Veterinario> findAll(){
        return veterinarioService.findAll();
    }

    @GetMapping("/buscar/{id}")
    public Veterinario findById(@PathVariable Long id){
        return veterinarioService.findById(id);
    }

    @GetMapping("/buscarn/{nombre}")
    public List<Veterinario> buscar(@PathVariable String nombre){
        return veterinarioService.findByName(nombre);
    }

    @PutMapping("/actualizar")
    public void updateVeterinario(@Valid @RequestBody Veterinario veterinario){
        veterinarioService.update(veterinario);
    }



}
