package org.bedu.java.proyecto.veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = -7678729433964902039L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "El nombre del cliente no puede estar vacio")
    private String nombre;
    @NotEmpty(message = "El apellido paterno del cliente no puede estar vacio")
    private String apePaterno;
    private String apeMaterno;
    @NotBlank(message = "Se debe proporcionar una direccion")
    @Length(min = 5, max = 50)
    private String direccion;
    @NotNull
    private Long telefono;
    @Email
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
