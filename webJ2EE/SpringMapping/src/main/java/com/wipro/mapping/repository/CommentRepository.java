package com.wipro.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.mapping.entity.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
