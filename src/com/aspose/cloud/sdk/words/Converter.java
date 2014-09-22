package com.aspose.cloud.sdk.words;

import java.io.FileInputStream;
import java.io.InputStream;

import android.util.Log;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;

/// <summary>
/// Class to convert file to different formats
/// </summary>
public class Converter {
	public Converter(String fileName) {

		// set default values
		this.fileName = fileName;

		saveformat = SaveFormat.Doc;
	}

	// / <summary>
	// / get or set Doc file name
	// / </summary>
	public String fileName;

	// / <summary>
	// / get or set the SaveFormat type
	// / </summary>
	public SaveFormat saveformat;
	private static final String TAG = "Converter";

	// / <summary>
	// / convert a document to SaveFormat
	// / </summary>
	// / <param name="output">the location of the output file</param>
	public boolean convert(String output) {
		try {
			// check whether file is set or not
			if (fileName.equals("")) {
				throw new Exception("No file name specified");
			}

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + fileName;
			strURI += "?format=" + saveformat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(output, responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}

	// / <summary>
	// / convert a document to SaveFormat
	// / </summary>
	// / <param name="output">the location of the output file</param>
	// / /// <param name="output">SaveFormat of the output file</param>
	public boolean convert(String output, SaveFormat OutPutType) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + fileName;
			strURI += "?format=" + OutPutType;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(output, responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
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
			String strURI = AsposeApp.BASE_PRODUCT_URI
					+ "/words/convert?format=" + outputFormat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream fileStream = new FileInputStream(inputPath);

			// get response stream
			InputStream responseStream = Utils.processCommand(signedURI, "PUT",
					fileStream);

			Folder.saveStreamToFile(outputPath, responseStream);
			responseStream.close();
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
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
			String strURI = AsposeApp.BASE_PRODUCT_URI
					+ "/words/convert?format=" + outputFormat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			// InputStream ResponseStream;

			// ResponseStream = Utils.ProcessCommand(signedURI, "PUT",
			// inputStream);//, Stream);

			return Utils.processCommand(signedURI, "PUT", inputStream);
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			return null;
		}

	}

}