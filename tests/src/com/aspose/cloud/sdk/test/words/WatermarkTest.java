package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.Watermark;
import com.aspose.cloud.sdk.words.DocumentResponse.Document;

import junit.framework.TestCase;

public class WatermarkTest extends TestCase {

	public WatermarkTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAddWatermarkTextToAWordDocument() throws Exception {
		Document document = Watermark.addWatermarkTextToAWordDocument("testDocument.docx", "Watermark text", 45.0);
		assertNotNull("Failed to add watermark text to a Word document", document);
	}
	
	public void testAddWatermarkImageToAWordDocument() throws Exception {
		Document document = Watermark.addWatermarkImageToAWordDocument("testDocument.docx", "bookmark.png", -60.0);
		assertNotNull("Failed to add watermark text to a Word document", document);
	}
	
	public void testRemoveWatermarkFromAWordDocument() throws Exception {
		Document document = Watermark.removeWatermarkFromAWordDocument("testDocument.docx");
		assertNotNull("Failed to remove watermark from a Word Document", document);
	}
}
