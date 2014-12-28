package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.Field;
import com.aspose.cloud.sdk.words.DocumentResponse.Document;
import com.aspose.cloud.sdk.words.GetMailMergeFieldNamesResponse.FieldName;

import junit.framework.TestCase;

public class FieldTestCase extends TestCase {

	public FieldTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetAllMergeFieldNamesFromAWordDocument() throws Exception {
 		FieldName fieldName = Field.getAllMergeFieldNamesFromAWordDocument("merge.docx.....docx");
		assertNotNull("Failed to get all merge field names from a word document", fieldName);
	}
	
	public void testInsertPageNumberFieldIntoTheWordDocument() throws Exception {
		Document document = Field.insertPageNumberFieldIntoTheWordDocument("myworddocument.docx", "{PAGE} of {NUMPAGES}", "right", false, true);
		assertNotNull("Failed to insert page number field into the word document", document);
	}
	
	public void testUpdateAllFieldsInTheWorldDocument() throws Exception {
		Document document = Field.updateAllFieldsInTheWordDocument("myworddocument.docx", "updatefieldsworddocument.docx");
		assertNotNull("Failed to update all fields in the word document", document);
	}
}
