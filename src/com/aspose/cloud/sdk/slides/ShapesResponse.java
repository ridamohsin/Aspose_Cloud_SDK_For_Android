package com.aspose.cloud.sdk.slides;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class ShapesResponse extends BaseResponse {
	
	@SerializedName("ShapeList")
	public ShapeList shapeList;
	
	public class ShapeList {
		ArrayList<LinkModel> _links;
		ArrayList<ShapeURI> ShapesLinks;
	}
	
	public class ShapeURI {
		LinkModel Uri;
	}
}
