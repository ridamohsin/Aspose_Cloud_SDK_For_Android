package com.aspose.cloud.sdk.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

public class ProjectDocuments {
	
	private static final String TASKS_URI = AsposeApp.BASE_PRODUCT_URI + "/tasks/";
	private static final List<String> validFormats = Arrays.asList("mpp", "xml", "html", "bmp", "png", "jpeg", 
			"pdf", "tiff", "xps", "xaml", "svg", "csv", "txt", "Spreadsheet2003", "XLSX", "PrimaveraP6XML", "PrimaveraXER");
	
	public static ArrayList<DocumentNameAndValue> retrieveProjectProperties(String projectName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		ArrayList<DocumentNameAndValue> documentPropertiesList = null;
		
		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Project name cannot be null or empty");
		}
		
		//build URL
		String strURL = TASKS_URI + projectName + "/documentProperties";
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String jsonStr = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		DocumentProperties documentPropertyResponse = gson.fromJson(jsonStr, DocumentProperties.class);
		if(documentPropertyResponse.getCode().equals("200") && documentPropertyResponse.getStatus().equals("OK")) {
			documentPropertiesList = documentPropertyResponse.properties.list;
		}
		
		return documentPropertiesList;
	}
	
	public static String convertProjectDocumentToFormat(String projectName, String designatedFormat) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		String localFilePath = null;
		
		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Project name cannot be null or empty");
		}
		
		if(!validFormats.contains(designatedFormat)) {
			throw new IllegalArgumentException("Valid Formats are mpp, xml, html, bmp, png, jpeg, " +
			"pdf, tiff, xps, xaml, svg, csv, txt, Spreadsheet2003, XLSX, PrimaveraP6XML, PrimaveraXER");
		}
		
		//build URL
		String strURL = TASKS_URI + projectName + "?format=" + designatedFormat;
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		
		//Replace fileName extension with designated format 
		String[] fileNameAndItsExtensionArray = projectName.split("\\.");
		projectName = fileNameAndItsExtensionArray[0] + "." + designatedFormat;
		
		//Save file on Disk
		localFilePath = Utils.saveStreamToFile(responseStream, projectName);
		
		return localFilePath;
	}
	
	public static TaskItem addATaskToProject(String srcProjectName, String taskName, int beforeTaskId, String changedProjectName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		TaskItem taskItem = null;
		
		if(srcProjectName == null || srcProjectName.length() == 0) {
			throw new IllegalArgumentException("Source Project name cannot be null or empty");
		}
		
		if(taskName == null || taskName.length() == 0) {
			throw new IllegalArgumentException("Task name cannot be null or empty");
		}
		
		String strURL;
		//changedProjectName is an optional parameter
		if(changedProjectName.length() != 0) {
			//Changes will save to changedProjectName project document
			strURL = TASKS_URI + srcProjectName + "/tasks?taskName=" + taskName + "&beforeTaskId=" + beforeTaskId + "&fileName=" + changedProjectName;
		} else {
			//changedProjectName is omitted so the changes will be saved to the source project document
			strURL = TASKS_URI + srcProjectName + "/tasks?taskName=" + taskName + "&beforeTaskId=" + beforeTaskId;
		}
		
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String jsonStr = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		AddNewTaskResponse addNewItemResponse = gson.fromJson(jsonStr, AddNewTaskResponse.class);
		if(addNewItemResponse.getCode().equals("200") && addNewItemResponse.getStatus().equals("OK")) {
			taskItem = addNewItemResponse.taskItem;
		}
		
		return taskItem;
	}
}
