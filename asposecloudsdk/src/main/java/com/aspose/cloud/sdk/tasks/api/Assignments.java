package com.aspose.cloud.sdk.tasks.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.tasks.model.AddAssignmentToProjectResponse;
import com.aspose.cloud.sdk.tasks.model.AssignmentItemModel;
import com.aspose.cloud.sdk.tasks.model.GetProjectAssignmentsResponseModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Assignments --- Using this class you can retrieve all calendar items in a project, add an assignment to a project and
 * deletes a project assignment with all references to it.
 * @author   M. Sohail Ismail
 */
public class Assignments {
	
	private static final String TASKS_URI = AsposeApp.BASE_PRODUCT_URI + "/tasks/";
	
	/**
	 * Get all assignment items in a project
	 * @param srcProjectName Name of the MS Project Binary File
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An array of assignment items in a project
	*/
	public static ArrayList<AssignmentItemModel> getAllAssignmentItemsInProject(String srcProjectName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		ArrayList<AssignmentItemModel> assignmentsArray = null;
		
		if(srcProjectName == null || srcProjectName.length() == 0) {
			throw new IllegalArgumentException("Source Project name cannot be null or empty");
		}
		
		//build URL
		String strURL = TASKS_URI + Uri.encode(srcProjectName) + "/assignments";
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

	/**
	 * Add an assignment to a project
	 * @param projectName Name of the MS Project Binary File
	 * @param taskUid The unique id of the task to be assigned.
	 * @param resourceUid The unique id of the resource to be assigned.
	 * @param units The units for the new assignment. Default value is 1.
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An object that contains add assignment to project response
	 */
	public static AddAssignmentToProjectResponse addAssignmentToProject(String projectName, int taskUid, int resourceUid, double units) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Project name cannot be null or empty");
		}

		//build URL
		String strURL = TASKS_URI + Uri.encode(projectName) + "/assignments?taskUid=" + taskUid + "&resourceUid=" + resourceUid + "&units=" + units;
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "POST");
		String jsonStr = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		AddAssignmentToProjectResponse addAssignmentToProjectRes = gson.fromJson(jsonStr, AddAssignmentToProjectResponse.class);
		if(addAssignmentToProjectRes.getCode().equals("200") && addAssignmentToProjectRes.getStatus().equals("OK")) {
			return addAssignmentToProjectRes;
		}

		return null;
	}

	/**
	 * Deletes a project assignment with all references to it
	 * @param projectName Name of the MS Project Binary File
	 * @param assignmentUid Assignment Uid
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return Boolean variable that indicates whether assignment deleted successfully from a project
	 */
	public static boolean deleteAnAssignmentFromAProject(String projectName, int assignmentUid) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		boolean isAssignmentDeletedSuccessfullyFromAProject = false;

		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Project name cannot be null or empty");
		}

		//build URL
		String strURL = TASKS_URI + Uri.encode(projectName) + "/assignments/" + assignmentUid;
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
		String jsonStr = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(jsonStr, BaseResponse.class);
		if(baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isAssignmentDeletedSuccessfullyFromAProject = true;
		}

		return isAssignmentDeletedSuccessfullyFromAProject;
	}

}
