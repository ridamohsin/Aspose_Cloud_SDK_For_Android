package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.Bookmark;
import com.aspose.cloud.sdk.words.GetASpecificBookmarkResponse.BookmarkEnvelop;
import com.aspose.cloud.sdk.words.GetBookmarkResponse.BookmarksEnvelop;

import junit.framework.TestCase;

public class BookmarkTest extends TestCase {

	public BookmarkTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetAllBookmarksFromAWordDocument() throws Exception {
		
		BookmarksEnvelop bookmarks = Bookmark.getAllBookmarksFromAWordDocument("TestMainAppendTemplate.doc");
		assertNotNull("Failed to get all bookmarks from a Word document", bookmarks);
	}

	public void testGetASpecificBookmarkFromAWord() throws Exception {
		
		BookmarkEnvelop bookmark = Bookmark.getASpecificBookmarkFromAWord("TestMainAppendTemplate.doc", "FirstBookmark");
		assertNotNull("Failed to get a specific bookmark from a Word document", bookmark);
	}
	
	public void testUpdateBookmarkTextOfAWordDocument() throws Exception {
		
		BookmarkEnvelop bookmark = Bookmark.updateBookmarkTextOfAWordDocument("TestMainAppendTemplate.doc", "FirstBookmark", "this is updated text");
		assertNotNull("Failed to update bookmark text of a Word document", bookmark);
		
	}
}
