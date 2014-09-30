package com.aspose.cloud.sdk.tasks;

import java.util.ArrayList;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.google.gson.annotations.SerializedName;

public class GetProjectCalendarItemsResponseModel extends BaseResponse {
	@SerializedName("Calendars")
	public Calendar calendar;
	
	public class Calendar {
		@SerializedName("List")
		public ArrayList<CalendarItemModel> calendarItemsArray;
	}
}
