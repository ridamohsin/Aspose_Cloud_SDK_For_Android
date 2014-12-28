package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.ReplaceTextResponse;
import com.aspose.cloud.sdk.words.Text;
import com.aspose.cloud.sdk.words.GetTextItemsResponse.TextItem;

import junit.framework.TestCase;

public class TextTestCase extends TestCase {

	public TextTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetTextItemsFromAWordDocument() throws Exception {
		TextItem textItems = Text.getTextItemsFromAWordDocument("myworddocument.docx");
		assertNotNull("Failed to get text items from a Word document", textItems);
	}
	
	public void testReplaceTextInAWordDocument() throws Exception {
		ReplaceTextResponse replaceTextResponse = Text.replaceTextInAWordDocument("myworddocument.docx", "Concepts" , "theory", false, true);
		assertNotNull("Failed to replace text in a Word document", replaceTextResponse);
	}
}
