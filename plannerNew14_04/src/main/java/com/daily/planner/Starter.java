package com.daily.planner;

import com.daily.planner.domain.repository.DayRepository;
import com.daily.planner.domain.repository.EventRepository;
import com.daily.planner.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class Starter {

    @Autowired
    DayRepository dayRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventService eventService ;

//    @Transactional
    public void run(String... args)  {
//        eventRepository.init();
        System.out.println("Jestem tu ");
//        eventService.getAllEvents();
//        eventRepository.createEvent("saads","dsad");

    }
}

