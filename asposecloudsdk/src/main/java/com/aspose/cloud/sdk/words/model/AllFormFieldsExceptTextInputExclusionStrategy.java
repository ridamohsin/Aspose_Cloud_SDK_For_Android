package com.aspose.cloud.sdk.words.model;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Created by muhammadsohailismail on 5/9/15.
 */
public class AllFormFieldsExceptTextInputExclusionStrategy implements ExclusionStrategy {

    public boolean shouldSkipClass(Class<?> arg0) {
        return false;
    }

    public boolean shouldSkipField(FieldAttributes f) {

        return f.getName().equals("IsCheckBoxExactSize") || f.getName().equals("CheckBoxSize")
                || f.getName().equals("Checked") || f.getName().equals("DropDownSelectedIndex")
                || f.getName().equals("DropDownItems");
    }

}
