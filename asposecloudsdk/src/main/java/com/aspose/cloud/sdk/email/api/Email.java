package com.aspose.cloud.sdk.email.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.email.model.AddEmailAttachmentResponse;
import com.aspose.cloud.sdk.email.model.AddNewEmailResponse;
import com.aspose.cloud.sdk.email.model.EmailDocument;
import com.aspose.cloud.sdk.email.model.EmailProperty;
import com.aspose.cloud.sdk.email.model.EmailPropertyResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Email --- Using this class you can convert email to other formats, read/update message properties
 * and download attachment from a message.
 *
 * @author M. Sohail Ismail
 */
public class Email {

    private static final String EMAIL_URI = AsposeApp.BASE_PRODUCT_URI + "/email/";
    private static final List<String> validFormats = Arrays.asList("eml", "mht", "msg");
    private static final List<String> validEmailProperties = Arrays.asList("bcc", "body", "cc", "date",
            "deliverynotificationoptions", "from", "to", "htmlbody", "isbodyhtml", "messageid", "priority", "subject",
            "textbody", "attachments");

    /**
     * It converts email messages back and forth between EML, MSG and MHT formats.
     * @param fileName Name of the file on cloud
     * @param designatedFormat A format to which email message will be converted
     * @return A path to the locally saved file
     * @throws java.security.InvalidKeyException      If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException                    If there is an IO error
     */
    public static String convertEmailToFormat(String fileName, String designatedFormat) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        String localFilePath = null;

        if (fileName == null || fileName.length() <= 3) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if (designatedFormat == null || designatedFormat.length() == 0) {
            throw new IllegalArgumentException("Designated format cannot be null or empty");
        }

        String srcFileExtension = fileName.substring(fileName.length() - 3);
        if (!validFormats.contains(designatedFormat) || !validFormats.contains(srcFileExtension)) {
            throw new IllegalArgumentException("Valid Formats for Email document are eml, mht and msg");
        }

        //build URL
        String strURL = EMAIL_URI + Uri.encode(fileName) + "?format=" + designatedFormat;
        //sign URL
        String signedURL = Utils.sign(strURL);
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Replace fileName extension with designated format
        String[] fileNameAndItsExtensionArray = fileName.split("\\.");
        fileName = fileNameAndItsExtensionArray[0] + "." + designatedFormat;

        //Save file on Disk
        localFilePath = Utils.saveStreamToFile(responseStream, fileName);
        return localFilePath;
    }

    /**
     * Download attachment from Message
     * @param fileName       Name of the file on cloud
     * @param attachmentName Name of attachment to download
     * @return A path to the locally saved attachment file
     * @throws java.security.InvalidKeyException      If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException                    If there is an IO error
     */
    public static String getEmailAttachment(String fileName, String attachmentName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String localAttachmentPath = null;

        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if (attachmentName == null || attachmentName.length() == 0) {
            throw new IllegalArgumentException("Attachment name cannot be null or empty");
        }

        //build URL
        String strURL = EMAIL_URI + Uri.encode(fileName) + "/attachments/" + Uri.encode(attachmentName);
        //sign URL
        String signedURL = Utils.sign(strURL);
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save attachment on Disk
        localAttachmentPath = Utils.saveStreamToFile(responseStream, attachmentName);
        return localAttachmentPath;
    }

    /**
     * Add attachment to a message
     * @param fileName Message name
     * @param attachmentName Attachment name
     * @return An object that contains add attachment to a message response
     * @throws java.security.InvalidKeyException      If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException                    If there is an IO error
     */
    public static AddEmailAttachmentResponse addEmailAttachment(String fileName, String attachmentName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        AddEmailAttachmentResponse addEmailAttachmentResponse = null;

        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if (attachmentName == null || attachmentName.length() == 0) {
            throw new IllegalArgumentException("Attachment name cannot be null or empty");
        }

        //build URL
        String strURL = EMAIL_URI + Uri.encode(fileName) + "/attachments/" + Uri.encode(attachmentName);
        //sign URL
        String signedURL = Utils.sign(strURL);
        InputStream responseStream = Utils.processCommand(signedURL, "POST");
        String jsonStr = Utils.streamToString(responseStream);

        //Parsing JSON
        Gson gson = new Gson();
        addEmailAttachmentResponse = gson.fromJson(jsonStr, AddEmailAttachmentResponse.class);
        if (addEmailAttachmentResponse.getCode().equals("200") && addEmailAttachmentResponse.getStatus().equals("OK")) {
            return addEmailAttachmentResponse;
        }

        return addEmailAttachmentResponse;
    }

    /**
     * Add new email
     * @param emailName The email name
     * @param emailData Email data
     * @return An object that contains add new email response
     * @throws java.security.InvalidKeyException      If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException                    If there is an IO error
     */
    public static AddNewEmailResponse addNewEmail(String emailName, EmailDocument emailData) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        AddNewEmailResponse addNewEmailResponse = null;

        if (emailName == null || emailName.length() == 0) {
            throw new IllegalArgumentException("Email name cannot be null or empty");
        }

        if (emailData == null) {
            throw new IllegalArgumentException("Email data cannot be null");
        }

        //build URL
        String strURL = EMAIL_URI + Uri.encode(emailName);
        //sign URL
        String signedURL = Utils.sign(strURL);

        //Encoding to JSON
        Gson gson = new Gson();
        String jsonStr = gson.toJson(emailData);

        InputStream responseStream = Utils.processCommand(signedURL, "PUT", jsonStr);
        String responseStr = Utils.streamToString(responseStream);

        //Parsing JSON
        addNewEmailResponse = gson.fromJson(responseStr, AddNewEmailResponse.class);
        if (addNewEmailResponse.getCode().equals("200") && addNewEmailResponse.getStatus().equals("OK")) {
            return addNewEmailResponse;
        }

        return addNewEmailResponse;
    }

    /**
     * Retrieve Message Properties like From, To, Subject, Bcc, CC, Body, Date, Priority and Attachments
     * @param fileName Name of the file on cloud
     * @param propertyName Property whose value needs to be retrieved
     * @return Property value
     * @throws java.security.InvalidKeyException      If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException                    If there is an IO error
     */
    public static String getEmailProperty(String fileName, String propertyName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String propertyValue = null;

        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if (propertyName == null || propertyName.length() == 0) {
            throw new IllegalArgumentException("Property name cannot be null or empty");
        }

        if (!validEmailProperties.contains(propertyName.toLowerCase(Locale.US))) {
            throw new IllegalArgumentException("Valid email properties are Bcc, Body, CC, Date, " +
                    "DeliveryNotificationOptions, From, To, HtmlBody, IsBodyHtml, MessageId, Priority, Subject, " +
                    "TextBody, Attachments");
        }

        //build URL
        String strURL = EMAIL_URI + Uri.encode(fileName) + "/properties/" + Uri.encode(propertyName);
        //sign URL
        String signedURL = Utils.sign(strURL);
        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        String jsonStr = Utils.streamToString(responseStream);

        //Parsing JSON
        Gson gson = new Gson();
        EmailPropertyResponse emailPropertyResponse = gson.fromJson(jsonStr, EmailPropertyResponse.class);
        if (emailPropertyResponse.getCode().equals("200") && emailPropertyResponse.getStatus().equals("OK")) {
            propertyValue = (String) emailPropertyResponse.emailProperty.value;
        }

        //Return desired email property value
        return propertyValue;
    }

    /**
     * Set Message Properties like From, To, Subject, Bcc, CC, Body, Date, Priority and Attachments
     * @param fileName      Name of the file on cloud
     * @param propertyName  Property to be updated
     * @param propertyValue A property value to be set
     * @return Indicates whether email property updated successfully or not
     * @throws java.security.InvalidKeyException      If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException                    If there is an IO error
     */
    public static boolean setEmailProperty(String fileName, String propertyName, String propertyValue) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        boolean isPropertyUpdated = false;

        if (fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if (propertyName == null || propertyName.length() == 0) {
            throw new IllegalArgumentException("Property name cannot be null or empty");
        }

        if (propertyValue == null) {
            throw new IllegalArgumentException("Property value cannot be null");
        }

        if (!validEmailProperties.contains(propertyName.toLowerCase(Locale.US))) {
            throw new IllegalArgumentException("Valid email properties are Bcc, Body, CC, Date, " +
                    "DeliveryNotificationOptions, From, To, HtmlBody, IsBodyHtml, MessageId, Priority, Subject, " +
                    "TextBody, Attachments");
        }

        //build URL
        String strURL = EMAIL_URI + Uri.encode(fileName) + "/properties/" + Uri.encode(propertyName);
        //sign URL
        String signedURL = Utils.sign(strURL);

        EmailProperty emailProperty = new EmailProperty();
        emailProperty.name = propertyName;
        emailProperty.value = propertyValue;

        //Encoding to JSON
        Gson gson = new Gson();
        String jsonStr = gson.toJson(emailProperty);

        InputStream responseStream = Utils.processCommand(signedURL, "PUT", jsonStr);
        String responseStr = Utils.streamToString(responseStream);

        //Parsing JSON
        EmailPropertyResponse emailPropertyResponse = gson.fromJson(responseStr, EmailPropertyResponse.class);
        if (emailPropertyResponse.getCode().equals("200") && emailPropertyResponse.getStatus().equals("OK")) {
            isPropertyUpdated = true;
        }

        return isPropertyUpdated;
    }
}
