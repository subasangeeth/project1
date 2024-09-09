package com.project.Repo;

import com.project.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepo extends JpaRepository<Post, Integer> {


    Optional<Post> findById(Long postId);
}
