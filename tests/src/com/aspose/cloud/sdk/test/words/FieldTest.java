package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.Field;
import com.aspose.cloud.sdk.words.DocumentResponse.Document;
import com.aspose.cloud.sdk.words.GetMailMergeFieldNamesResponse.FieldName;

import junit.framework.TestCase;

public class FieldTest extends TestCase {

	public FieldTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetAllMergeFieldNamesFromAWordDocument() throws Exception {
		FieldName fieldName = Field.getAllMergeFieldNamesFromAWordDocument("TestMainAppendTemplate.doc");
		assertNotNull("Failed to get all merge field names from a word document", fieldName);
	}
	
	public void testInsertPageNumberFieldIntoTheWordDocument() throws Exception {
		Document document = Field.insertPageNumberFieldIntoTheWordDocument("TestMainAppendTemplate.doc", "1 of 1", "right", true, true);
		assertNotNull("Failed to insert page number field into the word document", document);
	}
	
	public void testUpdateAllFieldsInTheWorldDocument() throws Exception {
		Document document = Field.updateAllFieldsInTheWordDocument("TestMainAppendTemplate.doc");
		assertNotNull("Failed to update all fields in the word document", document);
	}
}
