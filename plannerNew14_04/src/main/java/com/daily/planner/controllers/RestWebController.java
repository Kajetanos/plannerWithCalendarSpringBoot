package com.daily.planner.controllers;

import com.daily.planner.domain.Event;
import com.daily.planner.domain.SearchCriteria;
import com.daily.planner.domain.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/checkRoom")
    public void getSearchResultViaAjax(
            @Valid @RequestBody SearchCriteria search, Errors errors) {


//
//        if (errors.hasErrors()) {
//
//            result.setMsg(errors.getAllErrors()
//                    .stream().map(x -> x.getDefaultMessage())
//                    .collect(Collectors.joining(",")));
//
//        }
//        List<Event> events = EventService.


    }



}
