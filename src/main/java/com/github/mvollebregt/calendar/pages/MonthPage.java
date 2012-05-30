package com.github.mvollebregt.calendar.pages;

import com.github.mvollebregt.calendar.model.CalendarItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.AbstractItem;
import org.apache.wicket.markup.repeater.RepeatingView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

public class MonthPage extends WebPage {

    public static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);
    public static final DateFormat TIME_FORMAT = DateFormat.getTimeInstance(DateFormat.SHORT);

    public MonthPage() {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.clear();
        calendar.set(2012, Calendar.APRIL, 30); // TODO: initialise properly
        RepeatingView weeksView = new RepeatingView("weeks");
        add(weeksView);
        for (int i = 0; i < 5 ; i++) {
            AbstractItem week = new AbstractItem(weeksView.newChildId());
            weeksView.add(week);
            week.add(createSevenDays(calendar));
        }
    }

    private RepeatingView createSevenDays(Calendar calendar) {
        RepeatingView daysView = new RepeatingView("days");
        for (int i = 0; i < 7; i++) {
            AbstractItem day = new AbstractItem(daysView.newChildId());
            daysView.add(day);
            day.add(new Label("date", DATE_FORMAT.format(calendar.getTime())));
            day.add(createItemsForDay(calendar));
            calendar.add(Calendar.DATE, 1);
        }
        return daysView;
    }

    private RepeatingView createItemsForDay(Calendar calendar) {
        RepeatingView itemsView = new RepeatingView("items");
        Calendar end = (Calendar) calendar.clone();
        end.add(Calendar.DATE, 1);
        Set<CalendarItem> items = com.github.mvollebregt.calendar.model.Calendar.getInstance().getItemsBetween(calendar.getTime(), end.getTime());
        for (CalendarItem item : items) {
            AbstractItem itemView = new AbstractItem(itemsView.newChildId());
            itemsView.add(itemView);
            itemView.add(new Label("start", TIME_FORMAT.format(item.getStart())));
            itemView.add(new Label("name", item.getName()));
        }
        return itemsView;
    }
}
