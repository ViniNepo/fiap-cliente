package com.fiap.clientmicroservicefiap.infra.mappers;

import com.fiap.clientmicroservicefiap.domain.entities.Cliente;
import com.fiap.clientmicroservicefiap.infra.dto.request.ClienteRequestDTO;
import com.fiap.clientmicroservicefiap.infra.dto.response.ClienteResponseDTO;
import com.fiap.clientmicroservicefiap.infra.persistence.entities.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    @Mapping(target = "cpf", source = "cliente.cpf.numero")
    ClienteEntity paraEntidade(Cliente cliente);

    @Mapping(target = "cpf.numero", source = "clienteEntity.cpf")
    Cliente paraDominio(ClienteEntity clienteEntity);

    @Mapping(target = "cpf.numero", source = "clienteRequestDTO.cpf.numero")
    Cliente paraDominio(ClienteRequestDTO clienteRequestDTO);

    @Mapping(target = "cpf", source = "cliente.cpf.numero")
    ClienteResponseDTO paraDTO(Cliente cliente);
}
