package org.bedu.java.proyecto.veterinaria.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "historial_medico")
public class Consulta implements Serializable {
    private static final long serialVersionUID = 351246113858181938L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Mascota mascota;

    @ManyToOne
    private Veterinario veterinario;

    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "debe seleccionar una fecha")
    private Date fechaConsulta;

    @NotEmpty(message = "el campo no puede estar vacio")
    @Column
    private String diagnostico;

    @NotEmpty(message = "El campo no puede estar vacio")
    @Column
    private String tratamiento;

    @NotNull(message = "Debe tener un costo minimo de 1")
    @Min(1)
    @Column
    private double costo;


}
