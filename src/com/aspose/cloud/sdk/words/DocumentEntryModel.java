package com.aspose.cloud.sdk.words;

import com.google.gson.annotations.SerializedName;

public class DocumentEntryModel {
	
	@SerializedName("Href")
	private String href;
	@SerializedName("ImportFormatMode")
	private String importFormatMode;
	
	DocumentEntryModel(String href, String importFormatMode) {
		this.href = href;
		this.importFormatMode = importFormatMode;
	}
}
