package org.bedu.java.proyecto.veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = -7678729433964902039L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCliente;

    @NotEmpty(message = "El nombre del cliente no puede estar vacio")
    @Column(length = 30)
    private String nombre;

    @NotEmpty(message = "El apellido parterno del cliente no puede estar vacio")
    @Column(length = 30, name = "ape_paterno")
    private String apePaterno;

    @NotEmpty(message = "El apellido materno del cliente no puede estar vacio")
    @Column(length = 30, name = "ape_materno")
    private String apeMaterno;

    @NotBlank(message = "La direccion del cliente no puede estar vacia")
    @Column(length = 100)
    private String direccion;


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
