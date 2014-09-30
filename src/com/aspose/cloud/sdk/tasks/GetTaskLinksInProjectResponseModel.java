package com.aspose.cloud.sdk.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class GetTaskLinksInProjectResponseModel  extends BaseResponse {
	
	@SerializedName("TaskLinks")
	public ArrayList<TaskLinksModel> taskLinksArray;
}
