package com.web.validators;

import com.web.models.repositories.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsEmailAlreadyExist implements ConstraintValidator<EmailExist, String>{

   private UserRepository userRepository;

   public IsEmailAlreadyExist(UserRepository userRepository){
      this.userRepository = userRepository;
   }

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {

      return !userRepository.findByEmail(value).isPresent();
   }
}
