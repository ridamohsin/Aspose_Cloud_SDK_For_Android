package com.aspose.cloud.sdk.test.cells;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.aspose.cloud.sdk.cells.PositionEnum;
import com.aspose.cloud.sdk.cells.SortKey;
import com.aspose.cloud.sdk.cells.ValidFormatsOfWorksheet;
import com.aspose.cloud.sdk.cells.Worksheet;
import com.aspose.cloud.sdk.cells.CalculateFormulaResponse.CalculateFormulaResult;
import com.aspose.cloud.sdk.cells.GetAutoshapeFromAWorksheetResponse.AutoShape;
import com.aspose.cloud.sdk.cells.GetColumnFromAWorksheetResponse.Column;
import com.aspose.cloud.sdk.cells.GetCommentFromAWorksheetResponse.Comment;
import com.aspose.cloud.sdk.cells.GetValidationFromAWorksheetResponse.Validation;
import com.aspose.cloud.sdk.cells.WorksheetResponse.WorksheetResult;

import junit.framework.TestCase;

public class WorksheetTest extends TestCase {
	
	private Worksheet worksheet;
	
	public WorksheetTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		worksheet = new Worksheet("myworkbook.xlsx", "Sheet1");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testConvertWorksheetToImage() throws Exception {
		String localFilePath = worksheet.convertWorksheetToImage(ValidFormatsOfWorksheet.jpeg);
		File file = new File(localFilePath);
		assertEquals("Failed to convert a worksheet to designated image format", true, file.exists());
	}

	public void testAddANewWorksheet() throws Exception {
		WorksheetResult worksheetResult = worksheet.addANewWorksheet("newWorksheet");
		assertNotNull("Failed to add a new worksheet in a workbook", worksheetResult);
	}
	
	public void testGetWorksheetCount() throws Exception {
		int worksheetCount = worksheet.getWorksheetCount();
		boolean worksheetCountResult = worksheetCount >= 0 ? true : false;
		assertEquals("Failed to get worksheet count", true, worksheetCountResult);
	}
	
	public void testHideAWorksheetInAWorkbook() throws Exception {
		boolean isWorksheetHideSuccessfully = worksheet.hideAWorksheetInAWorkbook();
		assertEquals("Failed to hide a worksheet in a workbook", true, isWorksheetHideSuccessfully);
	}
	
	public void testUnhideAWorksheetInAWorkbook() throws Exception {
		boolean isWorksheetUnHideSuccessfully = worksheet.unhideAWorksheetInAWorkbook();
		assertEquals("Failed to unhide a worksheet in a workbook", true, isWorksheetUnHideSuccessfully);
	}
	
	public void testMoveAWorksheetToANewLocationInAWorkbook() throws Exception {
		boolean isWorksheetMovedSuccessfully = worksheet.moveAWorksheetToANewLocationInAWorkbook("Feb", PositionEnum.AFTER);
		assertEquals("Failed to move a worksheet to a new location in a workbook", true, isWorksheetMovedSuccessfully);
	}
	
	public void testRemoveAWorksheetFromAWorkbook() throws Exception {
		boolean isWorksheetRemovedSuccessfully = worksheet.removeAWorksheetFromAWorkbook();
		assertEquals("Failed to remove a worksheet from a workbook", true, isWorksheetRemovedSuccessfully);
	}
	
	public void testGetAutoshapeFromAWorksheet() throws Exception {
		AutoShape autoShape = worksheet.getAutoshapeFromAWorksheet(0);
		assertNotNull("Failed to get autoshape from a worksheet", autoShape);
	}
	
	public void testGetCommentFromAWorksheet() throws Exception {
		Comment comment = worksheet.getCommentFromAWorksheet("A1");
		assertNotNull("Failed to get a comment from a worksheet", comment);
	}
	 
	public void testGetValidationFromAWorksheet() throws Exception {
		Validation validation = worksheet.getValidationFromAWorksheet(0);
		assertNotNull("Failed to get validation from a worksheet ", validation);
	}
	
	public void testCalculateFormulaInAWorksheet() throws Exception {
		CalculateFormulaResult value = worksheet.calculateFormulaInAWorksheet("sum(b2:b6)");
		assertNotNull("Failed to calculate formula in a worksheet", value);
	}
	
	public void testSortWorksheetData() throws Exception {
		List<SortKey> keyList = new ArrayList<SortKey>();
		SortKey sort = new SortKey();
		sort.Key = 4;
		sort.SortOrder = "descending";
		keyList.add(sort);
		boolean isWorksheetDataSortedSuccessfully = worksheet.sortWorksheetData("A1:C13", false, false, true, keyList);
		assertEquals("Failed to sort worksheet data", true, isWorksheetDataSortedSuccessfully);
	}
	
	public void testGetColumnFromAWorksheet() throws Exception {
		Column column = worksheet.getColumnFromAWorksheet(0);
		assertNotNull("Failed to get column from a worksheet ", column);
	}
	
	public void testCopyAWorksheet() throws Exception {
		boolean isWorksheetCopiedSuccessfully = worksheet.copyAWorksheet("srcSheetName");
		assertEquals("Failed to copy a worksheet", true, isWorksheetCopiedSuccessfully);
	}
	
	public void testRenameAWorksheet() throws Exception {
		boolean isWorksheetRenamedSuccessfully = worksheet.renameAWorksheet("newSheetName");
		assertEquals("Failed to rename a worksheet", true, isWorksheetRenamedSuccessfully);
	}
	
	public void testUpdatePropertiesOfAWorksheet() throws Exception {
		String xmlData = 
				"<Worksheet>" +
					"<Type>Worksheet</Type>" +
					"<Name>sheet1</Name>" +
					"<IsGridlinesVisible>True</IsGridlinesVisible>" +
					"<IsRowColumnHeadersVisible>True</IsRowColumnHeadersVisible>" +
					"<DisplayZeros>True</DisplayZeros>" +
					"<DisplayRightToLeft>True</DisplayRightToLeft>" +
					"<IsOutlineShown>True</IsOutlineShown>" +
					"<IsSelected>True</IsSelected>" +
					"<HasAutofilter>True</HasAutofilter>" +
					"<TransitionEvaluation>True</TransitionEvaluation>" +
					"<TransitionEntry>True</TransitionEntry>" +
					"<VisibilityType>Visible</VisibilityType>" +
					"<IsVisible>True</IsVisible>" +
					"<Index>0</Index>" +
					"<FirstVisibleRow>1</FirstVisibleRow>" +
					"<FirstVisibleColumn>1</FirstVisibleColumn>" +
					"<Zoom>80</Zoom>" +
					"<ViewType>PageBreakPreview</ViewType>" +
					"<IsPageBreakPreview>True</IsPageBreakPreview>" +
					"<IsRulerVisible>True</IsRulerVisible>" +
				"</Worksheet>";
		worksheet.updatePropertiesOfAWorksheet(xmlData);
	}
	
	public void testSetABackgroundImageOrWatermarkImageForAWorksheet() throws Exception {
		boolean isBackgroundImageSetSuccessfully = worksheet.setABackgroundImageOrWatermarkImageForAWorksheet("IMG_0004.PNG");
		assertEquals("Failed to set a background image or watermark image for a worksheet", true, isBackgroundImageSetSuccessfully);
	}
	
	public void testFreezePanesInAWorksheet() throws Exception {
		boolean isPanesFreezedSuccessfully = worksheet.freezePanesInAWorksheet(1, 1, 1, 1);
		assertEquals("Failed to freeze panes in a worksheet", true, isPanesFreezedSuccessfully);
	}
	
	public void testUnFreezePanesInAWorksheet() throws Exception {
		boolean isPanesFreezedSuccessfully = worksheet.unFreezePanesInAWorksheet(1, 1, 1, 1);
		assertEquals("Failed to unfreeze panes in a worksheet", true, isPanesFreezedSuccessfully);
	}
	
	public void testDeleteABackgroundOrWatermarkImageOfAWorksheet() throws Exception {
		boolean isBackgroundImageDeletedSuccessfully = worksheet.deleteABackgroundOrWatermarkImageOfAWorksheet();
		assertEquals("Failed to delete a background or watermark image of a worksheet", true, isBackgroundImageDeletedSuccessfully);
	}
}
