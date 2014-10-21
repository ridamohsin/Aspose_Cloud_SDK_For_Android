package com.aspose.cloud.sdk.test.tasks;

import java.io.File;
import java.util.ArrayList;

import com.aspose.cloud.sdk.tasks.ProjectDocuments;
import com.aspose.cloud.sdk.tasks.ProjectPropertyModel;

import junit.framework.TestCase;

public class ProjectDocumentsTest extends TestCase {

	public ProjectDocumentsTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testRetrieveProjectProperties() throws Exception {
		ArrayList<ProjectPropertyModel> documentPropertiesList = ProjectDocuments.retrieveProjectProperties("NewProductDev.mpp");
		assertNotNull("Failed to retrieve project properties", documentPropertiesList);
	}
	
	public void testConvertProjectDataToFormat() throws Exception {
		String localFilePath = ProjectDocuments.convertProjectDataToFormat("NewProductDev.mpp", "pdf");
		File file = new File(localFilePath);
		assertEquals("Failed to convert project data to designated format", true, file.exists());
	}
}
