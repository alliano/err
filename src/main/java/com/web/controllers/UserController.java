package com.web.controllers;

import java.util.List;

// import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.utils.ParseGender;
import com.web.dto.RegisterDto;
import com.web.dto.ResponseHttp;
import com.web.models.entities.Users;
import com.web.services.UserService;
import com.web.utils.ParseErrors;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/")
public class UserController {

   @Autowired
   private UserService userService;

   // @Autowired
   // private ModelMapper modelMapper;


   @GetMapping(path = "")
   public String hello(){
      return "<h1>this api on develompent mode</h1>";
   }


   @PostMapping(path = "/register")
   public ResponseEntity<?> register(@RequestBody @Valid RegisterDto registration, Errors errors){
      ResponseHttp<Users> responseHttp = new ResponseHttp<Users>();
      if(errors.hasErrors()){
         responseHttp.setMessages(ParseErrors.setErrors(errors));
         responseHttp.setStatus(false);
         responseHttp.setPayload(null);
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseHttp);
      }
      else {
         // Users user = modelMapper.map(registration, Users.class);
         
         Users user = new Users();
         user.setName(registration.getName());
         user.setEmail(registration.getEmail());
         user.setPassword(registration.getPassword());
         user.setGender(ParseGender.parse(registration.getGender()));

         responseHttp.getMessages().add("welcome "+user.getName());
         responseHttp.setStatus(true);
         responseHttp.setPayload(userService.registration(user));
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseHttp);
      }
   }

   @GetMapping(path = "/findAll")
   public List<Users> findAll(){
      return userService.findAll();
   }
}
