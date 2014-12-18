package com.aspose.cloud.sdk.words;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class ConvertWordDocumentToAnyFormatWithAdditionalSettingsResponse extends BaseResponse {
	
	@SerializedName("SaveResult")
	public SaveResult saveResult;
	
	public class SaveResult {
		@SerializedName("SourceDocument")
		public LinkModel sourceDocument;
		@SerializedName("DestDocument")
		public LinkModel destDocument;
	}
}
