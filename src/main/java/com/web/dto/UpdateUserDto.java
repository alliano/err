package com.web.dto;

import com.web.models.entities.role.UserRole;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UpdateUserDto {

     @NotEmpty(message = "name is required!")
     private String name;

     private UserRole level_user = UserRole.USER;
}