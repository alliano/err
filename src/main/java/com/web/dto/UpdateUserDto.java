package com.web.dto;

import com.web.models.entities.role.UserRole;

import lombok.Data;

@Data
public class UpdateUserDto {

     private long id;

     private String name;
     
     private String profile; 

     private String profile_cover;

     private UserRole level_user = UserRole.USER;
}