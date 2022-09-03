package com.web.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfiguration implements WebMvcConfigurer {

     @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
         registry.addResourceHandler("/posts/**").addResourceLocations("/posts/");
         registry.addResourceHandler("/profile/**").addResourceLocations("/**");
         registry.addResourceHandler("/update/**").addResourceLocations("/update/**");
         WebMvcConfigurer.super.addResourceHandlers(registry);
     }

}
