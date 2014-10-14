package com.aspose.cloud.sdk.test.words;

import java.io.File;

import com.aspose.cloud.sdk.words.Converter;
import com.aspose.cloud.sdk.words.ValidFormatsEnum;

import junit.framework.TestCase;

public class ConverterTest extends TestCase {

	public ConverterTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testWordDocumentConversionToFormat() throws Exception {
		String fileName = Converter.convertWordDocumentToFormat("testWordDocument.doc", ValidFormatsEnum.html);
		File file = new File(fileName);
		assertEquals("Failed to convert word document to designated format", true, file.exists());
	}
	
	public void testLocallyStoredWordDocumentConversionToFormat() throws Exception {
		String fileName = Converter.convertLocallyStoredWordDocumentToFormat("/storage/emulated/0/testWordDocument.doc", ValidFormatsEnum.pdf);
		File file = new File(fileName);
		assertEquals("Failed to convert locally stored word document to designated format", true, file.exists());
	}
	
	public void testWordDocumentConversionToFormatWithAdditionalSettings() throws Exception {
		String xmlData = "<PdfSaveOptions>" +
	            			"<SaveFormat>pdf</SaveFormat>" +
	            			"<FileName>Output.pdf</FileName>" +
	            			"<ImageCompression>Jpeg</ImageCompression>" +
	            			"<JpegQuality>70</JpegQuality>" +
	            			"<TextCompression>Flate</TextCompression>" +
	            		 "</PdfSaveOptions>";
		String fileName = Converter.convertWordDocumentToFormatWithAdditionalSettings("testWordDocument.doc", xmlData, 
				"Output.pdf");
		File file = new File(fileName);
		assertEquals("Failed to convert word document to designated format with additional settings", true, file.exists());
	}
}
