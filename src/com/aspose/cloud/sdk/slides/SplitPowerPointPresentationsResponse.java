package com.aspose.cloud.sdk.slides;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class SplitPowerPointPresentationsResponse extends BaseResponse {
	@SerializedName("SplitResult")
	SplitResult splitResult;
	
	public class SplitResult {
		@SerializedName("Slides")
		ArrayList<LinkModel> slides;
		@SerializedName("SelfUri")
		LinkModel selfUri;
	}
}
