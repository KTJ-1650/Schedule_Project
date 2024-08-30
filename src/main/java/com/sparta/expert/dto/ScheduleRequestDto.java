package com.sparta.expert.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
public class ScheduleRequestDto {

    private Long scheduleId;
    private String username;
    private String title;
    private String content;

}
