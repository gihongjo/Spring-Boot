package org.example.simpleboard.board.db;

import jakarta.persistence.*;
import lombok.*;
import org.example.simpleboard.post.db.PostEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "board")
@ToString
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String boardName;
    private String status;

    @OneToMany(
            mappedBy = "board"  //PostEntity에서 이것과 연결하기 위해서는 이름을 맞춰야한다.

    )
    private List<PostEntity> postList= new ArrayList<>();
}
