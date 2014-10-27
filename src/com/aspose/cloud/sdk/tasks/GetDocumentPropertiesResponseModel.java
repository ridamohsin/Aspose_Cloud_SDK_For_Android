package com.aspose.cloud.sdk.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class GetDocumentPropertiesResponseModel extends BaseResponse{
	@SerializedName("Properties")
	PropertiesList properties;
	
	class PropertiesList {
		@SerializedName("List")
		ArrayList<ProjectPropertyModel> list;
	}
}