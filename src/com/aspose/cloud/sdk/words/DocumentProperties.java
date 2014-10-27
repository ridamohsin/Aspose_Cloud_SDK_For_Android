package com.aspose.cloud.sdk.words;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.words.GetDocumentPropertiesResponse.DocumentPropertiesModel;
import com.aspose.cloud.sdk.words.GetSpecificPropertyResponse.DocumentPropertyValue;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * DocumentProperties --- Using this class you can get all document properties or a particular document property,
 * you can also update and remove document property.
 * @author   M. Sohail Ismail
 */
public class DocumentProperties {
	
	private static final String WORD_URI = AsposeApp.BASE_PRODUCT_URI + "/words/";
	
	/**
	 * Get all document properties
	 * @param fileName Name of the MS Word document stored on cloud
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return An object that contains document properties
	*/
	public static DocumentPropertiesModel getAllDocumentProperties(String fileName) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
		
		DocumentPropertiesModel documentProperties = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		//build URL
      	String strURL = WORD_URI + fileName + "/documentProperties";
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
        Gson gson = new Gson();
        GetDocumentPropertiesResponse docPropertiesResponse = gson.fromJson(responseJSONString, GetDocumentPropertiesResponse.class);
		if(docPropertiesResponse.getCode().equals("200") && docPropertiesResponse.getStatus().equals("OK")) {
			documentProperties = docPropertiesResponse.documentProperties;
		}
		
		return documentProperties;
	}
	
	/**
	 * Get a particular document property
	 * @param fileName Name of the MS Word document stored on cloud
	 * @param propertyName The name of the property
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return An object that contains requested document property details
	*/
	public static DocumentPropertyValue getAParticularDocumentProperty(String fileName, String propertyName) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
		
		DocumentPropertyValue documentProperty = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(propertyName == null || propertyName.length() == 0) {
			throw new IllegalArgumentException("Property Name cannot be null or empty");
		}
		
		//build URL
      	String strURL = WORD_URI + fileName + "/documentProperties/" + propertyName;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        String responseJSONString = Utils.streamToString(responseStream);
          
        //Parsing JSON
        Gson gson = new Gson();
        GetSpecificPropertyResponse docPropertyResponse = gson.fromJson(responseJSONString, GetSpecificPropertyResponse.class);
		if(docPropertyResponse.getCode().equals("200") && docPropertyResponse.getStatus().equals("OK")) {
			documentProperty = docPropertyResponse.documentProperty;
		}
		
		return documentProperty;
	}
	
	/**
	 * Set a single document property
	 * @param fileName Name of the MS Word document stored on cloud
	 * @param propertyName The name of the property
	 * @param propertyValue The value of the property
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return An object that contains updated document property details
	*/
	public static DocumentPropertyValue setASingleDocumentProperty(String fileName, String propertyName, String propertyValue) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
		
		DocumentPropertyValue documentProperty = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(propertyName == null || propertyName.length() == 0) {
			throw new IllegalArgumentException("Property Name cannot be null or empty");
		}
		
		if(propertyValue == null || propertyValue.length() == 0) {
			throw new IllegalArgumentException("Property Value cannot be null or empty");
		}
		
		DocumentPropertyModel documentPropertyObj = new DocumentPropertyModel();
		documentPropertyObj.value = propertyValue;
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
        String requestJSONString = gson.toJson(documentPropertyObj, DocumentPropertyModel.class);
        
		//build URL
      	String strURL = WORD_URI + fileName + "/documentProperties/" + propertyName;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "PUT", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
        GetSpecificPropertyResponse docPropertyResponse = gson.fromJson(responseJSONString, GetSpecificPropertyResponse.class);
		if(docPropertyResponse.getCode().equals("200") && docPropertyResponse.getStatus().equals("OK")) {
			documentProperty = docPropertyResponse.documentProperty;
		}
		
		return documentProperty;
	}
	
	/**
	 * Remove a particular document property
	 * @param fileName Name of the MS Word document stored on cloud
	 * @param propertyName The name of the property
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return Boolean variable indicated whether document property deleted successfully
	*/
	public static boolean removeAParticularDocumentProperty(String fileName, String propertyName) throws IOException, InvalidKeyException, NoSuchAlgorithmException {
		
		boolean isPropertyDeletedSuccessfully = false;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(propertyName == null || propertyName.length() == 0) {
			throw new IllegalArgumentException("Property Name cannot be null or empty");
		}
		
		//build URL
      	String strURL = WORD_URI + fileName + "/documentProperties/" + propertyName;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
        String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
        Gson gson = new Gson();
        BaseResponse removePropertyResponse = gson.fromJson(responseJSONString, BaseResponse.class);
		if(removePropertyResponse.getCode().equals("200") && removePropertyResponse.getStatus().equals("OK")) {
			isPropertyDeletedSuccessfully = true;
		}
		
		return isPropertyDeletedSuccessfully;
	}
}