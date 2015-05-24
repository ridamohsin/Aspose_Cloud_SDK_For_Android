package com.aspose.cloud.sdk.words.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.words.model.GetDrawingObjectsResponse;
import com.aspose.cloud.sdk.words.model.GetDrawingObjectsResponse.DrawingObjectsData;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DrawingObject --- Using this class you can get all drawing objects from a word document, convert drawing object to
 * an image, get image data of a particular drawing object of the document, get embedded OLE file of the drawing object of the document,
 * get the OLE Drawing Object from Document using third party storage, read drawing object image data using third party storage,
 * read document drawing objects common info and convert drawing object to image Using third party storage.
 * accept/reject revisions in source document and get statistical data of the document.
 * @author   M. Sohail Ismail
 */
public class DrawingObject {
	
	private static final String WORD_URI = AsposeApp.BASE_PRODUCT_URI + "/words/";
	 
	/**
	 * Get all drawing objects from a Word document
	 * @param fileName Name of the word document
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An object that contains array of links where each link points to a drawing object
	*/
	public static DrawingObjectsData getAllDrawingObjects(String fileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		DrawingObjectsData drawingObjects = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		//build URL
      	String strURL = WORD_URI + Uri.encode(fileName) + "/drawingObjects/";
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
      	Gson gson = new Gson();
      	GetDrawingObjectsResponse drawingObjectsResponse = gson.fromJson(responseJSONString, GetDrawingObjectsResponse.class);
		if(drawingObjectsResponse.getCode().equals("200") && drawingObjectsResponse.getStatus().equals("OK")) {
			drawingObjects = drawingObjectsResponse.drawingObjects;
		}
		
		return drawingObjects;
	}
	
	/**
	 * Convert drawing object to an image
	 * @param fileName Name of the word document
	 * @param index Index of drawing object
	 * @param outputFileFormat The format in which drawing object will be saved
	 * @param outputFileName Name of the output file
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A path to output file saved on device
	*/
	public static String convertDrawingObjectToImage(String fileName, int index, String outputFileFormat, String outputFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		String localFilePath = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(outputFileFormat == null || outputFileFormat.length() == 0) {
			throw new IllegalArgumentException("OutputFileFormat cannot be null or empty");
		}
		
		if(outputFileName == null || outputFileName.length() <= 3) {
			throw new IllegalArgumentException("outputFileName cannot be null or empty");
		}
		
		//build URL
      	String strURL = WORD_URI + Uri.encode(fileName) + "/drawingObjects/" + index + "?format=" + outputFileFormat;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        
        //Save the stream in response to the disk
        localFilePath = Utils.saveStreamToFile(responseStream, outputFileName);
        return localFilePath;
	}
	
	/**
	 * Get image data of a particular drawing object of the document.
	 * @param fileName Name of the word document
	 * @param index Index of drawing object
	 * @param outputFileName Name of the output file
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A path to output file saved on device
	*/
	public static String getTheImageDrawingObjectFromDocument(String fileName, int index, String outputFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		String localFilePath = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(outputFileName == null || outputFileName.length() <= 3) {
			throw new IllegalArgumentException("OutputFileName cannot be null or empty");
		}
		
		//build URL
      	String strURL = WORD_URI + Uri.encode(fileName) + "/drawingObjects/" + index + "/imageData";
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        //Save the stream in response to the disk
        localFilePath = Utils.saveStreamToFile(responseStream, outputFileName);
        
        return localFilePath;
	}
	
	/**
	 * Get embedded OLE file of the drawing object of the document. Returns an error if the drawing object does not have embedded OLE file.
	 * @param fileName Name of the word document
	 * @param index Index of drawing object
	 * @param outputFileName Name of the output file
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A path to output file saved on device
	*/
	public static String getTheOLEDrawingObjectFromAWordDocument(String fileName, int index, String outputFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		String localFilePath = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(outputFileName == null || outputFileName.length() <= 3) {
			throw new IllegalArgumentException("OutputFileName cannot be null or empty");
		}
		
		//build URL
      	String strURL = WORD_URI + Uri.encode(fileName) + "/drawingObjects/" + index + "/oleData";
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        //Save the stream in response to the disk
        localFilePath = Utils.saveStreamToFile(responseStream, outputFileName);
        
        return localFilePath;
	}

	/**
	 * Get the OLE Drawing Object from Document Using Third Party Storage
	 * @param fileName Name of the word document
	 * @param objectIndex Drawing object index
	 * @param outFileName Name of the output file
	 * @param storageName Third party cloud storage name. For details please visit http://www.aspose.com/docs/display/totalcloud/How+to+Configure+3rd+Party+Cloud+Storages
	 * @param folderName In case file is not at root folder (Optional)
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A path to output file saved on device
	 */
	public static String getTheOLEDrawingObjectFromDocumentUsingThirdPartyStorage(String fileName, int objectIndex, String outFileName, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		String localFilePath = null;

		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		if(outFileName == null || outFileName.length() == 0) {
			throw new IllegalArgumentException("outFileName cannot be null or empty");
		}

		if(storageName == null || storageName.length() == 0) {
			throw new IllegalArgumentException("storageName cannot be null or empty");
		}

		//build URL
		String strURL = WORD_URI + Uri.encode(fileName) + "/drawingObjects/" + objectIndex + "/oleData?storage=" + storageName;
		//In case file is not at root folder
		if(folderName != null && folderName.length() != 0) {
			strURL += "&folder=" + folderName;
		}

		//sign URL
		String signedURL = Utils.sign(strURL);

		InputStream responseStream = Utils.processCommand(signedURL, "GET");

		//Save the stream in response to the disk
		localFilePath = Utils.saveStreamToFile(responseStream, outFileName);

		return localFilePath;
	}

	/**
	 * Read drawing object image data using third party storage
	 * @param fileName The document name.
	 * @param objectIndex The drawing object index.
	 * @param outFileName Name of the output file
	 * @param storageName Third party cloud storage name. For details please visit http://www.aspose.com/docs/display/totalcloud/How+to+Configure+3rd+Party+Cloud+Storages
	 * @param folderName In case file is not at root folder (Optional)
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A path to output file saved on device
	 */
	public static String readDrawingObjectImageDataUsingThirdPartyStorage(String fileName, int objectIndex, String outFileName, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		String localFilePath = null;

		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		if(outFileName == null || outFileName.length() == 0) {
			throw new IllegalArgumentException("outFileName cannot be null or empty");
		}

		if(storageName == null || storageName.length() == 0) {
			throw new IllegalArgumentException("storageName cannot be null or empty");
		}

		//build URL
		String strURL = WORD_URI + Uri.encode(fileName) + "/drawingObjects/" + objectIndex + "/imageData?storage=" + storageName;
		//In case file is not at root folder
		if(folderName != null && folderName.length() != 0) {
			strURL += "&folder=" + folderName;
		}

		//sign URL
		String signedURL = Utils.sign(strURL);

		InputStream responseStream = Utils.processCommand(signedURL, "GET");

		//Save the stream in response to the disk
		localFilePath = Utils.saveStreamToFile(responseStream, outFileName);

		return localFilePath;

	}

	/**
	 * Read document drawing objects common info
	 * @param fileName The document name.
	 * @param storageName Third party cloud storage name. For details please visit http://www.aspose.com/docs/display/totalcloud/How+to+Configure+3rd+Party+Cloud+Storages
	 * @param folderName In case file is not at root folder (Optional)
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An object that contains drawing objects data
	 */
	public static DrawingObjectsData getAllDrawingObjectsUsingThirdPartyStorage(String fileName, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		DrawingObjectsData drawingObjects = null;

		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		if(storageName == null || storageName.length() == 0) {
			throw new IllegalArgumentException("storageName cannot be null or empty");
		}

		//build URL
		String strURL = WORD_URI + Uri.encode(fileName) + "/drawingObjects?storage=" + storageName;
		//In case file is not at root folder
		if(folderName != null && folderName.length() != 0) {
			strURL += "&folder=" + folderName;
		}

		//sign URL
		String signedURL = Utils.sign(strURL);

		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String responseJSONString = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		GetDrawingObjectsResponse drawingObjectsResponse = gson.fromJson(responseJSONString, GetDrawingObjectsResponse.class);
		if(drawingObjectsResponse.getCode().equals("200") && drawingObjectsResponse.getStatus().equals("OK")) {
			drawingObjects = drawingObjectsResponse.drawingObjects;
		}

		return drawingObjects;
	}

	/**
	 * Convert drawing object to image Using third party storage
	 * @param fileName The document name.
	 * @param objectIndex The drawing object index.
	 * @param format Format to convert.
	 * @param storageName Third party cloud storage name. For details please visit http://www.aspose.com/docs/display/totalcloud/How+to+Configure+3rd+Party+Cloud+Storages
	 * @param folderName In case file is not at root folder (Optional)
	 * @param outFileName Name of the output file
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return A path to output file saved on device
	 */
	public static String convertDrawingObjectToImageUsingThirdPartyStorage(String fileName, int objectIndex, String format, String storageName, String folderName, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		String localFilePath = null;

		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		if(format == null || format.length() == 0) {
			throw new IllegalArgumentException("format cannot be null or empty");
		}

		if(storageName == null || storageName.length() == 0) {
			throw new IllegalArgumentException("storageName cannot be null or empty");
		}

		if(outFileName == null || outFileName.length() <= 3) {
			throw new IllegalArgumentException("outFileName cannot be null or empty");
		}

		//build URL
		String strURL = WORD_URI + Uri.encode(fileName) + "/drawingObjects/" + objectIndex + "?format=" + format + "&storage=" + storageName;
		//In case file is not at root folder
		if(folderName != null && folderName.length() != 0) {
			strURL += "&folder=" + folderName;
		}

		//sign URL
		String signedURL = Utils.sign(strURL);

		InputStream responseStream = Utils.processCommand(signedURL, "GET");

		//Save the stream in response to the disk
		localFilePath = Utils.saveStreamToFile(responseStream, outFileName);

		return localFilePath;
	}

}
