package com.aspose.cloud.sdk.tasks;

import com.aspose.cloud.sdk.tasks.api.Assignments;
import com.aspose.cloud.sdk.tasks.model.AddAssignmentToProjectResponse;
import com.aspose.cloud.sdk.tasks.model.AssignmentItemModel;

import junit.framework.TestCase;

import java.util.ArrayList;

public class AssignmentsTest extends TestCase {

	public AssignmentsTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetAllAssignmentItemsInProject() throws Exception {
		ArrayList<AssignmentItemModel> assignmentsArray = Assignments.getAllAssignmentItemsInProject("NewProductDev.mpp");
		assertNotNull("Failed to retrieve assignments information from Project", assignmentsArray);
	}

	public void testAddAssignmentToProject() throws Exception {
		AddAssignmentToProjectResponse addAssignmentToProjectRes = Assignments.addAssignmentToProject("myMSProject.mpp", 4, 31, 0.5);
		assertNotNull("Failed to add a new assignment to a project", addAssignmentToProjectRes);
	}

	public void testDeleteAnAssignmentFromAProject() throws Exception {
		boolean isAssignmentDeletedSuccessfullyFromAProject = Assignments.deleteAnAssignmentFromAProject("myMSProject.mpp", 167);
		assertTrue("Failed to delete an assignment from a project", isAssignmentDeletedSuccessfullyFromAProject);
	}
}
