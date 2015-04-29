package com.aspose.cloud.sdk.email.model;

import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class EmailProperty {
	@SerializedName("Name")
	public String name;
	@SerializedName("Value")
	public Object value;
    @SerializedName("Link")
    public LinkModel link;
}
