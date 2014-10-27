package com.aspose.cloud.sdk.pdf;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class AttachmentsResponse extends BaseResponse{
	@SerializedName("Attachments")
	public AttachmentsResult attachments;
	
	public class AttachmentsResult {
		public ArrayList<LinkModel> Links;
        public ArrayList<AttachmentDetails> List;
	}
}
