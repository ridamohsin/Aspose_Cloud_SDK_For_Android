package com.aspose.cloud.sdk.words;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.words.ConvertWordDocumentToAnyFormatWithAdditionalSettingsResponse.SaveResult;
import com.google.gson.Gson;

/**
 * Converter --- Using this class you can convert a Word document to images, multipage tiff, HTML, PDF and other file formats
 * on the Aspose cloud storage and without using cloud Storage.
 * @author   M. Sohail Ismail
 */

public class Converter {
	private static final String WORD_URI = AsposeApp.BASE_PRODUCT_URI + "/words/";
	
	/**
	 * Convert a Word document to images, multipage tiff, HTML, PDF and other file formats.
	 * @param fileName Name of the MS Word document on cloud
	 * @param designatedFormat A format to which word docuemnt will be converted
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return A path to converted word document
	*/ 
	public static String convertWordDocumentToFormat(String fileName, ValidFormatsEnum designatedFormat) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		String localFilePath = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(designatedFormat == null) {
			throw new IllegalArgumentException("Designated format cannot be null");
		}
		
		//build URL
		String strURL = WORD_URI + fileName + "?format=" + designatedFormat;
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		
		//Replace fileName extension with designated format 
		String[] fileNameAndItsExtensionArray = fileName.split("\\.");
		fileName = fileNameAndItsExtensionArray[0] + "." + designatedFormat;
		
		//Save file on Disk
		localFilePath = Utils.saveStreamToFile(responseStream, fileName);
		return localFilePath;
	}
	
	/**
	 * Convert Word document that is locally stored on device to images, multipage tiff, HTML, PDF and other file formats.
	 * @param localFilePath A path to Word document on disk
	 * @param designatedFormat A format to which word docuemnt will be converted
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return A path to converted word document
	*/ 
	public static String convertLocallyStoredWordDocumentToFormat(String localFilePath, ValidFormatsEnum designatedFormat) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		String convertedFilePath = null;
		
		if(localFilePath == null || localFilePath.length() == 0) {
			throw new IllegalArgumentException("Local file path cannot be null or empty");
		}
		
		if(designatedFormat == null) {
			throw new IllegalArgumentException("Designated format cannot be null");
		}
		
		//Build the request URI
		String strURL = WORD_URI + "convert?format=" + designatedFormat;
		//Sign the request URI
		String signedURL = Utils.sign(strURL);	
		//Convert the local file to InputStream
		InputStream fileStream = new FileInputStream(localFilePath);
		//Process the request on server
		InputStream responseStream = Utils.processCommand(signedURL, "PUT", fileStream);
		//Get fileName from localFilePath
		String fileName;
		int index = localFilePath.lastIndexOf("/");
		if(index != -1) {
			fileName = localFilePath.substring(index+1);
		} else {
			fileName = localFilePath;
		}
		//Replace fileName extension with designated format 
		String[] fileNameAndItsExtensionArray = fileName.split("\\.");
		fileName = fileNameAndItsExtensionArray[0] + "." + designatedFormat;
				
		//Save file on Disk
		convertedFilePath = Utils.saveStreamToFile(responseStream, fileName);
		
		return convertedFilePath;
	}
	
	/**
	 * Convert a Word document to other formats with additional settings
	 * @param fileName Name of the MS Word document on cloud
	 * @param xmlData Additional settings in XML format
	 * @param outputFileName Converted document will save on disk with this name
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return A path to converted word document
	*/
	public static SaveResult convertWordDocumentToFormatWithAdditionalSettings(String fileName, String xmlData) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		SaveResult saveResult = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(xmlData == null) {
			throw new IllegalArgumentException("XML Data cannot be null");
		}
		
		//build URL
		String strURL = WORD_URI + fileName + "/saveAs";
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "POST", xmlData, "xml");
		String responseJSONString = Utils.streamToString(responseStream);
		
		//Parsing JSON
      	Gson gson = new Gson();
      	ConvertWordDocumentToAnyFormatWithAdditionalSettingsResponse convertWordDocResponse = gson.fromJson(responseJSONString, ConvertWordDocumentToAnyFormatWithAdditionalSettingsResponse.class);
		if(convertWordDocResponse.getCode().equals("200") && convertWordDocResponse.getStatus().equals("OK")) {
			saveResult = convertWordDocResponse.saveResult;
		}
		
		return saveResult;
	}
}
