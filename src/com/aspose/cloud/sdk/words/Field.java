package com.aspose.cloud.sdk.words;

import java.io.InputStream;
import java.util.List;


import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Product;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

public class Field {
	public String format;
	public String alignment;
	public boolean isTop;
	public boolean setPageNumberOnFirstPage;

	// / <summary>
	// / insert page number filed into the document
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="alignment"></param>
	// / <param name="format"></param>
	// / <param name="isTop"></param>
	// / <param name="SetPageNumberOnFirstPage"></param>

	public Boolean insertPageNumber(String FileName, String alignment,
			String format, Boolean isTop, Boolean SetPageNumberOnFirstPage) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/insertPageNumbers";

			String signedURI = Utils.sign(strURI);

			// serialize the JSON request content
			Field field = new Field();
			field.alignment = alignment;
			field.format = format;
			field.isTop = isTop;
			field.setPageNumberOnFirstPage = SetPageNumberOnFirstPage;

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(field, Field.class);

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
	// / Gets all merge filed names from document
	// / </summary>
	// / <param name="FileName"></param>
	public List<String> getMailMergeFieldNames(String FileName) {
		try {
			// check whether file is set or not
			if (FileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = Product.getBaseProductUri() + "/words/" + FileName;
			strURI += "/mailMergeFieldNames";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			
			Gson gson = new Gson();

			MergeFieldResponse Response = gson.fromJson(strJSON,
					MergeFieldResponse.class);

			// return document property
			return Response.FieldNames.Names;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}