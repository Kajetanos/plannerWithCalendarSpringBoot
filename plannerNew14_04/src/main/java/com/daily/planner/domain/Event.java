package com.daily.planner.domain;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//to enter to db open url:// localhost/h2-console and connect to db with this name jdbc:h2:mem:testdb (default spring DB name)
//Event is our Entity DB
@Entity
//@Component
public class Event {

    //ID is set to autoincrements and field name is Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;
    private String description ;
    private String dateStart ;
    private String dateEnd ;
    private String timeStart ;
    private String timeEnd ;
    private String title ;


    private String place ;


    public Event(String description , String place , String title , String dateStart , String dateEnd , String timeStart, String timeEnd  ){
        this.description = description;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd ;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.title = title;
        this.place = place;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }
    public String getDateStart() {
        return dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Event() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                ", title='" + title + '\'' +
                ", allDay=" + place +
                '}';
    }
}
