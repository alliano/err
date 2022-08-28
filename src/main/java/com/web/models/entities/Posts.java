package com.web.models.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import com.fasterxml.jackson.annotation.JsonInclude;
import com.web.models.entities.auditing.TrackingDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Entity @Table(name = "posts") @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Posts extends TrackingDateTime implements Serializable {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @NotNull
   @ManyToOne(targetEntity = Users.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(name = "user_id", insertable = false ,updatable = false)
   private Users user; 

   @Column(name = "message_content", length = 2000, nullable = false)
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
