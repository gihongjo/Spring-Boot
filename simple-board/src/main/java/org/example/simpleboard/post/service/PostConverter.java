package org.example.simpleboard.post.service;

import org.example.simpleboard.post.model.PostDto;
import org.example.simpleboard.post.db.PostEntity;
import org.springframework.stereotype.Service;


//데이터를 변환해주는 기능을 한곳에 모아주기 위해 컨버터를 만들었다.

@Service
public class PostConverter {
    public PostDto toDto(PostEntity postEntity){

       return PostDto.builder()
                .id(postEntity.getId())
                .boardId(postEntity.getId())
               .status(postEntity.getStatus())
                .userName(postEntity.getUserName())
                .password(postEntity.getPassword())
                .email(postEntity.getEmail())
                .title(postEntity.getTitle())
                .postedAt(postEntity.getPostedAt())
                .content(postEntity.getContent())
                .boardId(postEntity.getBoard().getId())
                .build();

    }

}
