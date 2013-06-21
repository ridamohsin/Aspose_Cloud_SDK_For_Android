/**
 * 
 */
package com.aspose.cloud.sdk.pdf;

import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

import com.aspose.cloud.sdk.common.Product;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

// / <summary>
// / This class contains features to work with text
// / </summary>
public class TextEditor {
	public TextEditor(String fileName) {
		this.fileName = fileName;
		gson = new Gson();
	}

	// / <summary>
	// / PDF document name
	// / </summary>
	public String fileName;
	Gson gson = null;
	static final Logger logger = Logger.getLogger(TextEditor.class);

	// / <summary>
	// / Gets raw text from the whole PDF file
	// / </summary>
	// / <returns></returns>
	public String getText() {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/TextItems";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			String strJSON = Utils.streamToString(responseStream);

			// Parse and Deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			StringBuilder stringBuilder = new StringBuilder();

			for (TextItem textItem : textItemsResponse.getTextItems().getList()) {
				stringBuilder.append(textItem.getText());
			}

			return stringBuilder.toString();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Gets raw text from a particular page
	// / </summary>
	// / <returns></returns>
	public String getText(int pageNumber) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/TextItems";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			;

			// Parse and Deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			StringBuilder stringBuilder = new StringBuilder();

			for (TextItem textItem : textItemsResponse.getTextItems().getList()) {
				stringBuilder.append(textItem.getText());
			}

			return stringBuilder.toString();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	// / <summary>
	// / Gets text items from the whole PDF file
	// / </summary>
	// / <returns></returns>
	public List<TextItem> getTextItems() {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/TextItems";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			;

			// Parse and Deserializes the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	// / <summary>
	// / Gets text items from a particular page
	// / </summary>
	// / <returns></returns>
	public List<TextItem> getTextItems(int pageNumber) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/TextItems";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			;

			// Parse and Deserialize the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Gets all text items from a fragment
	// / </summary>
	// / <returns></returns>
	public List<TextItem> getTextItems(int pageNumber, int fragmentNumber) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/fragments/"
					+ Integer.toString(fragmentNumber);
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			;

			// Parse and Deserializes the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Gets count of the fragments from a particular page
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <returns></returns>
	public int getFragmentCount(int pageNumber) {

		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/fragments";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			;

			// Parse and deserializes the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList().size();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// / Gets count of segments in a fragment
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="fragmentNumber"></param>
	// / <returns></returns>
	public int getSegmentCount(int pageNumber, int fragmentNumber) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/fragments/"
					+ Integer.toString(fragmentNumber);
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			;

			// Parse and deserializes the JSON to a object.
			TextItemsResponse textItemsResponse = gson.fromJson(strJSON,
					TextItemsResponse.class);

			return textItemsResponse.getTextItems().getList().size();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// / Gets TextFormat of a particular Fragment
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="fragmentNumber"></param>
	// / <returns></returns>
	public TextFormat getTextFormat(int pageNumber, int fragmentNumber) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/fragments/"
					+ Integer.toString(fragmentNumber) + "/textformat";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			;

			// Parse and Deserialize the JSON to a object.
			TextFormatResponse textformatResponse = gson.fromJson(strJSON,
					TextFormatResponse.class);

			return textformatResponse.getTextFormat();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Gets TextFormat of a particular Segment
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="fragmentNumber"></param>
	// / <param name="segmentNumber"></param>
	// / <returns></returns>
	public TextFormat getTextFormat(int pageNumber, int fragmentNumber,
			int segmentNumber) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/fragments/"
					+ Integer.toString(fragmentNumber) + "/segments/"
					+ Integer.toString(segmentNumber) + "/textformat";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			;

			// Parse and Deserialize the JSON to a object.
			TextFormatResponse textformatResponse = gson.fromJson(strJSON,
					TextFormatResponse.class);
			return textformatResponse.getTextFormat();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Replace Text in a PDF Document
	// / </summary>
	// / <param name="oldText"></param>
	// / <param name="newText"></param>
	// / <param name="isRegularExpression"></param>
	// / <returns>Number of Matches</returns>
	public int replaceText(String oldText, String newText,
			boolean isRegularExpression) {
		try {
			// build URI to get replace text
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/replaceText";
			String signedURI = Utils.sign(strURI);

			// serialize the JSON request content
			TextReplace replaceText = new TextReplace();
			replaceText.setOldValue(oldText);
			replaceText.setNewValue(newText);
			if (isRegularExpression)
				replaceText.setRegex("true");
			else
				replaceText.setRegex("false");

			String strJSON = gson.toJson(replaceText, TextReplace.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			// further process JSON response
			String strResponse = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			ReplaceTextResponse replaceTextResponse = gson.fromJson(
					strResponse, ReplaceTextResponse.class);

			if (replaceTextResponse.getCode().equals("200")
					&& replaceTextResponse.getStatus().equals("OK"))
				return replaceTextResponse.getMatches();
			else
				return 0;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return 0;
		}

	}

	// / <summary>
	// / Replace Text in Particular Page of PDF Document
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="oldText"></param>
	// / <param name="newText"></param>
	// / <param name="isRegularExpression"></param>
	// / <returns>Number of Matches</returns>
	public int replaceText(int pageNumber, String oldText, String newText,
			boolean isRegularExpression) {
		try {
			// build URI to get replace text
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + pageNumber + "/replaceText";
			String signedURI = Utils.sign(strURI);

			// serialize the JSON request content
			TextReplace replaceText = new TextReplace();
			replaceText.setOldValue(oldText);
			replaceText.setNewValue(newText);
			if (isRegularExpression)
				replaceText.setRegex("true");
			else
				replaceText.setRegex("false");

			String strJSON = gson.toJson(replaceText, TextReplace.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			// further process JSON response
			String strResponse = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			ReplaceTextResponse replaceTextResponse = gson.fromJson(
					strResponse, ReplaceTextResponse.class);

			if (replaceTextResponse.getCode().equals("200")
					&& replaceTextResponse.getStatus().equals("OK"))
				return replaceTextResponse.getMatches();
			else
				return 0;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return 0;
		}
	}

}
