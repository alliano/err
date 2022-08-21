package com.web.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.models.entities.Posts;


@Repository
public interface UserPostRepository extends JpaRepository<Posts, Long> {
   
}
