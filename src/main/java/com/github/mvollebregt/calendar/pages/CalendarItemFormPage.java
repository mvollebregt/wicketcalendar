package com.github.mvollebregt.calendar.pages;

import com.github.mvollebregt.calendar.model.Calendar;
import com.github.mvollebregt.calendar.model.CalendarItem;
import org.apache.wicket.extensions.yui.calendar.DateTimeField;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
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
