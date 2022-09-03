package com.web.utils;

import java.util.Optional;

import org.springframework.security.core.context.SecurityContextHolder;

import com.web.models.entities.Users;

public class GetUser {

     public static Optional<Users> getMe() {
          return Optional.of( (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
     }

}