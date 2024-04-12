package org.example.simpleboard.reply.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.reply.db.ReplyEntity;
import org.example.simpleboard.reply.db.ReplyRepository;
import org.example.simpleboard.reply.model.ReplyRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;


    public ReplyEntity create(

            ReplyRequest replyRequest
    ){

        var entity = ReplyEntity.builder()
                .postId(replyRequest.getPostId())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .status("REGISTERED")
                .repliedAt(LocalDateTime.now())
                .build();

        return replyRepository.save(entity);

    }


}
