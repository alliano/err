package com.web.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.models.entities.Users;
import com.web.models.repositories.UserRepository;
import com.web.utils.GetUser;

@Service
public class UserService implements UserDetailsService {

   private UserRepository userRepository;

   private BCryptPasswordEncoder bCryptPasswordEncoder;

   public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
      this.userRepository = userRepository;
      this.bCryptPasswordEncoder = bCryptPasswordEncoder;
   }

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
    * update profile
    * @return
    */
   @jakarta.transaction.Transactional
   public Users updatUsers( Users user){
      Users dataUser = userRepository.findById(user.getId()).get();
      try{
         if(user.getName() != null) dataUser.setName(user.getName()); 
         if(user.getProfile() != null) dataUser.setProfile(user.getProfile());
         if(user.getProfile_cover() != null) dataUser.setProfile_cover(user.getProfile_cover());
         return userRepository.save(dataUser);
      }catch(NullPointerException Npe){
         System.out.println(Npe.getMessage());
         throw new NullPointerException("datanya null coba cek di UserService.java ");
      }
   }

   public void changePassword(String newPassword){
      System.out.println("\n\n\n\n\n"+newPassword+"\n\n");
      Users user = GetUser.GetMe().get();
      // cek kekuatan password

      //klo kuat save password

      // klo ga kuat batalkan changePassword
      System.out.println(user.getEmail());
   }
   
}
