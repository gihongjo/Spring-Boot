package org.example.simpleboard.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.post.db.PostEntity;
import org.example.simpleboard.post.model.PostRequest;
import org.example.simpleboard.post.service.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
