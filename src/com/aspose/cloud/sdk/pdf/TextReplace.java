package com.aspose.cloud.sdk.pdf;

/** 
represents Text in PDF document
*/
public class TextReplace
{
	public TextReplace(){}
	private String OldValue;
	private String NewValue;
	private String Regex;
	
	public final String getOldValue(){ return OldValue; }
	public final String getNewValue(){ return NewValue; }
	public final String getRegex(){ return Regex; }
	public final void setOldValue(String value){ OldValue = value; }
	public final void setNewValue(String value){ NewValue = value; }
	public final void setRegex(String value){ Regex = value; }
}
