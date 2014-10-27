package com.aspose.cloud.sdk.pdf;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class TextFormatResponse extends BaseResponse {
	@SerializedName("TextFormat")
	public TextFormat textFormat;
	
	public class TextFormat {
		public ColorModel Color;
		public int FontSize;
		public String FontName;
		public ArrayList<LinkModel> Links;
	}
}
