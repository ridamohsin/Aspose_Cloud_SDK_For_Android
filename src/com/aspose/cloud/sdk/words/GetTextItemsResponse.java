package com.aspose.cloud.sdk.words;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class GetTextItemsResponse extends BaseResponse {
	@SerializedName("TextItems")
	public TextItem textItems;
	
	public class TextItem {
		@SerializedName("List")
		ArrayList<TextAndLink> textAndLinksList;
		public LinkModel link;
	}
	
	public class TextAndLink {
		public String text;
		public LinkModel link;
	}
}
