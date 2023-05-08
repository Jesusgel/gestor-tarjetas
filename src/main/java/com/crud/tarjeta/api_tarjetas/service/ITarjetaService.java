package com.crud.tarjeta.api_tarjetas.service;

import com.crud.tarjeta.api_tarjetas.model.Tarjeta;

import java.util.List;

public interface ITarjetaService {

    public int guardar(Tarjeta tarjeta);

    public List<Tarjeta> listar();

    public int actualizar(Tarjeta tarjeta);

    public int eliminar(int id);
}
