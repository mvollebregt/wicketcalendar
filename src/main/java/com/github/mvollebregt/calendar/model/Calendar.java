package com.github.mvollebregt.calendar.model;

import java.util.HashSet;
import java.util.Set;

public class Calendar {

    private static Calendar calendar;

    // TODO: use dependency injection
    public static Calendar getInstance() {
        if (calendar == null) {
            calendar = new Calendar();
        }
        return calendar;
    }

    private Set<CalendarItem> items = new HashSet<CalendarItem>();

    public Set<CalendarItem> getItems() {
        return items;
    }

    public void setItems(Set<CalendarItem> items) {
        this.items = items;
    }
}
