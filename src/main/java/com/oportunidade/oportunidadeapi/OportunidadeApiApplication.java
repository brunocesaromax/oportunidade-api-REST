package com.oportunidade.oportunidadeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.oportunidade.oportunidadeapi"})
public class OportunidadeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OportunidadeApiApplication.class, args);
	}

}
