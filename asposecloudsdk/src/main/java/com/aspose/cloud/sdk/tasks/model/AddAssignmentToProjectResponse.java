package com.aspose.cloud.sdk.tasks.model;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muhammadsohailismail on 5/18/15.
 */
public class AddAssignmentToProjectResponse extends BaseResponse {
    @SerializedName("AssignmentItem")
    public AssignmentItemModel assignmentItem;
    @SerializedName("Message")
    public String message;
}
