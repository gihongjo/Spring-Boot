package org.example.simpleboard.reply.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.reply.db.ReplyEntity;
import org.example.simpleboard.reply.model.ReplyRequest;
import org.example.simpleboard.reply.service.ReplyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController {

    private final ReplyService replyService;



    @RequestMapping
    @PostMapping("")
    public ReplyEntity create(

            @RequestBody ReplyRequest replyRequest
    ){

       return replyService.create(replyRequest); //replyService 메서드는 ReplyEntity를 반환한다.


    }


}
