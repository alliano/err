package com.web.models.entities;

import java.io.Serializable;

import com.web.models.entities.auditing.BaseEntity;
import com.web.models.entities.role.UserStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Entity @Table(name = "chats")
public class Chats extends BaseEntity implements Serializable {
   
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(name = "name", nullable = false, length = 50)
   private String name;

   @Enumerated(EnumType.STRING)
   private UserStatus status;

   public Chats(long id, UserStatus status) {
      super();
      this.id = id;
      this.status = status;
   }

   public Chats(){ super(); }

}
