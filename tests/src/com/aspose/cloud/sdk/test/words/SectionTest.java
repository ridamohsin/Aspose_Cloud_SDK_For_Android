package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.Section;
import com.aspose.cloud.sdk.words.GetSectionListResponse.SectionList;
import com.aspose.cloud.sdk.words.GetSpecificSectionResponse.SectionDetails;

import junit.framework.TestCase;

public class SectionTest extends TestCase {

	public SectionTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetListOfSectionsFromAWordDocument() throws Exception {
		SectionList sectionsList = Section.getListOfSectionsFromAWordDocument("TestMainAppendTemplate.doc");
		assertNotNull("Failed to get a list of all sections present in a Word document", sectionsList);
	}
	
	public void testGetASpecificSectionFromAWordDocument() throws Exception {
		SectionDetails section = Section.getASpecificSectionFromAWordDocument("TestMainAppendTemplate.doc", 1);
		assertNotNull("Failed to get a specific section from a Word document", section);
	}
	
	public void testDeleteAllHeadersAndFootersFromTheDocument() throws Exception {
		boolean isAllHeadersAndFootersDeletedSuccessfully = Section.deleteAllHeadersAndFootersFromTheDocument("TestMainAppendTemplate.doc");
		assertEquals("Failed to delete all headers and footers of a word document", true, isAllHeadersAndFootersDeletedSuccessfully);
	}
}
