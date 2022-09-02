package com.web.models.entities;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.web.models.entities.auditing.TrackingDateTime;
import com.web.models.entities.role.UserGender;
import com.web.models.entities.role.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity @Table(name = "users") @Getter @Setter
public class Users extends TrackingDateTime implements UserDetails {
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name", length = 50, nullable = true, unique = false)
   private String name;

   @Column(name = "email", length = 50, nullable = false, unique = true)
   private String email;

   @Column(name = "password", length = 255, nullable = false)
   private String password;

   @Enumerated(EnumType.STRING)
   private UserRole level_user;

   @Enumerated(EnumType.STRING)
   private UserGender gender;

   @Column(name = "profile" ,length = 255, nullable = true)
   private String profile;

   @Column(name = "profile_cover" ,length = 255, nullable = true, insertable = true, updatable = true)
   private String profile_cover;

   @ManyToMany(targetEntity = Groups.class, mappedBy = "users")
   private List<Groups> groups;

   public Users( List<Groups> groups, String name, String email, String password, UserRole level_user, UserGender gender, String profile, String profile_cover) {
      super();
      this.groups = groups;
      this.name = name;
      this.email = email;
      this.password = password;
      this.level_user = level_user;
      this.gender = gender;
      this.profile = profile;
      this.profile_cover = profile_cover;
   }
   public Users(){ 
      super(); 
   }

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      SimpleGrantedAuthority autority = new SimpleGrantedAuthority(this.level_user.name());
      return Collections.singleton(autority);
   }
   @Override
   public String getUsername() {
      return this.email;
   }

   @Override 
   public String getPassword(){
      return this.password;
   }

   @Override
   public boolean isAccountNonExpired() {
      return true;
   }
   @Override
   public boolean isAccountNonLocked() {
      return true;
   }
   @Override
   public boolean isCredentialsNonExpired() {
      return true;
   }
   @Override
   public boolean isEnabled() {
      return true;
   }

}
