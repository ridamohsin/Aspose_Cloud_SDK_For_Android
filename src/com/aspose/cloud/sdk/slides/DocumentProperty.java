/**
 * 
 */
package com.aspose.cloud.sdk.slides;

// / <summary>
// / represents a single property of the document
// / </summary>
public class DocumentProperty {
	public DocumentProperty() {
	}

	// public List<LinkResponse> Links;
	private boolean BuiltIn;
	private String Name;
	private String Value;

	public boolean getIsBuiltIn() {
		return BuiltIn;
	}

	public String getName() {
		return Name;
	}

	public String getValue() {
		return Value;
	}

	public void setIsBuiltIn(boolean temBuiltIn) {
		BuiltIn = temBuiltIn;
	}

	public void setName(String temName) {
		Name = temName;
	}

	public void setValue(String temValue) {
		Value = temValue;
	}

}