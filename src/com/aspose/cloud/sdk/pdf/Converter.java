/**
 * 
 */
package com.aspose.cloud.sdk.pdf;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.aspose.cloud.sdk.common.Product;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;

// / <summary>
// / converts pages or document into different formats
// / </summary>
public class Converter {
	public Converter(String fileName) {
		this.fileName = fileName;
	}

	// / <summary>
	// / PDF document name
	// / </summary>
	public String fileName;
	static final Logger logger = Logger.getLogger(Converter.class);

	// / <summary>
	// / convert a particular page to image
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="pageNumber"></param>
	public boolean getImage(String outputPath, int pageNumber,
			ConvertImageFormat imageFormat, SaveLocation saveLocation,
			int imageHeight, int imageWidth) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber);
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
	// / convert a particular page to image with default size
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="pageNumber"></param>
	public boolean getImage(String outputPath, int pageNumber,
			ConvertImageFormat imageFormat, SaveLocation saveLocation) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber);
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

	// / <summary>
	// / save the document into various formats
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="saveFormat"></param>
	public boolean convert(String outputPath, SaveFormat saveFormat) {

		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName;
			strURI += "?format=" + saveFormat.toString();

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
	// / Convert Document to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public void convertLocalFile(String inputPath, String outputPath,
			SaveFormat outputFormat) {
		try {

			// build URI
			String strURI = Product.getBaseProductUri()
					+ "/pdf/convert?format=" + outputFormat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream fileStream = new FileInputStream(inputPath);

			// get response stream
			InputStream responseStream = Utils.processCommand(signedURI, "PUT",
					fileStream);

			Folder.saveStreamToFile(outputPath, responseStream);

			responseStream.close();

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

	}

	// / <summary>
	// / Convert document to different file format without using storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public InputStream convertLocalFile(InputStream inputStream,
			SaveFormat outputFormat) {
		try {
			// build URI
			String strURI = Product.getBaseProductUri()
					+ "/pdf/convert?format=" + outputFormat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			return Utils.processCommand(signedURI, "PUT", inputStream);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}

	}

}
