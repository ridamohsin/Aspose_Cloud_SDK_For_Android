package com.aspose.cloud.sdk.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

/**
 * Assignments --- Using this class you can retrieve all calendar items in a project 
 * @author   M. Sohail Ismail
 */
public class Assignments {
	
	private static final String TASKS_URI = AsposeApp.BASE_PRODUCT_URI + "/tasks/";
	
	/**
	 * Get all calendar items in a project
	 * @param projectName Name of the MS Project Binary File
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return An array of calendar items in a project
	*/
	public static ArrayList<AssignmentItemModel> getAllAssignmentItemsInProject(String srcProjectName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		ArrayList<AssignmentItemModel> assignmentsArray = null;
		
		if(srcProjectName == null || srcProjectName.length() == 0) {
			throw new IllegalArgumentException("Source Project name cannot be null or empty");
		}
		
		//build URL
		String strURL = TASKS_URI + srcProjectName + "/assignments";
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String jsonStr = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		GetProjectAssignmentsResponseModel assignmentItemsResponse = gson.fromJson(jsonStr, GetProjectAssignmentsResponseModel.class);
		if(assignmentItemsResponse.getCode().equals("200") && assignmentItemsResponse.getStatus().equals("OK")) {
			assignmentsArray = assignmentItemsResponse.assignment.assignmentsArray;
		}
		
		return assignmentsArray;
	}
	
}
