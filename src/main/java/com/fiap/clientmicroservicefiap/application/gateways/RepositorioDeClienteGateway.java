package com.fiap.clientmicroservicefiap.application.gateways;

import com.fiap.clientmicroservicefiap.domain.entities.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDeClienteGateway {
    Cliente buscarPorCPF(String cpf);

    Cliente cadastrarCliente(Cliente cliente);
}
