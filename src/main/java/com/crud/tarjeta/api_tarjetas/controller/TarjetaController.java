package com.crud.tarjeta.api_tarjetas.controller;

import com.crud.tarjeta.api_tarjetas.dto.TarjetaDto;
import com.crud.tarjeta.api_tarjetas.mappers.IMapperStruct;
import com.crud.tarjeta.api_tarjetas.model.Tarjeta;
import com.crud.tarjeta.api_tarjetas.service.ITarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/tarjeta")
@CrossOrigin("*")
public class TarjetaController {

    @Autowired
    private ITarjetaService iTarjetaService;

    @Autowired
    private IMapperStruct iMapperStruct;


    public ResponseEntity<List<TarjetaDto>>  listar(){
        // Necesito MAPEAR
        List<TarjetaDto> tarjetas =  IMapperStruct.INSTANCE.TarjetasToTarjetasDtos(iTarjetaService.listar());
        return new ResponseEntity<>(tarjetas, HttpStatus.OK);
    }

}
