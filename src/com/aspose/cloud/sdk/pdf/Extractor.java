/**
 * 
 */
package com.aspose.cloud.sdk.pdf;

import java.io.InputStream;

import org.apache.log4j.Logger;

import com.aspose.cloud.sdk.common.Product;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;
import com.google.gson.Gson;

// / <summary>
// / Extract various types of information from the document
// / </summary>
public class Extractor {
	public Extractor(String fileName) {
		this.fileName = fileName;
	}

	// / <summary>
	// / PDF document name
	// / </summary>
	public String fileName;
	static final Logger logger = Logger.getLogger(Extractor.class);

	// / <summary>
	// / Gets number of images in a specified page
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <returns></returns>
	public int getImageCount(int pageNumber) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/images";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			;

			Gson gson = new Gson();
			// Parse and Deserializes the JSON to a object.
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}

	}

	// / <summary>
	// / Get the particular image from the specified page
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="pageNumber"></param>
	public boolean getImage(String outputPath, int pageNumber, int imageIndex,
			ExtractImageFormat imageFormat, SaveLocation saveLocation,
			int imageHeight, int imageWidth) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/images/"
					+ Integer.toString(imageIndex);
			strURI += "?format=" + imageFormat.toString();
			strURI += "&width=" + Integer.toString(imageWidth);
			strURI += "&height=" + Integer.toString(imageHeight);

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}

	}

	// / <summary>
	// / Get the particular image from the specified page with the default image
	// size
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="pageNumber"></param>
	public boolean getImage(String outputPath, int pageNumber, int imageIndex,
			ExtractImageFormat imageFormat, SaveLocation saveLocation) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/images/"
					+ Integer.toString(imageIndex);
			strURI += "?format=" + imageFormat.toString();

			String signedURI = Utils.sign(strURI);
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			boolean response = Folder.saveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}

	}

}
