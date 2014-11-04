package com.aspose.cloud.sdk.test.cells;

import com.aspose.cloud.sdk.cells.Text;
import com.aspose.cloud.sdk.cells.TextItemsResponse.TextItemsData;

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
	
	public void testFindTextInAWorkbook() throws Exception {
		TextItemsData textItems = Text.findTextInAWorkbook("myworkbook.xlsx", "According");
		assertNotNull("Failed to find text in a workbook", textItems);
	}
	
	public void testFindTextInAWorksheet() throws Exception {
		TextItemsData textItems = Text.findTextInAWorksheet("myworkbook.xlsx", "Sheet1", "According");
		assertNotNull("Failed to find text in a worksheet", textItems);
	}
	
	public void testGetTextItemsFromAWorkbook() throws Exception {
		TextItemsData textItems = Text.getTextItemsFromAWorkbook("myworkbook.xlsx");
		assertNotNull("Failed to get text items from a workbook", textItems);
	}
	
	public void testGetTextItemsFromAWorksheet() throws Exception {
		TextItemsData textItems = Text.getTextItemsFromAWorksheet("myworkbook.xlsx", "Sheet1");
		assertNotNull("Failed to get text items from a worksheet", textItems);
	}
	
	public void testReplaceTextInAWorkbook() throws Exception {
		int matchesCount = Text.replaceTextInAWorkbook("myworkbook.xlsx", "According", "accordance");
		assertEquals("Failed to replace text in a workbook", true, matchesCount >= 0);
	}
	
	public void testReplaceTextInAWorksheet() throws Exception {
		int matchesCount = Text.replaceTextInAWorksheet("myworkbook.xlsx", "Sheet1", "According", "accordance");
		assertEquals("Failed to replace text in a worksheet", true, matchesCount >= 0);
	}
}
