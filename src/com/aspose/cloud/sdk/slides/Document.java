/**
 * 
 */
package com.aspose.cloud.sdk.slides;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import android.util.Log;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;
import com.google.gson.Gson;

// / <summary>
// / Deals with PowerPoint presentation level aspects
// / </summary>
public class Document {
	public Document(String fileName) {
		this.fileName = fileName;
		gson = new Gson();
	}

	// / <summary>
	// / Presentation name
	// / </summary>
	public String fileName;
	Gson gson = null;
	private static final String TAG = "Document";

	// / <summary>
	// / Finds the slide count of the specified PowerPoint document
	// / </summary>
	// / <returns>slide count</returns>
	public int getSlideCount() {
		try {
			// build URI to get slide count

			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/slides";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			SlidesResponse slidesResponse = gson.fromJson(strJSON,
					SlidesResponse.class);

			int count = slidesResponse.getSlides().getSlideList().size();
			return count;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return -1;
		}

	}

	// / <summary>
	// / Gets a list containing all document properties
	// / </summary>
	// / <returns>List of document properties</returns>
	public int getDocumentPropertiesCount() {
		try {
			// build URI to get document properties

			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/documentProperties";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			DocumentPropertiesResponse documentPropertiesResponse = gson
					.fromJson(strJSON, DocumentPropertiesResponse.class);

			return documentPropertiesResponse.getDocumentProperties().getList()
					.size();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return -1;
		}

	}

	// / <summary>
	// / Gets a list containing all document properties
	// / </summary>
	// / <returns>List of document properties</returns>
	public List<DocumentProperty> getDocumentProperties() {
		try {
			// build URI to get document properties

			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/documentProperties";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			DocumentPropertiesResponse documentPropertiesResponse = gson
					.fromJson(strJSON, DocumentPropertiesResponse.class);

			return documentPropertiesResponse.getDocumentProperties().getList();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}

	}

	// / <summary>
	// / Gets the value of a particular property
	// / </summary>
	// / <param name="propertyName"></param>
	// / <returns>value of the specified property</returns>
	public DocumentProperty getDocumentProperty(
			String propertyName) {
		try {
			// build URI to get single property
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/presentation/documentproperties/" + propertyName;
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			DocumentPropertyResponse documentPropertyResponse = gson.fromJson(
					strJSON, DocumentPropertyResponse.class);

			return documentPropertyResponse.getDocumentProperty();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Removes all the custom properties and resets all the built-in
	// properties
	// / </summary>
	public boolean removeAllProperties() {
		try {
			// build URI to remove/reset all the properties
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/documentProperties";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI,
					"DELETE");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return false;
		}
	}

	// / <summary>
	// / Replaces all instances of old text with new text in a presentation
	// / </summary>
	// / <param name="oldText"></param>
	// / <param name="newText"></param>
	public boolean replaceText(String oldText, String newText) {
		try {
			// build URI to replace text
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/replaceText?oldValue=" + oldText + "&newValue="
					+ newText;// + "&ignoreCase=true";
			strURI = strURI.replace(" ", "%20");
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return false;
		}

	}

	// / <summary>
	// / Replaces all instances of old text with new text in a slide
	// / </summary>
	// / <param name="oldText"></param>
	// / <param name="newText"></param>
	// / <param name="slideNumber"></param>
	public boolean replaceText(String oldText, String newText, int slideNumber) {
		try {
			// build URI to replace text in a particular slide
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/slides/" + Integer.toString(slideNumber)
					+ "/replaceText?oldValue=" + oldText + "&newValue="
					+ newText + "&ignoreCase=true";
			strURI = strURI.replace(" ", "%20");
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return false;
		}

	}

	// / <summary>
	// / Deletes a particular custom property or resets a particular built-in
	// property
	// / </summary>
	// / <param name="propertyName"></param>
	public boolean deleteDocumentProperty(String propertyName) {
		try {
			// build URI to remove single property
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/documentProperties/" + propertyName;
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI,
					"DELETE");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return false;
		}
	}

	// / <summary>
	// / Gets all the text items in a presentation
	// / </summary>
	// / <returns>A list containing all the text items</returns>
	public List<TextItem> getAllTextItems() {
		try {
			// build URI to get all text items in a presentation
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/textItems";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getItems();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}

	}

	// / <summary>
	// / Gets all the text items in a slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / /// <param name="withEmpty">Set this to true to include items for
	// shapes without text</param>
	// / <returns>A list containing all the text items in a slide</returns>
	public List<TextItem> getAllTextItems(int slideNumber, boolean withEmpty) {
		try {
			// build URI to get all text items in a slide
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/slides/" + Integer.toString(slideNumber)
					+ "/textItems?withEmpty="
					+ new Boolean(withEmpty).toString();
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getItems();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / saves the document into various formats
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="saveFormat"></param>
	public void saveAs(String outputPath, SaveFormat saveFormat) {

		try {
			// build URI to get page count
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName;
			strURI += "?format=" + saveFormat.toString().toLowerCase();

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Folder.saveStreamToFile(outputPath,
					responseStream);

			responseStream.close();
		}

		catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
	}

	// / <summary>
	// / Saves a particular slide into various formats
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="slideNumber"></param>
	// / <param name="imageFormat"></param>
	public void saveSlideAs(String outputPath, int slideNumber,
			ImageFormat imageFormat)// Returns 100x100 image
	{

		try {

			// build URI to get page count
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/slides/" + Integer.toString(slideNumber) + "?format="
					+ imageFormat.toString().toLowerCase();

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Folder.saveStreamToFile(outputPath,
					responseStream);

			responseStream.close();
		}

		catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
	}

	// / <summary>
	// / Saves a particular slide into various formats with specified width and
	// height
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="slideNumber"></param>
	// / <param name="imageFormat"></param>
	// / <param name="width"></param>
	// / <param name="height"></param>
	public void saveSlideAs(String outputPath, int slideNumber,
			ImageFormat imageFormat, int width, int height) {
		try {
			// build URI to get page count
			// String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" +
			// FileName + "/slides/" + slideNumber+"/images" + "?format=" +
			// imageFormat.toString().toLowerCase() + "&width=" +
			// Integer.toString(width) + "&height=" + Integer.toString(height);
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/slides/" + slideNumber + "?format="
					+ imageFormat.toString().toLowerCase() + "&width="
					+ Integer.toString(width) + "&height="
					+ Integer.toString(height);

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Folder.saveStreamToFile(outputPath,
					responseStream);

			responseStream.close();
		}

		catch (Exception e) {
			Log.e(TAG, e.getMessage());
		}
	}

	// / <summary>
	// / Sets the value of a particular property or adds a new property if the
	// specified property does not exist
	// / </summary>
	// / <param name="propertyName"></param>
	// / <param name="value"></param>
	public boolean setDocumentProperty(String propertyName, String value) throws IOException, InvalidKeyException, NoSuchAlgorithmException {

		// build URI to remove single property
		String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
				+ "/documentProperties/" + propertyName;
		String signedURI = Utils.sign(strURI);

		// serialize the JSON request content
		DocumentProperty docProperty = new DocumentProperty();
		docProperty.setValue(value);

		String strJSON = "";
		strJSON = gson.toJson(docProperty,
				DocumentProperty.class);

		InputStream responseStream = Utils.processCommand(signedURI, "PUT",
				strJSON);

		String strResponse = Utils.streamToString(responseStream);
		// Parse and deserialize the JSON to a object.
		DocumentPropertyResponse baseResponse = gson.fromJson(strResponse,
				DocumentPropertyResponse.class);

		if ((baseResponse.getCode().equals("200") && baseResponse.getStatus()
				.equals("OK"))
				|| (baseResponse.getCode().equals("201") && baseResponse
						.getStatus().equals("Created")))
			return true;
		else
			return false;
	}

}