package org.example.simpleboard.board.service;

import lombok.RequiredArgsConstructor;
import org.example.simpleboard.board.db.BoardEntity;
import org.example.simpleboard.board.model.BoardDto;
import org.example.simpleboard.post.model.PostDto;
import org.example.simpleboard.post.db.PostEntity;
import org.example.simpleboard.post.service.PostConverter;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardConverter {
    private final PostConverter postConverter;

    public BoardDto toDto(BoardEntity boardEntity){

        List<PostDto> postList = Optional.ofNullable(boardEntity.getPostList())
                .orElseGet(Collections::emptyList)  // 빈 리스트 반환
                .stream()
                .map(postConverter::toDto)
                .sorted(Comparator.comparing(PostDto::getId).reversed())  // 생성 날짜 기준 내림차순 정렬
                .collect(Collectors.toList());


        return BoardDto
                .builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .postList(postList)
                .build();
    }





}
