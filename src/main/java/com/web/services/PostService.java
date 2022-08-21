package com.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.models.entities.Posts;
import com.web.models.repositories.UserPostRepository;

@Service
public class PostService {
   
   @Autowired
   private UserPostRepository userPostRepository;

   public Posts createPost(Posts post) {
      try {
         return this.userPostRepository.save(post);
      } catch (Exception e) {
         System.out.println(e);
         return null;
      }
   }
}
