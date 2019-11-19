package com.curso.tcc;

import com.curso.tcc.schedules.ConsumirCSVBanco;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableScheduling
public class TccApplication {

	public static void main(String[] args) {
		SpringApplication.run(TccApplication.class, args);
		new ConsumirCSVBanco().iniciar();
	}

}
