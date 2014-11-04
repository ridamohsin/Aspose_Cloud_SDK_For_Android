package com.aspose.cloud.sdk.test.cells;

import com.aspose.cloud.sdk.cells.Row;
import com.aspose.cloud.sdk.cells.RowResponse.RowData;

import junit.framework.TestCase;

public class RowTest extends TestCase {

	private Row row;
	
	public RowTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		row = new Row("myworkbook.xlsx", "Sheet1");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetRowFromAWorksheet() throws Exception {
		RowData rowData = row.getRowFromAWorksheet(1);
		assertNotNull("Failed to get a row from a worksheet", rowData);
	}
	
	public void testAddAnEmptyRowInAWorksheet() throws Exception {
		RowData rowData = row.addAnEmptyRowInAWorksheet(2);
		assertNotNull("Failed to add an empty row in a worksheet", rowData);
	}
	
	public void testDeleteARowFromAWorksheet() throws Exception {
		boolean isRowDeletedSuccessfully = row.deleteARowFromAWorksheet(2);
		assertNotNull("Failed to delete a row from a worksheet", isRowDeletedSuccessfully);
	}
	
	public void testCopyRowsInAWorksheet() throws Exception {
		boolean isRowsCopiedSuccessfully = row.copyRowsInAWorksheet(1, 6, 2);
		assertNotNull("Failed to copy rows in a worksheet", isRowsCopiedSuccessfully);
	}
	
	public void testHideRowsInAWorksheet() throws Exception {
		boolean isRowsHideSuccessfully = row.hideRowsInAWorksheet(6, 2);
		assertNotNull("Failed to hide rows in a worksheet", isRowsHideSuccessfully);
	}
	
	public void testUnhideRowsInAWorksheet() throws Exception {
		boolean isRowsUnHideSuccessfully = row.unhideRowsInAWorksheet(6, 2);
		assertNotNull("Failed to unhide hidden rows in a worksheet", isRowsUnHideSuccessfully);
	}
	
	public void testGroupRowsInAWorksheet() throws Exception {
		boolean isRowsGroupedSuccessfully = row.groupRowsInAWorksheet(1, 10);
		assertNotNull("Failed to group rows in a worksheet", isRowsGroupedSuccessfully);
	}
	
	public void testunGroupRowsInAWorksheet() throws Exception {
		boolean isRowsUnGroupedSuccessfully = row.ungroupRowsInAWorksheet(1, 10);
		assertNotNull("Failed to ungroup grouped rows in a worksheet", isRowsUnGroupedSuccessfully);
	}
	
	public void testAutoFitRowsInAWorksheet() throws Exception {
		boolean isRowsAutoFitSuccessfully = row.autoFitRowsInAWorksheet(1, 10);
		assertNotNull("Failed to auto fit rows in a worksheet", isRowsAutoFitSuccessfully);
	}
}
