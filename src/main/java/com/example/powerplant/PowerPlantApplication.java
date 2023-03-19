package com.example.powerplant;

import com.example.powerplant.config.DBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({DBConfig.class})

public class PowerPlantApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerPlantApplication.class, args);
	}
}