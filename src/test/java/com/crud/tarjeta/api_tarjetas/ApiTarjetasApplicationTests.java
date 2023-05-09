package com.crud.tarjeta.api_tarjetas;

import com.crud.tarjeta.api_tarjetas.dto.TarjetaDto;
import com.crud.tarjeta.api_tarjetas.mappers.IMapperStruct;
import com.crud.tarjeta.api_tarjetas.model.Tarjeta;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ApiTarjetasApplicationTests {

	@Test
	void shouldMapTarjetaToDto() {

		Tarjeta objTarjeta  = new Tarjeta("Jesus","12345","ITAU",111, LocalDate.now(),LocalDate.now(),1);

		//when
		TarjetaDto objTarjetaDto = IMapperStruct.INSTANCE.TarjetaToTarjetaDto(objTarjeta);

		assertThat(objTarjetaDto).isNotNull();
		assertThat(objTarjetaDto.getNombreTitular()).isEqualTo("Jesus");
		assertThat(objTarjetaDto.getNumeroTarjeta()).isEqualTo("12345");
		assertThat(objTarjetaDto.getNombreBanco()).isEqualTo("ITAU");
		assertThat(objTarjetaDto.getCvv()).isEqualTo(111);

	}


	@Test
	void shouldMapListTarjetasToDto() {

		Tarjeta objTarjeta1 = new Tarjeta("Jesus","12345","ITAU",111, LocalDate.now(),LocalDate.now(),1);
		Tarjeta objTarjeta2  = new Tarjeta("Angee","67890","ESTADO",111, LocalDate.now(),LocalDate.now(),1);
		Tarjeta objTarjeta3  = new Tarjeta("Maria","54321","PROVINCIAL",111, LocalDate.now(),LocalDate.now(),1);

		List<Tarjeta> lstTarjetas = new ArrayList<>();
		lstTarjetas.add(objTarjeta1);
		lstTarjetas.add(objTarjeta2);
		lstTarjetas.add(objTarjeta3);

		//when
		List<TarjetaDto> lstTarjetaDto = IMapperStruct.INSTANCE.TarjetasToTarjetasDtos(lstTarjetas);

		assertThat(lstTarjetaDto).isNotNull();
		assertThat(lstTarjetaDto.size()).isEqualTo(3);
		assertThat(lstTarjetaDto.get(0).getNombreTitular()).isEqualTo("Jesus");
		assertThat(lstTarjetaDto.get(1).getNombreTitular()).isEqualTo("Angee");
		assertThat(lstTarjetaDto.get(2).getNombreTitular()).isEqualTo("Maria");

	}

}
