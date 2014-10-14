package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.DocumentProperties;
import com.aspose.cloud.sdk.words.GetDocumentPropertiesResponse.DocumentPropertiesModel;
import com.aspose.cloud.sdk.words.GetSpecificPropertyResponse.DocumentPropertyValue;

import junit.framework.TestCase;

public class DocumentPropertiesTest extends TestCase {

	public DocumentPropertiesTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetAllDocumentProperties() throws Exception {
		DocumentPropertiesModel documentProperties = DocumentProperties.getAllDocumentProperties("testDocument.docx");
		assertNotNull("Failed to get all document properties of a document", documentProperties);
	}
	
	public void testGetAParticularDocumentProperty() throws Exception {
		DocumentPropertyValue documentProperty = DocumentProperties.getAParticularDocumentProperty("testDocument.docx", "author");
		assertNotNull("Failed to get a particular document property of a document", documentProperty);
	}
	
	public void testSetASingleDocumentProperty() throws Exception {
		DocumentPropertyValue documentProperty = DocumentProperties.setASingleDocumentProperty("testDocument.docx", "author", "James John");
		assertNotNull("Failed to set a single document property of a document", documentProperty);
	}
	
	public void testRemoveAParticularDocumentProperty() throws Exception {
		boolean isPropertyDeletedSuccessfully = DocumentProperties.removeAParticularDocumentProperty("testDocument.docx", "first_property");
		assertEquals("Failed to remove a particular document property", true, isPropertyDeletedSuccessfully);
	}
	
}
