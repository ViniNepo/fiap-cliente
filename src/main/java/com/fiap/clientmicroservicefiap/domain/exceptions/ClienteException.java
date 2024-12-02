package com.fiap.clientmicroservicefiap.domain.exceptions;

import com.fiap.clientmicroservicefiap.domain.enums.ErroClienteEnum;

public class ClienteException extends RuntimeException {

    private final ErroClienteEnum erro;

    public ClienteException(ErroClienteEnum erro) {
        this.erro = erro;
    }

    public ErroClienteEnum getErro() {
        return this.erro;
    }

}
