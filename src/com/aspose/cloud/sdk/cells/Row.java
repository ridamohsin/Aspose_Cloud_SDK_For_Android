package com.aspose.cloud.sdk.cells;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.aspose.cloud.sdk.cells.RowResponse.RowData;
import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

/**
 * Row --- Using this class you can get row from a worksheet, add an empty row in a worksheet, delete a row from a worksheet, 
 * copy rows in a worksheet, hide/unhide rows in a worksheet, group/ungroup rows in a worksheet and can also
 * automatically fit rows' height and width.
 * @author   M. Sohail Ismail
 */
public class Row {
	
	private static final String CELLS_URI = AsposeApp.BASE_PRODUCT_URI + "/cells/";
	
	private String fileName;
	private String worksheetName;
	
	public Row(String fileName, String worksheetName) {
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
	 * Get row from a worksheet
	 * @param fileName Name of the file stored on cloud
	 * @param worksheetName Worksheet name
	 * @param rowID Row index
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return An object that contains row attributes
	*/
	public RowData getRowFromAWorksheet(int rowID) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		RowData row = null;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/rows/" + rowID;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		RowResponse rowResponse = gson.fromJson(responseJSONString, RowResponse.class);
		if (rowResponse.getCode().equals("200") && rowResponse.getStatus().equals("OK")) {
			row = rowResponse.row;
		}
		
		return row;
	}
	
	/**
	 * Add an empty row in a worksheet
	 * @param fileName Name of the file stored on cloud
	 * @param worksheetName Worksheet name
	 * @param rowID Row index
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return An object that contains row attributes
	*/
	public RowData addAnEmptyRowInAWorksheet(int rowID) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		RowData row = null;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/cells/rows/" + rowID;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "PUT");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		RowResponse rowResponse = gson.fromJson(responseJSONString, RowResponse.class);
		if (rowResponse.getCode().equals("200") && rowResponse.getStatus().equals("OK")) {
			row = rowResponse.row;
		}
		
		return row;
	}
	
	/**
	 * Delete a row from a worksheet 
	 * @param fileName Name of the file stored on cloud
	 * @param worksheetName Worksheet name
	 * @param rowID Row index
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return Boolean variable that indicates whether row deleted successfully
	*/
	public boolean deleteARowFromAWorksheet (int rowID) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		boolean isRowDeletedSuccessfully = false;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/cells/rows/" + rowID;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
		if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isRowDeletedSuccessfully = true;
		}
		
		return isRowDeletedSuccessfully;
	}
	
	/**
	 * Copy selected rows in a worksheet  
	 * @param fileName Name of the file stored on cloud
	 * @param worksheetName Worksheet name
	 * @param sourceRowIndex Source row index
	 * @param destinationRowIndex Destination row index
	 * @param rowNumber The copied row number
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return Boolean variable that indicates whether row copied successfully
	*/
	public boolean copyRowsInAWorksheet(int sourceRowIndex, int destinationRowIndex, int rowNumber) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		boolean isRowsCopiedSuccessfully = false;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/cells/rows/copy?sourceRowIndex=" + sourceRowIndex
				+ "&destinationRowIndex=" + destinationRowIndex + "&rowNumber=" + rowNumber;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "POST");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
		if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isRowsCopiedSuccessfully = true;
		}
		
		return isRowsCopiedSuccessfully;
	}
	
	/**
	 * Hide rows in a worksheet  
	 * @param fileName Name of the file stored on cloud
	 * @param worksheetName Worksheet name
	 * @param startrow The begin row index to be operated
	 * @param totalRows Number of rows to be operated
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return Boolean variable that indicates whether selected rows hide successfully
	*/
	public boolean hideRowsInAWorksheet(int startrow, int totalRows) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		boolean isRowsHideSuccessfully = false;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/cells/rows/hide?startrow=" + startrow +
				"&totalRows=" + totalRows;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "POST");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
		if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isRowsHideSuccessfully = true;
		}
		
		return isRowsHideSuccessfully;
	}
	
	/**
	 * Unhide rows in a worksheet  
	 * @param fileName Name of the file stored on cloud
	 * @param worksheetName Worksheet name
	 * @param startrow The begin row index to be operated
	 * @param totalRows Number of rows to be operated
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return Boolean variable that indicates whether selected rows unhide successfully
	*/
	public boolean unhideRowsInAWorksheet(int startrow, int totalRows) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		boolean isRowsUnHideSuccessfully = false;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/cells/rows/unhide?startrow=" + startrow +
				"&totalRows=" + totalRows;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "POST");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
		if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isRowsUnHideSuccessfully = true;
		}
		
		return isRowsUnHideSuccessfully;
	}
	
	/**
	 * Group rows in a worksheet  
	 * @param fileName Name of the file stored on cloud
	 * @param worksheetName Worksheet name
	 * @param firstIndex The first row index to be operated
	 * @param lastIndex The last row index to be operated
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return Boolean variable that indicates whether selected rows grouped successfully
	*/
	public boolean groupRowsInAWorksheet(int firstIndex, int lastIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		boolean isRowsGroupedSuccessfully = false;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/cells/rows/group?firstIndex=" + firstIndex +
				"&lastIndex=" + lastIndex;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "POST");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
		if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isRowsGroupedSuccessfully = true;
		}
		
		return isRowsGroupedSuccessfully;
	}
	
	/**
	 * Ungroup rows in a worksheet  
	 * @param fileName Name of the file stored on cloud
	 * @param worksheetName Worksheet name
	 * @param firstIndex The first row index to be operated
	 * @param lastIndex The last row index to be operated
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return Boolean variable that indicates whether selected rows ungrouped successfully
	*/
	public boolean ungroupRowsInAWorksheet(int firstIndex, int lastIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		boolean isRowsUnGroupedSuccessfully = false;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/cells/rows/ungroup?firstIndex=" + firstIndex +
				"&lastIndex=" + lastIndex;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "POST");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
		if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isRowsUnGroupedSuccessfully = true;
		}
		
		return isRowsUnGroupedSuccessfully;
	}

	/**
	 * Automatically fit rows' height and width  
	 * @param fileName Name of the file stored on cloud
	 * @param worksheetName Worksheet name
	 * @param firstIndex The first row index to be operated
	 * @param lastIndex The last row index to be operated
	 * @throws InvalidKeyException If initialization fails because the provided key is null.
	 * @throws NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws IOException If there is an IO error
	 * @return Boolean variable that indicates whether selected rows' height and width fit successfully
	*/
	public boolean autoFitRowsInAWorksheet(int firstIndex, int lastIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		boolean isRowsAutoFitSuccessfully = false;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(worksheetName == null || worksheetName.length() == 0) {
			throw new IllegalArgumentException("Worksheet name cannot be null or empty");
		}
		
		String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/cells/rows/autofit?firstIndex=" + firstIndex +
				"&lastIndex=" + lastIndex;
        //sign URL
        String signedURL = Utils.sign(strURL);
        
		InputStream responseStream = Utils.processCommand(signedURL, "POST");
		String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
		Gson gson = new Gson();
		BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
		if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
			isRowsAutoFitSuccessfully = true;
		}
		
		return isRowsAutoFitSuccessfully;
	}
}

