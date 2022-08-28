package com.web.dto;

import com.web.models.entities.role.UserRole;

import lombok.Data;

@Data
public class UpdateUserDto {

     private long id;

     private String name;

     private String email;

     private String password;

     private String prfile; 

     private String cover;

     private UserRole level_user = UserRole.USER;
}