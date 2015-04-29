package com.aspose.cloud.sdk.email.model;

import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by muhammadsohailismail on 4/29/15.
 */
public class EmailDocumentProperties {
    @SerializedName("Link")
    public LinkModel link;
    @SerializedName("List")
    public ArrayList<EmailProperty> emailPropertiesList;
}
