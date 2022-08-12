package com.web.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import eye2web.modelmapper.ModelMapper;

@Configuration
public class ModelMapperConfiguration {
   
   @Bean(name = "modelMapper")
   public ModelMapper modelMapper(){
      return new ModelMapper();
   }
}
