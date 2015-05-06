package com.aspose.cloud.sdk.words;

import com.aspose.cloud.sdk.words.api.DrawingObject;
import com.aspose.cloud.sdk.words.model.GetDrawingObjectsResponse.DrawingObjectsData;
import junit.framework.TestCase;

import java.io.File;

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
		DrawingObjectsData drawingObjects = DrawingObject.getAllDrawingObjects("ImageandDataTemplate.docx");
		assertNotNull("Failed to get all drawing objects from a Word document", drawingObjects);
	}
	
	public void testConvertDrawingObjectToImage() throws Exception {
		String localFilePath = DrawingObject.convertDrawingObjectToImage("myworddocument.docx", 0, "png", "circle.png");
		File file = new File(localFilePath);
		assertEquals("Failed to convert drawing object to an image", true, file.exists());
	}
	
	public void testGetTheImageDrawingObjectFromDocument() throws Exception {
		String localFilePath = DrawingObject.getTheImageDrawingObjectFromDocument("ImageandDataTemplate.docx", 0, "imageDrawing.png");
		File file = new File(localFilePath);
		assertEquals("Failed to get the image drawing object from a Word document", true, file.exists());
	}
	
	public void testGetTheOLEDrawingObjectFromAWordDocument() throws Exception {
		String localFilePath = DrawingObject.getTheOLEDrawingObjectFromAWordDocument("ImageandDataTemplate.docx", 0, "oleDrawingObject.png");
		File file = new File(localFilePath);
		assertEquals("Failed to get the OLE drawing object from a Word document", true, file.exists());
	}

	public void testGetTheOLEDrawingObjectFromDocumentUsingThirdPartyStorage() throws Exception {
		String localFilePath = DrawingObject.getTheOLEDrawingObjectFromDocumentUsingThirdPartyStorage("myworddocument.doc", 0, "oleDrawingObject.png", "MyDropboxStorage", "myFolder");
		File file = new File(localFilePath);
		assertEquals("Failed to get the OLE drawing object from document using third party storage", true, file.exists());
	}

	public void testReadDrawingObjectImageDataUsingThirdPartyStorage() throws Exception {
		String localFilePath = DrawingObject.readDrawingObjectImageDataUsingThirdPartyStorage("myworddocument.doc", 0, "oleDrawingObject.png", "MyDropboxStorage", "myFolder");
		File file = new File(localFilePath);
		assertEquals("Failed to read drawing object image data using third party storage", true, file.exists());
	}

	public void testGetAllDrawingObjectsUsingThirdPartyStorage() throws Exception {
		DrawingObjectsData drawingObjects = DrawingObject.getAllDrawingObjectsUsingThirdPartyStorage("myworddocument.doc", "MyDropboxStorage", "myFolder");
		assertNotNull("Failed to get all drawing objects from a word document using third party storage", drawingObjects);
	}

	public void testConvertDrawingObjectToImageUsingThirdPartyStorage() throws Exception {
		String localFilePath = DrawingObject.convertDrawingObjectToImageUsingThirdPartyStorage("myworddocument.doc", 0, "png", "MyDropboxStorage", "myFolder", "circle.png");
		File file = new File(localFilePath);
		assertEquals("Failed to convert drawing object to image using third party storage", true, file.exists());
	}

}
