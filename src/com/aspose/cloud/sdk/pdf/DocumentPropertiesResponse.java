package com.aspose.cloud.sdk.pdf;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class DocumentPropertiesResponse extends BaseResponse {
	@SerializedName("DocumentProperties")
	public DocumentPropertiesResult documentProperties;
	
	public class DocumentPropertiesResult {
        public ArrayList<DocumentPropertyModel> List;
	}

}
