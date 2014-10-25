package com.aspose.cloud.sdk.slides;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class ImagesResponse extends BaseResponse {
	@SerializedName("Images")
	public ImagesResult images;
	
	public class ImagesResult {
		public ArrayList<ImageData> List;
		public LinkModel SelfUri;
		public ArrayList<LinkModel> AlternateLinks;
		public ArrayList<LinkModel> Links;
	}
	
	public class ImageData {
		public int Width;
		public int Height;
		public LinkModel SelfUri;
		public ArrayList<LinkModel> AlternateLinks;
		public ArrayList<LinkModel> Links;
	}
}
