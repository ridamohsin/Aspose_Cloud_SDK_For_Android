package com.aspose.cloud.sdk.slides;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class SlideCommentsResponse extends BaseResponse {
	@SerializedName("SlideComments")
	SlideComments slideComments;
	
	public class SlideComments {
		ArrayList<LinkModel> _links;
		ArrayList<LinkModel> List;
	}
}
