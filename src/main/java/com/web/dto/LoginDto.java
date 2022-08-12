package com.web.dto;

import org.springframework.lang.Nullable;

import com.web.models.entities.role.UserRole;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class LoginDto {

   @NotEmpty(message = "email is required")
   private String email;

   @NotEmpty(message = "password is required")
   private String password;

   @Nullable
   private UserRole user_role = UserRole.USER;
   
}
