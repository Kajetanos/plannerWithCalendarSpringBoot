package com.daily.planner.controllers;

import com.daily.planner.domain.Day;
import com.daily.planner.domain.Event;
import com.daily.planner.domain.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import static com.daily.planner.domain.repository.EventRepository.parseTime;

@Controller
public class EventController {



    Event event;

    @Autowired
    Day day;

    @Autowired
    EventRepository eventRepository;



    @RequestMapping("/eventform")
    public String event(Model model){
//        Event event = eventRepository.getEvent();
        Event event = new Event();
        model.addAttribute("event" , event);
        System.out.println("mehod ready");

        return "eventform";
    }
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

    @RequestMapping(value ="calendarNew")
    public String calendarNew(){
        return "mineCalendar";
    }
    //dokonczyc robienie widoku dla poszczegolnego eventa :)
//    @RequestMapping(value ="event")
//    public String event() {
//
//        return "event";
//    }



}
