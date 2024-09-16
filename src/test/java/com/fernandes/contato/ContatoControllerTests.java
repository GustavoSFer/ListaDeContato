package com.fernandes.contato;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ContatoControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Teste - GET retorno status code 200")
	void DeveRetornarStatusOk() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/Contato"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	@DisplayName("Teste - GET Verificando o body de retorno")
	void DeveRetornarStatusOkAndBody() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/Contato"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].nome").value("Gustavo Fernandes"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].cpf").value("36427994859"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].celular").value("11958951333"))
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].tipo").value("Comercial"));
	}
	
	@Test
	@DisplayName("Teste - GET Buscando o id 1")
	void DeveRotornarOIDUm() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/Contato/1"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Gustavo Fernandes"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.cpf").value("36427994859"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.celular").value("11958951333"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.tipo").value("Comercial"));
	}
}
