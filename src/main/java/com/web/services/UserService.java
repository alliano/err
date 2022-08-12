package com.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.models.entities.Users;
import com.web.models.repositories.UserRepository;

@Service
public class UserService implements UserDetailsService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      return this.userRepository.findByEmail(email)
      .orElseThrow(() -> new UsernameNotFoundException(String.format("email \s doesn't exist", email)));
   }

   public Users registration(Users user){

      boolean userExist = this.userRepository.findByEmail(user.getEmail()).isPresent();

      if (userExist){
         throw new RuntimeException(String.format("user with \s already exist !", user.getEmail()));
      }
      else if(user.getPassword().equals(null) || user.getEmail().equals(null)) {
         throw new RuntimeException("email and password is required");
      }
      else {
         try{
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return this.userRepository.save(user);
         }catch(Exception EX){
            throw new RuntimeException(EX.getMessage());
         }
      }

   }

   public List<Users> findAll(){
      return userRepository.findAll();
   }
   
   
}
