package com.fiap.clientmicroservicefiap.infra.controller;

import com.fiap.clientmicroservicefiap.application.usecases.ClienteUseCases;
import com.fiap.clientmicroservicefiap.domain.entities.Cliente;
import com.fiap.clientmicroservicefiap.infra.dto.request.ClienteRequestDTO;
import com.fiap.clientmicroservicefiap.infra.mappers.ClienteMapper;
import com.fiap.clientmicroservicefiap.infra.resource.ClienteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteController implements ClienteResource {

    private final ClienteUseCases useCases;
    private final ClienteMapper mapper;

    @Autowired
    public ClienteController(ClienteUseCases useCases, ClienteMapper mapper) {
        this.useCases = useCases;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Object> cadastrarCliente(ClienteRequestDTO clienteRequest) {
        Cliente cliente = useCases.cadastrarCliente(mapper.paraDominio(clienteRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.paraDTO(cliente));
    }

    @Override
    public ResponseEntity<Object> consultarCliente(String cpf) {
        Cliente cliente = useCases.buscarPorCPF(cpf);
        return ResponseEntity.ok().body(mapper.paraDTO(cliente));
    }
}