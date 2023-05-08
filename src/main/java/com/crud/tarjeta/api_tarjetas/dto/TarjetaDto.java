package com.crud.tarjeta.api_tarjetas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarjetaDto {

    private String nombreTitular;
    private String numeroTarjeta;
    private String nombreBanco;
    private int cvv;
}
