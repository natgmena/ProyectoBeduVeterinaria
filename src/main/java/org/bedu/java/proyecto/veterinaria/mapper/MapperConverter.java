package org.bedu.java.proyecto.veterinaria.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;

public class MapperConverter {
  public static void main(String[] args) {
    ObjectMapper objectMapper = new ObjectMapper();

    Cliente cliente = new Cliente();

    cliente.setNombre("Nathalie");
    cliente.setApePaterno("Glz");
    cliente.setApeMaterno("Mena");
    cliente.setDireccion("121323 nay");
    cliente.setTelefono(Long.valueOf("1111111111"));
    cliente.setEmail("ana@mail.com");

    try {
      String jsonString = objectMapper.writeValueAsString(cliente);
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
