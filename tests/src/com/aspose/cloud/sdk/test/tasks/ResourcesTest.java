package com.aspose.cloud.sdk.test.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.tasks.ResourceItemModel;
import com.aspose.cloud.sdk.tasks.ResourceModel;
import com.aspose.cloud.sdk.tasks.Resources;
import com.aspose.cloud.sdk.tasks.TaskItemModel;

import junit.framework.TestCase;

public class ResourcesTest extends TestCase {

	public ResourcesTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetAllResourceItemsOfProject() throws Exception {
		ArrayList<ResourceItemModel> resourcesArray = Resources.getAllResourceItemsOfProject("NewProductDev.mpp");
		assertNotNull("Failed to retrieve all resources information in a project", resourcesArray);
	}
	
	public void testGetResourceInformation() throws Exception {
		ResourceModel resource = Resources.getResourceInformation("NewProductDev.mpp", 1);
		assertNotNull("Failed to retrieve detail information of a particular resource", resource);
	}

	public void testAddAResourceToProject() throws Exception {
		TaskItemModel taskItem = Resources.addAResourceToProject("NewProductDev.mpp", "Technology", 2, "UpdatedProductDev.mpp");
		assertNotNull("Failed to add a resource to a Project", taskItem);
	}
	
	public void testDeleteAResourceFromProject() throws Exception {
		boolean isResourceDeletedSuccessfully = Resources.deleteAResourceFromProject("NewProductDev.mpp", 19, "UpdatedProductDev.mpp");
		assertEquals("Failed to delete resource from a project", true, isResourceDeletedSuccessfully);
	}
}
