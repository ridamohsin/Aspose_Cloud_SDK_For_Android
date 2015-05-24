package com.aspose.cloud.sdk.words.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.words.model.DocumentResponse;
import com.aspose.cloud.sdk.words.model.DocumentResponse.Document;
import com.aspose.cloud.sdk.words.model.WatermarkTextModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Watermark --- Using this class you can add watermark text and image to a word document and remove watermark from a word document.
 * @author   M. Sohail Ismail
 */
public class Watermark {
	
	private static final String WORD_URI = AsposeApp.BASE_PRODUCT_URI + "/words/";
	
	/**
	 * Add watermark text to a word document
	 * @param fileName Name of the word document on cloud
	 * @param watermarkText Watermark text
	 * @param rotationAngle Watermark rotation angle in degrees
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A document object
	*/
	public static Document addWatermarkTextToAWordDocument(String fileName, String watermarkText, double rotationAngle) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		Document document = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(watermarkText == null || watermarkText.length() == 0) {
			throw new IllegalArgumentException("watermarkText cannot be null or empty");
		}
		
		WatermarkTextModel watermarkTextObj = new WatermarkTextModel();
		watermarkTextObj.text = watermarkText;
		watermarkTextObj.rotationAngle = rotationAngle;
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();
		String requestJSONString = gson.toJson(watermarkTextObj, WatermarkTextModel.class);
		
		//build URL
      	String strURL = WORD_URI + Uri.encode(fileName) + "/watermark/insertText";
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "POST", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
        DocumentResponse documentResponse = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(documentResponse.getCode().equals("200") && documentResponse.getStatus().equals("OK")) {
			document = documentResponse.document;
		}
		
		return document;
	}

	/**
	 * Add Watermark text to a Word document uploaded at third party storage
	 * @param fileName Name of the word document
	 * @param watermarkText Watermark text
	 * @param rotationAngle Watermark rotation angle in degrees
	 * @param storageName Third party cloud storage name. For details please visit http://www.aspose.com/docs/display/totalcloud/How+to+Configure+3rd+Party+Cloud+Storages
	 * @param folderName In case file is not at root folder (Optional)
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A document object
	 */
    public static Document addWatermarkTextToAWordDocumentUploadedAtThirdPartyStorage(String fileName, String watermarkText, double rotationAngle, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        Document document = null;

        if(fileName == null || fileName.length() <= 3) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(watermarkText == null || watermarkText.length() == 0) {
            throw new IllegalArgumentException("watermarkText cannot be null or empty");
        }

		if(storageName == null || storageName.length() == 0) {
			throw new IllegalArgumentException("storageName cannot be null or empty");
		}

        WatermarkTextModel watermarkTextObj = new WatermarkTextModel();
        watermarkTextObj.text = watermarkText;
        watermarkTextObj.rotationAngle = rotationAngle;

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String requestJSONString = gson.toJson(watermarkTextObj, WatermarkTextModel.class);

        //build URL
        String strURL = WORD_URI + Uri.encode(fileName) + "/insertWatermarkText?text=" + Uri.encode(watermarkText) + "&rotationAngle=" + rotationAngle
				+ "&storage=" + Uri.encode(storageName);
        //In case file is not at root folder
        if(folderName != null && folderName.length() != 0) {
            strURL += "&folder=" + folderName;
        }
        //sign URL
        String signedURL = Utils.sign(strURL);

        InputStream responseStream = Utils.processCommand(signedURL, "POST", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        DocumentResponse documentResponse = gson.fromJson(responseJSONString, DocumentResponse.class);
        if(documentResponse.getCode().equals("200") && documentResponse.getStatus().equals("OK")) {
            document = documentResponse.document;
        }

        return document;
    }


	/**
	 * Add watermark image to a word document
	 * @param fileName Name of the word document
	 * @param imagePath Server side image file path
	 * @param rotationAngle Watermark rotation angle in degrees
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A document object
	*/
	public static Document addWatermarkImageToAWordDocument(String fileName, String imagePath, double rotationAngle) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		Document document = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(imagePath == null || imagePath.length() == 0) {
			throw new IllegalArgumentException("imagePath cannot be null or empty");
		}
	
		//build URL
      	String strURL = WORD_URI + Uri.encode(fileName) + "/watermark/insertImage?image=" + Uri.encode(imagePath) + "&rotationAngle=" + rotationAngle;


        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "POST");
        String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
        Gson gson = new Gson();
        DocumentResponse documentResponse = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(documentResponse.getCode().equals("200") && documentResponse.getStatus().equals("OK")) {
			document = documentResponse.document;
		}
		
		return document;
	}

	/**
	 * Add watermark image to a Word document uploaded at third party storage
	 * @param fileName Name of the Word document
	 * @param imageFile Server side image file path
	 * @param rotationAngle Watermark rotation angle in degrees
	 * @param storageName Third party cloud storage name. For details please visit http://www.aspose.com/docs/display/totalcloud/How+to+Configure+3rd+Party+Cloud+Storages
	 * @param folderName In case file is not at root folder (Optional)
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A document object
	 */
	public static Document addWatermarkImageToAWordDocumentUploadedAtThirdPartyStorage(String fileName, String imageFile, double rotationAngle, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		Document document = null;

		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		if(imageFile == null || imageFile.length() == 0) {
			throw new IllegalArgumentException("imageFile cannot be null or empty");
		}

		if(storageName == null || storageName.length() == 0) {
			throw new IllegalArgumentException("storageName cannot be null or empty");
		}

		//build URL
		String strURL = WORD_URI + Uri.encode(fileName) + "/insertWatermarkImage?image=" + Uri.encode(imageFile) +
				"&rotationAngle=" + rotationAngle + "&storage=" + Uri.encode(storageName);
		//In case file is not at root folder
		if(folderName != null && folderName.length() != 0) {
			strURL += "&folder=" + folderName;
		}

		//sign URL
		String signedURL = Utils.sign(strURL);

		InputStream responseStream = Utils.processCommand(signedURL, "POST");
		String responseJSONString = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		DocumentResponse documentResponse = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(documentResponse.getCode().equals("200") && documentResponse.getStatus().equals("OK")) {
			document = documentResponse.document;
		}

		return document;
	}

	/**
	 * Deletes the last watermark (if it exists) from a Word Document
	 * @param fileName Name of the Word document on cloud
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A document object
	*/
	public static Document removeWatermarkFromAWordDocument(String fileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		Document document = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		//build URL
      	String strURL = WORD_URI + Uri.encode(fileName) + "/watermark";
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
        String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
        Gson gson = new Gson();
        DocumentResponse documentResponse = gson.fromJson(responseJSONString, DocumentResponse.class);
		if(documentResponse.getCode().equals("200") && documentResponse.getStatus().equals("OK")) {
			document = documentResponse.document;
		}
		
		return document;
	}
}
