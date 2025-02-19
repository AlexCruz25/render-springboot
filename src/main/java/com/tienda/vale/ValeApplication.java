package com.tienda.vale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ValeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValeApplication.class, args);
                System.out.println("Servidor Activo");
	}

}
