package com.aspose.cloud.sdk.cells;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.aspose.cloud.sdk.cells.CellsResponse.CellData;
import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

/**
 * Images --- Using this class you can convert an autoshape to image.
 * @author   M. Sohail Ismail
 */
public class Images {
	private static final String CELLS_URI = AsposeApp.BASE_PRODUCT_URI + "/cells/";
	
	private String fileName;
	private String worksheetName;
	
	public Images(String fileName, String worksheetName) {
		this.fileName = fileName;
		this.worksheetName = worksheetName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setWorksheetName(String worksheetName) {
		this.worksheetName = worksheetName;
	}
	
	/**
	 * Convert an autoshape to image
	 * @param fileName Name of the file stored on cloud
	 * @param worksheetName Worksheet name
	 * @param autoShapeIndex Autoshape Index
	 * @param designatedFormat Convert the autoshape to this format
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return An object that contains cell attributes
	*/ 
	public CellData convertAutoShapeToImage(int autoShapeIndex, ValidFormatsOfWorksheet designatedFormat) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		CellData cell = null;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName 
				+ "/autoshapes/" + autoShapeIndex + "?format=" + designatedFormat;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		CellsResponse cellResponse = gson.fromJson(responseJSONString, CellsResponse.class);
		if (cellResponse.getCode().equals("200") && cellResponse.getStatus().equals("OK")) {
			cell = cellResponse.cell;
		}
		
		return cell;
	}
}
