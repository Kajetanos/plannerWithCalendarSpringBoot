package com.daily.planner.controllers;

import com.daily.planner.domain.Event;
import com.daily.planner.domain.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class EventController {



    Event event;

    @Autowired
    EventRepository eventRepository;

    @RequestMapping("showevent")
    public String showEvent(Model model , Event event){

        List<Event> events = eventRepository.getAllEvents();
        model.addAttribute("events", events);
        return "showevents";
    }
    @RequestMapping("/calendar")
    public String calendar(Model model){
        Event event = new Event();
        model.addAttribute("event" , event);
        return "calendar";
    }
    @RequestMapping(value = "/calendar" , method = RequestMethod.POST)
    public String saveKnights(Event event){
        System.out.println(event);
        System.out.println(event.getDescription());
        eventRepository.createEvent(event.getDescription(),event.getPlace(), event.getTitle()  ,event.getDateStart() , event.getDateEnd() , event.getTimeStart() , event.getTimeEnd()  );
        return "redirect:/calendar";
    }
    @RequestMapping(value = "/calendar/{id}" , method = { RequestMethod.GET })
    public String deleteEvent(@PathVariable(value = "id") String id){

        eventRepository.removeEvent(Integer.parseInt(id));

        return "redirect:/calendar";
    }

}
