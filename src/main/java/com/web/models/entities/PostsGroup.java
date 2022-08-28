package com.web.models.entities;

import java.io.Serializable;

import com.web.models.entities.auditing.TrackingDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Entity @Table(name ="posts_group")
public class PostsGroup extends TrackingDateTime implements Serializable {
   
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @ManyToOne(targetEntity = Users.class)
   @JoinColumn(name = "user_id")
   private Users user;

   @ManyToOne(targetEntity = Groups.class)
   @JoinColumn(name = "group_id")
   private Groups group;

   @Column(name = "message", length = 9999, nullable = false)
   private String message;

   @Column(name = "image", nullable = true)
   private String image;

   public PostsGroup(long id, Users user, Groups group, String message, String image) {
      super();
      this.id = id;
      this.user = user;
      this.group = group;
      this.message = message;
      this.image = image;
   }

   public PostsGroup(){
      super();
   }

   
}
