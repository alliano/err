package com.web.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dto.RegisterDto;
import com.web.models.entities.Users;
import com.web.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/")
public class UserController {

   private UserService userService;

   public UserController(UserService userService) {
      this.userService = userService;
   } 

   @GetMapping(path = "")
   public String hello(){
      return "<h1>this api on develompent mode</h1>";
   }


   @PostMapping(path = "/register")
   public ResponseEntity<?> register(@RequestBody @Valid RegisterDto registration, Errors errors){
      return userService.registration(registration, errors);
   }

   @GetMapping(path = "/findAll")
   public List<Users> findAll(){
      return userService.findAll();
   }
}
