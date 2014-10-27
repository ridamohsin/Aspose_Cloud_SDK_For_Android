package com.aspose.cloud.sdk.pdf;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class FormFieldResponse extends BaseResponse {
	@SerializedName("Field")
	public FieldResult field;
	
	public class FieldResult {
		public String Name;
		public int Type;
		public ArrayList<LinkModel> Links;
		public ArrayList<String> Values;
	}
}
