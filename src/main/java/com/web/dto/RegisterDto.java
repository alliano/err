package com.web.dto;

import com.web.models.entities.role.UserRole;
import com.web.validators.EmailExist;
import com.web.validators.PasswordEqualConstrain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@PasswordEqualConstrain(message = "password and confirmation password must match !")
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class RegisterDto {
   
   @NotEmpty(message = "name is required !")
   private String name;

   @NotEmpty(message = "email is required !")
   @Email
   @EmailExist(message = "email already to use !")
   private String email;

   @NotEmpty(message = "password is required !")
   private String password;

   @NotEmpty(message = "please fill confirmation password !")
   private String confirmationPassword;

   @NotEmpty(message = "gender is required ! ")
   private String gender;

   private UserRole level_user = UserRole.USER;


}
