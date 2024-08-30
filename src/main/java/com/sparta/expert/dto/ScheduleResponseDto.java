package com.sparta.expert.dto;

import com.sparta.expert.entity.Schedule;
import com.sparta.expert.repository.ScheduleRepository;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter


public class ScheduleResponseDto {

    private Long scheduleId;
    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public ScheduleResponseDto(Schedule schedule) {
        this.scheduleId = schedule.getId();
        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.updatedAt = schedule.getUpdatedAt();
    }


}


