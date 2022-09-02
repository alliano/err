package com.web.models.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.models.entities.Posts;

@Repository
public interface UserPostRepository extends JpaRepository<Posts, Long> {
   
     @Modifying
     @Query(name = "crete", value = "insert into posts (image, message_content, user_id) values (:image, :message_content, :user_id)", nativeQuery = true)
     public void postStatus(@Param(value = "image") String image, @Param(value = "message_content") String message_content, @Param(value = "user_id") long user_id);

     public Page<Posts> findAll(Pageable pageable);
}
