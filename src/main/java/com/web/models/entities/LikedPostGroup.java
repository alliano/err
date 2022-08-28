package com.web.models.entities;


import java.io.Serializable;

import com.web.models.entities.auditing.TrackingDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Entity @Table(name = "liked_post_group")
public class LikedPostGroup extends TrackingDateTime implements Serializable {
   
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @ManyToOne()
   @JoinColumn(name = "post_id")
   private PostsGroup postsGroup;
 
   @OneToOne()
   @JoinColumn(name = "user_id")
   private Users user;

   public LikedPostGroup(long id, PostsGroup postsGroup, Users user) {
      super();
      this.id = id;
      this.postsGroup = postsGroup;
      this.user = user;
   }

   public LikedPostGroup(){
      super();
   }
}
