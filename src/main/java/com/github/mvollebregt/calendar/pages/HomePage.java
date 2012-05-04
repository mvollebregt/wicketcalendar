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

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
        // TODO Add your page's components here
    }
}
