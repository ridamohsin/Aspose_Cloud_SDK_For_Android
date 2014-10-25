package com.aspose.cloud.sdk.slides;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class TextItemsResponse extends BaseResponse {
	@SerializedName("TextItems")
	public TextItemsData textItems;
	
	public class TextItemsData {
		public ArrayList<TextAndUri> Items;
		public ArrayList<LinkModel> _links;
	}
	
	public class TextAndUri {
		LinkModel Uri;
		String Text;
	}
}
