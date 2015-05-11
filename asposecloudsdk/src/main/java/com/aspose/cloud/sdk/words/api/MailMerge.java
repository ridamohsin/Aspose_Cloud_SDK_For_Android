package com.aspose.cloud.sdk.words.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.words.model.CleanupOptionEnum;
import com.aspose.cloud.sdk.words.model.DocumentResponse;
import com.aspose.cloud.sdk.words.model.DocumentResponse.Document;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * MailMerge --- Using this class you can execute mail merge template and populate a word document from XML data 
 * @author   M. Sohail Ismail
 */
public class MailMerge {

	private static final String WORD_URI = AsposeApp.BASE_PRODUCT_URI + "/words/";
	
	/**
	 * Execute template and populate a word document from XML data
	 * @param fileName Name of the MS Word document on cloud
	 * @param xmlData An XML data used to populate a word document
	 * @param cleanupOption If cleanup parameter is omitted/null, cleanup options will be None
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A document object
	*/
	public static Document executeTemplateAndPopulateAWordDocumentFromXMLData(String fileName, String xmlData, CleanupOptionEnum cleanupOption, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		Document document = null;
		
		if(fileName == null || fileName.length() == 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(xmlData == null || xmlData.length() == 0) {
			throw new IllegalArgumentException("XML data cannot be null or empty");
		}
		
		//build URL
		StringBuilder strURL = new StringBuilder(WORD_URI + Uri.encode(fileName) + "/executeTemplate");
		if(cleanupOption != null) {
			strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
			strURL.append("cleanup=" + cleanupOption);
		}
		//If document is on the third party storage
		if(storageName != null && storageName.length() != 0) {
			strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
			strURL.append("storage=" + storageName);
		}
		//In case if file is not at root folder
		if(folderName != null && folderName.length() != 0) {
			strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
			strURL.append("folder=" + folderName);
		}

        //sign URL
        String signedURL = Utils.sign(strURL.toString());
        
        InputStream responseStream = Utils.processCommand(signedURL, "POST", xmlData, "xml");
        String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
      	Gson gson = new Gson();
      	DocumentResponse executeTemplateRes = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(executeTemplateRes.getCode().equals("200") && executeTemplateRes.getStatus().equals("OK")) {
			document = executeTemplateRes.document;
		}
		
		return document;
	}

	public static Document executeMailMergeWithoutRegionAndPopulateAWordDocumentFromXMLData(String fileName, String xmlData, CleanupOptionEnum cleanupOption, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		Document document = null;

		if(fileName == null || fileName.length() == 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		//build URL
		StringBuilder strURL = new StringBuilder(WORD_URI + Uri.encode(fileName) + "/executeMailMerge?withRegions=false");
		if(cleanupOption != null) {
			strURL.append("&cleanup=" + cleanupOption);
		}
		//If document is on the third party storage
		if(storageName != null && storageName.length() != 0) {
			strURL.append("&storage=" + storageName);
		}
		//In case if file is not at root folder
		if(folderName != null && folderName.length() != 0) {
			strURL.append("&folder=" + folderName);
		}
		//sign URL
		String signedURL = Utils.sign(strURL.toString());

		InputStream responseStream = Utils.processCommand(signedURL, "POST", xmlData, "XML");
		String responseJSONString = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		DocumentResponse executeTemplateRes = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(executeTemplateRes.getCode().equals("200") && executeTemplateRes.getStatus().equals("OK")) {
			document = executeTemplateRes.document;
		}

		return document;
	}

	public static Document executeMailMergeWithRegionsAndPopulateAWordDocumentFromXMLData(String fileName, String xmlData, CleanupOptionEnum cleanupOption, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		Document document = null;

		if(fileName == null || fileName.length() == 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		//build URL
		StringBuilder strURL = new StringBuilder(WORD_URI + Uri.encode(fileName) + "/executeMailMerge?withRegions=true");
		if(cleanupOption != null) {
			strURL.append("&cleanup=" + cleanupOption);
		}
        //If document is on the third party storage
		if(storageName != null && storageName.length() != 0) {
			strURL.append("&storage=" + storageName);
		}
		//In case if file is not at root folder
		if(folderName != null && folderName.length() != 0) {
			strURL.append("&folder=" + folderName);
		}
		//sign URL
		String signedURL = Utils.sign(strURL.toString());

		InputStream responseStream = Utils.processCommand(signedURL, "POST", xmlData, "XML");
		String responseJSONString = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		DocumentResponse executeTemplateRes = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(executeTemplateRes.getCode().equals("200") && executeTemplateRes.getStatus().equals("OK")) {
			document = executeTemplateRes.document;
		}

		return document;
	}

	public static Document executeMailMergeWithRegionsAndInsertDynamicImagesOnTheMergeFields(String fileName, String xmlData, CleanupOptionEnum cleanupOption) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		Document document = null;

		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		//build URL
		String strURL;
		if(cleanupOption != null) {
			strURL = WORD_URI + Uri.encode(fileName) + "/executeMailMerge?withRegions=true&cleanup=" + cleanupOption;
		} else {
			strURL = WORD_URI + Uri.encode(fileName) + "/executeMailMerge?withRegions=true";
		}

		//sign URL
		String signedURL = Utils.sign(strURL);

		InputStream responseStream = Utils.processCommand(signedURL, "POST", xmlData, "XML");
		String responseJSONString = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		DocumentResponse executeTemplateRes = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(executeTemplateRes.getCode().equals("200") && executeTemplateRes.getStatus().equals("OK")) {
			document = executeTemplateRes.document;
		}

		return document;
	}

	public static Document executeMailMergeWithoutRegionWithoutUsingTheCloudStorage(String docFileType, String docFilePath, String xmlFileType, String xmlFilePath) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		Document document = null;

		if(docFilePath == null || docFilePath.length() == 3) {
			throw new IllegalArgumentException("Doc file path cannot be null or empty");
		}

		if(xmlFilePath == null || xmlFilePath.length() == 3) {
			throw new IllegalArgumentException("XML file path cannot be null or empty");
		}

		//build URL
		String strURL = WORD_URI + "executeMailMerge?withRegions=false";
		//sign URL
		String signedURL = Utils.sign(strURL);

		InputStream responseStream = Utils.processCommand(signedURL, docFileType, docFilePath, xmlFileType, xmlFilePath);
		String responseJSONString = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		DocumentResponse executeTemplateRes = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(executeTemplateRes.getCode().equals("200") && executeTemplateRes.getStatus().equals("OK")) {
			document = executeTemplateRes.document;
		}

		return document;
	}

}
