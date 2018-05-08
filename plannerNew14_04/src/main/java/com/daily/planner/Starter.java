package com.daily.planner;

import com.daily.planner.domain.repository.EventRepository;
import com.daily.planner.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Starter {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventService eventService ;

    public void run(String... args)  {

    }
}

