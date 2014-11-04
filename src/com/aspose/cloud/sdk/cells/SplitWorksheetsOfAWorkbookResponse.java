package com.aspose.cloud.sdk.cells;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class SplitWorksheetsOfAWorkbookResponse extends BaseResponse {
	@SerializedName("Result")
	public SplitWorksheetsOfAWorkbookResult result;
	
	public class SplitWorksheetsOfAWorkbookResult {
		@SerializedName("Documents")
		ArrayList<DocumentLink> documents;
	}
	
	public class DocumentLink {
		@SerializedName("Id")
		int id;
		LinkModel link;
	}
}
