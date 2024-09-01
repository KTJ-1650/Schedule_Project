package com.sparta.expert.dto;

import com.sparta.expert.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponseDto {
    //댓글 내용, 작성일, 수정일, 작성 유저명
    private String commentContent;
    private String commentUsername;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CommentResponseDto(Comment comment){
        this.commentContent = comment.getCommentContent();
        this.commentUsername = comment.getCommentUsername();
    }


}
