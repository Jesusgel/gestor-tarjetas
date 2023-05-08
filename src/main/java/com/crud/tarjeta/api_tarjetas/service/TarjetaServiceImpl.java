package com.crud.tarjeta.api_tarjetas.service;

import com.crud.tarjeta.api_tarjetas.model.Tarjeta;
import com.crud.tarjeta.api_tarjetas.repository.ITarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarjetaServiceImpl implements  ITarjetaService{

    @Autowired
    private ITarjetaRepository iTarjetaRepository;
    @Override
    public int guardar(Tarjeta tarjeta) {

        int intRow;
        try {
            intRow = iTarjetaRepository.guardar(tarjeta);
        }catch (Exception ex){
            throw  ex;
        }
        return intRow;
    }

    @Override
    public List<Tarjeta> listar() {

        List<Tarjeta> tarjetas;
        try {
            tarjetas = iTarjetaRepository.listar();
        }catch (Exception ex){
            throw  ex;
        }
        return tarjetas;
    }

    @Override
    public int actualizar(Tarjeta tarjeta) {
        int intRow;
        try {
            intRow = iTarjetaRepository.actualizar(tarjeta);
        }catch (Exception ex){
            throw  ex;
        }
        return intRow;
    }

    @Override
    public int eliminar(int id) {
        int intRow;
        try {
            intRow =  iTarjetaRepository.eliminar(id);
        }catch (Exception ex){
            throw  ex;
        }
        return intRow;
    }
}
