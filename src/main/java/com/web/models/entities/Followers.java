package com.web.models.entities;

import java.io.Serializable;
import java.util.List;

import com.web.models.entities.auditing.TrackingDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Table(name = "followers") @Entity
public class Followers extends TrackingDateTime implements Serializable {
   
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "follower_id")
   private Users follower;

   @OneToMany(cascade = CascadeType.ALL, targetEntity = Users.class)
   @JoinColumn(name = "following_id")
   private List<Users> following;

   public Followers(Long id, Users follower, List<Users> following) {
      super();
      this.id = id;
      this.follower = follower;
      this.following = following;
   }

   public Followers(){ super(); }

}
