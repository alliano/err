package com.web.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dto.ResponseHttp;
import com.web.dto.UpdatePasswordDto;
import com.web.dto.UpdateUserDto;
import com.web.models.entities.Users;
import com.web.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/profile")
public class UserProfileController {
     
     private UserService userService;

     private ModelMapper modelMapper;

     public UserProfileController(UserService userService, ModelMapper modelMapper){
          this.userService = userService;
          this.modelMapper = modelMapper;
     }

     @PostMapping(path = "/update")
     public Users updateUser(@RequestBody UpdateUserDto user,@Valid Errors error){
          this.userService.changePassword("random");
          return this.userService.updatUsers(modelMapper.map(user, Users.class));
     }

     public ResponseEntity<ResponseHttp<Users>> updatePassword(@RequestBody UpdatePasswordDto nPassword, @Valid Errors errors){
          
          ResponseHttp<Users> responseHttp = new ResponseHttp<>();

          if(errors.hasErrors()){
               System.out.println("error");
          }
          return ResponseEntity.status(HttpStatus.OK).body(responseHttp);
     }
}
