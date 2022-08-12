package com.web.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {
   
   @Bean(name = "modelMapper")
   public ModelMapper modelMapper(){
      return new ModelMapper();
   }
}
