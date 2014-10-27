package com.aspose.cloud.sdk.test.pdf;

import com.aspose.cloud.sdk.pdf.BookmarkDetails;
import com.aspose.cloud.sdk.pdf.BookmarksResponse.BookmarksResult;
import com.aspose.cloud.sdk.pdf.Bookmarks;

import junit.framework.TestCase;

public class BookmarksTest extends TestCase {

	public BookmarksTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetAllBookmarksFromAPDF() throws Exception {
		BookmarksResult bookmarks = Bookmarks.getAllBookmarksFromAPDF("Bitcoin.pdf");
		assertNotNull("Failed to get all bookmarks from a PDF", bookmarks);
	}

	public void testGetBookmarkCountFromAPDF() throws Exception {
		int bookmarkCount = Bookmarks.getBookmarkCountFromAPDF("Bitcoin.pdf");
		assertEquals("Failed to get bookmarks count from a PDF", true, bookmarkCount>=0);
	}
	
	public void testGetASpecificBookmarkFromAPDF() throws Exception {
		BookmarkDetails bookmark = Bookmarks.getASpecificBookmarkFromAPDF("Bitcoin.pdf", 1);
		assertNotNull("Failed to get a specific bookmark from a PDF", bookmark);
	}

}
