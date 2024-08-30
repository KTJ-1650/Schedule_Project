package com.sparta.expert.controller;

import com.sparta.expert.dto.ScheduleRequestDto;
import com.sparta.expert.dto.ScheduleResponseDto;
import com.sparta.expert.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/save")
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){


        return  scheduleService.createSchedule(scheduleRequestDto);
    }

    @GetMapping("/{id}")
    public  ScheduleResponseDto inquirySchedule(@PathVariable Long id){

        return scheduleService.inquirySchedule(id);
    }

    @PutMapping("/update/{id}")
    public ScheduleResponseDto modifySchedule(@PathVariable Long id ,@RequestBody ScheduleRequestDto scheduleRequestDto){

        return scheduleService.modifySchedule(id,scheduleRequestDto);
    }
}
