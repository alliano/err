package com.web.models.entities;

import java.io.Serializable;
import com.web.models.entities.auditing.TrackingDateTime;

import jakarta.persistence.CascadeType;
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

@Setter @Getter @Entity @Table(name = "liked_post")
public class LikedPost extends TrackingDateTime implements Serializable {
   
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   
   @ManyToOne(targetEntity = Posts.class)
   @JoinColumn(name = "post_id")
   private Posts post;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id")
   private Users user;
   
   public LikedPost(long id, Posts post, Users user) {
      this.id = id;
      this.post = post;
      this.user = user;
   }

   public LikedPost(){
      super();
   }
}
