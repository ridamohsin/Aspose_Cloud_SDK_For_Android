package com.aspose.cloud.sdk.tasks.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.tasks.model.GetTaskLinksInProjectResponseModel;
import com.aspose.cloud.sdk.tasks.model.TaskLinksModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * TaskLinks --- Using this class you can retrieve all task links in a project, adds a new task link to a project and
 * delete a task link.
 * @author   M. Sohail Ismail
 */
public class TaskLinks {
	
	private static final String TASKS_URI = AsposeApp.BASE_PRODUCT_URI + "/tasks/";
	
	/**
	 * Get all task links in a project
	 * @param projectName Name of the MS Project Binary File
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An array of project's task links
	*/
	public static ArrayList<TaskLinksModel> getAllTaskLinksInProject(String projectName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		ArrayList<TaskLinksModel> taskLinksArray = null;
		
		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Source Project name cannot be null or empty");
		}
		
		//build URL
		String strURL = TASKS_URI + Uri.encode(projectName) + "/taskLinks";
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String jsonStr = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		GetTaskLinksInProjectResponseModel taskLinksInProject = gson.fromJson(jsonStr, GetTaskLinksInProjectResponseModel.class);
		if(taskLinksInProject.getCode().equals("200") && taskLinksInProject.getStatus().equals("OK")) {
			taskLinksArray = taskLinksInProject.taskLinksArray;
		}
		
		return taskLinksArray;
	}

	/**
	 * Adds a new task link to a project
	 * @param projectName The name of the file.
	 * @param taskLinkRequest Task link data
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return Boolean variable that indicates whether task link added successfully to a project
	 */
	public static boolean  addsANewTaskLinkToAProject(String projectName, TaskLinksModel taskLinkRequest) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		boolean isNewTaskLinkAddedSuccessfully = false;

		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Source Project name cannot be null or empty");
		}

		if(taskLinkRequest == null) {
			throw new IllegalArgumentException("Task link request cannot be null");
		}

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		String requestJSONString = gson.toJson(taskLinkRequest, TaskLinksModel.class);

		//build URL
		String strURL = TASKS_URI + Uri.encode(projectName) + "/taskLinks";

		String signedURL = Utils.sign(strURL.toString());
		InputStream responseStream = Utils.processCommand(signedURL, "POST", requestJSONString);
		String jsonStr = Utils.streamToString(responseStream);

		//Parsing JSON
		BaseResponse baseResponse = gson.fromJson(jsonStr, BaseResponse.class);
		if(baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isNewTaskLinkAddedSuccessfully = true;
		}

		return isNewTaskLinkAddedSuccessfully;
	}

	/**
	 * Delete a task link
	 * @param projectName The name of the file.
	 * @param taskLinkIndex Task link index
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return Boolean variable that indicates whether task link deleted successfully from project
	 */
	public static boolean  deleteATaskLink(String projectName, int taskLinkIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		boolean isTaskLinkDeletedSuccessfully = false;

		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Source Project name cannot be null or empty");
		}

		//build URL
		String strURL = TASKS_URI + Uri.encode(projectName) + "/taskLinks/" + taskLinkIndex;

		String signedURL = Utils.sign(strURL.toString());
		InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
		String jsonStr = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(jsonStr, BaseResponse.class);
		if(baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isTaskLinkDeletedSuccessfully = true;
		}

		return isTaskLinkDeletedSuccessfully;
	}
}