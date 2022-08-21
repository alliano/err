package com.web.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.web.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfiguration {

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Autowired
   private UserService loginService;

   @Bean(name = "secureFilterChain  ")
   public SecurityFilterChain filterChain(HttpSecurity http ) throws Exception {

      http.authorizeRequests( autorize -> {
         try {
            autorize.antMatchers(HttpMethod.POST, "/register").permitAll()
            .anyRequest().authenticated().and().httpBasic().and().sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authenticationProvider(authenticationProvider()).csrf().disable();
         } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
         }
      });
      return http.build();
   }

   protected DaoAuthenticationProvider authenticationProvider(){
      DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
      auth.setPasswordEncoder(this.bCryptPasswordEncoder);
      auth.setUserDetailsService(this.loginService);
      return auth;
   }

   @Bean(value = "autenticationManager")
   public AuthenticationManager authManager(AuthenticationConfiguration configuration) throws Exception {
      return configuration.getAuthenticationManager();
   }

   @Bean(value = "webMvcConfigurer")
   public WebMvcConfigurer webMvcConfigurer(){
      return new WebMvcConfigurer() {
         @Override
         public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/").allowedOrigins("*")
            .allowedHeaders("*").allowedMethods("*")
            .allowedOriginPatterns("*", "**");
            WebMvcConfigurer.super.addCorsMappings(registry);
         }
      };
   }


}