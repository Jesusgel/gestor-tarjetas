package com.crud.tarjeta.api_tarjetas.model;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class Tarjeta {

    private int idTarjeta;
    private String nombreTitular;
    private String numeroTarjeta;
    private String nombreBanco;
    private int cvv;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;
    private  int estatus;

    public Tarjeta(String nombreTitular, String numeroTarjeta, String nombreBanco, int cvv, LocalDate fechaCreacion, LocalDate fechaModificacion, int estatus) {
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.nombreBanco = nombreBanco;
        this.cvv = cvv;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estatus = estatus;
    }

    public Tarjeta(){}
}
