package org.example.simpleboard.reply.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.post.db.PostRepository;
import org.example.simpleboard.reply.db.ReplyEntity;
import org.example.simpleboard.reply.db.ReplyRepository;
import org.example.simpleboard.reply.model.ReplyRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;

    public ReplyEntity create(

            ReplyRequest replyRequest
    ){


        var optionalPostEntity = postRepository.findById(replyRequest.getPostId());

        if(optionalPostEntity.isEmpty()){
            throw new RuntimeException("post게시물이 존재하지 않습니다."+replyRequest.getPostId());
        }

        var entity = ReplyEntity.builder()
                .post(optionalPostEntity.get())
                .userName(replyRequest.getUserName())
                .password(replyRequest.getPassword())
                .title(replyRequest.getTitle())
                .content(replyRequest.getContent())
                .status("REGISTERED")
                .repliedAt(LocalDateTime.now())
                .build();

        return replyRepository.save(entity);

    }

    public List<ReplyEntity> findAllbyPostId(
            Long postId
    ){

        return replyRepository.findAllByPostIdAndStatusOrderByIdDesc(postId, "REGISTERED");
    }


}
