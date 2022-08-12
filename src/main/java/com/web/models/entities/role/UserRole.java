package com.web.models.entities.role;

public enum UserRole {
   USER("USER"),ADMIN("ADMIN");

   protected String value;

   private UserRole(String value){
      this.value = value;
   }
}
