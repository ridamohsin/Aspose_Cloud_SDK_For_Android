package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.GetFontInformationOfARunResponse.Font;
import com.aspose.cloud.sdk.words.GetParagraphListResponse.ParagraphsTextAndLink;
import com.aspose.cloud.sdk.words.GetRunOfAParagraphResponse.Run;
import com.aspose.cloud.sdk.words.GetSpecificParagraphResponse.ParagraphDetail;
import com.aspose.cloud.sdk.words.Paragraph;

import junit.framework.TestCase;

public class ParagraphTest extends TestCase {

	public ParagraphTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetListOfAllParagraphsPresentInAWordDocument() throws Exception {
		ParagraphsTextAndLink paragraphsList = Paragraph.getListOfAllParagraphsPresentInAWordDocument("TestMainAppendTemplate.doc");
		assertNotNull("Failed to get a list of all paragraphs present in a Word document", paragraphsList);
	}
	
	public void testGetASpecificParagraphPresentInAWordDocument() throws Exception {
		ParagraphDetail paragraph = Paragraph.getASpecificParagraphPresentInAWordDocument("TestMainAppendTemplate.doc", 1);
		assertNotNull("Failed to get a specific paragraph present in a Word document", paragraph);
	}
	
	public void testGetASpecificRunOfAParagraphPresentInAWordDocument() throws Exception {
		Run run = Paragraph.getASpecificRunOfAParagraphPresentInAWordDocument("TestMainAppendTemplate.doc", 1, 1);
		assertNotNull("Failed to get a specific run of a paragraph present in a Word document", run);
	}
	
	public void testGetFontInformationOfARunFromAWordDocument() throws Exception {
		Font font = Paragraph.getFontInformationOfARunFromAWordDocument("TestMainAppendTemplate.doc", 1, 1);
		assertNotNull("Failed to get a font related information of a specific run of a paragraph present in a Word document", 
				font);
	}
	
	public void testUpdateFontOfARunInAWordDocument() throws Exception {
		String xmlData = "<Font>" +
							"<AllCaps>true</AllCaps>" +
							"<Bold>false</Bold>" +
							"<Italic>true</Italic>" +
							"<Underline>Dash</Underline>" +
						 "</Font>";
		Font font = Paragraph.updateFontOfARunInAWordDocument("TestMainAppendTemplate.doc", 1, 1, xmlData);
		assertNotNull("Failed to update font of a specific run of a paragraph present in a Word document", font);
	}
}
