package org.bedu.java.proyecto.veterinaria.controller;

import org.bedu.java.proyecto.veterinaria.services.ClienteService;
import org.bedu.java.proyecto.veterinaria.services.IMascotaService;
import org.bedu.java.proyecto.veterinaria.services.MascotaService;
import org.bedu.java.proyecto.veterinaria.services.VeterinarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

    private MascotaService mascotaService;
    private ClienteService clienteService;
    private VeterinarioService veterinarioService;

    public MascotaController(MascotaService mascotaService, ClienteService clienteService, VeterinarioService veterinarioService) {
        this.mascotaService = mascotaService;
        this.clienteService = clienteService;
        this.veterinarioService = veterinarioService;
    }




}
