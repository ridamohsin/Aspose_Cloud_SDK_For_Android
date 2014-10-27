package com.aspose.cloud.sdk.pdf;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class FormFieldsResponse extends BaseResponse {
	@SerializedName("Fields")
	public FieldsResult fields;
	
	public class FieldsResult {
		ArrayList<FieldDetails> List;
		ArrayList<LinkModel> Links;
	}
	
	public class FieldDetails {
		public String Name;
		public int Type;
		public ArrayList<LinkModel> Links;
		public ArrayList<String> Values;
	}
}
