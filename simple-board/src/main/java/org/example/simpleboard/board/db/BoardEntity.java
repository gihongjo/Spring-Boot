package org.example.simpleboard.board.db;

import jakarta.persistence.*;
import jakarta.persistence.OrderBy;
import lombok.*;
import org.example.simpleboard.post.db.PostEntity;
import org.hibernate.annotations.*;

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
    @SQLRestriction("status = 'REGISTERED'")   //@Where 어노테이션은 deprcated 되었다.
    private List<PostEntity> postList= List.of();
}
