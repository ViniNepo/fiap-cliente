package com.fiap.clientmicroservicefiap.infra.handler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(controllers = {ClienteAdvice.class, ClientControllerMock.class})

public class ClientAdviceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testClientExceptionHandler() throws Exception {
        mockMvc.perform(get("/clientes/test-error-clientes-cadastrado")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        mockMvc.perform(get("/clientes/test-error-clientes-cpf-nao-encontrado")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
