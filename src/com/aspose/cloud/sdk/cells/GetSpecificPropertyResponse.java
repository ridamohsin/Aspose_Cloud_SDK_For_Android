package com.aspose.cloud.sdk.cells;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class GetSpecificPropertyResponse extends BaseResponse {
	
	@SerializedName("DocumentProperty")
	DocumentPropertyValue documentProperty;
	
	public class DocumentPropertyValue {
		@SerializedName("Name")
		public String name;
		@SerializedName("Value")
        public String value;
		@SerializedName("BuiltIn")
        public boolean builtIn;
        public LinkModel link;
	}
	
}
