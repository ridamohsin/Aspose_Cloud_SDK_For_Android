package com.aspose.cloud.sdk.words;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class GetSpecificHyperlinkResponse extends BaseResponse {
	
	@SerializedName("Hyperlink")
	HyperlinkDetail hyperlink;
	
	public class HyperlinkDetail {
		@SerializedName("DisplayText")
		public String displayText;
		@SerializedName("Value")
		public String value;
		public LinkModel link;
	}
}
