package com.aspose.cloud.sdk.words.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.words.model.GetTextItemsResponse;
import com.aspose.cloud.sdk.words.model.GetTextItemsResponse.TextItem;
import com.aspose.cloud.sdk.words.model.ReplaceTextModel;
import com.aspose.cloud.sdk.words.model.ReplaceTextResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Text --- Using this class you can get text items from a word document and replace text in a word document 
 * @author   M. Sohail Ismail
 */
public class Text {
	
	private static final String WORD_URI = AsposeApp.BASE_PRODUCT_URI + "/words/";
	
	/**
	 * Get Text Items from a Word Document 
	 * @param fileName Name of the word document
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An object that contains array of text items
	*/
	public static TextItem getTextItemsFromAWordDocument(String fileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		TextItem textItems = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		//build URL
      	String strURL = WORD_URI + Uri.encode(fileName) + "/textItems";
        //sign URL
        String signedURL = Utils.sign(strURL);
        
        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
      	Gson gson = new Gson();
      	GetTextItemsResponse textItemsResponse = gson.fromJson(responseJSONString, GetTextItemsResponse.class);
		if(textItemsResponse.getCode().equals("200") && textItemsResponse.getStatus().equals("OK")) {
			textItems = textItemsResponse.textItems;
		}
		
		return textItems;
	}
	
	/**
	 * Replace Text in a Word Document
	 * @param fileName Name of the word document
	 * @param oldValue Old string to replace
	 * @param newValue New string to replace
	 * @param isMatchCase True indicates case-sensitive comparison, false indicates case-insensitive comparison
	 * @param isMatchWholeWord True indicates the oldValue must be a stand-alone word
	 * @param storageName Third party cloud storage name. For details please visit http://www.aspose.com/docs/display/totalcloud/How+to+Configure+3rd+Party+Cloud+Storages
	 * @param folderName //In case file is not at root folder (Optional)
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return An object that contains number of matches
	*/
	public static ReplaceTextResponse replaceTextInAWordDocument(String fileName, String oldValue, String newValue,
			boolean isMatchCase, boolean isMatchWholeWord, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		ReplaceTextResponse replaceTextResponse = null;
		
		if(fileName == null || fileName.length() <= 3) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		if(oldValue == null) {
			throw new IllegalArgumentException("oldValue cannot be null");
		}
		
		if(newValue == null) {
			throw new IllegalArgumentException("newValue cannot be null");
		}
		
		ReplaceTextModel replaceTextObj = new ReplaceTextModel();
		// set old string to replace
		replaceTextObj.oldValue = oldValue;
        // set new string to replace
		replaceTextObj.newValue = newValue;
        // True indicates case-sensitive comparison, false indicates case-insensitive comparison.
		replaceTextObj.isMatchCase = isMatchCase;
        // True indicates the oldValue must be a stand alone word.
		replaceTextObj.isMatchWholeWord = isMatchWholeWord;
        
		GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String requestJSONString = gson.toJson(replaceTextObj, ReplaceTextModel.class);
        
		//build URL
      	StringBuilder strURL =  new StringBuilder(WORD_URI + Uri.encode(fileName) + "/replaceText");
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
        
        InputStream responseStream = Utils.processCommand(signedURL, "POST", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);
        
        //Parsing JSON
        replaceTextResponse = gson.fromJson(responseJSONString, ReplaceTextResponse.class);
		if(replaceTextResponse.getCode().equals("200") && replaceTextResponse.getStatus().equals("OK")) {
			return replaceTextResponse;
		} else {
			return null;
		}
	}
}
