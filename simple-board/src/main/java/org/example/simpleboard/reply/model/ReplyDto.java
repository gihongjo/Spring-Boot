package org.example.simpleboard.reply.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ReplyDto {


    @NotNull
    private Long postId;

    @NotBlank
    private String userName;
    @NotBlank
    @Size(min = 4,max = 4)
    private String password;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
