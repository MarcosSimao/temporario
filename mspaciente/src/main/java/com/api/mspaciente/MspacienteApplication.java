package com.api.mspaciente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MspacienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MspacienteApplication.class, args);
	}

}
