package com.web.models.entities;

import java.io.Serializable;

import com.web.models.entities.auditing.TrackingDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter @Table(name = "addresses") @Entity
public class Addresses extends TrackingDateTime implements Serializable {
   
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @OneToOne(cascade = CascadeType.ALL, targetEntity = Users.class)
   @JoinColumn(name = "user_id")
   private Users user;

   @Column(name = "street", length = 100, nullable = true)
   private String street;

   @Column(name = "contry", length = 50, nullable = true)
   private String country;

   @Column(name = "province", length = 50, nullable = true)
   private String province;

   @Column(name = "distinch", length = 50, nullable = true)
   private String districh;

   public Addresses(long id, Users user, String street, String country, String province, String districh) {
      this.id = id;
      this.user = user;
      this.street = street;
      this.country = country;
      this.province = province;
      this.districh = districh;
   }

   public Addresses(){
      super();
   }

}
