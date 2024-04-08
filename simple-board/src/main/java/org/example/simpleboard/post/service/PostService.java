package org.example.simpleboard.post.service;


import lombok.RequiredArgsConstructor;
import org.example.simpleboard.post.db.PostEntity;
import org.example.simpleboard.post.db.PostRepository;
import org.example.simpleboard.post.model.PostRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    public PostEntity create(
        PostRequest postRequest
    ){
        var entity= PostEntity.builder()
                .board_id(1L) //임시고정
                .email(postRequest.getEmail())
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .title(postRequest.getTitle())
                .status("REGISTERED")
                .postedAt(LocalDateTime.now())
                .content(postRequest.getContent())
                .build();

    return postRepository.save(entity);
    }

}
