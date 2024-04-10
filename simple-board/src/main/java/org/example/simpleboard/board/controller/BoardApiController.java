package org.example.simpleboard.board.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.board.db.BoardEntity;
import org.example.simpleboard.board.model.BoardRequest;
import org.example.simpleboard.board.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("")
    public BoardEntity create(

            //유효성 검사. BoardRequest를 따라가보면 Not blank로 Not Null을 지정해줬다.
            @Valid
            @RequestBody
            BoardRequest boardRequest
            ){
        //Post가 들어오면 boardService를 boardRequest넣어서 생성한다.
        return boardService.create(boardRequest);
    }
}
