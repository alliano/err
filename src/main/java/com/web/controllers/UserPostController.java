package com.web.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.web.dto.PostDto;
import com.web.models.entities.Posts;
import com.web.services.PostService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/posts")
public class UserPostController {

   @Autowired
   private PostService postService;

   @PostMapping(path = "/create")
   public void createPost(@RequestBody @Valid PostDto post, Errors errors) throws SQLException, Exception{
       postService.postStatus(post);
   }
   @GetMapping(path = "/p/{page}/{size}")
   public Iterable<Posts> findAllPosts(@PathVariable("page") int page, @PathVariable("size") int size) {
      return postService.findAllPosts(size, page, "asc");
   }

   @GetMapping(path = "/all")
   public List<Posts> findAll(){
      List<Posts> posts = postService.findAll();
      for (Posts posts2 : posts) {
         System.out.println(posts2.getMessage());
      }
      return postService.findAll();
   }
}
