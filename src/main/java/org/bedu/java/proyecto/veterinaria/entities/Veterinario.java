package org.bedu.java.proyecto.veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.io.Serializable;

@Entity
@Table(name = "veterinarios")
public class Veterinario implements Serializable {
    private static final long serialVersionUID = 1937196091082513910L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "El nombre del veterinario no puede estar vacio")
    private String nombre;
    @NotEmpty(message = "El apellido parterno del veterinario no puede estar vacio")
    @Column(name = "ape_paterno")
    private String apePaterno;
    @NotEmpty(message = "El apellido materno del veterinario no puede estar vacio")
    @Column(name = "ape_materno")
    private String apeMaterno;
    @NotNull(message = "La cedula no puede estar vacia")
    @Min(value = 7, message = "La cedula debe tener minimo 7 digitos")
    @Min(value = 9, message = "La cedula debe tener maximo 9 digitos")
    private int cedula;
    @NotEmpty(message = "La direecion no puede estar vacia")
    private String direccion;
    @NotNull(message = "El telefono no puede estar vacio")
    private Long telefono;
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombreCompleto(){
        return nombre + " " + apePaterno + " " + apeMaterno;
    }
}
