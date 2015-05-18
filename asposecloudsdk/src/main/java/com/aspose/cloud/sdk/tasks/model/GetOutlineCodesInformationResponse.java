package com.aspose.cloud.sdk.tasks.model;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by muhammadsohailismail on 5/18/15.
 */
public class GetOutlineCodesInformationResponse extends BaseResponse {

    @SerializedName("OutlineCodes")
    public OutlineCodes outlineCodes;

    public class OutlineCodes {
        @SerializedName("List")
        public ArrayList<OutlineCodeItem> list;
        public LinkModel link;
    }

    public class OutlineCodeItem {
        @SerializedName("Index")
        public int index;
        @SerializedName("Link")
        public LinkModel link;
    }

}
