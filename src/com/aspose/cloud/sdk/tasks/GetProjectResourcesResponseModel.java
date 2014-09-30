package com.aspose.cloud.sdk.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class GetProjectResourcesResponseModel extends BaseResponse {
	@SerializedName("Resources")
	public Resources resources;
	
	public class Resources {
		@SerializedName("ResourceItem")
		public ArrayList<ResourceItemModel> resourceItemsArray;
	}
}
