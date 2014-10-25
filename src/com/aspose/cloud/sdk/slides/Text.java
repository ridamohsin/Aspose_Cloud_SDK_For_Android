package com.aspose.cloud.sdk.slides;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.slides.TextItemsResponse.TextItemsData;
import com.google.gson.Gson;

/**
 * Text --- Using this class you can create a new empty PowerPoint presentation, convert PowerPoint document to other File formats, 
 * merge multiple PowerPoint presentation files and split all or specific slides of a presentation file
 * @author   M. Sohail Ismail
 */
public class Text {
	
	private static final String SLIDES_URI = AsposeApp.BASE_PRODUCT_URI + "/slides/";
	
	/**
	 * Get all text items from a Presentation
	 * @param fileName Name of the file stored on cloud
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return An object that contains collection of text items
	*/ 
	public static TextItemsData getAllTextItemsFromAPresentation(String fileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		TextItemsData textItems = null;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		//build URL
		String strURL = SLIDES_URI + fileName + "/textItems";
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String responseJSONString = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		TextItemsResponse textItemsResponse = gson.fromJson(responseJSONString, TextItemsResponse.class);
		if(textItemsResponse.getCode().equals("200") && textItemsResponse.getStatus().equals("OK")) {
			textItems = textItemsResponse.textItems;
		}
		
		return textItems;
	}
	
	/**
	 * Get all text items from a slide
	 * @param fileName Name of the file stored on cloud
	 * @param slideIndex Index of slide starting from 1
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return An object that contains collection of text items
	*/ 
	public static TextItemsData getAllTextItemsFromASlide(String fileName, int slideIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		TextItemsData textItems = null;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		//build URL
		String strURL = SLIDES_URI + fileName + "/slides/" + slideIndex + "/textItems";
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String responseJSONString = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		TextItemsResponse textItemsResponse = gson.fromJson(responseJSONString, TextItemsResponse.class);
		if(textItemsResponse.getCode().equals("200") && textItemsResponse.getStatus().equals("OK")) {
			textItems = textItemsResponse.textItems;
		}
		
		return textItems;
	}
	
	/**
	 * Replace all text instances in a presentation
	 * @param fileName Name of the file stored on cloud
	 * @param oldValue The string to be replaced
	 * @param newValue The string to replace all occurrences of oldValue
	 * @param ignoreCase If set to true then search will be case insensitive. Default value is false
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return Returns the number of matches
	*/ 
	public static int replaceAllTextInstancesInAPresentation(String fileName, String oldValue, String newValue, 
			boolean ignoreCase) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		int matches = -1;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		//build URL
		String strURL = SLIDES_URI + fileName + "/replaceText?oldValue=" + oldValue + "&newValue=" + newValue + "&ignoreCase=" + ignoreCase;
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "POST");
		String responseJSONString = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		DocumentResponse documentResponse = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(documentResponse.getCode().equals("200") && documentResponse.getStatus().equals("OK")) {
			matches = documentResponse.document.matches;
		}
		
		return matches;
	}
	
	/**
	 * Replace all text instances in a slide
	 * @param fileName Name of the file stored on cloud
	 * @param slideIndex Index of slide starting from 1
	 * @param oldValue The string to be replaced
	 * @param newValue The string to replace all occurrences of oldValue
	 * @param ignoreCase If set to true then search will be case insensitive. Default value is false
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return Returns the number of matches
	*/ 
	public static int replaceAllTextInstancesInASlide(String fileName, int slideIndex, String oldValue, String newValue, 
			boolean ignoreCase) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		int matches = -1;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		//build URL
		String strURL = SLIDES_URI + fileName + "/slides/" + slideIndex + "/replaceText?oldValue=" + oldValue + "&newValue=" + newValue + "&ignoreCase=" + ignoreCase;
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "POST");
		String responseJSONString = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		DocumentResponse documentResponse = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(documentResponse.getCode().equals("200") && documentResponse.getStatus().equals("OK")) {
			matches = documentResponse.document.matches;
		}
		
		return matches;
	}
}
