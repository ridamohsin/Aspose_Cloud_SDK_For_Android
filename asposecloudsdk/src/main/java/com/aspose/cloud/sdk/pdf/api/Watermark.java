package com.aspose.cloud.sdk.pdf.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.pdf.model.StampModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by muhammadsohailismail on 5/7/15.
 */
public class Watermark {
    private static final String PDF_URI = AsposeApp.BASE_PRODUCT_URI + "/pdf/";

    public static boolean addTextStampToAPDFPage(String fileName, int pageNumber, StampModel stampData, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        boolean isTextStampAddedSuccessfully = false;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(stampData == null) {
            throw new IllegalArgumentException("Stamp data cannot be null");
        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String requestJSONString = gson.toJson(stampData, StampModel.class);

        //build URL
        StringBuilder strURL = new StringBuilder(PDF_URI + Uri.encode(fileName) + "/pages/" + pageNumber + "/stamp");
        //If document is on the third party storage
        if(storageName != null && storageName.length() != 0) {
            strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
            strURL.append("storage=" + storageName);
        }
        //In case if file is not at root folder
        if(folderName != null && folderName.length() != 0) {
            strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
            strURL.append("folder=" + folderName);
        }

        //sign URL
        String signedURL = Utils.sign(strURL.toString());
        InputStream responseStream = Utils.processCommand(signedURL, "PUT", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
        if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
            isTextStampAddedSuccessfully = true;
        }

        return isTextStampAddedSuccessfully;
    }

    public static boolean addImageStampToAPDFPage(String fileName, int pageNumber, StampModel stampData, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        boolean isImageStampAddedSuccessfully = false;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(stampData == null) {
            throw new IllegalArgumentException("Stamp data cannot be null");
        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String requestJSONString = gson.toJson(stampData, StampModel.class);

        //build URL
        StringBuilder strURL = new StringBuilder(PDF_URI + Uri.encode(fileName) + "/pages/" + pageNumber + "/stamp");
        //If document is on the third party storage
        if(storageName != null && storageName.length() != 0) {
            strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
            strURL.append("storage=" + storageName);
        }
        //In case if file is not at root folder
        if(folderName != null && folderName.length() != 0) {
            strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
            strURL.append("folder=" + folderName);
        }

        //sign URL
        String signedURL = Utils.sign(strURL.toString());
        InputStream responseStream = Utils.processCommand(signedURL, "PUT", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
        if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
            isImageStampAddedSuccessfully = true;
        }

        return isImageStampAddedSuccessfully;
    }

    public static boolean addPDFPageAsStampToAPDFPage(String fileName, int pageNumber, StampModel stampData, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        boolean isPDFPageAsStampAddedSuccessfully = false;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(stampData == null) {
            throw new IllegalArgumentException("Stamp data cannot be null");
        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String requestJSONString = gson.toJson(stampData, StampModel.class);

        //build URL
        StringBuilder strURL = new StringBuilder(PDF_URI + Uri.encode(fileName) + "/pages/" + pageNumber + "/stamp");
        //If document is on the third party storage
        if(storageName != null && storageName.length() != 0) {
            strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
            strURL.append("storage=" + storageName);
        }
        //In case if file is not at root folder
        if(folderName != null && folderName.length() != 0) {
            strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
            strURL.append("folder=" + folderName);
        }

        //sign URL
        String signedURL = Utils.sign(strURL.toString());
        InputStream responseStream = Utils.processCommand(signedURL, "PUT", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
        if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
            isPDFPageAsStampAddedSuccessfully = true;
        }

        return isPDFPageAsStampAddedSuccessfully;
    }

    public static boolean addPageNumberStampToAPDFPage(String fileName, int pageNumber, StampModel stampData, String storageName, String folderName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        boolean isPageNumberStampAddedSuccessfully = false;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(stampData == null) {
            throw new IllegalArgumentException("Stamp data cannot be null");
        }

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String requestJSONString = gson.toJson(stampData, StampModel.class);

        //build URL
        StringBuilder strURL = new StringBuilder(PDF_URI + Uri.encode(fileName) + "/pages/" + pageNumber + "/stamp");
        //If document is on the third party storage
        if(storageName != null && storageName.length() != 0) {
            strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
            strURL.append("storage=" + storageName);
        }
        //In case if file is not at root folder
        if(folderName != null && folderName.length() != 0) {
            strURL.append((strURL.indexOf("?") == -1) ? "?" : "&");
            strURL.append("folder=" + folderName);
        }

        //sign URL
        String signedURL = Utils.sign(strURL.toString());
        InputStream responseStream = Utils.processCommand(signedURL, "PUT", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
        if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
            isPageNumberStampAddedSuccessfully = true;
        }

        return isPageNumberStampAddedSuccessfully;
    }
}
