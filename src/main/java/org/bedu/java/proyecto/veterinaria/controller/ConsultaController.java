package org.bedu.java.proyecto.veterinaria.controller;

import jakarta.validation.Valid;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.entities.Consulta;
import org.bedu.java.proyecto.veterinaria.entities.Mascota;
import org.bedu.java.proyecto.veterinaria.services.IConsultaService;
import org.bedu.java.proyecto.veterinaria.services.IMascotaService;
import org.bedu.java.proyecto.veterinaria.services.IVeterinarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {
    private final IConsultaService consultaService;
    private final IMascotaService mascotaService;
    private final IVeterinarioService veterinarioService;

    public ConsultaController(IConsultaService consultaService, IMascotaService mascotaService, IVeterinarioService veterinarioService) {
        this.consultaService = consultaService;
        this.mascotaService = mascotaService;
        this.veterinarioService = veterinarioService;
    }

    //metodos para uso en thymeleaf

    @GetMapping()
    public String consultas(Model model){
        var consultas = consultaService.findAll();
        model.addAttribute("consultas", consultas);
        return "consultas";
    }

    @GetMapping("/agregar")
    public String agregar(Consulta consulta, Model model){
        model.addAttribute("consulta", consulta);
        model.addAttribute("mascotas", mascotaService.findAll());
        model.addAttribute("veterinarios", veterinarioService.findAll());
        return "modificarconsulta";
    }

    @PostMapping("/guardar")
    public String save(@Valid Consulta consulta){
        consultaService.save(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/editar/{id}")
    public String update(Consulta consulta, Model model){
        consulta = consultaService.findById(consulta);
        model.addAttribute("consulta", consulta);
        model.addAttribute("mascotas", mascotaService.findAll());
        model.addAttribute("veterinarios", veterinarioService.findAll());
        return "modificarconsulta";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Consulta consulta){
        consultaService.delete(consulta);
        return "redirect:/consultas";
    }

    //Metodos para usar con postman

    @PostMapping("/newconsulta")
    public @ResponseBody void guardar(@Valid @RequestBody Consulta consulta){
        consultaService.save(consulta);
    }

    @PutMapping("/actualizar/{id}")
    public @ResponseBody void actualizar(@Valid @RequestBody Consulta consulta){
        consultaService.update(consulta);
    }

    @DeleteMapping("/delete/{id}")
    public @ResponseBody Consulta deleteById(@PathVariable Long id){
        return consultaService.deleteById(id);
    }

    @GetMapping("/allconsultas")
    public @ResponseBody List<Consulta> findAll(Consulta consulta){
        return consultaService.findAll();
    }

    @GetMapping("/buscar/{id}")
    public @ResponseBody Consulta findById(@PathVariable Long id){
        return consultaService.findById(id);
    }
}
