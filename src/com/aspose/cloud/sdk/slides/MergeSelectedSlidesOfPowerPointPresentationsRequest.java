package com.aspose.cloud.sdk.slides;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class MergeSelectedSlidesOfPowerPointPresentationsRequest {
	@SerializedName("Presentations")
	public ArrayList<PathAndSlides> presentations = new ArrayList<PathAndSlides>();
	
	public class PathAndSlides {
		@SerializedName("Path")
		public String path;
		@SerializedName("Slides")
		public ArrayList<Integer> slides = new ArrayList<Integer>();
	}
}
