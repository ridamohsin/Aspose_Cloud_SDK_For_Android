package com.aspose.cloud.sdk.cells;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import android.net.Uri;

import com.aspose.cloud.sdk.cells.OleObjectResponse.OleObjectData;
import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

public class OleObject {
	private static final String CELLS_URI = AsposeApp.BASE_PRODUCT_URI + "/cells/";
	
	private String fileName;
	private String worksheetName;
	
	public OleObject(String fileName, String worksheetName) {
		this.fileName = Uri.encode(fileName);
		this.worksheetName = Uri.encode(worksheetName);
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setWorksheetName(String worksheetName) {
		this.worksheetName = worksheetName;
	}
	
	public OleObjectData getOleObjectFromAWorksheet(int oleObjectIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		OleObjectData oleObject = null;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/oleobjects/" + oleObjectIndex;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		OleObjectResponse oleObjectResponse = gson.fromJson(responseJSONString, OleObjectResponse.class);
		if (oleObjectResponse.getCode().equals("200") && oleObjectResponse.getStatus().equals("OK")) {
			oleObject = oleObjectResponse.oleObject;
		}
		
		return oleObject;
	}
	
	public String convertOLEObjectToImage(int oleObjectIndex, ValidOleObjectConversionFormats designatedFormat, String outputFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		String localFilePath = null;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		if(designatedFormat == null) {
			throw new IllegalArgumentException("Designated format cannot be null");
		}
		
		if(outputFileName == null || outputFileName.length() == 0) {
			throw new IllegalArgumentException("The name with image will be saved cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/oleobjects/" + oleObjectIndex + "?format=" + designatedFormat;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		
		//Save the stream in response to the disk
		localFilePath = Utils.saveStreamToFile(responseStream, outputFileName);
				
		return localFilePath;
	}
	
	/*public void addOleObjectToExcelWorksheet(String xmlOleObjectRequest) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		if(xmlOleObjectRequest == null || xmlOleObjectRequest.length() == 0) {
			throw new IllegalArgumentException("xmlOleObjectRequest cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/oleobjects";
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "PUT", xmlOleObjectRequest, "xml");
		String responseJSONString = Utils.streamToString(responseStream);
	}*/
	
	public boolean deleteAllOleObjectsFromExcelWorksheet() throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		boolean isAllOleObjectsDeletedSuccessfully = false;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
        
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/oleobjects";
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
		if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isAllOleObjectsDeletedSuccessfully = true;
		}
		
		return isAllOleObjectsDeletedSuccessfully;
	}
	
	public boolean deleteASpecificOleObjectFromExcelWorksheet(int oleObjectIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		boolean isOleObjectDeletedSuccessfully = false;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
        
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/oleobjects/" + oleObjectIndex;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
		if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isOleObjectDeletedSuccessfully = true;
		}
		
		return isOleObjectDeletedSuccessfully;
	}
}
