package com.fiap.clientmicroservicefiap.infra.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.fiap.clientmicroservicefiap.application.usecases.ClienteUseCases;
import com.fiap.clientmicroservicefiap.domain.entities.CPF;
import com.fiap.clientmicroservicefiap.domain.entities.Cliente;
import com.fiap.clientmicroservicefiap.infra.dto.request.ClienteRequestDTO;
import com.fiap.clientmicroservicefiap.infra.dto.request.CpfRequestDTO;
import com.fiap.clientmicroservicefiap.infra.dto.response.ClienteResponseDTO;
import com.fiap.clientmicroservicefiap.infra.mappers.ClienteMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class ClienteControllerTest {

    @Mock
    private ClienteUseCases clienteUseCases;

    @Mock
    private ClienteMapper clienteMapper;

    @InjectMocks
    private ClienteController clienteController;

    ClienteControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarClientePeloCPF() {
        CPF cpf = new CPF("18282873004");
        Cliente mockCliente = new Cliente(1L, "John Doe", "teste@teste.com", cpf);
        ClienteResponseDTO mockResponseDTO = new ClienteResponseDTO(1L, "John Doe", "teste@teste.com", "123.456.789-00");

        when(clienteUseCases.buscarPorCPF(cpf.getNumero())).thenReturn(mockCliente);
        when(clienteMapper.paraDTO(mockCliente)).thenReturn(mockResponseDTO);

        ResponseEntity<Object> response = clienteController.consultarCliente(cpf.getNumero());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponseDTO, response.getBody());

        verify(clienteUseCases, times(1)).buscarPorCPF(cpf.getNumero());
        verify(clienteMapper, times(1)).paraDTO(mockCliente);
    }

    @Test
    void cadastrarClientePeloCPF() {
        CPF cpf = new CPF("18282873004");
        CpfRequestDTO cpfRequestDTO = new CpfRequestDTO("18282873004");
        Cliente mockCliente = new Cliente(1L, "John Doe", "teste@teste.com", cpf);
        ClienteRequestDTO mockClienteRequestDTO = new ClienteRequestDTO("John Doe", "teste@teste.com", cpfRequestDTO);
        ClienteResponseDTO mockResponseDTO = new ClienteResponseDTO(1L, "John Doe", "teste@teste.com", "123.456.789-00");

        when(clienteUseCases.cadastrarCliente(mockCliente)).thenReturn(mockCliente);
        when(clienteMapper.paraDominio(mockClienteRequestDTO)).thenReturn(mockCliente);
        when(clienteMapper.paraDTO(mockCliente)).thenReturn(mockResponseDTO);

        ResponseEntity<Object> response = clienteController.cadastrarCliente(mockClienteRequestDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(mockResponseDTO, response.getBody());

        verify(clienteUseCases, times(1)).cadastrarCliente(mockCliente);
        verify(clienteMapper, times(1)).paraDominio(mockClienteRequestDTO);
        verify(clienteMapper, times(1)).paraDTO(mockCliente);
    }
}
