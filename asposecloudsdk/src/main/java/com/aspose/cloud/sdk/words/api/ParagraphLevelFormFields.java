package com.aspose.cloud.sdk.words.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.words.model.AllFormFieldsExceptCheckboxExclusionStrategy;
import com.aspose.cloud.sdk.words.model.AllFormFieldsExceptDropDownExclusionStrategy;
import com.aspose.cloud.sdk.words.model.AllFormFieldsExceptTextInputExclusionStrategy;
import com.aspose.cloud.sdk.words.model.FormFieldProperties;
import com.aspose.cloud.sdk.words.model.FormFieldTypeEnum;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by muhammadsohailismail on 5/9/15.
 */
public class ParagraphLevelFormFields {

    private static final String WORD_URI = AsposeApp.BASE_PRODUCT_URI + "/words/";

    public static void getFormFieldsFromAParagraphInTheWordDocument(String fileName, int sectionIndex, int paragraphIndex, int formFieldIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        Document document;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        String strURL = WORD_URI + Uri.encode(fileName) + "/sections/" + sectionIndex + "/paragraphs/" + paragraphIndex + "/formfields/" + formFieldIndex;

        //sign URL
        String signedURL = Utils.sign(strURL);

        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        String responseJSONString = Utils.streamToString(responseStream);
    }

    public static void addFormFieldsToAParagraphInTheWordDocument(String fileName, int sectionIndex, int paragraphIndex,
                                                                  FormFieldProperties formFieldProperties, FormFieldTypeEnum formFieldType) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(formFieldProperties == null) {
            throw new IllegalArgumentException("Form field properties cannot be null");
        }

        if(formFieldType == null) {
            throw new IllegalArgumentException("Form field type cannot be null");
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        //FormFieldProperties contains properties of all form fields. If we are going to add FormFieldTextInput than
        //no need to include FormFieldCheckbox and FormFieldDropDown.
        //Same case with other two types of FormFields (FormFieldCheckboxProperties and FormFieldDropDownProperties)
        if(formFieldType == FormFieldTypeEnum.FormFieldTextInputProperties) {
            gsonBuilder.setExclusionStrategies(new AllFormFieldsExceptTextInputExclusionStrategy());
        }
        else if(formFieldType == FormFieldTypeEnum.FormFieldCheckboxProperties) {
            gsonBuilder.setExclusionStrategies(new AllFormFieldsExceptCheckboxExclusionStrategy());
        }
        else if(formFieldType == FormFieldTypeEnum.FormFieldDropDownProperties) {
            gsonBuilder.setExclusionStrategies(new AllFormFieldsExceptDropDownExclusionStrategy());
        }

        Gson gson = gsonBuilder.create();
        String requestJSONString = gson.toJson(formFieldProperties, FormFieldProperties.class);

        String strURL = WORD_URI + Uri.encode(fileName) + "/sections/" + sectionIndex + "/paragraphs/" + paragraphIndex + "/formfields";

        //sign URL
        String signedURL = Utils.sign(strURL);

        InputStream responseStream = Utils.processCommand(signedURL, "PUT", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

    }

}
