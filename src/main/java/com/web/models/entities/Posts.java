package com.web.models.entities;

import java.io.Serializable;

import com.web.models.entities.auditing.BaseEntity;

import jakarta.persistence.CascadeType;
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

@Setter @Getter @Entity @Table(name = "posts")
public class Posts extends BaseEntity implements Serializable {
   
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @ManyToOne(targetEntity = Users.class, cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id")
   private Users user;

   @Column(name = "message_content", length = 600, nullable = false)
   private String message;

   @Column(name = "image", nullable = true)
   private String image;

   public Posts(long id, Users user, String message, String image) {
      super();
      this.id = id;
      this.user = user;
      this.message = message;
      this.image = image;
   }

   public Posts(){
      super();
   }
}
