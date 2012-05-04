package com.github.mvollebregt.calendar.model;

import java.io.Serializable;
import java.util.Date;

public class CalendarItem implements Serializable {

    private String name;
    private Date dateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
