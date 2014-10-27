package com.aspose.cloud.sdk.pdf;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class BookmarksResponse extends BaseResponse {
	
	@SerializedName("Bookmarks")
	public BookmarksResult bookmarks;
	
	public class BookmarksResult {
		public ArrayList<LinkModel> Links;
        public ArrayList<BookmarkDetails> List;
	}
}
