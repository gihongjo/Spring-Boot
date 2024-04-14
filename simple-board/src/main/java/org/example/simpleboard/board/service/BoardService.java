package org.example.simpleboard.board.service;


import lombok.RequiredArgsConstructor;
import org.example.simpleboard.board.db.BoardEntity;
import org.example.simpleboard.board.db.BoardRepository;
import org.example.simpleboard.board.model.BoardDto;
import org.example.simpleboard.board.model.BoardRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository; //final을 붙여줘야 기본 생성자에 해당 값이 들어가서 생성됨.
    private final BoardConverter boardConverter;
    public BoardDto create(
            BoardRequest boardRequest
    ){
        var entity =BoardEntity
                .builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        var saveEntity=boardRepository.save(entity);
        return boardConverter.toDto(saveEntity);
    }

    public BoardDto view(Long id) {

        var entity=boardRepository.findById(id).get();

        return boardConverter.toDto(entity);
    }
}
