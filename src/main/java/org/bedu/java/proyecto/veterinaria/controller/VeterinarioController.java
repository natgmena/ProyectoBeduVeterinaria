package org.bedu.java.proyecto.veterinaria.controller;

import jakarta.validation.Valid;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Veterinario;
import org.bedu.java.proyecto.veterinaria.services.IVeterinarioService;
import org.bedu.java.proyecto.veterinaria.services.VeterinarioService;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/veterinarios")
public class VeterinarioController {

    private IVeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    //Metodos para vista web con thymeleaf

    @PostMapping("/guardar")
    public String save(@Valid Veterinario veterinario, Errors errors){
        if(errors.hasErrors()){
            return "modificarveterinario";
        }
        veterinarioService.save(veterinario);
        return "redirect:/veterinarios";
    }

    @GetMapping("/agregar")
    public String agregar(Veterinario veterinario){
        return "modificarveterinario";
    }

    @GetMapping()
    public String veterinarios(Model model){
        var veterinarios = veterinarioService.findAll();
        model.addAttribute("veterinarios", veterinarios);
        return "veterinarios";
    }

    @GetMapping("/editar/{id}")
    public String update(Veterinario veterinario, Model model){
        veterinario = veterinarioService.findById(veterinario);
        model.addAttribute("veterinario", veterinario);
        return "modificarveterinario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Veterinario veterinario){
        veterinarioService.delete(veterinario);
        return "redirect:/veterinarios";
    }

    //metodos para usar con postmans como si fuera rest

    @PostMapping("/newveterinario")
    public @ResponseBody void guardar(@Valid @RequestBody Veterinario veterinario){
        veterinarioService.save(veterinario);
    }

    @PutMapping("/actualizar")
    public @ResponseBody void actualizar(@Valid @RequestBody Veterinario veterinario){
        veterinarioService.update(veterinario);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody Veterinario deleteById(@PathVariable Long id){
        return veterinarioService.deleteById(id);
    }

    @GetMapping("/allveterinarios")
    public @ResponseBody List<Veterinario> findAll(Veterinario veterinario){
        return veterinarioService.findAll();
    }

    @GetMapping("/buscar/{id}")
    public @ResponseBody Veterinario findById(@PathVariable Long id){
        return veterinarioService.findById(id);
    }

    @GetMapping("/buscarn/{nombre}")
    public @ResponseBody List<Veterinario> buscar(@PathVariable String nombre){
        return veterinarioService.findByName(nombre);
    }
}
