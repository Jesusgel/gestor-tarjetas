package com.crud.tarjeta.api_tarjetas.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TarjetaDto implements Serializable {

    private static  final long serialVersionUID = 1L;

    private String nombreTitular;
    private String numeroTarjeta;
    private String nombreBanco;
    private int cvv;

}
