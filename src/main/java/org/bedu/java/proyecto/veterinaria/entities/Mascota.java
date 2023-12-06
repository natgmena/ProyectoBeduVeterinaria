package org.bedu.java.proyecto.veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "mascotas")
public class Mascota implements Serializable {
    private static final long serialVersionUID = 6776155424837865739L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "El nombre de la mascota no puede estar vacio")
    @Size(min= 2, max = 25)
    private String nombre;

    @NotEmpty(message = "El tipo de mascota no puede estar vacio")
    private String tipoMascota;
    private String raza;

    @NotEmpty(message = "El sexo de la mascota no puede estar vacio")
    private String sexo;

    @NotNull(message = "La edad de la mascota no puede estar vaciá")
    private int edad;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "La fecha de registro no puede estar vacía")
    private Date fechaRegistro;

    @ManyToOne
    private Cliente clientes;

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

}
