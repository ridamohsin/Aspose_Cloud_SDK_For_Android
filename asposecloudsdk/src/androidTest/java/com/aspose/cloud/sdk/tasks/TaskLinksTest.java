package com.aspose.cloud.sdk.tasks;

import com.aspose.cloud.sdk.tasks.api.TaskLinks;
import com.aspose.cloud.sdk.tasks.model.TaskLinksModel;

import junit.framework.TestCase;

import java.util.ArrayList;

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
		ArrayList<TaskLinksModel> taskLinksArray = TaskLinks.getAllTaskLinksInProject("myMSProject.mpp");
		assertNotNull("Failed to retrieve task links information from a project", taskLinksArray);
	}

	public void testAddsANewTaskLinkToAProject() throws Exception {
		TaskLinksModel taskLinkRequest = new TaskLinksModel();
		taskLinkRequest.index = 0;
		taskLinkRequest.predecessorUid = 25;
		taskLinkRequest.successorUid = 44;
		taskLinkRequest.linkType = 1;
		taskLinkRequest.lag = 0;
		taskLinkRequest.lagFormat = 4;

		boolean isNewTaskLinkAddedSuccessfully = TaskLinks.addsANewTaskLinkToAProject("myMSProject.mpp", taskLinkRequest);
		assertTrue("Failed to add a task link to a Project", isNewTaskLinkAddedSuccessfully);
	}

	public void testDeleteATaskLink() throws Exception {
		boolean isTaskLinkDeletedSuccessfully = TaskLinks.deleteATaskLink("myMSProject.mpp", 29);
		assertTrue("Failed to delete a task link from Project", isTaskLinkDeletedSuccessfully);
	}
}
