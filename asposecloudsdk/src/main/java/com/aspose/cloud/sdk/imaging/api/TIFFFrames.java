package com.aspose.cloud.sdk.imaging.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.imaging.model.ImagePropertiesResponse;
import com.aspose.cloud.sdk.imaging.model.ManipulateTIFFFrameKeys;
import com.aspose.cloud.sdk.imaging.model.TIFFFrameRotateFlipMethodEnum;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * TIFFFrames --- Using this class you can get properties of a tiff frame, extract frame from tiff image and perform operations on it like resize, crop and RotateFlip.
 * @author   M. Sohail Ismail
 */
public class TIFFFrames {

    private static final String IMAGING_URI = AsposeApp.BASE_PRODUCT_URI + "/imaging/";

    /**
     * Get properties of a tiff frame.
     * @param fileName Filename with image.
     * @param frameID Number of frame.
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return An object that contains image properties
     */
    public static ImagePropertiesResponse getTIFFFrameProperties(String fileName, int frameID) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        ImagePropertiesResponse imgPropertiesResponse = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        //Build the request URI
        String strURL = IMAGING_URI + fileName + "/frames/" + frameID + "/properties";

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        String jsonStr = Utils.streamToString(responseStream);

        //Parsing JSON
        Gson gson = new Gson();
        imgPropertiesResponse = gson.fromJson(jsonStr, ImagePropertiesResponse.class);
        if(imgPropertiesResponse.getCode().equals("200") && imgPropertiesResponse.getStatus().equals("OK")) {
            return imgPropertiesResponse;
        }

        return imgPropertiesResponse;
    }

    /**
     * Get separate frame of tiff image.
     * @param fileName Filename with image.
     * @param frameID Number of frame.
     * @param outFileName Save file on device with this name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Path to extracted Tiff frame saved on device
     */
    public static String extractFrameFromAMultiFrameTIFFImage(String fileName, int frameID, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        String outFilePath = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(outFileName == null || outFileName.length() == 0) {
            throw new IllegalArgumentException("Out file name cannot be null or empty");
        }

        //Build the request URI
        String strURL = IMAGING_URI + fileName + "/frames/" + frameID;

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, outFileName);

        return outFilePath;
    }

    /**
     * Extract a frame from a Tiff image, resize it and save separately on device
     * @param fileName Filename with image.
     * @param frameID Number of frame.
     * @param newWidth New width of the scaled image.
     * @param newHeight New height of the scaled image.
     * @param outFileName Save file on device with this name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Path to resized Tiff frame saved on device
     */
    public static String resizeATIFFFrame(String fileName, int frameID, int newWidth, int newHeight, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        String outFilePath = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(outFileName == null || outFileName.length() == 0) {
            throw new IllegalArgumentException("Out file name cannot be null or empty");
        }

        //Build the request URI
        String strURL = IMAGING_URI + fileName + "/frames/" + frameID + "?newWidth=" + newWidth + "&newHeight=" + newHeight;

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, outFileName);

        return outFilePath;

    }

    /**
     * Extract a frame from a Tiff image, crop it and save separately on device
     * @param fileName Filename with image.
     * @param frameID Number of frame.
     * @param x X position of start point for cropping rectangle
     * @param y Y position of start point for cropping rectangle
     * @param rectWidth Width of cropping rectangle
     * @param rectHeight Height of cropping rectangle
     * @param outFileName Save file on device with this name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Path to cropped Tiff frame saved on device
     */
    public static String cropATIFFFrame(String fileName, int frameID, int x, int y, int rectWidth, int rectHeight, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        String outFilePath = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(outFileName == null || outFileName.length() == 0) {
            throw new IllegalArgumentException("Out file name cannot be null or empty");
        }

        //Build the request URI
        String strURL = IMAGING_URI + fileName + "/frames/" + frameID + "?x=" + x + "&y=" + y + "&rectWidth=" + rectWidth + "&rectHeight=" + rectHeight;

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, outFileName);

        return outFilePath;

    }

    /**
     * Perform RotateFlip operation on a frame of Tiff image and save it separately on the device
     * @param fileName Filename with image.
     * @param frameID Number of frame.
     * @param rotateFlipMethod RotateFlip method. Please see class TIFFFrameRotateFlipMethodEnum for valid values.
     * @param outFileName Save file on device with this name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Path to rotateflipped Tiff frame saved on device
     */
    public static String rotateFlipATIFFFrame(String fileName, int frameID, TIFFFrameRotateFlipMethodEnum rotateFlipMethod, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        String outFilePath = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(outFileName == null || outFileName.length() == 0) {
            throw new IllegalArgumentException("Out file name cannot be null or empty");
        }

        //Build the request URI
        String strURL = IMAGING_URI + fileName + "/frames/" + frameID + "?rotateFlipMethod=" + rotateFlipMethod;

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, outFileName);

        return outFilePath;

    }

    /**
     * Perform several operations such as RotateFlip, Resize and Crop on a frame of Tiff image and save the updated multi-frame TIFF image on the device
     * @param fileName Filename with image.
     * @param frameID Number of frame.
     * @param manipulateTIFFFrameParameters HashMap contains operations to perform on a frame of Tiff image. Values could be following
     *                                      newWidth New width of the scaled image.
     *                                      newHeight New height of the scaled image.
     *                                      x X position of start point for cropping rectangle
     *                                      y Y position of start point for cropping rectangle
     *                                      rectWidth Width of cropping rectangle
     *                                      rectHeight Height of cropping rectangle
     *                                      rotateFlipMethod RotateFlip method. Please see class TIFFFrameRotateFlipMethodEnum for valid values.
     *                                      saveOtherFrames Include all other frames or just specified frame in response.
     *                                      outPath Path to updated file, if this is empty, response contains streamed image.
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Path to updated Tiff image saved on device
     */
    public static String manipulateATIFFFrame(String fileName, int frameID, HashMap<String, String> manipulateTIFFFrameParameters) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        String outFilePath = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(manipulateTIFFFrameParameters == null) {
            throw new IllegalArgumentException("manipulateTIFFFrameParameters cannot be null");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + fileName + "/frames/" + frameID + "?").buildUpon();

        if(manipulateTIFFFrameParameters.containsKey(ManipulateTIFFFrameKeys.newWidth)) {
            String newWidth = manipulateTIFFFrameParameters.get(ManipulateTIFFFrameKeys.newWidth);
            uriBuilder.appendQueryParameter(ManipulateTIFFFrameKeys.newWidth, newWidth);
        }
        if(manipulateTIFFFrameParameters.containsKey(ManipulateTIFFFrameKeys.newHeight)) {
            String newHeight = manipulateTIFFFrameParameters.get(ManipulateTIFFFrameKeys.newHeight);
            uriBuilder.appendQueryParameter(ManipulateTIFFFrameKeys.newHeight, newHeight);
        }
        if(manipulateTIFFFrameParameters.containsKey(ManipulateTIFFFrameKeys.x)) {
            String x = manipulateTIFFFrameParameters.get(ManipulateTIFFFrameKeys.x);
            uriBuilder.appendQueryParameter(ManipulateTIFFFrameKeys.x, x);
        }
        if(manipulateTIFFFrameParameters.containsKey(ManipulateTIFFFrameKeys.y)) {
            String y = manipulateTIFFFrameParameters.get(ManipulateTIFFFrameKeys.y);
            uriBuilder.appendQueryParameter(ManipulateTIFFFrameKeys.y, y);
        }
        if(manipulateTIFFFrameParameters.containsKey(ManipulateTIFFFrameKeys.rectWidth)) {
            String rectWidth = manipulateTIFFFrameParameters.get(ManipulateTIFFFrameKeys.rectWidth);
            uriBuilder.appendQueryParameter(ManipulateTIFFFrameKeys.rectWidth, rectWidth);
        }
        if(manipulateTIFFFrameParameters.containsKey(ManipulateTIFFFrameKeys.rectHeight)) {
            String rectHeight = manipulateTIFFFrameParameters.get(ManipulateTIFFFrameKeys.rectHeight);
            uriBuilder.appendQueryParameter(ManipulateTIFFFrameKeys.rectHeight, rectHeight);
        }
        if(manipulateTIFFFrameParameters.containsKey(ManipulateTIFFFrameKeys.rotateFlipMethod)) {
            String rotateFlipMethod = manipulateTIFFFrameParameters.get(ManipulateTIFFFrameKeys.rotateFlipMethod);
            uriBuilder.appendQueryParameter(ManipulateTIFFFrameKeys.rotateFlipMethod, rotateFlipMethod);
        }
        if(manipulateTIFFFrameParameters.containsKey(ManipulateTIFFFrameKeys.saveOtherFrames)) {
            String saveOtherFrames = manipulateTIFFFrameParameters.get(ManipulateTIFFFrameKeys.saveOtherFrames);
            uriBuilder.appendQueryParameter(ManipulateTIFFFrameKeys.saveOtherFrames, saveOtherFrames);
        }
        if(manipulateTIFFFrameParameters.containsKey(ManipulateTIFFFrameKeys.outPath)) {
            String outPath = manipulateTIFFFrameParameters.get(ManipulateTIFFFrameKeys.outPath);
            uriBuilder.appendQueryParameter(ManipulateTIFFFrameKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, fileName);

        return outFilePath;

    }
}
