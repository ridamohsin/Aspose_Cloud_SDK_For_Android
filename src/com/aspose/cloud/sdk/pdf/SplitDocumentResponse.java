package com.aspose.cloud.sdk.pdf;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class SplitDocumentResponse extends BaseResponse {
	@SerializedName("Result")
	public SplitResult result;
	
	public class SplitResult {
		public ArrayList<LinkResponse> Documents;
	}
	
	public class LinkResponse extends LinkModel {
		public int Id;
	}
}
