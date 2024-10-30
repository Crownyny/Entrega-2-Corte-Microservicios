package co.edu.unicauca.rest_api.api_rest.facadeServices.mapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class Mapper {
    
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
