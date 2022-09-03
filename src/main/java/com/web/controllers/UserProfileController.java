package com.web.controllers;

import org.modelmapper.internal.Errors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

     public UserProfileController(UserService userService){
          this.userService = userService;
     }

     // update profile name
     @PostMapping(path = "/update")
     public ResponseEntity<?> updateUser(@RequestBody UpdateUserDto user,@Valid Errors errors){
          return ResponseEntity.status(HttpStatus.OK).body(userService.updatUsers(user));
     }

     // update profile and cover
     @PostMapping(path = "/procov")
     public ResponseEntity<?> updateCoverAndProfile(@RequestParam(name = "profile") MultipartFile profile, @RequestParam(value = "cover") MultipartFile cover){
          return ResponseEntity.status(HttpStatus.OK).body(userService.updateProfileCover(profile, cover));
     }










     public ResponseEntity<ResponseHttp<Users>> updatePassword(@RequestBody UpdatePasswordDto Password, @Valid Errors errors){

          ResponseHttp<Users> responseHttp = new ResponseHttp<>();

          if(errors.hasErrors()){
               System.out.println("error");
          }
          return ResponseEntity.status(HttpStatus.OK).body(responseHttp);
     }
}
