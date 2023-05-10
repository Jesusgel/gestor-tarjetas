package com.crud.tarjeta.api_tarjetas.mappers;

import com.crud.tarjeta.api_tarjetas.dto.TarjetaDto;
import com.crud.tarjeta.api_tarjetas.model.Tarjeta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapperStruct  {

    IMapperStruct INSTANCE = Mappers.getMapper(IMapperStruct.class);

    TarjetaDto TarjetaToTarjetaDto(Tarjeta objTarjeta);

    List<TarjetaDto>   TarjetasToTarjetasDtos(List<Tarjeta> lstTarjetas);
}
