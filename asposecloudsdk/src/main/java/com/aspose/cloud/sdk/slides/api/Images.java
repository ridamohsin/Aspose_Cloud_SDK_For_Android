package com.aspose.cloud.sdk.slides.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.slides.model.ImagesResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Images --- Using this class you can get number of images in a presentation or slide
 * @author   M. Sohail Ismail
 */
public class Images {
	
	private static final String SLIDES_URI = AsposeApp.BASE_PRODUCT_URI + "/slides/";
	
	/**
	 * Get number of images in a presentation
	 * @param fileName Name of the file stored on cloud
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return Images count
	*/ 
	public static int getNumberOfImagesInAPresentation(String fileName, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		int imagesCount = -1;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		//build URL
		StringBuilder strURL = new StringBuilder(SLIDES_URI + Uri.encode(fileName) + "/images");
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
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String responseJSONString = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		ImagesResponse imagesResponse = gson.fromJson(responseJSONString, ImagesResponse.class);
		if(imagesResponse.getCode().equals("200") && imagesResponse.getStatus().equals("OK")) {
			imagesCount = imagesResponse.images.List.size();
		}
		
		return imagesCount;
	}
	
	/**
	 * Get number of images in a slide
	 * @param fileName Name of the file stored on cloud
	 * @param slideIndex Index of slide
	 * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
	 * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
	 * @throws java.io.IOException If there is an IO error
	 * @return Images count
	*/ 
	public static int getNumberOfImagesInASlide(String fileName, int slideIndex, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
		
		int imagesCount = -1;
		
		if(fileName == null || fileName.length() == 0) {
			throw new IllegalArgumentException("File name cannot be null or empty");
		}
		
		//build URL
		StringBuilder strURL = new StringBuilder(SLIDES_URI + Uri.encode(fileName) + "/slides/" + slideIndex +  "/images");
		//If document is on the third party storage
		if(storageName != null && storageName.length() != 0) {
			strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
			strURL.append("storage=" + storageName);
		}
		//If file is not at root folder
		if(folderName != null && folderName.length() != 0) {
			strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
			strURL.append("folder=" + folderName);
		}

		//sign URL
		String signedURL = Utils.sign(strURL.toString());
		InputStream responseStream = Utils.processCommand(signedURL, "GET");
		String responseJSONString = Utils.streamToString(responseStream);
		
		//Parsing JSON
		Gson gson = new Gson();
		ImagesResponse imagesResponse = gson.fromJson(responseJSONString, ImagesResponse.class);
		if(imagesResponse.getCode().equals("200") && imagesResponse.getStatus().equals("OK")) {
			imagesCount = imagesResponse.images.List.size();
		}
		
		return imagesCount;
	}
}
