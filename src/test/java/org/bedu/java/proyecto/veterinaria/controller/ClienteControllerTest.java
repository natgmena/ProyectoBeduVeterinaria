package org.bedu.java.proyecto.veterinaria.controller;

import org.bedu.java.proyecto.veterinaria.DAO.IClienteRepository;
import org.bedu.java.proyecto.veterinaria.DTO.ClienteDTO;
import org.bedu.java.proyecto.veterinaria.DTO.NewClienteDTO;
import org.bedu.java.proyecto.veterinaria.mapper.ClienteMapper;
import org.bedu.java.proyecto.veterinaria.services.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ClienteService clienteService;
    @MockBean
    private IClienteRepository iClienteRepository;
    @MockBean
    private ClienteMapper clienteMapper;
    @Test
    public void saveClientTestPossitiveScenario() throws Exception {
      // Configuración comportamiento esperado
      NewClienteDTO newClienteDTO = new NewClienteDTO();

      newClienteDTO.setNombre("Nathalie");
      newClienteDTO.setApePaterno("Glz");
      newClienteDTO.setApeMaterno("Mena");
      newClienteDTO.setDireccion("121323 nay");
      newClienteDTO.setTelefono(Long.valueOf("1111111111"));
      newClienteDTO.setEmail("ana@mail.com");

      ClienteDTO simulatedClienteDTO = new ClienteDTO();

      simulatedClienteDTO.setNombre("Nathalie");
      simulatedClienteDTO.setApePaterno("Glz");
      simulatedClienteDTO.setApeMaterno("Mena");
      simulatedClienteDTO.setDireccion("121323 nay");
      simulatedClienteDTO.setTelefono(Long.valueOf("1111111111"));
      simulatedClienteDTO.setEmail("ana@mail.com");

      when(clienteService.save(any(NewClienteDTO.class))).thenReturn(simulatedClienteDTO);

      ClienteDTO resultado = clienteService.save(newClienteDTO);

      // Verifica que el método ownerService.save fue llamado con los argumentos esperados
      verify(clienteService, times(1)).save(eq(newClienteDTO));

      // Verifica que los resultados son los esperados
      assertEquals(simulatedClienteDTO.getId(), resultado.getId());
      assertEquals(simulatedClienteDTO.getNombre(), resultado.getNombre());
      Assertions.assertEquals(simulatedClienteDTO.getApePaterno(), resultado.getApePaterno());
      Assertions.assertEquals(simulatedClienteDTO.getApeMaterno(), resultado.getApeMaterno());
      assertEquals(simulatedClienteDTO.getDireccion(), resultado.getDireccion());
      assertEquals(simulatedClienteDTO.getTelefono(), resultado.getTelefono());
      assertEquals(simulatedClienteDTO.getEmail(), resultado.getEmail());
    }
    @Test
    public void saveClientNegativeScenario() throws Exception {
      try {
        // Configuración comportamiento esperado
        NewClienteDTO newClienteDTO = new NewClienteDTO();

        newClienteDTO.setNombre("Nathalie");
        newClienteDTO.setApePaterno("Glz");
        newClienteDTO.setApeMaterno("Mena");
        newClienteDTO.setDireccion("121323 nay");
        newClienteDTO.setTelefono(Long.valueOf("1111111111"));
        newClienteDTO.setEmail("ana@mail.com");

        ClienteDTO simulatedClienteDTO = new ClienteDTO();

        simulatedClienteDTO.setNombre("Nathalie");
        simulatedClienteDTO.setApePaterno("Glz");
        simulatedClienteDTO.setApeMaterno("Mena");
        simulatedClienteDTO.setDireccion("121323 nay");
        simulatedClienteDTO.setTelefono(Long.valueOf("1111111111"));
        simulatedClienteDTO.setEmail("ana@mail.com");

        when(clienteService.save(any(NewClienteDTO.class))).thenThrow(new RuntimeException("Error al guardar"));

        assertThrows(RuntimeException.class,() -> clienteService.save(newClienteDTO));

        // Verifica que el método ownerService.save fue llamado con los argumentos esperados
        verify(clienteService, times(1)).save(eq(newClienteDTO));
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }


