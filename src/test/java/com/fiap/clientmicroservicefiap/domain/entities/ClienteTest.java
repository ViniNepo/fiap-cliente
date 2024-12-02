package com.fiap.clientmicroservicefiap.domain.entities;

import com.fiap.clientmicroservicefiap.domain.exceptions.DominioException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private Cliente cliente;
    private CPF cpf = new CPF("18282873004");

    @BeforeEach
    void setUp() {
        cliente = new Cliente(1L, "John Doe", "teste@teste.com", cpf);
    }

    @Test
    void testCriacaoCliente() {
        assertNotNull(cliente);
        assertEquals(1L, cliente.getId());
        assertEquals("teste@teste.com", cliente.getEmail());
        assertEquals("18282873004", cliente.getNumeroCpf());
        assertEquals(cpf, cliente.getCpf());
        assertEquals("John Doe", cliente.getNome());
    }

    @Test
    void testCriacaoClienteEmailVazio() {
        assertThrows(DominioException.class, () -> {
            Cliente clienteSemEmail = new Cliente(1L, "John Doe", "", cpf);
        });
    }

    @Test
    void testCriacaoClienteNomeVazio() {
        assertThrows(DominioException.class, () -> {
            Cliente clienteSemEmail = new Cliente(1L, "", "teste@teste.com", cpf);
        });
    }
}
