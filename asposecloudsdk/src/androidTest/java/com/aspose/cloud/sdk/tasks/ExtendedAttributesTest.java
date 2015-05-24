package com.aspose.cloud.sdk.tasks;

import com.aspose.cloud.sdk.tasks.api.ExtendedAttributes;
import com.aspose.cloud.sdk.tasks.model.ExtendedAttributeItemModel;
import com.aspose.cloud.sdk.tasks.model.GetOutlineCodesInformationResponse;

import junit.framework.TestCase;

import java.util.ArrayList;

public class ExtendedAttributesTest extends TestCase {

	public ExtendedAttributesTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetProjectExtendedAttributes() throws Exception {
		ArrayList<ExtendedAttributeItemModel> extendedAttributesArray = ExtendedAttributes.getProjectExtendedAttributes("myMSProject.mpp");
		assertNotNull("Failed to retrieve extended attributes information from a project", extendedAttributesArray);
	}

	public void testDeleteExtendedAttributes() throws Exception {
		boolean isExtendedAttributeDeletedSuccessfully = ExtendedAttributes.deleteExtendedAttribute("myMSProject.mpp", 1);
		assertTrue("Failed to delete extended attributes", isExtendedAttributeDeletedSuccessfully);
	}

	public void testRetrieveOutlineCodesInformation() throws Exception {
		GetOutlineCodesInformationResponse.OutlineCodes outlineCodes = ExtendedAttributes.getOutlineCodesInformation("Consolidating A_Start.mpp");
		assertNotNull("Failed to retrieve outline codes information", outlineCodes);
	}

	public void testDeleteOutlineCodes() throws Exception {
		boolean isOutlineCodeDeletedSuccessfully = ExtendedAttributes.deleteOutlineCodes("myMSProject.mpp", 1);
		assertTrue("Failed to delete outline codes", isOutlineCodeDeletedSuccessfully);
	}
}
