package org.bedu.java.proyecto.veterinaria.DTO;

import lombok.Data;

@Data
public class NewClienteDTO {
  private Long id;
  private String nombre;
  private String apePaterno;
  private String apeMaterno;
  private String direccion;
  private Long telefono;
  private String email;
}
