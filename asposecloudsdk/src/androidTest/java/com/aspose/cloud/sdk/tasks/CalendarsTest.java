package com.aspose.cloud.sdk.tasks;

import com.aspose.cloud.sdk.tasks.api.Calendars;
import com.aspose.cloud.sdk.tasks.model.AddCalendarToProjectResponse;
import com.aspose.cloud.sdk.tasks.model.CalendarData;
import com.aspose.cloud.sdk.tasks.model.CalendarItemModel;
import com.aspose.cloud.sdk.tasks.model.DayModel;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

	public void testAddCalendarToProject() throws Exception {

		CalendarData calendarData = new CalendarData();
		calendarData.Name = "Next Week Tasks";
		calendarData.Uid = 0;

		DayModel day = new DayModel();
		day.DayType = 1;
		day.DayWorking = false;
		Date date = new Date();
		day.FromDate = date.toString();
		//Tomorrow's date
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		Date tomorrowDate = c.getTime();
		day.ToDate = tomorrowDate.toString();

 		calendarData.IsBaseCalendar = true;
		calendarData.IsBaselineCalendar = false;

		AddCalendarToProjectResponse addCalendarRes = Calendars.addCalendarToProject("NewProductDev.mpp", calendarData);
		assertNotNull("Failed to add a calendar to a Project", addCalendarRes);
	}

	public void testDeleteCalendarFromAProject() throws Exception {

		boolean isCalendarDeletedSuccessfullyFromAProject = Calendars.deleteCalendarFromAProject("NewProductDev.mpp", 12);
		assertTrue("Failed to delete a Calendar from Project", isCalendarDeletedSuccessfullyFromAProject);
	}

}
