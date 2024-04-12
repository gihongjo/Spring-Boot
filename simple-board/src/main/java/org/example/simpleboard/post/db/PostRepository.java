package org.example.simpleboard.post.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity,Long> {


    //쿼리 메서드 방식
    //SELECTED * FROM post  WHERE id =? AND status = ? ORDER BY id DESC LIMIT 1
    public Optional<PostEntity> findFirstByIdAndStatusOrderByIdDesc(Long Id, String status);
}
