package com.crud.tarjeta.api_tarjetas.controller;

import com.crud.tarjeta.api_tarjetas.dto.TarjetaDto;
import com.crud.tarjeta.api_tarjetas.mappers.IMapperStruct;
import com.crud.tarjeta.api_tarjetas.model.Tarjeta;
import com.crud.tarjeta.api_tarjetas.service.ITarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tarjeta")
@CrossOrigin("*")
public class TarjetaController {

    @Autowired
    private ITarjetaService iTarjetaService;

    @Autowired
    private IMapperStruct iMapperStruct;


    @GetMapping("/")
    public ResponseEntity<List<TarjetaDto>>  listar(){
        List<TarjetaDto> lstTarjetas =  IMapperStruct.INSTANCE.TarjetasToTarjetasDtos(iTarjetaService.listar());
        return new ResponseEntity<>(lstTarjetas, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity  guardar(@RequestBody Tarjeta objTarjeta) {
        int intOk = iTarjetaService.guardar(objTarjeta);
        return new ResponseEntity<>(intOk, HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity  actualizar(@RequestBody Tarjeta objTarjeta) {
        int intOk =  iTarjetaService.actualizar(objTarjeta);
        return new ResponseEntity<>(intOk, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity  eliminar(@PathVariable int id) {
        int intOk =  iTarjetaService.eliminar(id);
        return new ResponseEntity<>(intOk, HttpStatus.OK);
    }


}
