package com.aspose.cloud.sdk.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class GetAllTasksInProjectResponse extends BaseResponse {
	@SerializedName("Tasks")
	public Tasks tasks;
	
	public class Tasks {
		@SerializedName("TaskItem")
		public ArrayList<TaskItemModel> taskItemsArray;
	}
}
