package com.web.models.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.web.models.entities.auditing.TrackingDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter @Entity @Table(name ="grups")
public class Groups extends TrackingDateTime implements Serializable {
 
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(name = "name", nullable = false)
   private String name;

   @Column(name = "profile", nullable = true)
   private String profile;

   @Column(name = "profile_name", nullable = true)
   private String profile_cover;

   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(
      name = "users_groups",
      joinColumns = @JoinColumn(name = "group_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
   @JsonManagedReference
   private List<Users> users;
}
