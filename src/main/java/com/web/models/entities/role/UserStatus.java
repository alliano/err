package com.web.models.entities.role;

public enum UserStatus {
   ACTIVE("ACTIVE"),OFF("OFF");

   protected String value;

   private UserStatus(String value){
      this.value = value;
   }
}
