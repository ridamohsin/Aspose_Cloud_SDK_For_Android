package com.aspose.cloud.sdk.slides;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class PowerPointSlideBackgroundResponse extends BaseResponse {
	@SerializedName("Background")
	BackgroundResult background;
	
	public class BackgroundResult {
		public String Type;
		public LinkModel SelfUri;
		public ArrayList<LinkModel> AlternateLinks;
		public ArrayList<LinkModel> Links;
	}
}
