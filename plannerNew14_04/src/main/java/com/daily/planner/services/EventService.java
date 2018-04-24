package com.daily.planner.services;

import com.daily.planner.domain.Event;
import com.daily.planner.domain.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
@Service
public class EventService {


    @Autowired
    EventRepository eventRepository;


//    public Event findByDate(String date) {
//
//        String eventStartDateFromDB = eventRepository.getDate();
//
//    }




}
