package com.aspose.cloud.sdk.ocr;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;


// / <summary>
// / Class to extract text from images.
// / 1. Image from Aspose server.
// / </summary>
public class Extractor {
	// / <summary>
	// / Default constructor
	// / </summary>
	public Extractor() {
		this.gson = new Gson();

	}

	static final Logger logger = Logger.getLogger(Extractor.class);
	Gson gson = null;

	// / <summary>
	// / Extract image text using default settings.
	// / </summary>
	// / <param name="fileName">The image file name.</param>
	// / <param name="folder">The image file folder.</param>
	// / <returns><see cref="OCRResponse"/> with the operation result.</returns>
	public OCRResponse extractText(String imageFileName, String folder) {
		try {
			// build URI to extract text
			String strURI = "";
			if (IsNullOrEmpty(folder))
				strURI = AsposeApp.BASE_PRODUCT_URI + "/ocr/" + imageFileName
						+ "/recognize";
			else
				strURI = AsposeApp.BASE_PRODUCT_URI + "/ocr/" + imageFileName
						+ "/recognize?folder=" + folder;

			// sign URI
			String signedURI = Utils.sign(strURI);

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Extract image text using specific language.
	// / </summary>
	// / <param name="fileName">The image file name.</param>
	// / <param name="language">The language.</param>
	// / <param name="useDefaultDictionaries">Use default dictionaries or
	// not.</param>
	// / <param name="folder">The image folder.</param>
	// / <returns><see cref="OCRResponse"/> with the operation result.</returns>
	public OCRResponse extractText(String imageFileName, LanguageName language,
			boolean useDefaultDictionaries, String folder) {
		try {

			// build URI to extract text
			String strURI = "";
			if (IsNullOrEmpty(folder))
				strURI = AsposeApp.BASE_PRODUCT_URI + "/ocr/" + imageFileName
						+ "/recognize?language=" + language
						+ "&useDefaultDictionaries=" + useDefaultDictionaries;
			else
				strURI = AsposeApp.BASE_PRODUCT_URI + "/ocr/" + imageFileName
						+ "/recognize?language=" + language
						+ "&useDefaultDictionaries=" + useDefaultDictionaries
						+ "&folder=" + folder;

			// sign URI
			String signedURI = Utils.sign(strURI);

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Extract image text from local file.
	// / </summary>
	// / <param name="localFile">The local file.</param>
	// / <param name="language">The text language.</param>
	// / <param name="useDefaultDictionaries">Use default dictionaries or
	// not.</param>
	// / <returns><see cref="OCRResponse"/> with the operation result.</returns>
	public OCRResponse extractText(String localFile, LanguageName language,
			boolean useDefaultDictionaries) {
		try {

			// build URI to extract text
			String strURI = AsposeApp.BASE_PRODUCT_URI
					+ "/ocr/recognize?language=" + language
					+ "&useDefaultDictionaries=" + useDefaultDictionaries;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream fileStream = new FileInputStream(localFile);

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", fileStream);

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Extract image text from stream.
	// / </summary>
	// / <param name="stream">The stream with image data.</param>
	// / <param name="language">Language.</param>
	// / <param name="useDefaultDictionaries">Use default dictionaries or
	// not.</param>
	// / <returns><see cref="OCRResponse"/> with the operation result.</returns>
	public OCRResponse extractText(InputStream stream, LanguageName language,
			boolean useDefaultDictionaries) {
		try {

			// build URI to extract text
			String strURI = AsposeApp.BASE_PRODUCT_URI
					+ "/ocr/recognize?language=" + language
					+ "&useDefaultDictionaries=" + useDefaultDictionaries;

			// sign URI
			String signedURI = Utils.sign(strURI);

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", stream);

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Scans whole or part of images and extracts OCR text
	// / </summary>
	// / <param name="imageFileName">Name of the image file</param>
	public OCRResponse extractText(String imageFileName) {
		try {
			// build URI to extract text
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/ocr/"
					+ imageFileName + "/recognize?useDefaultDictionaries=true";

			// sign URI
			String signedURI = Utils.sign(strURI);

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	// / <summary>
	// / Scans whole or part of images and extracts OCR text
	// / </summary>
	// / <param name="imageFileName">Name of the image file</param>
	// / <param name="language">Language of document to recognize</param>
	// / <param name="useDefaultDictionaries">Allows to correct text after
	// recognition using default dictionaries</param>
	// / <param name="x">Start x of the rectangle: Recognition of text inside
	// specified Rectangle region</param>
	// / <param name="y">Start y of the rectangle: Recognition of text inside
	// specified Rectangle region</param>
	// / <param name="width">Width of the rectangle: Recognition of text inside
	// specified Rectangle region</param>
	// / <param name="height">Height of the rectangle: Recognition of text
	// inside specified Rectangle region</param>
	// / <param name="folder">Folder with images to recognize</param>
	// / <returns></returns>
	public OCRResponse ExtractText(String imageFileName, LanguageName language,
			boolean useDefaultDictionaries, int x, int y, int width,
			int height, String folder) {
		try {
			// build URI to extract text
			String strURI = AsposeApp.BASE_PRODUCT_URI
					+ "/ocr/"
					+ imageFileName
					+ "/recognize?language="
					+ language
					+ ((x >= 0 && y >= 0 && width > 0 && height > 0) ? "&rectX="
							+ x
							+ "&rectY="
							+ y
							+ "&rectWidth="
							+ width
							+ "&rectHeight=" + height
							: "") + "&useDefaultDictionaries="
					+ ((useDefaultDictionaries) ? "true" : "false")
					+ ((IsNullOrEmpty(folder)) ? "" : "&folder=" + folder);

			// sign URI
			String signedURI = Utils.sign(strURI);

			// execute signed URI request and get response
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	// / <summary>
	// / Extract Text from remote image URL.
	// / </summary>
	// / <param name="url">The image url.</param>
	// / <param name="language">The specific language.</param>
	// / <param name="useDefaultDictionaries">Use default dictionaries or
	// not.</param>
	// / <returns><see cref="OCRResponse"/> with the operation result.</returns>
	public OCRResponse ExtractTextFromURL(String url, LanguageName language,
			boolean useDefaultDictionaries) {
		try {

			// build URI to extract text
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/ocr/recognize?url="
					+ url + "&language=" + language
					+ "&useDefaultDictionaries=" + useDefaultDictionaries;

			// sign URI
			String signedURI = Utils.sign(strURI);

			// execute signed URI request and get response
			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			OCRResponse ocrResponse = gson.fromJson(strJSON, OCRResponse.class);

			return ocrResponse;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public static boolean IsNull(String str) {
		return str == null ? true : false;
	}

	public static boolean IsNullOrEmpty(String param) {
		if (IsNull(param) || param.trim().length() == 0) {
			return true;
		}
		return false;
	}

}
