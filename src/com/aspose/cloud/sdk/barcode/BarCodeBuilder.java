/**
 * 
 */
package com.aspose.cloud.sdk.barcode;

import java.io.InputStream;

import android.util.Log;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;
import com.google.gson.Gson;

/// <summary>
/// Class to create barcodes.
/// </summary>
/// <example>
/// Create a Code128 barcode and save the barcode image on local system.
/// <code>
/// BarCodeBuilder builder = new BarCodeBuilder("test-123", BarCodeType.Pdf417);
/// builder.Save(SaveLocation.Local, "code128.png", ImageFormat.PNG);
/// </code>
/// </example>
public class BarCodeBuilder {
	private static final String TAG = "BarCodeBuilder";

	// / <summary>
	// / Default constructor, initialize the BarcodeBuilder class
	// / Default symbology is Code128
	// / </summary>
	public BarCodeBuilder() {
		this.barCodeType = BarCodeType.Code128;
		this.codeText = "test-123";
		this.imageFormat = ImageFormat.PNG;
		this.gson = new Gson();

	}

	// / <summary>
	// / Constructor with codetext and barcode type
	// / </summary>
	// / <param name="codetext">Barcode value</param>
	// / <param name="barcodeType">Barcode type</param>
	public BarCodeBuilder(String codetext, BarCodeType barcodeType) {
		this.barCodeType = barcodeType;
		this.codeText = codetext;
		this.imageFormat = ImageFormat.PNG;
		this.gson = new Gson();
	}

	// / <summary>
	// / Get or set Codetext of the barcode
	// / </summary>
	public String codeText;

	// / <summary>
	// / Get or set the type of barcode to be generated e.g. Code128,
	// Code39Standard, Pdf417 etc
	// / </summary>
	public BarCodeType barCodeType;

	// / <summary>
	// / Get or set the image format of the barcode. Default is PNG
	// / </summary>
	public ImageFormat imageFormat;

	// / <summary>
	// / Set X resolution in DPI. Default is 96.
	// / </summary>
	public float resolutionX;

	// / <summary>
	// / Set Y resolution in DPI. Default is 96.
	// / </summary>
	public float resolutionY;

	// / <summary>
	// / Set X dimension. Default is 0.7.
	// / </summary>
	public float dimensionX;

	// / <summary>
	// / Set Y dimension. Default is 2.
	// / </summary>
	public float dimensionY;

	// / <summary>
	// / Folder name on server, where barcode is to be saved. To be used with
	// Save() method with SaveLocation.Server parameter
	// / </summary>
	public String folderName;

	Gson gson = null;

	// / <summary>
	// / Creates the barcode and save the barcode image to the local path
	// provided
	// / Examples:
	// / Save(SaveLocation.Local, "c:\\code128.png", ImageFormat.PNG);
	// / Save(SaveLocation.Server, "test-1234.png", ImageFormat.PNG);
	// / </summary>
	// / <param name="SaveLocation">Location where barcode needs to be saved,
	// local or Aspose server</param>
	// / <param name="outputPath">Location where barcode is to be saved</param>
	// / <param name="ImageFormat">Image format</param>
	public GenerationResponse save(SaveLocation saveLocation,
			String outputPath, ImageFormat imageFormat) {
		try {
			performValidations();

			// If image needs to be saved locally
			if (saveLocation == SaveLocation.Local) {
				// Build URL with querystring request parameters
				String uri = uriBuilder("");

				// Send the request to Aspose server
				InputStream responseStream = Utils.processCommand(
						Utils.sign(uri), "GET");

				// Read the response, in this case the response is a InputStream
				// that contains barcode image
				// So, just save the response stream to a local image file

				Folder.saveStreamToFile(outputPath, responseStream);
				responseStream.close();

				GenerationResponse response = new GenerationResponse();
				response.setStatus("OK");
				return response;
			} else if (saveLocation == SaveLocation.Server) {
				// Build URL with querystring request parameters
				String uri = uriBuilder(outputPath);

				// Send the request to Aspose server
				InputStream responseStream = Utils.processCommand(
						Utils.sign(uri), "PUT");

				// Read the response
				String strJSON = Utils.streamToString(responseStream);

				// Parse and Deserializes the JSON to a object.
				GenerationResponse barcodeGenerationResponse = gson.fromJson(
						strJSON, GenerationResponse.class);

				return barcodeGenerationResponse;
			}

			// Return null, if anything goes wrong
			return null;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Creates the barcode and save the barcode image to the supplied stream
	// / Example: Save(SaveLocation.Local, imgStream, ImageFormat.PNG);
	// / </summary>
	// / <param name="imageStream">InputStream where image will be saved</param>
	// / <param name="ImageFormat">Image format</param>
	// public GenerationResponse Save(SaveLocation saveLocation, InputStream
	// imageStream, ImageFormat imageFormat)
	public InputStream save(ImageFormat imageFormat) {
		try {
			performValidations();

			// Build URL with querystring request parameters
			String uri = uriBuilder("");

			// Send the request to Aspose server
			InputStream responseStream = Utils.processCommand(Utils.sign(uri),
					"GET");

			return responseStream;
			// Read the response, in this case the response is a InputStream
			// that contains barcode image
			// Just copy the response stream to the image stream that user
			// passed
			// imageStream= new
			// com.spose.cloud.common.CopyInputStream(responseStream).getCopy();

			// CopyStream(responseStream, imageStream);
			// java.lang.Object.copy()

			// close the response stream
			// responseStream.close();

			// GenerationResponse response = new GenerationResponse();
			// response.getStatus() = "OK";
			// return response;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Build the URI
	// / </summary>
	private String uriBuilder(String imageFileName) {
		// Initialize with server URI, text and type, which are must
		String uri = AsposeApp.BASE_PRODUCT_URI + "/barcode/";
		// imageFileName is to be handled in case of PUT request, where barcode
		// is to be saved on Aspose server
		if (imageFileName != null && !imageFileName.equals("")) {
			uri += imageFileName + "/";
		}
		uri += "generate?text=" + codeText + "&type=" + barCodeType;
		// Add image format parameter
		uri += "&format=" + imageFormat;

		// Add folder parameter
		if (folderName != null && !folderName.equals("")) {
			uri += "&folder=" + folderName;
		}

		// Add x resolution parameter
		if (resolutionX != 0.0f) {
			uri += "&resolutionX=" + resolutionX;
		}
		// Add y resolution parameter
		if (resolutionY != 0.0f) {
			uri += "&resolutionY=" + resolutionY;
		}
		// Add x dimension parameter
		if (dimensionX != 0.0f) {
			uri += "&dimensionX=" + dimensionX;
		}
		// Add y dimension parameter
		if (dimensionY != 0.0f) {
			uri += "&dimensionY=" + dimensionY;
		}
		// return the URI
		return uri;
	}

	// / <summary>
	// / Perform validations locally
	// / </summary>
	private void performValidations() throws Exception {
		// Throw exception if App Key is empty
		if (AsposeApp.APP_KEY == null
				|| AsposeApp.APP_KEY.trim().length() == 0) {
			throw new Exception(
					"App Key is not specified. Please set the App Key property.");
		}
		// Throw exception if App SID is empty
		if (AsposeApp.APP_SID == null
				|| AsposeApp.APP_SID.trim().length() == 0) {
			throw new Exception(
					"App SID is not specified. Please set App SID property.");
		}
		// Throw exception if codetext is empty
		if (codeText == null || codeText.equals("")) {
			throw new Exception(
					"Codetext is not specified. Please set Codetext property.");
		}
	}

}