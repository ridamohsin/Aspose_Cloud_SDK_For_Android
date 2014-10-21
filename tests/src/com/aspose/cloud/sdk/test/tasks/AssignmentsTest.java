package com.aspose.cloud.sdk.test.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.tasks.AssignmentItemModel;
import com.aspose.cloud.sdk.tasks.Assignments;

import junit.framework.TestCase;

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

	public void testAssignments() throws Exception {
		ArrayList<AssignmentItemModel> assignmentsArray = Assignments.getAllAssignmentItemsInProject("NewProductDev.mpp");
		assertNotNull("Failed to retrieve assignments information from Project", assignmentsArray);
	}
}
