package com.vg.seviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SeviceregistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeviceregistryApplication.class, args);
	}

}
