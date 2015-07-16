package com.aspose.cloud.sdk.cells.model;

import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by muhammadsohailismail on 7/16/15.
 */
public class PivotTablesInfo {
    @SerializedName("PivotTableList")
    public ArrayList<PivotTableLink> pivotTableList;
    public LinkModel link;
}
