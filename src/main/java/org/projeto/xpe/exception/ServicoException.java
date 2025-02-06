package org.projeto.xpe.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class ServicoException extends WebApplicationException {

    private final String codigo;

    public ServicoException(String codigo, String mensagem, Response.Status status) {
        super(mensagem, status);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
