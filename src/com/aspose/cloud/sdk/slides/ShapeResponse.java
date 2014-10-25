package com.aspose.cloud.sdk.slides;

import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class ShapeResponse extends BaseResponse {
	@SerializedName("Shape")
	public ShapeData shape;
	
	public class ShapeData {
		public String AlternativeText;
		public float Height;
		public boolean Hidden;
		public String Name;
		public float Width;
		public float X;
		public float Y;
		public List<LinkModel> Shapes;
		public ShapeURI FillFormat;
		public ShapeURI LineFormat; 
		public String ShapeType;
	}
	
	public class ShapeURI {
		LinkModel Uri;
	}
}
