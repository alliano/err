package com.web.models.entities;

import java.io.Serializable;

import com.web.models.entities.auditing.TrackingDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Entity @Table(name = "comments")
public class Comments extends TrackingDateTime implements Serializable {
   
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @ManyToOne(targetEntity = Users.class, cascade = CascadeType.PERSIST)
   private Users user;
   
   @ManyToOne(targetEntity = Posts.class, cascade = CascadeType.ALL)
   private Posts post;

   @Column(name = "message", length = 9999, nullable = false)
   private String message;

   public Comments(long id, Users user, Posts post, String message) {
      super();
      this.id = id;
      this.user = user;
      this.post = post;
      this.message = message;
   }

   public Comments(){
      super();
   }

}
