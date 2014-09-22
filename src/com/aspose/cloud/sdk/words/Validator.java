package com.aspose.cloud.sdk.words;

import android.util.Log;

import com.aspose.cloud.sdk.common.AsposeApp;

/// <summary>
/// Performs any validation related tasks
/// </summary>
public class Validator {
	public Validator(String fileName) {
		// set default values
		FileName = fileName;
	}
	private static final String TAG = "Validator";
	// / <summary>
	// / get or set file name
	// / </summary>
	public String FileName;

	// / <summary>
	// / Performs input validation on the client end or local server
	// / </summary>
	public static void LocalValidation() {
		try {
			// Throws exception if product server is not specified
			if (AsposeApp.BASE_PRODUCT_URI + "/words/" == null
					|| (AsposeApp.BASE_PRODUCT_URI + "/words/").length() == 0)
				throw new Exception(
						"App Server is not specified. Please set Server property.");

			// Throw exception if App Key is empty
			if (AsposeApp.APP_KEY == null
					|| AsposeApp.APP_KEY.length() == 0)
				throw new Exception(
						"App Key is not specified. Please set the App Key property.");

			// Throw exception if App SID is empty
			if (AsposeApp.APP_SID == null
					|| AsposeApp.APP_SID.length() == 0)
				throw new Exception(
						"App SID is not specified. Please set App SID property.");
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
		}
	}

	/*
	 * public Boolean validateFile() {
	 * 
	 * if (Path.GetExtension(FileName).ToLower() == "." +
	 * SaveFormat.Doc.ToString().ToLower() ||
	 * Path.GetExtension(FileName).ToLower() == "." +
	 * SaveFormat.Docx.ToString().ToLower()) return true; else return false; }
	 */
}