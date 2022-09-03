package com.web.utils;

import java.util.Random;

import org.springframework.web.multipart.MultipartFile;

public class ParseFile {

     private static String[] extentionAllow = {"jpg","jpeg","JPG","PNG","png"};

     public static String getNewName(MultipartFile file){
          String newName = generateNewName();
          boolean status = false;
          String[] result = file.getOriginalFilename().split("\\.");
          String extentionFIle = result[result.length-1];
          for(int i =  0; i < extentionAllow.length; i++){
               if(extentionFIle.equals(extentionAllow[i])){
                    status = true;
               }
          }
          if (status)
               return newName.concat("."+extentionFIle);
          else
               throw new RuntimeException("tidak dapat mendapatkan nama baru!");

     }
     private static String generateNewName(){
          Random random = new Random();
          char[] text = new char[30];
          String characters = "QWERTYUIOPASDFGHJKLZXCVBNM0987654321mnbvcxzasdfghjklpoiuytrewq#@%&*!$?/";

          //buat nama baru untuk file
          for(int i = 0; i < 30; i++){
               text[i] = characters.charAt(random.nextInt(characters.length()));
          }
          String newFileName = new String(text);
          return newFileName;
     }
}
