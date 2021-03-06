package com.aspose.cloud.sdk.slides.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.slides.model.DocumentPropertiesResponse;
import com.aspose.cloud.sdk.slides.model.DocumentPropertiesResponse.DocumentPropertiesResult;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * DocumentProperties --- Using this class you can get, set and remove document properties
 * @author   M. Sohail Ismail
 */
public class DocumentProperties {

	private static final String SLIDES_URI = AsposeApp.BASE_PRODUCT_URI + "/slides/";

	/**
	 * Get properties of a PowerPoint document
	 *
	 * @param fileName Name of the file stored on cloud
	 * @return An object that contains document properties
	 * @throws java.security.InvalidKeyException      If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException                    If there is an IO error
	 */
	public static DocumentPropertiesResult getDocumentProperties(String fileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		DocumentPropertiesResult documentProperties = null;

		if (fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		//build URL
		String strURL = SLIDES_URI + Uri.encode(fileName) + "/documentProperties";
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String responseJSONString = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		DocumentPropertiesResponse documentPropertiesResponse = gson.fromJson(responseJSONString, DocumentPropertiesResponse.class);
		if (documentPropertiesResponse.getCode().equals("200") && documentPropertiesResponse.getStatus().equals("OK")) {
			documentProperties = documentPropertiesResponse.documentProperties;
		}

		return documentProperties;
	}

	/**
	 * Delete all document properties
	 *
	 * @param fileName Name of the file stored on cloud
	 * @return An object that contains document properties
	 * @throws java.security.InvalidKeyException      If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException                    If there is an IO error
	 */
	public static DocumentPropertiesResult removeAllProperties(String fileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		DocumentPropertiesResult documentProperties = null;

		if (fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}

		//build URL
		String strURL = SLIDES_URI + Uri.encode(fileName) + "/documentProperties";
		//sign URL
		String signedURL = Utils.sign(strURL);
		InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
		String responseJSONString = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		DocumentPropertiesResponse documentPropertiesResponse = gson.fromJson(responseJSONString, DocumentPropertiesResponse.class);
		if (documentPropertiesResponse.getCode().equals("200") && documentPropertiesResponse.getStatus().equals("OK")) {
			documentProperties = documentPropertiesResponse.documentProperties;
		}

		return documentProperties;
	}

	/**
	 * Set document properties
	 *
	 * @param fileName The document name.
	 * @param documentPropertyRequest New properties.
	 * @param contentType Can be either XML or JSON
	 * @return An object that contains document properties
	 * @throws java.security.InvalidKeyException      If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException                    If there is an IO error
	 */
	public static DocumentPropertiesResult setDocumentProperties(String fileName, String documentPropertyRequest, String contentType) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

		DocumentPropertiesResult documentProperties = null;

		//build URL
		String strURL = SLIDES_URI + Uri.encode(fileName) + "/documentProperties";
		//sign URL
		String signedURL = Utils.sign(strURL);

		InputStream responseStream = Utils.processCommand(signedURL, "POST", documentPropertyRequest, contentType);
		String responseJSONString = Utils.streamToString(responseStream);

		//Parsing JSON
		Gson gson = new Gson();
		DocumentPropertiesResponse documentPropertiesResponse = gson.fromJson(responseJSONString, DocumentPropertiesResponse.class);
		if (documentPropertiesResponse.getCode().equals("200") && documentPropertiesResponse.getStatus().equals("OK")) {
			documentProperties = documentPropertiesResponse.documentProperties;
		}

		return documentProperties;
	}
}