package com.web.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.models.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {
   
   public Optional<Users> findByEmail(String email);

   // @Query(name = "update", nativeQuery = true, value = "update users set users.name = :name, users.email = :email, users.password = :password, users.profile = :profile, users.profile_cover = :cover where id = :id")
   // public void updateUserProfile(@Param(value = "name") String name, @Param(value = "email") String email, @Param(value = "password") String password, @Param(value = "profile") String provile, @Param("cover") String cover, @Param(value = "id") long id);
}
