package org.example.simpleboard.post.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.post.db.PostEntity;
import org.example.simpleboard.post.model.PostRequest;
import org.example.simpleboard.post.model.PostViewRequest;
import org.example.simpleboard.post.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class postApiController {

    private final PostService postService;


    @PostMapping("")    //기본 주소로 설정
    public PostEntity create(

            @Valid
            @RequestBody
            PostRequest postRequest

    ){

        return postService.create(postRequest);

    }

    @PostMapping("/view")
    public PostEntity view(
            @Valid
            @RequestBody
            PostViewRequest postViewRequest
    ){

        return postService.view(postViewRequest);

    }

    @GetMapping("/all")
    public List<PostEntity> all(

    ){
        return postService.all();

    }

    @PostMapping("/delete")
    public void delete(
            @Valid
            @RequestBody
            PostViewRequest postViewRequest

    ){

        postService.delete(postViewRequest);

    }


}
