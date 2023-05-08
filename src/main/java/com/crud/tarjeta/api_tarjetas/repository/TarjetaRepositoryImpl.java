package com.crud.tarjeta.api_tarjetas.repository;

import com.crud.tarjeta.api_tarjetas.model.Tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TarjetaRepositoryImpl implements  ITarjetaRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int guardar(Tarjeta tarjeta) {
        String SQL = "INSERT INTO tarjeta VALUES(?,?,?,?,GETDATE(),GETDATE(),?)";
        return jdbcTemplate.update(SQL, new Object[]{   tarjeta.getNombreTitular(),tarjeta.getNumeroTarjeta(), tarjeta.getNombreBanco(),tarjeta.getCvv(),tarjeta.getFechaCreacion(), tarjeta.getFechaModificacion(), tarjeta.getEstatus()});
    }

    @Override
    public List<Tarjeta> listar() {
        String SQL = "SELECT * FROM tarjeta WHERE estatus = 1";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Tarjeta.class));
    }

    @Override
    public int actualizar(Tarjeta tarjeta) {
        String SQL = "UPDATE tarjeta SET nombreTitular = ? , numeroTarjeta = ? , nombreBanco = ? , cvv = ?, fechaModificacion = GETDATE() WHERE idTarjeta= ?";
        return jdbcTemplate.update(SQL, new Object[]{  tarjeta.getNombreTitular(),tarjeta.getNumeroTarjeta(),tarjeta.getNombreBanco(), tarjeta.getCvv(),tarjeta.getIdTarjeta()});
    }

    @Override
    public int eliminar(int id) {
        String SQL = "UPDATE tarjeta SET estatus = 0 WHERE idTarjeta = ?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
}
