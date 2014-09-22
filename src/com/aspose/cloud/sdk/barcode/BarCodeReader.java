/**
 * 
 */
package com.aspose.cloud.sdk.barcode;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import android.util.Log;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;
import com.google.gson.Gson;

/// <summary>
/// Class to read barcodes from image. There are 2 ways to feed the image for barcode recognition
/// 1. Image from Aspose server.
/// 2. Image from any URL.
/// 3. Local image. Image will be uploaded on Aspose server in this case.
/// </summary>
public class BarCodeReader {
	// / <summary>
	// / Default constructor
	// / </summary>
	private static final String TAG = "BarCodeReader";

	public BarCodeReader() {
		this.gson = new Gson();

	}

	Gson gson = null;
	// Declare private member variables to be used within different methods
	private String remoteImageName = "";

	// / <summary>
	// / Read barcode from local image. Local image will first be uploaded on
	// Aspose server
	// / and then recognized using com.spose.cloud.barcode. Result will be returned
	// to client
	// / </summary>
	// / <param name="localImage">Full path and file name of local image</param>
	// / <param name="remoteFolder">Remote folder name on Aspose
	// storage</param>
	// / <param name="barcodeReadType">Barcode type to be recognized</param>
	// / <returns>List of recognized barcodes</returns>
	// / <example>
	// / BarCodeReader reader = new BarCodeReader();
	// / List<RecognizedBarCode> barcodesRead =
	// reader.ReadFromLocalImage(@"c:\pdf417.jpg", "", BarCodeReadType.Pdf417);
	// / foreach (RecognizedBarCode barcodeRead in barcodesRead)
	// / {
	// / Console.WriteLine("Codetext: " + barcodeRead.BarCodeValue + "\nType: "
	// + barcodeRead.BarCodeType);
	// / }
	// / </example>
	public List<RecognizedBarCode> readFromLocalImage(String localImage,
			String remoteFolder, BarCodeReadType barcodeReadType) {
		try {

			// First upload the local image to remote location
			Folder folder = new Folder();
			folder.uploadFile(localImage, remoteFolder);

			// After upload, perform server recognition on uploaded image
			return read(new File(localImage).getName(), remoteFolder,
					barcodeReadType);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}

	}

	// / <summary>
	// / Read barcode from image on Aspose server.
	// / </summary>
	// / <param name="remoteImageName">Remote image file name.</param>
	// / <param name="remoteFolder">Optional. Specify folder path to locate the
	// image.</param>
	// / <param name="readType">Barcode type</param>
	// / <returns>List of recognized barcodes</returns>
	// / <example>
	// / BarCodeReader reader = new BarCodeReader();
	// / List<RecognizedBarCode> barcodesRead = reader.Read("test-1234.png", "",
	// BarCodeReadType.AllSupportedTypes);
	// / Console.WriteLine("Read from server.");
	// / foreach (RecognizedBarCode barcodeRead in barcodesRead)
	// / {
	// / Console.WriteLine("Codetext: " + barcodeRead.BarCodeValue + "\nType: "
	// + barcodeRead.BarCodeType);
	// / }
	// / </example>
	public List<RecognizedBarCode> read(String remoteImageName,
			String remoteFolder, BarCodeReadType readType) {
		try {

			this.remoteImageName = remoteImageName;

			performValidations(false);

			// Build URL with queryString request parameters
			String uri = uriBuilder(remoteImageName, remoteFolder, readType);
			// Send the request to Aspose server
			InputStream responseStream = Utils.processCommand(Utils.sign(uri),
					"GET");

			// Read the response
			String strJSON = Utils.streamToString(responseStream);

			// Parse and Deserializes the JSON to a object.
			RecognitionResponse barcodeRecognitionResponse = gson.fromJson(
					strJSON, RecognitionResponse.class);

			return barcodeRecognitionResponse.getBarcodes();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Read barcode from URL
	// / </summary>
	// / <param name="url">A URL containing image e.g.
	// http://www.yourdomain.com/folder/images/code39.png </param>
	// / <param name="readType">type of barcode to be recognized</param>
	// / <returns>The response from Aspose service</returns>
	// / <example>
	// / BarCodeReader reader = new BarCodeReader();
	// / List<RecognizedBarCode> barcodesRead =
	// serverReader.Read("http://upload.wikimedia.org/wikipedia/commons/c/ce/WikiQRCode.png",
	// BarCodeReadType.AllSupportedTypes);
	// / Console.WriteLine("Read from URL.");
	// / foreach (RecognizedBarCode barcodeRead in barcodesRead)
	// / {
	// / Console.WriteLine("Codetext: " + barcodeRead.BarCodeValue + "\nType: "
	// + barcodeRead.BarCodeType);
	// / }
	// / </example>
	public List<RecognizedBarCode> read(String url, BarCodeReadType readType) {
		try {
			// Only validate the API keys
			performValidations(true);

			// Build URI for accessing com.spose.cloud.barcode API
			String uri = uriBuilderForURLImage(url, readType);

			// Send the request to Aspose server
			InputStream responseStream = Utils.processCommand(Utils.sign(uri),
					"POST");

			// Read the response
			String strJSON = Utils.streamToString(responseStream);

			// Parse the json String to JObject

			// Parse and Deserializes the JSON to a object.
			RecognitionResponse barcodeRecognitionResponse = gson.fromJson(
					strJSON, RecognitionResponse.class);

			return barcodeRecognitionResponse.getBarcodes();
		} catch (Exception e) {

			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	private String uriBuilder(String remoteImage, String remoteFolder,
			BarCodeReadType readType) {
		// Initialize with server URI, text and type, which are must
		String uri = AsposeApp.BASE_PRODUCT_URI + "/barcode/";
		// remoteImage is the name of image on Aspose server
		if (remoteImage != null && !remoteImage.equals("")) {
			uri += remoteImage + "/";
		}
		uri += "recognize?";

		// First parameter. Add barcode type to be recognized
		// If AllSupportedTypes is selected, set blank, otherwise, send the
		// ToString()
		if (readType == BarCodeReadType.AllSupportedTypes) {
			uri += "type=";
		} else {
			uri += "type=" + readType.toString();
		}
		// Add remote folder parameter
		if (remoteFolder != null && !remoteFolder.equals("")) {
			uri += "&format=" + remoteFolder;
		}
		// Add folder parameter
		if (remoteFolder != null && !remoteFolder.equals("")) {
			uri += "&folder=" + remoteFolder;
		}
		// return the URI
		return uri;
	}

	private void performValidations(boolean apikeysOnly) throws Exception {
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
		// If only API keys need to be validated, then no need to proceed
		// further, so return
		if (apikeysOnly) {
			return;
		}
		// Throw exception if barcode value is empty
		if (remoteImageName == null || remoteImageName.equals("")) {
			throw new Exception("Image name is not specified.");
		}
	}

	// / <summary>
	// / Build URI for the recognition of image from URL
	// / </summary>
	// / <param name="url">URL of the image</param>
	// / <param name="readType">barcode read type</param>
	// / <returns>URI of Aspose URL image recognition</returns>
	private String uriBuilderForURLImage(String url, BarCodeReadType readType) {
		// Initialize with server URI, text and type, which are must
		String uri = AsposeApp.BASE_PRODUCT_URI + "/barcode/";
		uri += "recognize?";

		// First parameter. Add barcode type to be recognized
		// If AllSupportedTypes is selected, set blank, otherwise, send the
		// ToString()
		if (readType == BarCodeReadType.AllSupportedTypes) {
			uri += "type=";
		} else {
			uri += "type=" + readType.toString();
		}
		// Add URL parameter
		if (url != null && !url.equals("")) {
			uri += "&url=" + url;
		}
		// return the URI
		return uri;
	}
}