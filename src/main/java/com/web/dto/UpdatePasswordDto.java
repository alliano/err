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
     private String password;

     @NotEmpty
     private String confirmationPassword;
}
