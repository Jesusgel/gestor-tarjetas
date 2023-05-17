package com.crud.tarjeta.api_tarjetas;

import com.crud.tarjeta.api_tarjetas.configuration.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class ApiTarjetasApplication {

	public static void main(String[] args) {
		//Class<?>[] configClasses = {ApiTarjetasApplication.class, SwaggerConfig.class};
		SpringApplication.run(ApiTarjetasApplication.class, args);
	}

}
