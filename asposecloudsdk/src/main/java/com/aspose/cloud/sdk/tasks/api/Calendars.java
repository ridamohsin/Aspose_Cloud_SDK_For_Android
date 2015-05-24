package com.aspose.cloud.sdk.tasks.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.tasks.model.AddCalendarToProjectResponse;
import com.aspose.cloud.sdk.tasks.model.CalendarData;
import com.aspose.cloud.sdk.tasks.model.CalendarItemModel;
import com.aspose.cloud.sdk.tasks.model.GetProjectCalendarItemsResponseModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Calendars --- Using this class you can read project calendar items, adds a new calendar to project file and
 * deletes a project calendar.
 * @author   M. Sohail Ismail
 */
public class Calendars {
	
	private static final String TASKS_URI = AsposeApp.BASE_PRODUCT_URI + "/tasks/";

	/**
	 * Read project calendar items.
	 * @param srcProjectName The name of the file.
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An array of calendar items in a project
	 */
	public static ArrayList<CalendarItemModel> getAllCalendarItemsInProject(String srcProjectName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		ArrayList<CalendarItemModel> calendarItemsArray = null;
		
		if(srcProjectName == null || srcProjectName.length() == 0) {
			throw new IllegalArgumentException("Source Project name cannot be null or empty");
		}
		
		//build URL
		String strURL = TASKS_URI + Uri.encode(srcProjectName) + "/calendars";
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

	/**
	 * Adds a new calendar to project file.
	 * @param projectName The name of the file.
	 * @param calendarData Calendar data
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An object that contains add calendar to project response
	 */
	public static AddCalendarToProjectResponse addCalendarToProject(String projectName, CalendarData calendarData) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Project name cannot be null or empty");
		}

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String requestJSONString = gson.toJson(calendarData, CalendarData.class);

		//build URL
		String strURL = TASKS_URI + Uri.encode(projectName) + "/calendars";
		String signedURL = Utils.sign(strURL);

		InputStream responseStream = Utils.processCommand(signedURL, "POST", requestJSONString);
		String jsonStr = Utils.streamToString(responseStream);

		//Parsing JSON
		AddCalendarToProjectResponse addCalendarRes = gson.fromJson(jsonStr, AddCalendarToProjectResponse.class);
		if(addCalendarRes.getCode().equals("201") && addCalendarRes.getStatus().equals("Created")) {
			return addCalendarRes;
		}

		return null;
	}

	/**
	 * Deletes a project calendar
	 * @param projectName The name of the file.
	 * @param calendarUid Calendar Uid
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return Boolean variable that indicates whether calendar deleted successfully from a project
	 */
	public static boolean deleteCalendarFromAProject(String projectName, int calendarUid) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		boolean isCalendarDeletedSuccessfullyFromAProject = false;

		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Project name cannot be null or empty");
		}

		//build URL
		String strURL = TASKS_URI + Uri.encode(projectName) + "/calendars/" + calendarUid;
		String signedURL = Utils.sign(strURL);

		InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
		String jsonStr = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		BaseResponse addCalendarRes = gson.fromJson(jsonStr, BaseResponse.class);
		if(addCalendarRes.getCode().equals("200") && addCalendarRes.getStatus().equals("OK")) {
			isCalendarDeletedSuccessfullyFromAProject = true;
		}

		return isCalendarDeletedSuccessfullyFromAProject;
	}

}
