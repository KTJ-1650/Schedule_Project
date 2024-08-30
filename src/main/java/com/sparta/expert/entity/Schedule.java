package com.sparta.expert.entity;

import com.sparta.expert.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
//@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;

    @Column(name = "schedule_title")
    private String title;
    @Column(name = "schedule_content")
    private String content;
    @Column(name = "schedule_username")
    private String username;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;


    public Schedule(ScheduleRequestDto scheduleRequestDto){
        this.title = scheduleRequestDto.getTitle();
        this.content = scheduleRequestDto.getContent();
        this.username = scheduleRequestDto.getUsername();

    }
}
