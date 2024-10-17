package com.wipro.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.mapping.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
