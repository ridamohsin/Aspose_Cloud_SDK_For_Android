package com.aspose.cloud.sdk.test.words;

import java.util.ArrayList;

import com.aspose.cloud.sdk.words.Document;
import com.aspose.cloud.sdk.words.StatisticsOfDocumentResponse;
import com.aspose.cloud.sdk.words.ValidFormatsEnum;
import com.aspose.cloud.sdk.words.TrackingChangesResponse.TrackChangesResult;

import junit.framework.TestCase;

public class DocumentTest extends TestCase {

	public DocumentTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testAppendDocument() throws Exception {
		//Create the string array to hold document names
	    String[] appendDocs = {"TestAppendTemplate1.doc","TestAppendTemplate2.doc"};
        //Create the string array to hold import format modes
    	String[] importFormatsModes = {"KeepSourceFormatting", "UseDestinationStyles"};
    	boolean response = Document.appendDocument("TestMainAppendTemplate.doc", appendDocs, importFormatsModes, "TempWords");
    	assertEquals("Failed to append a list of word documents", true, response);
	}
	
	public void testSplitAllPagesToNewPDFs() throws Exception {
		ArrayList<String> filePaths = Document.splitAllPagesToNewPDFs("TestMainAppendTemplate.doc");
		assertNotNull("Failed to split all pages to new PDFs", filePaths);
	}
	
	public void testSplitSpecificPagesToFormat() throws Exception {
		ArrayList<String> filePaths = Document.splitSpecificPagesToFormat("TestMainAppendTemplate.doc", ValidFormatsEnum.pdf, 1, 1);
		assertNotNull("Failed to split specific pages to designated format", filePaths);
	}
	
	public void testAcceptAllTrackingChanges() throws Exception {
		TrackChangesResult acceptTrackChangesResult = Document.acceptAllTrackingChanges("TestMainAppendTemplate.doc", "TestAcceptMainAppendTemplate");
		assertNotNull("Failed to accept all tracking changes in the document", acceptTrackChangesResult);
	}
	
	public void testRejectAllTrackingChanges() throws Exception {
		TrackChangesResult rejectTrackChangesResult = Document.rejectAllTrackingChanges("TestMainAppendTemplate.doc", "TestRejectMainAppendTemplate");
		assertNotNull("Failed to reject all tracking changes in the document", rejectTrackChangesResult);
	}
	
	public void testStatisticsOfDocument() throws Exception {
		StatisticsOfDocumentResponse statisticsOfDocument = Document.statisticsOfDocument("TestMainAppendTemplate.doc");
		assertNotNull("Failed to find statistics of the document", statisticsOfDocument);
	}
}
