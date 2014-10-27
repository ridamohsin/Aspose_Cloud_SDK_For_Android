package com.aspose.cloud.sdk.pdf;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class PdfLinksResponse extends BaseResponse {
	@SerializedName("Links")
	public PdfLinksResult links;
	
	public class PdfLinksResult {
		public ArrayList<LinkModel> Links;
        public ArrayList<LinkDetails> List;
	}
}
