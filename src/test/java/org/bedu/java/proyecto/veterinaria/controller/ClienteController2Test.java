package org.bedu.java.proyecto.veterinaria.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.bedu.java.proyecto.veterinaria.services.IClienteService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Validator;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(MockitoJUnitRunner.class)
public class ClienteController2Test {
  private MockMvc mockMvc;
  @Mock
  private IClienteService clienteService;
  @InjectMocks
  private ClienteController clienteController;

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
  }

  @Test
  public void testSaveValidCliente() throws Exception {
    // Mocking the service behavior
    doNothing().when(clienteService).save(any(Cliente.class));

    // Sending a POST request with a valid Cliente
    mockMvc.perform(post("/clientes/guardar")
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .param("nombre", "John")
                    .param("apePaterno", "Doe"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/clientes"));

    // Verifying that the service's save method was called
    verify(clienteService, times(1)).save(any(Cliente.class));
  }
}
