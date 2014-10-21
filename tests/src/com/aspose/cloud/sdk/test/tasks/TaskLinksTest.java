package com.aspose.cloud.sdk.test.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.tasks.TaskLinks;
import com.aspose.cloud.sdk.tasks.TaskLinksModel;

import junit.framework.TestCase;

public class TaskLinksTest extends TestCase {

	public TaskLinksTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetAllTaskLinksInProject() throws Exception {
		ArrayList<TaskLinksModel> taskLinksArray = TaskLinks.getAllTaskLinksInProject("NewProductDev.mpp");
		assertNotNull("Failed to retrieve task links information from a project", taskLinksArray);
	}
}
