package br.com.mountainfortress.PudimDouroAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PudimDouroApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PudimDouroApiApplication.class, args);
	}

}
