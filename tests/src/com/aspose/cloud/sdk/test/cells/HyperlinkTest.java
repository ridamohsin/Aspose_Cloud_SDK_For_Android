package com.aspose.cloud.sdk.test.cells;

import com.aspose.cloud.sdk.cells.Hyperlink;
import com.aspose.cloud.sdk.cells.HyperlinkResponse;
import com.aspose.cloud.sdk.cells.HyperlinkResponse.CellArea;
import com.aspose.cloud.sdk.cells.HyperlinkResponse.HyperlinkData;

import junit.framework.TestCase;

public class HyperlinkTest extends TestCase {

	private Hyperlink hyperlink;
	
	public HyperlinkTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		hyperlink = new Hyperlink("myworkbook.xlsx", "Sheet1");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetHyperlinkFromExcelWorksheet() throws Exception {
		HyperlinkData hyperlinkData = hyperlink.getHyperlinkFromExcelWorksheet(0);
		assertNotNull("Failed to get hyperlink from excel worksheet", hyperlinkData);
	}
	
	public void testAddHyperlinksToExcelWorksheet() throws Exception {
		HyperlinkData hyperlinkData = hyperlink.addHyperlinksToExcelWorksheet(3, 0, 1, 2, "www.banckle.com");
		assertNotNull("Failed to add hyperlinks to excel worksheet", hyperlinkData);
	}
	
	public void testUpdateHyperlinksInExcelWorksheet() throws Exception {
		
		HyperlinkResponse hyperlinkRequest = new HyperlinkResponse();
		HyperlinkData hyperlinkRequestData = hyperlinkRequest.new HyperlinkData();
		hyperlinkRequest.hyperlink = hyperlinkRequestData;
		
		hyperlinkRequestData.Address = "http://www.aspose.com/";
		hyperlinkRequestData.ScreenTip = "Hello World";
		hyperlinkRequestData.TextToDisplay = "Welcome to Aspose";
		
		CellArea cellArea = hyperlinkRequest.new CellArea();
		cellArea.StartRow = 1;
		cellArea.EndRow = 1;
		cellArea.StartColumn = 1;
		cellArea.EndColumn = 3;
		hyperlinkRequestData.Area = cellArea;
		
		HyperlinkData hyperlinkData = hyperlink.updateHyperlinksInExcelWorksheet(0, hyperlinkRequest);
		assertNotNull("Failed to update hyperlinks in excel worksheet", hyperlinkData);
	}
	
	public void testDeleteAllHyperlinksFromExcelWorksheet() throws Exception {
		boolean isAllHyperlinksDeletedSuccessfully = hyperlink.deleteAllHyperlinksFromExcelWorksheet();
		assertEquals("Failed to delete all hyperlinks from excel worksheet", true, isAllHyperlinksDeletedSuccessfully);
	}
	
	public void testDeleteASpecificHyperlinkFromExcelWorksheet() throws Exception {
		boolean isAHyperlinkDeletedSuccessfully = hyperlink.deleteASpecificHyperlinkFromExcelWorksheet(0);
		assertEquals("Failed to delete a specifi hyperlink from excel worksheet", true, isAHyperlinkDeletedSuccessfully);
	}
}
