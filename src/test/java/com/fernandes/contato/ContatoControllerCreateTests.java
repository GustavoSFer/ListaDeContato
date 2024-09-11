package com.fernandes.contato;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fernandes.contato.controller.ContatoController;
import com.fernandes.contato.entities.Contato;
import com.fernandes.contato.enums.TipoCelular;
import com.fernandes.contato.service.ContatoService;

@WebMvcTest(ContatoController.class)
public class ContatoControllerCreateTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContatoService contatoService;  // Uso do @MockBean para criar o mock do serviço

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateContato() throws Exception {
        // Criação de um objeto Contato para simular a entrada
        Contato contato = new Contato("Gustavo", "gustavo@example.com", "9999-9999", TipoCelular.Perticular);

        // Mockando o comportamento do ContatoService
        when(contatoService.createContato(contato)).thenReturn(contato);

        // Simulando a requisição POST com MockMvc
        mockMvc.perform(post("/Contato")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(contato))) // Converte o objeto Contato em JSON
                .andExpect(status().isOk())  // Verifica se o status retornado é 200 OK
                .andExpect(content().json(objectMapper.writeValueAsString(contato)));  // Verifica se o retorno JSON é o esperado
    }
}
