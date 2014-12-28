package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.Hyperlink;
import com.aspose.cloud.sdk.words.GetAllHyperlinksResponse.HypelinkData;
import com.aspose.cloud.sdk.words.GetSpecificHyperlinkResponse.HyperlinkDetail;

import junit.framework.TestCase;

public class HyperlinkTestCase extends TestCase {

	public HyperlinkTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetAllHyperlinksFromAWordDocument() throws Exception {
		HypelinkData hyperlinks = Hyperlink.getAllHyperlinksFromAWordDocument("myworddocument.docx");
		assertNotNull("Failed to get all hyperlinks from a Word document", hyperlinks);
	}
	
	public void testGetAParticularHyperlinkFromAWordDocument() throws Exception {
		HyperlinkDetail hyperlink = Hyperlink.getAParticularHyperlinkFromAWordDocument("myworddocument.docx", 1);
		assertNotNull("Failed to get a particular hyperlink from a Word document", hyperlink);
	}
}
