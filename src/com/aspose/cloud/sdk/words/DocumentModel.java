package com.aspose.cloud.sdk.words;

import com.google.gson.annotations.SerializedName;

public class DocumentModel {
	@SerializedName("FileName")
	public String fileName;
	@SerializedName("SourceFormat")
    public int sourceFormat;
	@SerializedName("IsEncrypted")
	public boolean isEncrypted;
	@SerializedName("IsSigned")
	public boolean isSigned;
}
