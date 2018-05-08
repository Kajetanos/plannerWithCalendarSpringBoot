package com.daily.planner.controllers;

import com.daily.planner.domain.Event;
import com.daily.planner.domain.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/event")
public class RestWebController {

    List<Event> events = new ArrayList<Event>();

    @Autowired
    EventRepository eventRepository;

    @GetMapping(value = "/all")
    public List<Event> getEvents() {
//        eventRepository.createEvent("sadfsafd",false,"TYTU","2018-04-05","2018-04-05","02:02" ,"19:08");
        return eventRepository.getAllEvents() ;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable(value = "id") String id){
        Event event ;
        eventRepository.removeEvent(Integer.parseInt(id));
        System.out.println("usunięty id = "+id);
    }
    @RequestMapping("/calendar/{id}")
    public Event event(@PathVariable("id") String id , ModelMap model ) {

        model.addAttribute("chosingEvent", eventRepository. findById(Integer.parseInt(id)));
        Event event ;
        event = eventRepository. findById(Integer.parseInt(id)) ;
        return event;
    }



}
