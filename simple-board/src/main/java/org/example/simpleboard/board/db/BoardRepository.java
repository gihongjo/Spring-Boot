package org.example.simpleboard.board.db;

import org.example.simpleboard.post.db.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity,Long>{



}
