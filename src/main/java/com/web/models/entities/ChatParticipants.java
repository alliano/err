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

@Setter @Getter @Table(name = "chat_participants") @Entity
public class ChatParticipants extends TrackingDateTime implements Serializable {
   
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id")
   private Users user;

   @OneToOne
   @JoinColumn(name = "chat_id")
   private Chats chat;

   public ChatParticipants(Long id, Users user, Chats chat) {
      super();
      this.chat = chat;
      this.id = id;
      this.user = user;
   }

   public ChatParticipants(){ super(); }
}
