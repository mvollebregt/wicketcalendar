/*
 * Copyright (c) 2012, Michel Vollebregt
 *
 * This file is part of wicketcalendar.
 *
 * wicketcalendar is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * wicketcalendar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with wicketcalendar.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.mvollebregt.calendar.model;

import java.util.Date;
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

    public Set<CalendarItem> getItemsBetween(Date start, Date end) {
        Set<CalendarItem> itemsBetween = new HashSet<CalendarItem>();
        for (CalendarItem item : items) {
            if (start.compareTo(item.getStart()) <= 0 && item.getStart().compareTo(end) < 0) {
                itemsBetween.add(item);
            }
        }
        return itemsBetween;
    }
}
