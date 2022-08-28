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
      else if(user.getPassword().isEmpty() || user.getEmail().isEmpty()) {
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

   /**
    * update provile
    * @return
    */
   public Users updatUsers( Users user){
      Users dataUser = userRepository.findById(user.getId()).get();
      try{
         if(user.getName().isEmpty()) dataUser.setName(user.getName());
         else if(user.getEmail() != null) dataUser.setEmail(user.getEmail());
         else if(user.getPassword() != null) dataUser.setEmail(user.getEmail());
         else if(user.getPassword() != null) dataUser.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
         else if(user.getProfile() != null) dataUser.setProfile(user.getProfile());
         else if(user.getProfile_cover() == null) dataUser.setProfile_cover(user.getProfile_cover());

         System.out.println(dataUser.getEmail());
         System.out.println(dataUser.getName());
         System.out.println(dataUser.getProfile());

         userRepository.updateUserProfile(user.getName(), user.getEmail(), user.getPassword(), user.getProfile(), user.getProfile_cover(), user.getId());
         return userRepository.findById(user.getId()).get();
      }catch(NullPointerException Npe){
         System.out.println("b aja ngntd");
         return null;
      }
   }
   
}
