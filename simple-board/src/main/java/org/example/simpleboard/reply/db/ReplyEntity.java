package org.example.simpleboard.reply.db;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "reply")
@ToString
public class ReplyEntity {

//          `id` bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
//                         `post_id` bigint(32) NOT NULL,
//                         `board` bigint(32),
//                         `user_name` varchar(50) NOT NULL,
//                         `password` varchar(4) NOT NULL,
//                         `email` varchar(50) NOT NULL,
//                         `status` varchar(50) NOT NULL,
//                         `title` varchar(100) NOT NULL,
//                         `content` text NOT NULL,
//            `posted_at` datetime NOT NULL


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;
    private String userName;
    private String password;
    private String status;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime repliedAt;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
