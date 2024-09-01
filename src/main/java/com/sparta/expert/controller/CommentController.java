package com.sparta.expert.controller;

import com.sparta.expert.dto.CommentResponseDto;
import com.sparta.expert.dto.CommentReuquestDto;
import com.sparta.expert.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    //댓글 저장
    @PostMapping("/scheduleId")
    public CommentResponseDto createComment(@PathVariable Long id, @RequestBody CommentReuquestDto commentReuquestDto){

        return commentService.createComment(id,commentReuquestDto);
    }

    //댓글 단건 조회
    @GetMapping
    public  CommentResponseDto inquiryComment(@PathVariable Long id){

        return  commentService.inquiryComment(id);
    }
    //댓글 전체 조회
    @GetMapping
    public List<CommentResponseDto> fullInquiryComment(@PathVariable Long id){

        return  commentService.fullInquiryComment(id);
    }

    //댓글 수정
    @PutMapping
    public  CommentResponseDto putComment(@PathVariable Long id,@RequestBody CommentReuquestDto commentReuquestDto){

        return  commentService.putComment(id,commentReuquestDto);
    }

    @DeleteMapping
    public  void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }
}
