package com.aspose.cloud.sdk.words.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.words.model.AllFormFieldsExceptCheckboxExclusionStrategy;
import com.aspose.cloud.sdk.words.model.AllFormFieldsExceptDropDownExclusionStrategy;
import com.aspose.cloud.sdk.words.model.AllFormFieldsExceptTextInputExclusionStrategy;
import com.aspose.cloud.sdk.words.model.FormFieldModel;
import com.aspose.cloud.sdk.words.model.FormFieldProperties;
import com.aspose.cloud.sdk.words.model.FormFieldTypeEnum;
import com.aspose.cloud.sdk.words.model.ParagraphLevelFormFieldResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * ParagraphLevelFormFields --- Using this class you can get representation of an one of the form field, adds form field to paragraph,
 * updates form field's properties and removes form field from document.
 * @author   M. Sohail Ismail
 */
public class ParagraphLevelFormFields {

    private static final String WORD_URI = AsposeApp.BASE_PRODUCT_URI + "/words/";

    /**
     * Get representation of an one of the form field
     * @param fileName The document name.
     * @param sectionIndex Section index.
     * @param paragraphIndex Paragraph index.
     * @param formFieldIndex Form field index.
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Form field object
     */
    public static FormFieldModel getFormFieldsFromAParagraphInTheWordDocument(String fileName, int sectionIndex, int paragraphIndex, int formFieldIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        FormFieldModel formField = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        String strURL = WORD_URI + Uri.encode(fileName) + "/sections/" + sectionIndex + "/paragraphs/" + paragraphIndex + "/formfields/" + formFieldIndex;

        //sign URL
        String signedURL = Utils.sign(strURL);

        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        Gson gson = new Gson();
        ParagraphLevelFormFieldResponse formFieldResponse = gson.fromJson(responseJSONString, ParagraphLevelFormFieldResponse.class);
        if(formFieldResponse.getCode().equals("200") && formFieldResponse.getStatus().equals("OK")) {
            formField = formFieldResponse.formField;
        }

        return formField;
    }

    /**
     * Adds form field to paragraph, returns added form field's data
     * @param fileName Name of the word document
     * @param sectionIndex Section index.
     * @param paragraphIndex Paragraph index.
     * @param formFieldProperties From field data.
     * @param formFieldType Form Field type. Could be either FormFieldTextInputProperties, FormFieldCheckboxProperties or FormFieldDropDownProperties
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Form field object
     */
    public static FormFieldModel addFormFieldsToAParagraphInTheWordDocument(String fileName, int sectionIndex, int paragraphIndex,
                                                                  FormFieldProperties formFieldProperties, FormFieldTypeEnum formFieldType) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        FormFieldModel formField = null;

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

        //Parsing JSON
        ParagraphLevelFormFieldResponse formFieldResponse = gson.fromJson(responseJSONString, ParagraphLevelFormFieldResponse.class);
        if(formFieldResponse.getCode().equals("200") && formFieldResponse.getStatus().equals("OK")) {
            formField = formFieldResponse.formField;
        }

        return formField;
    }

    /**
     * Updates form field's properties, returns updated form field's data
     * @param fileName Name of the word document
     * @param sectionIndex Section index.
     * @param paragraphIndex Paragraph index.
     * @param formFieldIndex Form field index.
     * @param formFieldProperties From field data.
     * @param formFieldType Form Field type. Could be either FormFieldTextInputProperties, FormFieldCheckboxProperties or FormFieldDropDownProperties
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Updated form field object
     */
    public static FormFieldModel updatesFormFieldsProperties(String fileName, int sectionIndex, int paragraphIndex, int formFieldIndex,
                                                                            FormFieldProperties formFieldProperties, FormFieldTypeEnum formFieldType) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        FormFieldModel formField = null;

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

        String strURL = WORD_URI + Uri.encode(fileName) + "/sections/" + sectionIndex + "/paragraphs/" + paragraphIndex + "/formfields/" + formFieldIndex;

        //sign URL
        String signedURL = Utils.sign(strURL);

        InputStream responseStream = Utils.processCommand(signedURL, "POST", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        ParagraphLevelFormFieldResponse formFieldResponse = gson.fromJson(responseJSONString, ParagraphLevelFormFieldResponse.class);
        if(formFieldResponse.getCode().equals("200") && formFieldResponse.getStatus().equals("OK")) {
            formField = formFieldResponse.formField;
        }

        return formField;
    }

    /**
     * Removes form field from document
     * @param fileName The document name.
     * @param sectionIndex Section index.
     * @param paragraphIndex Paragraph index.
     * @param formFieldIndex Form field index.
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Boolean variable that indicates whether form field deleted successfully from document
     */
    public static boolean removesFormFieldFromDocument(String fileName, int sectionIndex, int paragraphIndex, int formFieldIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        boolean formFieldDeletedSuccessfully = false;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        String strURL = WORD_URI + Uri.encode(fileName) + "/sections/" + sectionIndex + "/paragraphs/" + paragraphIndex + "/formfields/" + formFieldIndex;

        //sign URL
        String signedURL = Utils.sign(strURL);

        InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        Gson gson = new Gson();
        BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
        if(baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
            formFieldDeletedSuccessfully = true;
        }

        return formFieldDeletedSuccessfully;
    }
}
