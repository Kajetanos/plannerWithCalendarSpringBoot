package com.daily.planner.domain.repository;

import com.daily.planner.domain.Event;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class EventRepository {


    @PersistenceContext
    private EntityManager em ;

    public List<Event> getAllEvents() {
        Query query = em.createQuery("SELECT Date FROM Event Date");
        List<Event> events = query.getResultList();
        System.out.println("wsyztskie eventy " + events);
        return events;
    }
    public static Long parseTime(String date, String time) {
        Long parse ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String dateInString = date.toString() + time.toString();
        try {
            Date dateToCount = sdf.parse(dateInString);
            parse = dateToCount.getTime();
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null ;
    }
    @Transactional
    public Event createEvent(String description , String allDay , String title , String dateStart , String dateEnd , String timeStart, String timeEnd  ){

//        Event eventNew = new Event("sdf" , true , "sdfsa" , "sdfsda" , "dsfa" , "fdsaf" , "sdafsa"   );
        Event event = new Event(description , allDay , title , dateStart , dateEnd , timeStart , timeEnd  );
         em.persist(event);
//         em.persist(eventNew);
        return event;
    }
    @Transactional
    public void removeEvent (Integer id) {
        Event event = em.find(Event.class , id);
        em.remove(event);
    }
    @Transactional
    public String getDate() {
        Event event = new Event();
        String dateDB = event.getTimeStart();
        return null;
    }
    @Transactional
    public Event findById (int id) {
        Event event = em.find(Event.class , id);
        return event ;
    }

}
