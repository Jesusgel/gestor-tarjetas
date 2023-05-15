package com.crud.tarjeta.api_tarjetas.dto;

import com.crud.tarjeta.api_tarjetas.util.ServiceResponse;

import java.io.Serializable;

public class MensajeDto<T>  extends ServiceResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private transient T objeto;

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }
}
