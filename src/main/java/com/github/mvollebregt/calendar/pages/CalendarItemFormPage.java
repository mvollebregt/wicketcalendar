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
import org.apache.wicket.extensions.yui.calendar.DateTimeField;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import java.util.Date;

public class CalendarItemFormPage extends WebPage {

    public CalendarItemFormPage() {
        this(new CalendarItem());
    }

    public CalendarItemFormPage(final CalendarItem calendarItem) {
        Form calendarItemForm = new StatelessForm("calenderItemForm", new CompoundPropertyModel<CalendarItem>(calendarItem)) {
            /** default form submit */
            @Override
            protected void onSubmit() {
                Calendar.getInstance().getItems().add(calendarItem);
                setResponsePage(SummaryPage.class);
            }
        };
        add(calendarItemForm);
        calendarItemForm.add(new FeedbackPanel("feedback"));
        calendarItemForm.add(new RequiredTextField<String>("name"));
        calendarItemForm.add(new DateTimeField("dateTime"));


        calendarItemForm.add(new Button("saveButton"));
        Button cancelButton = new Button("cancelButton") {
            /** cancel button submit */
            @Override
            public void onSubmit() {
                setResponsePage(SummaryPage.class);
            }
        };
        cancelButton.setDefaultFormProcessing(false);
        calendarItemForm.add(cancelButton);
    }


}
