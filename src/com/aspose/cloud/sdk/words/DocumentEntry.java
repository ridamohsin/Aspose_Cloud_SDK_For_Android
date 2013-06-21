package com.aspose.cloud.sdk.words;

public class DocumentEntry {
	public DocumentEntry() {
	}

	public DocumentEntry(String href, String importFormatMode) {
		setHref(href);
		setImportFormatMode(importFormatMode);
	}

	private String Href;

	public final String getHref() {
		return Href;
	}

	public final void setHref(String value) {
		Href = value;
	}

	private String ImportFormatMode;

	public final String getImportFormatMode() {
		return ImportFormatMode;
	}

	public final void setImportFormatMode(String value) {
		ImportFormatMode = value;
	}
}
