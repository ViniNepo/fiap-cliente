package com.fiap.clientmicroservicefiap.infra.gateways;

import com.fiap.clientmicroservicefiap.application.gateways.RepositorioDeClienteGateway;
import com.fiap.clientmicroservicefiap.domain.entities.Cliente;
import com.fiap.clientmicroservicefiap.infra.mappers.ClienteMapper;
import com.fiap.clientmicroservicefiap.infra.persistence.entities.ClienteEntity;
import com.fiap.clientmicroservicefiap.infra.persistence.repositories.ClienteRepository;

import java.util.Optional;

public class RepositorioDeClienteGatewayImpl implements RepositorioDeClienteGateway {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper;

    public RepositorioDeClienteGatewayImpl(ClienteRepository clienteRepository, ClienteMapper mapper) {
        this.clienteRepository = clienteRepository;
        this.mapper = mapper;
    }

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        ClienteEntity entity = mapper.paraEntidade(cliente);
        return mapper.paraDominio(clienteRepository.save(entity));
    }

    @Override
    public Cliente buscarPorCPF(String cpf) {
        Optional<ClienteEntity> entity = clienteRepository.getClienteEntityByCpf(cpf);
        return entity.map(mapper::paraDominio).orElse(null);
    }

}
