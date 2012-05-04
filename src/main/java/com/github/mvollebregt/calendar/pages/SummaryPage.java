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

package com.github.mvollebregt.calendar.pages;

import com.github.mvollebregt.calendar.model.Calendar;
import com.github.mvollebregt.calendar.model.CalendarItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;

import java.util.*;

public class SummaryPage extends WebPage {

    public SummaryPage() {
        add(new Label("itemCount", "You have " + Calendar.getInstance().getItems().size() + " items in your calendar"));
        add(new BookmarkablePageLink("addNewItemLink", CalendarItemFormPage.class));
        List<CalendarItem> calendarItemList = new ArrayList<CalendarItem>(Calendar.getInstance().getItems());
        Collections.sort(calendarItemList, new Comparator<CalendarItem>() {
            public int compare(CalendarItem o1, CalendarItem o2) {
                return o1.getDateTime().compareTo(o2.getDateTime());
            }
        });

        add(new PropertyListView<CalendarItem>("calendarItemList", calendarItemList) {
            @Override
            protected void populateItem(ListItem<CalendarItem> calendarItem) {
                calendarItem.add(new Label("dateTime"));
                calendarItem.add(new Label("name"));
            }
        });
    }
}
