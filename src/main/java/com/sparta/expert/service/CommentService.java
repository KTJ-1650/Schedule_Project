package com.sparta.expert.service;

import com.sparta.expert.dto.CommentResponseDto;
import com.sparta.expert.dto.CommentReuquestDto;
import com.sparta.expert.entity.Comment;
import com.sparta.expert.entity.Schedule;
import com.sparta.expert.repository.CommentRepository;
import com.sparta.expert.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mbeans.SparseUserDatabaseMBean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
//    1. 일정에 댓글을 달 수 있습니다.
//    1. 댓글과 일정은 연관관계를 가집니다.
//    2. 댓글을 저장, 단건 조회, 전체 조회, 수정, 삭제할 수 있습니다.
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    // id 조회 -> id 조회된 데이터를 찾아야됨. ->조회된 데이터 엔티티로 반환
    // 요청받은 데이터를
    //
    public CommentResponseDto createComment(Long id,CommentReuquestDto commentReuquestDto) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("not found id"));
        //조회된 id 찾고 id에 저장된 정보까지 엔티티에 저장
        Comment comment = new Comment(commentReuquestDto);

        comment.setSchedule(schedule);

        return new CommentResponseDto(commentRepository.save(comment));
    }


    public CommentResponseDto inquiryComment(Long id){

        Comment comment = commentRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("not found Id"));

        return new CommentResponseDto(comment);

    }

    public List<CommentResponseDto> fullInquiryComment(Long id) {

      Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("not found Id"));

      List<Comment> comments = commentRepository.findBySchedule(schedule);

      return comments.stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }

    public CommentResponseDto putComment(Long id, CommentReuquestDto commentReuquestDto) {
        //데이터베이스에 스케쥴 아이디를 찾고 댓글 아이디를 찾아야된다.
        //그 댓글 아이디의 데이터를 엔티티에 반환시키고 그 엔티티에
        //요청된 요구사항으로 변경 시킨다.
        //그리고 레포지토리에 저장한다.

      Comment comment = commentRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("not found id"));

      comment.setCommentContent(commentReuquestDto.getCommentContent());
      comment.setCommentUsername(commentReuquestDto.getCommentUsername());

      return new CommentResponseDto(commentRepository.save(comment));

    }

    public void deleteComment(Long id) {
       commentRepository.deleteById(id);


    }
}
