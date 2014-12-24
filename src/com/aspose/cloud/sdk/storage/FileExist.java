package com.aspose.cloud.sdk.storage;

import com.google.gson.annotations.SerializedName;

public class FileExist {
	@SerializedName("IsExist")
	public boolean isExist; //Indicates whether a file exists or not
	@SerializedName("IsFolder")
	public boolean isFolder; //Indicates whether its a file or folder
}