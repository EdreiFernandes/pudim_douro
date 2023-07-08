package br.com.mountainfortress.PudimDouroAPI.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public ModelMapper getModelMapper() {return new ModelMapper();}
}
