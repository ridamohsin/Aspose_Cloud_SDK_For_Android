package com.aspose.cloud.sdk.test.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.tasks.TaskItemModel;
import com.aspose.cloud.sdk.tasks.TaskModel;
import com.aspose.cloud.sdk.tasks.Tasks;

import junit.framework.TestCase;

public class TasksTest extends TestCase {

	public TasksTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetAllTasksInProject() throws Exception {
		ArrayList<TaskItemModel> tasksArray = Tasks.getAllTasksInProject("NewProductDev.mpp");
		assertNotNull("Failed to retrieve all tasks in a project", tasksArray);
	}
	
	public void testGetTaskInformation() throws Exception {
		TaskModel taskInfo = Tasks.getTaskInformation("NewProductDev.mpp", 145);
		assertNotNull("Failed to retrieve task information", taskInfo);
	}

	public void testAddATaskToProject() throws Exception {
		TaskItemModel taskItem = Tasks.addATaskToProject("NewProductDev.mpp", "New Task", 145, "UpdatedProductDev.mpp");
		assertNotNull("Failed to add a task to a project", taskItem);
	}

	public void testDeleteATaskFromProject() throws Exception {
		boolean isTaskDeletedSuccessfully = Tasks.deleteATaskFromProject("NewProductDev.mpp", 287, "UpdatedProductDev.mpp");
		assertEquals("Failed to delete a Task from project", true, isTaskDeletedSuccessfully);
	}

}
