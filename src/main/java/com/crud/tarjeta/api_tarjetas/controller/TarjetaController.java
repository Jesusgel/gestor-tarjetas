package com.crud.tarjeta.api_tarjetas.controller;

import com.crud.tarjeta.api_tarjetas.dto.MensajeDto;
import com.crud.tarjeta.api_tarjetas.dto.TarjetaDto;
import com.crud.tarjeta.api_tarjetas.mappers.IMapperStruct;
import com.crud.tarjeta.api_tarjetas.model.Tarjeta;
import com.crud.tarjeta.api_tarjetas.service.ITarjetaService;
import com.crud.tarjeta.api_tarjetas.util.ConstantesUtil;
import com.crud.tarjeta.api_tarjetas.util.RespuestaUtil;

import com.crud.tarjeta.api_tarjetas.util.ServiceResponse;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/tarjeta")
@CrossOrigin("*")
public class TarjetaController {

    @Autowired
    private ITarjetaService iTarjetaService;

    @Autowired
    private IMapperStruct iMapperStruct;

    private static final Log objLogger = LogFactory.getLog(TarjetaController.class);


    @GetMapping("/listar")
    public ResponseEntity<MensajeDto<List<TarjetaDto>>>  listar(){
        MensajeDto<List<TarjetaDto>>  objMensajeDto = new MensajeDto<>();
        List<TarjetaDto>  lstTarjetasDto = new ArrayList<>();
        try {
            lstTarjetasDto =  IMapperStruct.INSTANCE.TarjetasToTarjetasDtos(iTarjetaService.listar());
            objMensajeDto.setObjeto(lstTarjetasDto);
            objMensajeDto.setCodigo(ConstantesUtil.CODIGO_EXITO);
            objMensajeDto.setMensaje(ConstantesUtil.MENSAJE_EXITO);
        }catch (Exception ex){
            objLogger.error(ex);
            objMensajeDto.setObjeto(null);
            objMensajeDto.setCodigo(ConstantesUtil.CODIGO_ERROR);
            objMensajeDto.setMensaje(ConstantesUtil.MENSAJE_ERROR);
        }
        return RespuestaUtil.ok(objMensajeDto);
    }

    @PostMapping("/guardar")
    public ResponseEntity<MensajeDto<String>>  guardar(@RequestBody Tarjeta objTarjeta) {
        MensajeDto<String> objMensajeDto = new MensajeDto<>();
       try {
           int intOk = iTarjetaService.guardar(objTarjeta);
           if(intOk > 0) {
               objMensajeDto.setCodigo(ConstantesUtil.CODIGO_EXITO);
               objMensajeDto.setMensaje(ConstantesUtil.MENSAJE_EXITO);
           }

       }catch (Exception ex){
           objLogger.error(ex);
           objMensajeDto.setCodigo(ConstantesUtil.CODIGO_ERROR);
           objMensajeDto.setMensaje(ConstantesUtil.MENSAJE_ERROR);
       }
        return RespuestaUtil.nuevo(objMensajeDto);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<MensajeDto<String>> actualizar(@RequestBody Tarjeta objTarjeta) {
        MensajeDto<String> objMensajeDto = new MensajeDto<>();
        try {
            int intOk = iTarjetaService.actualizar(objTarjeta);
            if(intOk > 0) {
                objMensajeDto.setCodigo(ConstantesUtil.CODIGO_EXITO);
                objMensajeDto.setMensaje(ConstantesUtil.MENSAJE_EXITO);
            }

        }catch (Exception ex){
            objLogger.error(ex);
            objMensajeDto.setCodigo(ConstantesUtil.CODIGO_ERROR);
            objMensajeDto.setMensaje(ConstantesUtil.MENSAJE_ERROR);
        }
        return RespuestaUtil.ok(objMensajeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MensajeDto<String>>  eliminar(@PathVariable int id) {
        MensajeDto<String> objMensajeDto = new MensajeDto<>();
        try {
            int intOk = iTarjetaService.eliminar(id);
            if(intOk > 0) {
                objMensajeDto.setCodigo(ConstantesUtil.CODIGO_EXITO);
                objMensajeDto.setMensaje(ConstantesUtil.MENSAJE_EXITO);
            }

        }catch (Exception ex){
            objLogger.error(ex);
            objMensajeDto.setCodigo(ConstantesUtil.CODIGO_ERROR);
            objMensajeDto.setMensaje(ConstantesUtil.MENSAJE_ERROR);
        }
        return RespuestaUtil.ok(objMensajeDto);
    }


}
