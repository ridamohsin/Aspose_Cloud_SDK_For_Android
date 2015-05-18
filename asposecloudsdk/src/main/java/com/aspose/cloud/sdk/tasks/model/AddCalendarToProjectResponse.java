package com.aspose.cloud.sdk.tasks.model;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muhammadsohailismail on 5/18/15.
 */
public class AddCalendarToProjectResponse extends BaseResponse {

    @SerializedName("CalendarItem")
    public CalendarItemModel calendarItem;
    @SerializedName("Message")
    public String message;

}
