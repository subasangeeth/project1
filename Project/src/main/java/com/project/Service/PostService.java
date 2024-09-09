package com.project.Service;

import com.project.Controller.LoginController;
import com.project.Model.Post;
import com.project.Repo.PostRepo;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo;


    @Autowired
    private HttpSession httpSession;




    public Post addPost(MultipartFile imageData, String desc,LocalDate date) throws IOException {
        byte[] image = imageData.getBytes();
        date = LocalDate.now();
        Post post = new Post((String) httpSession.getAttribute("username"), image, desc,date);
        System.out.println((String) httpSession.getAttribute("username"));
        postRepo.save(post);

        return post;
    }


    public List<Post> getAll() {
        return postRepo.findAll();
    }


    public Optional<Post> getPostById(Long postId) {
        return postRepo.findById(postId);





            }

    public void savePost(Post post) {
        postRepo.save(post);
    }
}



    





