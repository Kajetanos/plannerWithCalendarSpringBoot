package com.daily.planner.services;

import com.daily.planner.domain.Day;
import com.daily.planner.domain.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayService {

    @Autowired
    DayRepository dayRepository;

    public void saveTask(Day day){

        dayRepository.addTask();
    }
}
