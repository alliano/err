package com.web.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;

import com.web.dto.RegisterDto;
import com.web.dto.ResponseHttp;
import com.web.dto.UpdateUserDto;
import com.web.models.entities.Users;
import com.web.models.repositories.UserRepository;
import com.web.utils.GetUser;
import com.web.utils.ParseErrors;
import com.web.utils.ParseFile;
import com.web.utils.ParseGender;

import jakarta.transaction.Transactional;

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

   public ResponseEntity<?> registration(RegisterDto userRegistration,Errors errors){

      ResponseHttp<Users> httpResponse = new ResponseHttp<Users>();
      boolean userExist = this.userRepository.findByEmail(userRegistration.getEmail()).isPresent();
      Users user = new Users();
      if(errors.hasErrors()){
        httpResponse.setMessages( ParseErrors.setErrors(errors));
        httpResponse.setStatus(false);
        httpResponse.setPayload(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(httpResponse);
      }
      else {
      //cek user nya udah ada di database atau belum
      if(userExist)throw new RuntimeException("email already to use please changes other email");

      //cek status password
      if(userRegistration.getPassword() == null) {
         httpResponse.setMessages(List.of("password is required"));
         Runtime.getRuntime().exit(0);
      }
      else if (userRegistration.getPassword().equalsIgnoreCase("123456789")) {
         httpResponse.setMessages(List.of("password doesn't strong!"));
         Runtime.getRuntime().exit(0);
      }
      else if(userRegistration.getPassword().length() < 5){
         httpResponse.setMessages(List.of("password can't less than 6 characters"));
         Runtime.getRuntime().exit(0);
      }
      else {
         user.setPassword(bCryptPasswordEncoder.encode(userRegistration.getPassword()));
      }

      //cek email
      if(userRegistration.getEmail() == null) {
         httpResponse.setMessages(List.of("email is required!"));
         Runtime.getRuntime().exit(0);
      }
      else{
         user.setName(userRegistration.getName());
         user.setEmail(userRegistration.getEmail());
         user.setLevel_user(userRegistration.getLevel_user());
         user.setGender(ParseGender.parse(userRegistration.getGender()));
      }

      httpResponse.setStatus(true);
      httpResponse.setPayload(userRepository.save(user));
      return ResponseEntity.status(HttpStatus.OK).body(httpResponse);
      }
   }



   public List<Users> findAll(){
      return userRepository.findAll();
   }

   /**
    * update Name
    * @return
    */
   @Transactional
   public Users updatUsers(UpdateUserDto user ){
      Users dataUser = GetUser.getMe().get();
      try{
         if(user.getName() != null) dataUser.setName(user.getName());

         return userRepository.save(dataUser);
      }catch(NullPointerException Npe){
         System.out.println(Npe.getMessage());
         throw new NullPointerException("datanya null coba cek di UserService.java ");
      }
   }

   /**
    * update profile and cover
    * @param profile
    * @param cover
    * @return
    */
   @Transactional
   public Users updateProfileCover(MultipartFile profile, MultipartFile cover){
      Users user = GetUser.getMe().get();
      if(!profile.isEmpty()){
         user.setProfile(ParseFile.getNewName(profile));
      }
      else {
         throw new RuntimeException("tidak dapat mengupdate profile");
      }
      if(!cover.isEmpty()){
         user.setProfile_cover(ParseFile.getNewName(cover));
      }
      else{
         throw new RuntimeException("tidak dapat meng update cover");
      }
      return userRepository.save(user);
   }







   public void changePassword(String newPassword){
      System.out.println("\n\n\n\n\n"+newPassword+"\n\n");
      Users user = GetUser.getMe().get();
      // cek kekuatan password

      //klo kuat save password

      // klo ga kuat batalkan changePassword
      System.out.println(user.getEmail());
   }

}
