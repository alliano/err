package com.web.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.web.dto.PostDto;
import com.web.models.entities.Posts;
import com.web.models.repositories.UserPostRepository;

import jakarta.transaction.Transactional;

@Service
public class PostService {
   
   @Autowired
   private UserPostRepository userPostRepository;

   @Transactional
   public void postStatus(PostDto post) throws Exception, SQLException{
      userPostRepository.postStatus(post.getImage(), post.getMessage_content(), post.getUser());
   }

   public Iterable<Posts> findAllPosts(int size, int page, String sort){
      Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
      Page<Posts> posts = userPostRepository.findAllPosts(pageable);
      return posts;
   }

   public List<Posts> findAll() {
      return userPostRepository.findAll();
   }
}
