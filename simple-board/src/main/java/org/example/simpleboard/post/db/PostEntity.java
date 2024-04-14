package org.example.simpleboard.post.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.example.simpleboard.board.db.BoardEntity;
import org.example.simpleboard.reply.db.ReplyEntity;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "post")
@ToString
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne  //객체끼리 이어주면 컬럼으로 인식해서 이름을 이렇게 맞춰주어야 하고, 그렇게 하면 board + _id로 이름이 지어진다,
    @JsonIgnore //무한반복되는 고리를 끊어주기 위해 JsonIgnore을 붙여 Json으로 만들 때 무시한다.
    private BoardEntity board;

    private String userName;
    private String password;
    private String email;
    private String status;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime postedAt;


    @OneToMany(
            mappedBy = "post"
    ) private List<ReplyEntity> replyList = new ArrayList<>();
}
