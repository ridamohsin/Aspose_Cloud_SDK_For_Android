package com.aspose.cloud.sdk.pdf;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class TextItemsResponse extends BaseResponse {
	@SerializedName("TextItems")
	public TextItems textItems;
	
	public class TextItems {
		public ArrayList<TextItemDetails> List;
		public ArrayList<LinkModel> Links;
	}
	
	public class TextItemDetails {
		public String Text;
		public ArrayList<LinkModel> Links;
	}
}
