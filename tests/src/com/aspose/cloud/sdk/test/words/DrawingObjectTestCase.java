package com.aspose.cloud.sdk.test.words;

import java.io.File;

import com.aspose.cloud.sdk.words.DrawingObject;
import com.aspose.cloud.sdk.words.GetDrawingObjectsResponse.DrawingObjectsData;

import junit.framework.TestCase;

public class DrawingObjectTestCase extends TestCase {

	public DrawingObjectTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetAllDrawingObjects() throws Exception {
		DrawingObjectsData drawingObjects = DrawingObject.getAllDrawingObjects("myworddocument.docx");
		assertNotNull("Failed to get all drawing objects from a Word document", drawingObjects);
	}
	
	public void testConvertDrawingObjectToImage() throws Exception {
		String localFilePath = DrawingObject.convertDrawingObjectToImage("myworddocument.docx", 0, "png", "circle.png");
		File file = new File(localFilePath);
		assertEquals("Failed to convert drawing object to an image", true, file.exists());
	}
	
	public void testGetTheImageDrawingObjectFromDocument() throws Exception {
		String localFilePath = DrawingObject.getTheImageDrawingObjectFromDocument("myworddocument.docx", 0, "piechart.png");
		File file = new File(localFilePath);
		assertEquals("Failed to get the image drawing object from a Word document", true, file.exists());
	}
	
	public void testGetTheOLEDrawingObjectFromAWordDocument() throws Exception {
		String localFilePath = DrawingObject.getTheOLEDrawingObjectFromAWordDocument("myworddocument.docx", 0, "oleFile.jpeg");
		File file = new File(localFilePath);
		assertEquals("Failed to get the OLE drawing object from a Word document", true, file.exists());
	}
}
