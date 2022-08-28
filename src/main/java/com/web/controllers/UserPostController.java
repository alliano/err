package com.web.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
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
import com.web.models.entities.Users;
import com.web.models.entities.role.UserRole;
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
   //   Iterable<Posts> posts = postService.findAllPosts(size, page, "asc");


     Users user1 = new Users();
     user1.setId(1L);
     user1.setName("babi1");
     user1.setEmail("bab1i@gmail.com");
     user1.setLevel_user(UserRole.USER);

     Posts data = new Posts();
     data.setImage("kdcjwknv.jpg");
     data.setMessage("dkavcljsnrfdg");
     data.setUser(user1);

     
     Users user2 = new Users();
     user2.setId(2L);
     user2.setName("babi2");
     user2.setEmail("babi2@gmail.com");
     user2.setLevel_user(UserRole.USER);

     Posts data2 = new Posts();
     data2.setImage("kdcjwknv.jpg");
     data2.setMessage("dkavcljsnrfdg");
     data2.setUser(user1);
     
     
     Users user3 = new Users();
     user3.setId(3L);
     user3.setName("babi3");
     user3.setEmail("babi3@gmail.com");
     user3.setLevel_user(UserRole.USER);
     
     Posts data3 = new Posts();
     data3.setImage("kdcjwknv.jpg");
     data3.setMessage("dkavcljsnrfdg");
     data3.setUser(user1);
     

     Users user4 = new Users();
     user4.setId(4L);
     user4.setName("babi4");
     user4.setEmail("babi4@gmail.com");
     user4.setLevel_user(UserRole.USER);
     
     Posts data4 = new Posts();
     data4.setImage("kdcjwknv.jpg");
     data4.setMessage("dkavcljsnrfdg");
     data4.setUser(user1);
     
     List<Posts> list = new ArrayList<Posts>();
     list.add(data);
     list.add(data2);
     list.add(data3);
     list.add(data4);
     
     Iterable<Posts> dataDumy = List.of(data,data2,data3,data4);
   
     
    
     for (Posts posts2 : dataDumy) {
        System.out.println(posts2.getId());
        System.out.println(posts2.getImage());
        System.out.println(posts2.getMessage());
        System.out.println(posts2.getUser().getName());
     }
      return dataDumy;
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
