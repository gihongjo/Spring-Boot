package org.example.simpleboard.post.service;


import lombok.RequiredArgsConstructor;
import org.example.simpleboard.board.db.BoardRepository;
import org.example.simpleboard.post.db.PostEntity;
import org.example.simpleboard.post.db.PostRepository;
import org.example.simpleboard.post.model.PostRequest;
import org.example.simpleboard.post.model.PostViewRequest;
import org.example.simpleboard.reply.service.ReplyService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    private final ReplyService replyService;



    public PostEntity create(
        PostRequest postRequest
    ){

        var boardEntity = boardRepository
                .findById(postRequest.getBoardId())
                .get();// < 임시고정 원래는 존재하는지 까지 판별해야함

        var entity= PostEntity.builder()
                 .board(boardEntity) //임시고정
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

    /*
    * 1. 게시글이 있는가?
    * 2. 비밀번호가 맞는가?
    * */
    public PostEntity view(PostViewRequest postViewRequest) {
       //요청 본문이 들어오면 JpaRepository를 활용해


        return postRepository
                .findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(),"REGISTERED")  //findById는 옵셔널(반복적인 null check 가능)
                .map(data->{
                if(!data.getPassword().equals(postViewRequest.getPassword())){

                    var format ="패스워드가 맞지 않습니다. %s vs %s";
                    throw new RuntimeException(String.format(format, data.getPassword(),postViewRequest.getPassword()));
                }
                //여기에서 각 게시물과 게시물의 댓글도 보여주겠다.

                return data;
        }).orElseThrow( //findById가 옵셔널이기 때문에 orElseThrow를 던져줄 수 있다. (null일 때를 대비할 수 있다.)
                        ()->{
                            return new RuntimeException("해당 게시글이 존재하지 않습니다. 게시글 ID:"+postViewRequest.getPostId());
                        }
                );

    }


    public List<PostEntity> all() {
        return postRepository.findAll();
    }


    public void delete(PostViewRequest postViewRequest) {

        postRepository
                .findById(postViewRequest.getPostId())  //findById는 옵셔널(반복적인 null check 가능)
                .map(data->{
                    if(!data.getPassword().equals(postViewRequest.getPassword())){

                        var format ="패스워드가 맞지 않습니다. %s vs %s";
                        throw new RuntimeException(String.format(format, data.getPassword(),postViewRequest.getPassword()));
                    }

                    data.setStatus("UNREGISTERED");
                    postRepository.save(data);

                    return data;
                }).orElseThrow( //findById가 옵셔널이기 때문에 orElseThrow를 던져줄 수 있다. (null일 때를 대비할 수 있다.)
                        ()->{
                            return new RuntimeException("해당 게시글이 존재하지 않습니다."+postViewRequest.getPostId());
                        }
                );

    }
}
