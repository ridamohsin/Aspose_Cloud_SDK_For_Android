package com.aspose.cloud.sdk.words;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class GetProtectionOfTheWordDocumentResponse extends BaseResponse {
	
	@SerializedName("ProtectionData")
	ProtectionData protectionData;
	
	@SerializedName("DocumentLink")
	LinkModel documentLink;
	
	public class ProtectionData {
		@SerializedName("ProtectionType")
		ProtectionTypeEnum protectionType;
	}
}
