package com.web.models.entities;

import java.io.Serializable;


import com.web.models.entities.auditing.BaseEntity;
import com.web.models.entities.role.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Entity @Table(name = "members")
public class Members extends BaseEntity implements Serializable {

   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(nullable = true)
   private long user;

   @Enumerated(EnumType.STRING)
   @Column(length = 20)
   private UserRole user_role;

   @ManyToOne(targetEntity = Groups.class, cascade = CascadeType.ALL)
   @JoinColumn(name = "group_id")
   private Groups group;
   
}
