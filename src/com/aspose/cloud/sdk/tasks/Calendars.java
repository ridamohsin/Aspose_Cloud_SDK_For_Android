package com.aspose.cloud.sdk.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

public class Calendars {
	
	private static final String TASKS_URI = AsposeApp.BASE_PRODUCT_URI + "/tasks/";
	
	public static ArrayList<CalendarItemModel> getAllCalendarItemsInProject(String srcProjectName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		ArrayList<CalendarItemModel> calendarItemsArray = null;
		
		if(srcProjectName == null || srcProjectName.length() == 0) {
			throw new IllegalArgumentException("Source Project name cannot be null or empty");
		}
		
		//build URL
		String strURL = TASKS_URI + srcProjectName + "/calendars";
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String jsonStr = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		GetProjectCalendarItemsResponseModel calendarItemsResponse = gson.fromJson(jsonStr, GetProjectCalendarItemsResponseModel.class);
		if(calendarItemsResponse.getCode().equals("200") && calendarItemsResponse.getStatus().equals("OK")) {
			calendarItemsArray = calendarItemsResponse.calendar.calendarItemsArray;
		}
		
		return calendarItemsArray;
	}
}
