package com.sparta.expert.repository;

import com.sparta.expert.entity.Comment;
import com.sparta.expert.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findBySchedule(Schedule schedule);
}
