package com.fiap.clientmicroservicefiap.config;

import com.fiap.clientmicroservicefiap.application.gateways.RepositorioDeClienteGateway;
import com.fiap.clientmicroservicefiap.application.usecases.ClienteUseCases;
import com.fiap.clientmicroservicefiap.infra.gateways.RepositorioDeClienteGatewayImpl;
import com.fiap.clientmicroservicefiap.infra.mappers.ClienteMapper;
import com.fiap.clientmicroservicefiap.infra.persistence.repositories.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfiguration {

    @Bean
    ClienteUseCases clienteUseCases(RepositorioDeClienteGateway repositorioDeClienteGateway) {
        return new ClienteUseCases(repositorioDeClienteGateway);
    }

    @Bean
    RepositorioDeClienteGatewayImpl repositorioDeClienteGateway(ClienteRepository repository, ClienteMapper mapper) {
        return new RepositorioDeClienteGatewayImpl(repository, mapper);
    }

}
