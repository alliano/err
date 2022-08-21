package com.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.dto.PostDto;
import com.web.models.entities.Posts;
import com.web.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/post")
public class UserPostController {
   
   @Autowired
   private PostService postService;

   @Autowired
   private ModelMapper modelMapper;

   @PostMapping(path = "")
   public Posts createPost(@RequestBody @Valid PostDto post, Errors errors){

      Posts userPost = modelMapper.map(post, Posts.class);
      return this.postService.createPost(userPost);
   }
}
