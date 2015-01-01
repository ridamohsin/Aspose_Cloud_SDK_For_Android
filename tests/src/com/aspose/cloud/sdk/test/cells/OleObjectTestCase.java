package com.aspose.cloud.sdk.test.cells;

import java.io.File;

import com.aspose.cloud.sdk.cells.OleObject;
import com.aspose.cloud.sdk.cells.ValidOleObjectConversionFormats;
import com.aspose.cloud.sdk.cells.OleObjectResponse.OleObjectData;

import junit.framework.TestCase;

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
	
	/*public void testAddOleObjectToExcelWorksheet() throws Exception {
		String xmlOleObjectRequest = "<OleObject>" +
										"<SourceFullName>OLESrcDoc.docx</SourceFullName>" +
										"<ImageSourceFullName>bookmark.png</ImageSourceFullName>" +
										"<UpperLeftRow>10</UpperLeftRow>" + 
										"<UpperLeftColumn>10</UpperLeftColumn>" + 
										"<Top>20</Top>" +
										"<Left>20</Left>" +  
										"<Height>20</Height>" +  
										"<Width>20</Width>" + 
									"</OleObject>";
		oleObject.addOleObjectToExcelWorksheet(xmlOleObjectRequest);
	}*/
	
	public void testDeleteAllOleObjectsFromExcelWorksheet() throws Exception {
		boolean isAllOleObjectsDeletedSuccessfully = oleObject.deleteAllOleObjectsFromExcelWorksheet();
		assertEquals("Failed to delete all OLE objects from a worksheet", true, isAllOleObjectsDeletedSuccessfully);
	}
	
	public void testDeleteASpecificOleObjectFromExcelWorksheet() throws Exception {
		boolean isOleObjectDeletedSuccessfully = oleObject.deleteASpecificOleObjectFromExcelWorksheet(0);
		assertEquals("Failed to delete a specific OleObject from Excel Worksheet", true, isOleObjectDeletedSuccessfully);
	}
}
