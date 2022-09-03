package com.web.dto;

import com.web.validators.PasswordEqualConstrain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @PasswordEqualConstrain(message = "password and confirmation password must match !")
public class UpdatePasswordDto {

     @Size(min = 8,message = "password can't less from 8 characters!")
     @NotEmpty
     private String lastPassword;

     @NotEmpty(message = "new password is required!")
     private String password;

     @NotEmpty(message = "confirmation password is required!")
     private String confirmationPassword;
}

