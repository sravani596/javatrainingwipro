package com.wipro.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.mapping.entity.Comment;
import com.wipro.mapping.entity.Post;
import com.wipro.mapping.repository.PostRepository;

@SpringBootApplication
public class SpringMappingApplication implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Post post = new Post("One to Many mapping using JPA and Hibernate", "One to Many mapping using JPA and Hibernate");

        Comment comment1 = new Comment("Very useful");
        Comment comment2 = new Comment("Informative");
        Comment comment3 = new Comment("Great post");

        post.getComments().add(comment1);
        post.getComments().add(comment2);
        post.getComments().add(comment3);

        this.postRepository.save(post);
    }
}
