package org.bedu.java.proyecto.veterinaria.controller;

import jakarta.validation.Valid;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Mascota;
import org.bedu.java.proyecto.veterinaria.entities.Veterinario;
import org.bedu.java.proyecto.veterinaria.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    private IMascotaService mascotaService;
    private IClienteService clienteService;


    public MascotaController(IMascotaService mascotaService, IClienteService clienteService, IVeterinarioService veterinarioService) {
        this.mascotaService = mascotaService;
        this.clienteService = clienteService;
    }

    //Metodos para vista web con thymeleaf

    @GetMapping()
    public String mascotas(Model model){
        var mascotas = mascotaService.findAll();
        model.addAttribute("mascotas", mascotas);
        return "mascotas";
    }

    @PostMapping("/guardar")
    public String save(@Valid Mascota mascota){
        mascotaService.save(mascota);
        return "redirect:/mascotas";
    }

    @GetMapping("/agregar")
    public String agregar(Mascota mascota, Model model){
        model.addAttribute("mascota", mascota);
        model.addAttribute("clientes", clienteService.findAll());
        return "modificarmascota";
    }

    @GetMapping("/editar/{id}")
    public String update(Mascota mascota, Model model){
        mascota = mascotaService.findById(mascota);
        model.addAttribute("mascota", mascota);
        model.addAttribute("fechaRegistro", mascota.getFechaRegistro());
        model.addAttribute("clientes", clienteService.findAll());
        return "modificarmascota";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Mascota mascota){
        mascotaService.delete(mascota);
        return "redirect:/mascotas";
    }

    //metodos para usar con postman

    @PostMapping("/newmascota")
    public @ResponseBody void guardar(@Valid @RequestBody Mascota mascota){
        mascotaService.save(mascota);
    }

    @PutMapping("/actualizar/{id}")
    public @ResponseBody void actualizar(@Valid @RequestBody Mascota mascota){
        mascotaService.update(mascota);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody Mascota deleteById(@PathVariable Long id){
        return mascotaService.deleteById(id);
    }

    @GetMapping("/allmascotas")
    public @ResponseBody List<Mascota> findAll(Mascota mascota){
        return mascotaService.findAll();
    }

    @GetMapping("/buscar/{id}")
    public @ResponseBody Mascota findById(@PathVariable Long id){
        return mascotaService.findById(id);
    }

}
