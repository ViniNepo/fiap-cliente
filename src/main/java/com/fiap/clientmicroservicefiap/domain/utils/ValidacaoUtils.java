package com.fiap.clientmicroservicefiap.domain.utils;

import com.fiap.clientmicroservicefiap.domain.exceptions.DominioException;

public class ValidacaoUtils {

    /**
     * Validação de string se está vazia
     *
     * @param stringValor
     * @param mensagem
     * @throws DominioException
     */
    public static void validaArgumentoNaoVazio(String stringValor, String mensagem) throws DominioException {
        if (stringValor == null || stringValor.trim().isEmpty()) {
            throw new DominioException(mensagem);
        }
    }
}
