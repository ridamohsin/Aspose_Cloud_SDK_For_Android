package com.aspose.cloud.sdk.words;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class GetSpecificSectionResponse extends BaseResponse {
	@SerializedName("Section")
	SectionDetails section;
	
	public class SectionDetails {
		@SerializedName("Paragraphs")
		Link paragraphs;
		@SerializedName("PageSetup")
		Link pageSetup;
	}
	
	public class Link {
		LinkModel link;
	}
}
