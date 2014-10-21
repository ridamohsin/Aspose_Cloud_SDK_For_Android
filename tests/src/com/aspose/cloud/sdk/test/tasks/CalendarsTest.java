package com.aspose.cloud.sdk.test.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.tasks.CalendarItemModel;
import com.aspose.cloud.sdk.tasks.Calendars;

import junit.framework.TestCase;

public class CalendarsTest extends TestCase {

	public CalendarsTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetAllCalendarItemsInProject() throws Exception {
		ArrayList<CalendarItemModel> calendarItemsArray = Calendars.getAllCalendarItemsInProject("NewProductDev.mpp");
		assertNotNull("Failed to retrieve calendar information from a project", calendarItemsArray);
	}
}
