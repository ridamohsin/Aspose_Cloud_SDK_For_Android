package com.aspose.cloud.sdk.tasks.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.tasks.model.ExtendedAttributeItemModel;
import com.aspose.cloud.sdk.tasks.model.GetOutlineCodesInformationResponse;
import com.aspose.cloud.sdk.tasks.model.GetOutlineCodesInformationResponse.OutlineCodes;
import com.aspose.cloud.sdk.tasks.model.ProjectExtendedAttributesResponseModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * ExtendedAttributes --- Using this class you can retrieve all extended attributes in a project, read outline codes,
 * delete a project extended attribute and delete a project outline code.
 * @author   M. Sohail Ismail
 */
public class ExtendedAttributes {
	
	private static final String TASKS_URI = AsposeApp.BASE_PRODUCT_URI + "/tasks/";
	
	/**
	 * Get all extended attributes in a project
	 * @param srcProjectName Name of the MS Project Binary File
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An array of extended attributes in a project
	*/
	public static ArrayList<ExtendedAttributeItemModel> getProjectExtendedAttributes(String srcProjectName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		ArrayList<ExtendedAttributeItemModel> extendedAttributesArray = null;
		
		if(srcProjectName == null || srcProjectName.length() == 0) {
			throw new IllegalArgumentException("Source Project name cannot be null or empty");
		}
		
		//build URL
		String strURL = TASKS_URI + Uri.encode(srcProjectName) + "/extendedAttributes";
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String jsonStr = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		ProjectExtendedAttributesResponseModel projectExtendedAttributesResponse = gson.fromJson(jsonStr, ProjectExtendedAttributesResponseModel.class);
		if(projectExtendedAttributesResponse.getCode().equals("200") && projectExtendedAttributesResponse.getStatus().equals("OK")) {
			extendedAttributesArray = projectExtendedAttributesResponse.extendedAttribute.extendedAttributesArray;
		}
		
		return extendedAttributesArray;
	}

	/**
	 * Read outline codes
	 * @param projectName The name of the file.
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An object that contains outlines codes
	 */
	public static OutlineCodes getOutlineCodesInformation(String projectName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		OutlineCodes outlineCodes = null;

		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Project name cannot be null or empty");
		}

		//build URL
		String strURL = TASKS_URI + Uri.encode(projectName) + "/outlineCodes";
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String jsonStr = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		GetOutlineCodesInformationResponse getOutlineCodesInformation = gson.fromJson(jsonStr, GetOutlineCodesInformationResponse.class);
		if(getOutlineCodesInformation.getCode().equals("200") && getOutlineCodesInformation.getStatus().equals("OK")) {
			outlineCodes = getOutlineCodesInformation.outlineCodes;
		}

		return outlineCodes;
	}

	/**
	 * Delete a project extended attribute
	 * @param projectName The name of the file.
	 * @param index Index of extended attribute
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return Boolean variable that indicates whether extended attribute deleted successfully
	 */
	public static boolean  deleteExtendedAttribute(String projectName, int index) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		boolean isExtendedAttributeDeletedSuccessfully = false;

		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Project name cannot be null or empty");
		}

		//build URL
		String strURL = TASKS_URI + Uri.encode(projectName) + "/extendedAttributes/" + index;
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
		String jsonStr = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(jsonStr, BaseResponse.class);
		if(baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isExtendedAttributeDeletedSuccessfully = true;
		}

		return isExtendedAttributeDeletedSuccessfully;
	}

	/**
	 * Deletes a project outline code
	 * @param projectName The name of the file.
	 * @param index Outline code index.
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return Boolean variable that indicates whether outline code deleted successfully
	 */
	public static boolean deleteOutlineCodes(String projectName, int index) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		boolean isOutlineCodeDeletedSuccessfully = false;

		if(projectName == null || projectName.length() == 0) {
			throw new IllegalArgumentException("Project name cannot be null or empty");
		}

		//build URL
		String strURL = TASKS_URI + Uri.encode(projectName) + "/outlineCodes/" + index;
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
		String jsonStr = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(jsonStr, BaseResponse.class);
		if(baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isOutlineCodeDeletedSuccessfully = true;
		}

		return isOutlineCodeDeletedSuccessfully;
	}

}
