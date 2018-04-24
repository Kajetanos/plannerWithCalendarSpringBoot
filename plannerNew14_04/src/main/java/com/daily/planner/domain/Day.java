package com.daily.planner.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Entity
public class Day {

    @Transient
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    @Transient
    Date currentDate = new Date();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id ;

    private String date;
    private String description ;
//    private int event_id;

    @OneToOne
    private Event event;

    public  Day(){

//        this.date = dateFormat.format(currentDate);
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateNow() {
        return date = dateFormat.format(currentDate);
    }

    public void setDate(String dateNow) {
        this.date = dateNow;
    }

    @Override
    public String toString() {
        return "Day{" +
                "dateFormat=" + dateFormat +
                ", currentDate=" + currentDate +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


}
