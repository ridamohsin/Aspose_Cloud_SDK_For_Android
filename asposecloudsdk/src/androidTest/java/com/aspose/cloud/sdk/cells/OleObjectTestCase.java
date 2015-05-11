package com.aspose.cloud.sdk.cells;

import com.aspose.cloud.sdk.cells.api.OleObject;
import com.aspose.cloud.sdk.cells.model.ValidOleObjectConversionFormats;
import com.aspose.cloud.sdk.cells.model.OleObjectResponse.OleObjectData;

import junit.framework.TestCase;

import java.io.File;

public class OleObjectTestCase extends TestCase {

	private OleObject oleObject;
	
	public OleObjectTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		oleObject = new OleObject("myworkbook.xlsx", "Sheet1");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetOleObjectFromAWorksheet() throws Exception {
		OleObjectData oleObjectData = oleObject.getOleObjectFromAWorksheet(0);
		assertNotNull("Failed to get OleObject from a Worksheet", oleObjectData);
	}
	
	public void testConvertOLEObjectToImage() throws Exception {
		String localFilePath = oleObject.convertOLEObjectToImage(0, ValidOleObjectConversionFormats.tiff, "oleObjectImage.tiff");
		File file = new File(localFilePath);
		assertEquals("Failed to convert OLE Object to Image", true, file.exists());
	}

	public void testAddOleObjectsToExcelWorksheet() throws Exception {
		String oleObjectData = "<OleObject>" +
				               		"<SourceFullName>OLEDoc2.docx</SourceFullName>" +
									"<ImageSourceFullName>sample.jpg</ImageSourceFullName>" +
									"<UpperLeftRow>10</UpperLeftRow>" +
									"<UpperLeftColumn>10</UpperLeftColumn>" +
									"<Top>20</Top>" +
									"<Left>20</Left>" +
									"<Height>20</Height>" +
									"<Width>20</Width>" +
								"</OleObject>";
		OleObjectData myOLEObject = oleObject.addOleObjectsToExcelWorksheet(oleObjectData, "xml");
		assertNotNull("Failed to add OleObject to Excel Worksheet", myOLEObject);
	}

	public void testUpdateOLEObject() throws Exception {

		String oleObjectData = "<OleObject>" +
									"<SourceFullName>OLEDoc1.docx</SourceFullName>" +
									"<ImageSourceFullName>sample.jpg</ImageSourceFullName>" +
									"<UpperLeftRow>5</UpperLeftRow>" +
									"<UpperLeftColumn>5</UpperLeftColumn>" +
									"<Top>10</Top>" +
									"<Left>10</Left>" +
									"<Height>20</Height>" +
									"<Width>20</Width>" +
								"</OleObject>";

		boolean isOLEObjectUpdatedSuccessfully = oleObject.updateOLEObject(0, oleObjectData, "xml");
		assertEquals("Failed to update a specific OleObject from a worksheet", isOLEObjectUpdatedSuccessfully);
	}

	public void testDeleteAllOleObjectsFromExcelWorksheet() throws Exception {
		boolean isAllOleObjectsDeletedSuccessfully = oleObject.deleteAllOleObjectsFromExcelWorksheet();
		assertEquals("Failed to delete all OLE objects from a worksheet", true, isAllOleObjectsDeletedSuccessfully);
	}
	
	public void testDeleteASpecificOleObjectFromExcelWorksheet() throws Exception {
		boolean isOleObjectDeletedSuccessfully = oleObject.deleteASpecificOleObjectFromExcelWorksheet(0);
		assertEquals("Failed to delete a specific OleObject from Excel Worksheet", true, isOleObjectDeletedSuccessfully);
	}
}
