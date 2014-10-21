package com.aspose.cloud.sdk.test.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.tasks.ExtendedAttributeItemModel;
import com.aspose.cloud.sdk.tasks.ExtendedAttributes;

import junit.framework.TestCase;

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
		ArrayList<ExtendedAttributeItemModel> extendedAttributesArray = ExtendedAttributes.getProjectExtendedAttributes("NewProductDev.mpp");
		assertNotNull("Failed to retrieve extended attributes information from a project", extendedAttributesArray);
	}
}
