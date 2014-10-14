package com.aspose.cloud.sdk.words;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class ReplaceTextResponse extends BaseResponse {
	
	@SerializedName("Matches")
	public int matches;
	@SerializedName("DocumentLink")
	LinkModel documentLink;
	
}
