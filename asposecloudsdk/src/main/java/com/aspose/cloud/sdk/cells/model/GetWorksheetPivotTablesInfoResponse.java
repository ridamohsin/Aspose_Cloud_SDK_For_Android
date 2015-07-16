package com.aspose.cloud.sdk.cells.model;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.google.gson.annotations.SerializedName;

/**
 * Created by muhammadsohailismail on 7/16/15.
 */
public class GetWorksheetPivotTablesInfoResponse extends BaseResponse {
    @SerializedName("PivotTables")
    public PivotTablesInfo pivotTables;
}