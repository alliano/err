package com.web.models.entities;

import java.io.Serializable;
import com.web.models.entities.auditing.TrackingDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Table(name = "chat_items") @Entity
public class ChatItems extends TrackingDateTime implements Serializable {
   
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinColumn(name = "chat_id")
   private Chats chat;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "sender_id")
   private Users user;

   @Column(name = "message" ,nullable = false, length = 99999)
   private String message;

   private long UUID;
}
