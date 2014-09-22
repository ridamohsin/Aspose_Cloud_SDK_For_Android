package com.aspose.cloud.sdk.words;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import android.util.Log;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

/// <summary>
/// Deals with document level aspects
/// </summary>
public class Document {
	private static final String TAG = "Document";
	// / <summary>
	// / document name
	// / </summary>
	public String fileName;

	// / <summary>
	// / The original format of the file.
	// / </summary>
	public String sourceFormat;

	// / <summary>
	// / Returns true if the document is encrypted and requires a password to
	// open
	// / </summary>
	public String isEncrypted;

	// / <summary>
	// / Returns true if the document contains a digital signature.
	// / </summary>
	public String isSigned;

	// / <summary>
	// / Document Properties Response
	// / </summary>
	public DocumentPropertiesResponse documentproperties;

	// / <summary>
	// / Link Response related to document like
	// / <link
	// href="http://api.aspose.com/v1.1/words/TestGet.doc/documentProperties"
	// rel="self" />
	// / </summary>
	public List<LinkResponse> links;

	// / <summary>
	// / Document Constructor, set the file name
	// / </summary>
	// / <param name="fileName"> File Name</param>
	public Document(String fileName) {
		this.fileName = fileName;
	}

	// / <summary>
	// / Get Document's properties
	// / </summary>
	// / <returns>List of document properties</returns>
	public List<DocumentProperty> getProperties() {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + fileName;
			strURI += "/documentProperties";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			DocumentResponse docResponse = gson.fromJson(strJSON,
					DocumentResponse.class);

			return docResponse.DocumentProperties.List;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}

	}

	public DocumentProperty getProperty(String propertyName) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + fileName;
			strURI += "/documentProperties/" + propertyName;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			DocumentResponse docResponse = gson.fromJson(strJSON,
					DocumentResponse.class);

			return docResponse.DocumentProperty;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Set document property
	// / </summary>
	// / <param name="propertyName">property name</param>
	// / <param name="propertyValue">property value</param>
	public boolean setProperty(String propertyName, String propertyValue) {
		try {
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + fileName
					+ "/documentProperties/" + propertyName;
			String signedURI = Utils.sign(strURI);

			// serialize the JSON request content
			DocumentProperty docProperty = new DocumentProperty();
			docProperty.Value = propertyValue;

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(docProperty, DocumentProperty.class);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT",
					strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
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
	// / Delete a document property
	// / </summary>
	// / <param name="propertyName">Property Name</param>
	// / <returns></returns>
	public boolean deleteProperty(String propertyName) {
		try {
			// check whether file is set or not
			if (fileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + fileName;
			strURI += "/documentProperties/" + propertyName;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI,
					"DELETE");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}

	// / <summary>
	// / Get Resource Properties information like document source format,
	// IsEncrypted, IsSigned and document properties
	// / </summary>
	// / <returns></returns>
	public DocumentResourceResponse getDocumentInfo() {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + fileName;
			// strURI += "/document";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			DocumentResourceResponse docResponse = gson.fromJson(strJSON,
					DocumentResourceResponse.class);

			return docResponse;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	public Boolean appendDocument(String[] appendDocs,
			String[] importFormatModes, String folder) {

		// check whether file is set or not
		if (fileName == "")
			throw new RuntimeException("No file name specified");

		// check whether required information is complete
		if (appendDocs.length != importFormatModes.length)
			throw new RuntimeException(
					"Please specify complete documents and import format modes");

		try {
			// Create DocumentEntryList object
			DocumentEntryList list = new DocumentEntryList();
			list.setDocumentEntries(new java.util.ArrayList<DocumentEntry>());

			for (int i = 0; i < appendDocs.length; i++) {
				String appendDoc = appendDocs[i];
				String docServerPath = folder + "\\" + appendDoc;
				list.getDocumentEntries().add(
						new DocumentEntry(docServerPath, importFormatModes[i]));
			}

			// Extract File Name
			String inputFileName = new File(fileName).getName();

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/"
					+ inputFileName + "/appendDocument";
			if (folder != "")
				strURI = strURI + "?folder=" + folder;

			// sign URI
			String signedURI = Utils.sign(strURI);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(list, DocumentEntryList.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			String ResJSONStr = Utils.streamToString(responseStream);

			Gson gsonObj = new Gson();

			BaseResponse baseResponse = gsonObj.fromJson(ResJSONStr,
					BaseResponse.class);

			if (baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			return false;
		}

	}

}