package com.sparta.expert.service;


import com.sparta.expert.dto.ScheduleRequestDto;
import com.sparta.expert.dto.ScheduleResponseDto;
import com.sparta.expert.entity.Schedule;
import com.sparta.expert.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service

public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {

        //요청받은 데이터를(dto)->entity로 변환
        Schedule schedule = new Schedule(scheduleRequestDto);

        return new ScheduleResponseDto(scheduleRepository.save(schedule));
    }

    public ScheduleResponseDto inquirySchedule(Long id) {

        //요청받은 데이터를 찾아야 됨. 어디서? 저장된 데이터베이스에서
        //레포지토리에서 찾고 난후 이걸 엔티티에 다시 적용시킨다
        // 엔티티에 있는거를 반환 시킨다.
        //요청받은 데이터가 엔티티에 있는지 없음 -> 데이터베이스에서 조회하고 반환한다.

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("schedule not found"));

        return new ScheduleResponseDto(schedule);
    }

    //데이터가 수정된 데이터를 갔고 왔음
    //저장된 데이터를 조회하고 -> 엔티티에 반환하고 ->엔티티에 반환된 데이터에 요청된 수정된데이터를 다시 반환
    //그리고 다시 수정된 데이터를 레포지토리에 저장 ->레포지토리에 저장된걸 응답

    //저장된 아이디를 찾고 그아이디에 저장된 데이터를 요청된 데이터로 수정
    //저장된 아이디를 찾고 스케쥴 엔티티에 저장 했어.
    //스케쥴 엔티티를 요청한 데이터로 변환
    //수정된 데이터를 다시 레포지토리에 저장
    public ScheduleResponseDto modifySchedule(Long id,ScheduleRequestDto scheduleRequestDto) {

        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("modifySchedule not found"));

        schedule.setUsername(scheduleRequestDto.getUsername());
        schedule.setTitle(schedule.getTitle());
        schedule.setContent(schedule.getContent());


        return new ScheduleResponseDto(scheduleRepository.save(schedule));

    }
}

