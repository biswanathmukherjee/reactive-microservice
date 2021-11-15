package com.ibm.learn.reactive.microservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Reactive Microservice",
				version = "1.0",
				description = "Open API Specification"
		)
)
public class ReactiveMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveMicroserviceApplication.class, args);
	}

}
