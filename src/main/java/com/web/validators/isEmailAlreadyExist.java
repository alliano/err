package com.web.validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.models.repositories.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class isEmailAlreadyExist implements ConstraintValidator<EmailExist, String>{

   private @Autowired UserRepository userRepository;

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      
      return !userRepository.findByEmail(value).isPresent();
   }
}
