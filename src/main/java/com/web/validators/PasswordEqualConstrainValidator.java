package com.web.validators;


import com.web.dto.RegisterDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordEqualConstrainValidator implements ConstraintValidator<PasswordEqualConstrain, Object>{
 
   @Override
   public boolean isValid(Object value, ConstraintValidatorContext context) {
      try {
         RegisterDto register = (RegisterDto) value;
         boolean isNotEmpty = (register.getPassword().equals(null) || register.getConfirmationPassword().equals(null) ? true : false);
      if(isNotEmpty){
         return  false;
      }
      else if(register.getPassword().equals(register.getConfirmationPassword())){
         return true;
      }
      else {
         return false;
      }
      }catch(NullPointerException Npx){
         return false;
      }  

   }

}
