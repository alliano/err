package com.web.utils;

import com.web.models.entities.role.UserGender;

public class ParseGender {
   
   public static UserGender parse(String gender) {
      try {
         if(gender.equalsIgnoreCase("male")) return UserGender.MALE;
         else if(gender.equalsIgnoreCase("female")) return UserGender.FEMALE;
         else if(gender.equals(null)) return UserGender.FEMALE;
         else
         return UserGender.FEMALE;
      } catch (NullPointerException e) {
         System.out.println(e);
         return null;
      }
   }
}
