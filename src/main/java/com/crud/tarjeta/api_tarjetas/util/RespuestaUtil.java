package com.crud.tarjeta.api_tarjetas.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespuestaUtil {

    public static <T> ResponseEntity<T> ok(T objGenerico){

        return new ResponseEntity<>(objGenerico, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> nuevo(T objGenerico){
        return new ResponseEntity<>(objGenerico, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<T> error(T objGenerico){
        return new ResponseEntity<>(objGenerico, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ResponseEntity<T>  sinContenido(T objGenerico){
        return new ResponseEntity<>(objGenerico, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<T>  noEncontrado(T objGenerico){
        return new ResponseEntity<>(objGenerico, HttpStatus.NOT_FOUND);
    }
}
