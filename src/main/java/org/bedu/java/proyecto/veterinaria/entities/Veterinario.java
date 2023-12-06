package org.bedu.java.proyecto.veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "veterinarios")
public class Veterinario implements Serializable {
    private static final long serialVersionUID = 1937196091082513910L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "El nombre del veterinario no puede estar vacio")
    @Column(length = 30)
    private String nombre;

    @NotEmpty(message = "El apellido parterno del veterinario no puede estar vacio")
    @Column(length = 30, name = "ape_paterno")
    private String apePaterno;

    @NotEmpty(message = "El apellido materno del veterinario no puede estar vacio")
    @Column(length = 30, name = "ape_materno")
    private String apeMaterno;

    @NotNull(message = "La cedula profesional no puede estar vacia")
    @Min(value = 7, message = "La cedula profesional debe tener minimo 7 digitos")
    @Min(value = 9, message = "La cedula profesional debe tener maximo 9 digitos")
    private int cedulaProf;

    @NotNull(message = "El telefono no puede estar vacio")
    @Column(nullable = false, length = 10)
    private Long telefono;

    @Email
    @Column(nullable = false, length = 26)
    @NotNull(message = "El correo del cliente no puede estar vacio")
    private String email;

    public String getNombreCompleto(){
        return nombre + " " + apePaterno + " " + apeMaterno;
    }
}
