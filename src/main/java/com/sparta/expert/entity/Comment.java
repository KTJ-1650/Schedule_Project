package com.sparta.expert.entity;

import com.sparta.expert.dto.CommentReuquestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "commentContent")
    private String commentContent;
    @Column(name = "commentUsername")
    private String commentUsername;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(CommentReuquestDto commentReuquestDto){
        this.commentContent = commentReuquestDto.getCommentContent();
        this.commentUsername = commentReuquestDto.getCommentUsername();
    }




}
