package com.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.web.dto.LoginDto;
import com.web.dto.RegisterDto;
import com.web.dto.ResponseHttp;
import com.web.models.entities.Users;
import com.web.models.entities.role.UserGender;
import com.web.services.UserService;
import com.web.utils.ParseErrors;

import eye2web.modelmapper.ModelMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/")
public class UserController {

   @Autowired
   private UserService userService;

   @Autowired
   private ModelMapper modelMapper;

   // @PostMapping(path = "/login")
   // public ResponseEntity<?> login(@RequestBody @Valid LoginDto login, Errors errors) {
   //    ResponseHttp<Users> responseHttp = new ResponseHttp<Users>();
   //    if(errors.hasErrors()){
   //       responseHttp.setMessages(ParseErrors.setErrors(errors));
   //       responseHttp.setStatus(false);
   //       responseHttp.setPayload(null);
   //       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseHttp);
   //    }
   //    else{
   //       Users user = modelMapper.map(login, Users.class);
   //       responseHttp.setStatus(true);
   //       responseHttp.getMessages().add("hallo "+user.getName());
   //       responseHttp.setPayload(this.userService.registration(user));
   //       return ResponseEntity.status(HttpStatus.OK).body(responseHttp);
   //    }
   // }
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
         Users user = modelMapper.map(registration, Users.class);
         user.setGender(checkGender(registration.getGender()));
         responseHttp.getMessages().add("welcome "+user.getName());
         responseHttp.setStatus(true);
         responseHttp.setPayload(userService.registration(user));
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseHttp);
      }
   }

   private UserGender checkGender (String gen){
      try {
         if(gen.equalsIgnoreCase("male")) return UserGender.MALE;
         else if(gen.equalsIgnoreCase("female")) return UserGender.FEMALE;
         else if(gen.equals(null)) return UserGender.FEMALE;
         else
         return UserGender.FEMALE;
      } catch (NullPointerException e) {
         System.out.println(e);
         return null;
      }
   }

   @GetMapping(path = "/findAll")
   public List<Users> findAll(){
      return userService.findAll();
   }
}
