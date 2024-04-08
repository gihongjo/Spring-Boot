package org.example.simpleboard.post.db;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    private Long board_id;

    private String userName;
    private String password;
    private String email;
    private String status;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime postedAt;




    /*
    * `board_id` bigint(32),
                        `user_name` varchar(50) NOT NULL,
                        `password` varchar(4) NOT NULL,
                        `email` varchar(50) NOT NULL,
                        `status` varchar(50) NOT NULL,
                        `title` varchar(100) NOT NULL,
                        `content` text,
                        `posted_at` datetime NOT NULL
    * */

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
