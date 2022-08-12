package com.web.models.entities.role;

public enum UserGender {
   MALE("MALE"),FEMALE("FEMALE");

   protected String value;

   private UserGender(String value){
      this.value = value;
   }
}
