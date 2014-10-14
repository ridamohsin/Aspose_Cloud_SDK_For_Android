package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.ReplaceTextResponse;
import com.aspose.cloud.sdk.words.Text;
import com.aspose.cloud.sdk.words.GetTextItemsResponse.TextItem;

import junit.framework.TestCase;

public class TextTest extends TestCase {

	public TextTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetTextItemsFromAWordDocument() throws Exception {
		TextItem textItems = Text.getTextItemsFromAWordDocument("TestMainAppendTemplate.doc");
		assertNotNull("Failed to get text items from a Word document", textItems);
	}
	
	public void testReplaceTextInAWordDocument() throws Exception {
		ReplaceTextResponse replaceTextResponse = Text.replaceTextInAWordDocument("TestMainAppendTemplate.doc", "other" , "mine", false, true);
		assertNotNull("Failed to replace text in a Word document", replaceTextResponse);
	}
}
