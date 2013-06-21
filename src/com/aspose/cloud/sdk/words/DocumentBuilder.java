package com.aspose.cloud.sdk.words;

import java.io.InputStream;


import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Product;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;
import com.google.gson.Gson;

public class DocumentBuilder {
	public class WatermarkText {
		public String Text;
		public double RotationAngle;
	}

	public class WatermarkImage {
		public String ImageFile;
		public double RotationAngle;
	}

	public class ReplaceText {
		public String OldValue;
		public String NewValue;
		public boolean IsMatchCase;
		public boolean IsMatchWholeWord;
	}

	// / <summary>
	// / insert water mark text into the document
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="text"></param>
	// / <param name="rotationAngle"></param>
	// / <returns></returns>
	public Boolean insertWatermarkText(String FileName, String text,
			double rotationAngle) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/insertWatermarkText";

			String signedURI = Utils.sign(strURI);

			// serialize the JSON request content
			WatermarkText watermark = new WatermarkText();
			watermark.Text = text;
			watermark.RotationAngle = rotationAngle;

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(watermark, WatermarkText.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / insert image water mark into the document
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="imageFile"></param>
	// / <param name="rotationAngle"></param>
	// / <returns></returns>
	public Boolean insertWatermarkImage(String FileName, String imageFile,
			double rotationAngle) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/insertWatermarkImage?imageFile=";
			strURI += imageFile + "&rotationAngle=" + rotationAngle;

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Replace a text with new value into the document
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="OldValue"></param>
	// / <param name="NewValue"></param>
	// / <param name="IsMatchCase"></param>
	// / <param name="IsMatchWholeWord"></param>
	// / <param name="output"></param>
	// / <returns></returns>
	public boolean replaceText(String FileName, String OldValue,
			String NewValue, boolean IsMatchCase, boolean IsMatchWholeWord,
			String output) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/replaceText";

			String signedURI = Utils.sign(strURI);

			// serialize the JSON request content
			ReplaceText repacetext = new ReplaceText();
			repacetext.OldValue = OldValue;
			repacetext.NewValue = NewValue;
			repacetext.IsMatchCase = IsMatchCase;
			repacetext.IsMatchWholeWord = IsMatchWholeWord;

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(repacetext, ReplaceText.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			ReplaceTextResponse baseResponse = gson.fromJson(strResponse,
					ReplaceTextResponse.class);

			// sign URI
			signedURI = Utils.sign(baseResponse.DocumentLink.Href
					+ "?format=doc");

			// get response stream
			responseStream = Utils.processCommand(signedURI, "GET");

			boolean response = Folder.saveStreamToFile(output, responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}