package com.fiap.clientmicroservicefiap.infra.handler;

import com.fiap.clientmicroservicefiap.domain.enums.ErroClienteEnum;
import com.fiap.clientmicroservicefiap.domain.exceptions.ClienteException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientControllerMock {

    @GetMapping("/test-error-clientes-cadastrado")
    public void throwErrorClienteCadastrado() {
        throw new ClienteException(ErroClienteEnum.CLIENTE_JA_CADASTRADO);
    }

    @GetMapping("/test-error-clientes-cpf-nao-encontrado")
    public void throwErrorClienteCPFNaoEncontrado() {
        throw new ClienteException(ErroClienteEnum.CLIENTE_CPF_NAO_ENCONTRADO);
    }
}
