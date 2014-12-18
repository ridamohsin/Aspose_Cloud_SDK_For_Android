package com.aspose.cloud.sdk.test.words;

import java.io.File;
import java.io.InputStream;

import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;
import com.aspose.cloud.sdk.words.Converter;
import com.aspose.cloud.sdk.words.ValidFormatsEnum;
import com.aspose.cloud.sdk.words.ConvertWordDocumentToAnyFormatWithAdditionalSettingsResponse.SaveResult;

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
		String filePath = Converter.convertWordDocumentToFormat("myworddocument.docx", ValidFormatsEnum.pdf);
		File file = new File(filePath);
		assertEquals("Failed to convert word document to designated format", true, file.exists());
	}
	
	public void testLocallyStoredWordDocumentConversionToFormat() throws Exception {
		String filePath = Converter.convertLocallyStoredWordDocumentToFormat("/storage/emulated/0/AsposeFiles/myworddocument.docx", ValidFormatsEnum.pdf);
		File file = new File(filePath);
		assertEquals("Failed to convert locally stored word document to designated format", true, file.exists());
	}
	
	public void testWordDocumentConversionToFormatWithAdditionalSettings() throws Exception {
		String xmlData = "<RtfSaveOptions>" +
							"<SaveFormat>rtf</SaveFormat>" +
							"<FileName>TestSaveAs.rtf</FileName>" +
							"<ExportImagesForOldReaders>false</ExportImagesForOldReaders>" +
						 "</RtfSaveOptions>";
		SaveResult saveResult = Converter.convertWordDocumentToFormatWithAdditionalSettings("myworddocument.docx", xmlData);
		assertNotNull("Failed to convert word document to designated format with additional settings", saveResult);
		
		//Get converted file from Aspose server
		InputStream responseStream = Folder.getFile(saveResult.destDocument.href);
		//Save file on Disk
		String filePath = Utils.saveStreamToFile(responseStream, saveResult.destDocument.href);
		File file = new File(filePath);
		assertEquals("Failed to save convert word document to disk", true, file.exists());
	}
}
