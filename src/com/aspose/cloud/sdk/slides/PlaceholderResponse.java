package com.aspose.cloud.sdk.slides;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class PlaceholderResponse extends BaseResponse {
	@SerializedName("Placeholder")
	PlaceholderResult placeholder;
	
	public class PlaceholderResult {
		int Index;
		int Orientation;
		int Size;
		int Type;
		ShapeUri Shape;
		ArrayList<LinkModel> _links;
	}
	
	public class ShapeUri {
		LinkModel Uri;
	}
}
