package com.aspose.cloud.sdk.slides;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class SlidesResponse extends BaseResponse {
	
	@SerializedName("Slides")
	public SlidesResult slides;
	
	public class SlidesResult {
		@SerializedName("SlideList")
		public ArrayList<SlidesModel> slideList;
		@SerializedName("SelfUri")
		public LinkModel selfUri;
		@SerializedName("AlternateLinks")
		public ArrayList<LinkModel> alternateLinks;
		@SerializedName("Links")
		public ArrayList<LinkModel> links;
	}
	
	public class SlidesModel {
		public LinkModel Uri;
	}
	
}
