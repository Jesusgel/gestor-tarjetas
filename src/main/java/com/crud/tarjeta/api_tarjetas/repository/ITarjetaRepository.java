package com.crud.tarjeta.api_tarjetas.repository;

import com.crud.tarjeta.api_tarjetas.model.Tarjeta;

import java.util.List;

public interface ITarjetaRepository {

    public int guardar(Tarjeta tarjeta);

    public List<Tarjeta> listar();

    public int actualizar(Tarjeta tarjeta);

    public int eliminar(int id);
}
