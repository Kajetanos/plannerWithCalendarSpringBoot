package com.daily.planner.controllers;

import com.daily.planner.domain.Day;
import com.daily.planner.domain.Event;
import com.daily.planner.domain.repository.EventRepository;
import com.daily.planner.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DayController {



    @Autowired
    Day day;

//    @Autowired
//    Event event;

    @Autowired
    DayService dayService;

    @Autowired
    EventRepository eventRepository;

    @RequestMapping("/day")
    public String sayHello(Model model){

        model.addAttribute("dateNow" , day.getDateNow());
        model.addAttribute("date" , day);
        return "day";
    }

    @RequestMapping(value = "/test")
    public String test(){
//        eventRepository.init();
        return "day";
    }


}
