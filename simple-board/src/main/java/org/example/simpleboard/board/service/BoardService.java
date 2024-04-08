package org.example.simpleboard.board.service;


import lombok.RequiredArgsConstructor;
import org.example.simpleboard.board.db.BoardEntity;
import org.example.simpleboard.board.db.BoardRepository;
import org.example.simpleboard.board.model.BoardRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository; //final을 붙여줘야 기본 생성자에 해당 값이 들어가서 생성됨.

    public BoardEntity create(
            BoardRequest boardRequest
    ){
        var entity =BoardEntity
                .builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        return boardRepository.save(entity);
    }
}
