package com.aspose.cloud.sdk.pdf;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class AnnotationsResponse extends BaseResponse {
	@SerializedName("Annotations")
	public AnnotationsResult annotations;
	
	public class AnnotationsResult {
		public ArrayList<LinkModel> Links;
        public ArrayList<AnnotationDetails> List;
	}
}
