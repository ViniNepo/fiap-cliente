package com.fiap.clientmicroservicefiap.infra.gateways;

import com.fiap.clientmicroservicefiap.domain.entities.CPF;
import com.fiap.clientmicroservicefiap.domain.entities.Cliente;
import com.fiap.clientmicroservicefiap.infra.mappers.ClienteMapper;
import com.fiap.clientmicroservicefiap.infra.persistence.entities.ClienteEntity;
import com.fiap.clientmicroservicefiap.infra.persistence.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RepositorioDeClienteGatewayImplTest {

    @Mock
    private ClienteRepository repository;

    @Mock
    private ClienteMapper mapper;

    @InjectMocks
    private RepositorioDeClienteGatewayImpl gateway;

    private Cliente cliente;
    private ClienteEntity clienteEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        CPF cpf = new CPF("18282873004");
        cliente = new Cliente(1L, "John Doe", "teste@teste.com", cpf);
        clienteEntity = new ClienteEntity(1L, "John Doe", "teste@teste.com", "18282873004");
    }

    @Test
    void testSalvar() {
        when(mapper.paraEntidade(cliente)).thenReturn(clienteEntity);
        when(repository.save(clienteEntity)).thenReturn(clienteEntity);
        when(mapper.paraDominio(clienteEntity)).thenReturn(cliente);

        Cliente resultado = gateway.cadastrarCliente(cliente);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());

        verify(mapper).paraEntidade(cliente);
        verify(repository).save(clienteEntity);
        verify(mapper).paraDominio(clienteEntity);
    }

    @Test
    void testBuscarPorCPF() {
        when(repository.getClienteEntityByCpf(cliente.getNumeroCpf())).thenReturn(Optional.ofNullable(clienteEntity));
        when(mapper.paraDominio(clienteEntity)).thenReturn(cliente);

        Cliente resultado = gateway.buscarPorCPF(cliente.getNumeroCpf());

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());

        verify(repository).getClienteEntityByCpf(cliente.getNumeroCpf());
        verify(mapper).paraDominio(clienteEntity);
    }
}
