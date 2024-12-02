package com.fiap.clientmicroservicefiap.application.usecases;

import com.fiap.clientmicroservicefiap.application.gateways.RepositorioDeClienteGateway;
import com.fiap.clientmicroservicefiap.domain.entities.Cliente;
import com.fiap.clientmicroservicefiap.domain.enums.ErroClienteEnum;
import com.fiap.clientmicroservicefiap.domain.exceptions.ClienteException;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteUseCases {

    private final RepositorioDeClienteGateway repositorio;

    @Autowired
    public ClienteUseCases(RepositorioDeClienteGateway repositorio) {
        this.repositorio = repositorio;
    }

    public Cliente buscarPorCPF(String cpf) {

        Cliente cliente = repositorio.buscarPorCPF(cpf);

        if (cliente == null) {
            throw new ClienteException(ErroClienteEnum.CLIENTE_CPF_NAO_ENCONTRADO);
        }

        return cliente;

    }

    public Cliente cadastrarCliente(Cliente cliente) {

        if (repositorio.buscarPorCPF(cliente.getNumeroCpf()) != null) {
            throw new ClienteException(ErroClienteEnum.CLIENTE_JA_CADASTRADO);
        }

        return repositorio.cadastrarCliente(cliente);
    }

}
