package com.aspose.cloud.sdk.pdf;

import com.aspose.cloud.sdk.common.BaseResponse;

/** 
represents response of a single text item
*/
public class ReplaceTextResponse extends BaseResponse
{
	private java.util.ArrayList<LinkResponse> Links;
	private int Matches;
	
	public final java.util.ArrayList<LinkResponse> getLinks(){ return Links; }
	public final int getMatches(){ return Matches; }
	
	public final void setLinks(java.util.ArrayList<LinkResponse> value){ Links = value; }
	public final void setMatches(int value){ Matches = value; }
}
