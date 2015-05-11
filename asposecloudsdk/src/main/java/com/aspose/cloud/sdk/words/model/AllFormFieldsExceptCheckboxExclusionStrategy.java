package com.aspose.cloud.sdk.words.model;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Created by muhammadsohailismail on 5/9/15.
 */
public class AllFormFieldsExceptCheckboxExclusionStrategy implements ExclusionStrategy {

    public boolean shouldSkipClass(Class<?> arg0) {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes f) {

        return f.getName().equals("TextInputFormat") || f.getName().equals("TextInputType")
                || f.getName().equals("TextInputDefault") || f.getName().equals("MaxLength")
                || f.getName().equals("DropDownSelectedIndex") || f.getName().equals("DropDownItems");
    }

}
