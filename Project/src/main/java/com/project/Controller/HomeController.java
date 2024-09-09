package com.project.Controller;



import com.project.Model.CommentRequest;
import com.project.Model.Post;
import com.project.Service.CommentService;
import com.project.Service.PostService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller

public class HomeController {

    @Autowired
    PostService postService;
    @Autowired
    HttpSession session;
    @Autowired
    CommentService commentService;

    @GetMapping("/addPost")
    public String postt() {
        return
                "addPost.html";
    }


    @PostMapping("/create")
    public Post createPost(
            @RequestParam("file") MultipartFile file,

            @RequestParam("description") String description) throws IOException {
        LocalDate datee = null;
        return postService.addPost(file, description, datee);
    }


    @GetMapping("/all")
    @ResponseBody
    public List<Post> getAllPosts() {
        return postService.getAll();
    }

    @PostMapping("/addComment")
    public String addComment(@RequestBody CommentRequest commentRequest) {


        commentService.saveComment(commentRequest.getPostId(), commentRequest.getComment(), commentRequest.getUsername());
        return "Posted";
    }
}



