package com.project.Service;

import com.project.Model.Comment;
import com.project.Model.Post;
import com.project.Repo.CommentRepo;
import com.project.Repo.PostRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CommentService {

    @Autowired
    private PostRepo postRepository;

    @Autowired
    private CommentRepo commentRepository;

    @Autowired
    HttpSession session;


    public void saveComment(Long postId, String commentText,String username) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));


        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUsername(session.getAttribute("username").toString());
        comment.setText(commentText);


        commentRepository.save(comment);
    }
}
