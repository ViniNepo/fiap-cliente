package com.fiap.clientmicroservicefiap.application.usecases;

import com.fiap.clientmicroservicefiap.application.gateways.RepositorioDeClienteGateway;
import com.fiap.clientmicroservicefiap.domain.entities.CPF;
import com.fiap.clientmicroservicefiap.domain.entities.Cliente;
import com.fiap.clientmicroservicefiap.domain.exceptions.ClienteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClienteUseCasesTest {

    @Mock
    private RepositorioDeClienteGateway repositorio;

    @InjectMocks
    private ClienteUseCases clienteUseCases;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void cadastrarClienteComSucesso() {
        CPF cpf = new CPF("18282873004");
        Cliente mockCliente = new Cliente(1L, "John Doe", "teste@teste.com", cpf);

        when(repositorio.buscarPorCPF(cpf.getNumero())).thenReturn(null);
        when(repositorio.cadastrarCliente(any(Cliente.class))).thenReturn(mockCliente);

        Cliente resultado = clienteUseCases.cadastrarCliente(mockCliente);

        assertNotNull(resultado);
        assertEquals(mockCliente, resultado);
        verify(repositorio).buscarPorCPF(cpf.getNumero());
        verify(repositorio).cadastrarCliente(any(Cliente.class));
    }

    @Test
    void cadastrarClienteComErro() {
        CPF cpf = new CPF("18282873004");
        Cliente mockCliente = new Cliente(1L, "John Doe", "teste@teste.com", cpf);

        when(repositorio.buscarPorCPF(cpf.getNumero())).thenReturn(mockCliente);

        assertThrows(ClienteException.class, () -> clienteUseCases.cadastrarCliente(mockCliente));

        verify(repositorio).buscarPorCPF(cpf.getNumero());
    }

    @Test
    void buscarPorCPFComSucesso() {
        CPF cpf = new CPF("18282873004");
        Cliente mockCliente = new Cliente(1L, "John Doe", "teste@teste.com", cpf);

        when(repositorio.buscarPorCPF(cpf.getNumero())).thenReturn(mockCliente);

        Cliente resultado = clienteUseCases.buscarPorCPF(cpf.getNumero());

        assertNotNull(resultado);
        assertEquals(mockCliente, resultado);
        verify(repositorio).buscarPorCPF(cpf.getNumero());
    }

    @Test
    void buscarPorCPFComErro() {
        CPF cpf = new CPF("18282873004");

        when(repositorio.buscarPorCPF(cpf.getNumero())).thenReturn(null);

        assertThrows(ClienteException.class, () -> clienteUseCases.buscarPorCPF(cpf.getNumero()));

        verify(repositorio).buscarPorCPF(cpf.getNumero());
    }

}