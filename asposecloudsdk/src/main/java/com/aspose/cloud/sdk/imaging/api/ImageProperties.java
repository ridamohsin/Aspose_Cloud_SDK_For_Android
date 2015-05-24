package com.aspose.cloud.sdk.imaging.api;

import android.net.Uri;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.imaging.model.BMPImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.GIFImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.ImagePropertiesResponse;
import com.aspose.cloud.sdk.imaging.model.JPGImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.PNGImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.PSDImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.TIFFImagePropertiesKeys;
import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * ImageProperties --- Using this class you can get properties of an image and update properties of BMP, GIF, TIFF, JPG, PNG and PSD image.
 * @author   M. Sohail Ismail
 */
public class ImageProperties {
    private static final String IMAGING_URI = AsposeApp.BASE_PRODUCT_URI + "/imaging/";

    /**
     * Update parameters of bmp image.
     * @param fileName Filename of image
     * @param bmpImageProperties HashMap of BMP image properties. Values could be following
     *                           bitsPerPixel Color depth
     *                           horizontalResolution New horizontal resolution
     *                           verticalResolution New vertical resolution
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated BMP image saved on device
     */
    public static String updateBMPImageProperties(String fileName, HashMap<String, String> bmpImageProperties) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String localFilePath = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + Uri.encode(fileName) + "/bmp?").buildUpon();

        if(bmpImageProperties.containsKey(BMPImagePropertiesKeys.bitsPerPixel)) {
            String bitsPerPixel = bmpImageProperties.get(BMPImagePropertiesKeys.bitsPerPixel);
            uriBuilder.appendQueryParameter(BMPImagePropertiesKeys.bitsPerPixel, bitsPerPixel);
        }
        if(bmpImageProperties.containsKey(BMPImagePropertiesKeys.horizontalResolution)) {
            String horizontalResolution = bmpImageProperties.get(BMPImagePropertiesKeys.horizontalResolution);
            uriBuilder.appendQueryParameter(BMPImagePropertiesKeys.horizontalResolution, horizontalResolution);
        }
        if(bmpImageProperties.containsKey(BMPImagePropertiesKeys.verticalResolution)) {
            String verticalResolution = bmpImageProperties.get(BMPImagePropertiesKeys.verticalResolution);
            uriBuilder.appendQueryParameter(BMPImagePropertiesKeys.verticalResolution, verticalResolution);
        }
        if(bmpImageProperties.containsKey(BMPImagePropertiesKeys.fromScratch)) {
            String fromScratch = bmpImageProperties.get(BMPImagePropertiesKeys.fromScratch);
            uriBuilder.appendQueryParameter(BMPImagePropertiesKeys.fromScratch, fromScratch);
        }
        if(bmpImageProperties.containsKey(BMPImagePropertiesKeys.outPath)) {
            String outPath = bmpImageProperties.get(BMPImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(BMPImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save the stream in response to the disk
        localFilePath = Utils.saveStreamToFile(responseStream, fileName);

        return localFilePath;
    }

    /**
     * Update parameters of bmp image stored on device
     * @param localFilePath Path to file stored on device
     * @param bmpImageProperties HashMap of BMP image properties. Values could be following
     *                           bitsPerPixel Color depth
     *                           horizontalResolution New horizontal resolution
     *                           verticalResolution New vertical resolution
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @param outFileName Updated BMP image save on device with this name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated BMP image saved on device
     */
    public static String updateBMPImagePropertiesWithoutStorage(String localFilePath, HashMap<String, String> bmpImageProperties, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String outFilePath = null;

        if(localFilePath == null || localFilePath.length() == 0) {
            throw new IllegalArgumentException("Local file path cannot be null or empty");
        }

        if(outFileName == null || outFileName.length() == 0) {
            throw new IllegalArgumentException("Out file name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + "bmp?").buildUpon();

        if(bmpImageProperties.containsKey(BMPImagePropertiesKeys.bitsPerPixel)) {
            String bitsPerPixel = bmpImageProperties.get(BMPImagePropertiesKeys.bitsPerPixel);
            uriBuilder.appendQueryParameter(BMPImagePropertiesKeys.bitsPerPixel, bitsPerPixel);
        }
        if(bmpImageProperties.containsKey(BMPImagePropertiesKeys.horizontalResolution)) {
            String horizontalResolution = bmpImageProperties.get(BMPImagePropertiesKeys.horizontalResolution);
            uriBuilder.appendQueryParameter(BMPImagePropertiesKeys.horizontalResolution, horizontalResolution);
        }
        if(bmpImageProperties.containsKey(BMPImagePropertiesKeys.verticalResolution)) {
            String verticalResolution = bmpImageProperties.get(BMPImagePropertiesKeys.verticalResolution);
            uriBuilder.appendQueryParameter(BMPImagePropertiesKeys.verticalResolution, verticalResolution);
        }
        if(bmpImageProperties.containsKey(BMPImagePropertiesKeys.fromScratch)) {
            String fromScratch = bmpImageProperties.get(BMPImagePropertiesKeys.fromScratch);
            uriBuilder.appendQueryParameter(BMPImagePropertiesKeys.fromScratch, fromScratch);
        }
        if(bmpImageProperties.containsKey(BMPImagePropertiesKeys.outPath)) {
            String outPath = bmpImageProperties.get(BMPImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(BMPImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Convert the local file to InputStream
        InputStream fileStream = new FileInputStream(localFilePath);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "POST", fileStream);

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, outFileName);

        return outFilePath;
    }

    /**
     * Update parameters of GIF image.
     * @param fileName Filename of image
     * @param gifImageProperties HashMap of GIF image properties. Values could be following
     *                           backgroundColorIndex Index of the background color.
     *                           colorResolution Color resolution.
     *                           hasTrailer Specifies if image has trailer.
     *                           interlaced Specifies if image is interlaced.
     *                           isPaletteSorted Specifies if palette is sorted.
     *                           pixelAspectRatio Pixel aspect ratio.
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated GIF image saved on device
     */
    public static String updateGIFImageProperties(String fileName, HashMap<String, String> gifImageProperties) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        String localFilePath = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + Uri.encode(fileName) + "/gif?").buildUpon();

        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.backgroundColorIndex)) {
            String backgroundColorIndex = gifImageProperties.get(GIFImagePropertiesKeys.backgroundColorIndex);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.backgroundColorIndex, backgroundColorIndex);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.colorResolution)) {
            String colorResolution = gifImageProperties.get(GIFImagePropertiesKeys.colorResolution);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.colorResolution, colorResolution);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.hasTrailer)) {
            String hasTrailer = gifImageProperties.get(GIFImagePropertiesKeys.hasTrailer);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.hasTrailer, hasTrailer);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.interlaced)) {
            String interlaced = gifImageProperties.get(GIFImagePropertiesKeys.interlaced);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.interlaced, interlaced);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.isPaletteSorted)) {
            String isPaletteSorted = gifImageProperties.get(GIFImagePropertiesKeys.isPaletteSorted);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.isPaletteSorted, isPaletteSorted);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.pixelAspectRatio)) {
            String pixelAspectRatio = gifImageProperties.get(GIFImagePropertiesKeys.pixelAspectRatio);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.pixelAspectRatio, pixelAspectRatio);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.fromScratch)) {
            String fromScratch = gifImageProperties.get(GIFImagePropertiesKeys.fromScratch);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.fromScratch, fromScratch);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.outPath)) {
            String outPath = gifImageProperties.get(GIFImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save the stream in response to the disk
        localFilePath = Utils.saveStreamToFile(responseStream, fileName);

        return localFilePath;
    }

    /**
     * Update parameters of GIF image stored on device
     * @param localFilePath Path to file stored on device
     * @param gifImageProperties HashMap of GIF image properties. Values could be following
     *                           backgroundColorIndex Index of the background color.
     *                           colorResolution Color resolution.
     *                           hasTrailer Specifies if image has trailer.
     *                           interlaced Specifies if image is interlaced.
     *                           isPaletteSorted Specifies if palette is sorted.
     *                           pixelAspectRatio Pixel aspect ratio.
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @param outFileName Updated GIF image save on device with this name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated GIF image saved on device
     */
    public static String updateGIFImagePropertiesWithoutStorage(String localFilePath, HashMap<String, String> gifImageProperties, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String outFilePath = null;

        if(localFilePath == null || localFilePath.length() == 0) {
            throw new IllegalArgumentException("Local file path cannot be null or empty");
        }

        if(outFileName == null || outFileName.length() == 0) {
            throw new IllegalArgumentException("Out file name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + "gif?").buildUpon();

        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.backgroundColorIndex)) {
            String backgroundColorIndex = gifImageProperties.get(GIFImagePropertiesKeys.backgroundColorIndex);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.backgroundColorIndex, backgroundColorIndex);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.colorResolution)) {
            String colorResolution = gifImageProperties.get(GIFImagePropertiesKeys.colorResolution);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.colorResolution, colorResolution);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.hasTrailer)) {
            String hasTrailer = gifImageProperties.get(GIFImagePropertiesKeys.hasTrailer);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.hasTrailer, hasTrailer);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.interlaced)) {
            String interlaced = gifImageProperties.get(GIFImagePropertiesKeys.interlaced);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.interlaced, interlaced);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.isPaletteSorted)) {
            String isPaletteSorted = gifImageProperties.get(GIFImagePropertiesKeys.isPaletteSorted);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.isPaletteSorted, isPaletteSorted);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.pixelAspectRatio)) {
            String pixelAspectRatio = gifImageProperties.get(GIFImagePropertiesKeys.pixelAspectRatio);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.pixelAspectRatio, pixelAspectRatio);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.fromScratch)) {
            String fromScratch = gifImageProperties.get(GIFImagePropertiesKeys.fromScratch);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.fromScratch, fromScratch);
        }
        if(gifImageProperties.containsKey(GIFImagePropertiesKeys.outPath)) {
            String outPath = gifImageProperties.get(GIFImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(GIFImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Convert the local file to InputStream
        InputStream fileStream = new FileInputStream(localFilePath);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "POST", fileStream);

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, outFileName);

        return outFilePath;
    }

    /**
     * Update parameters of TIFF image stored on device
     * @param localFilePath Path to file stored on device
     * @param tiffImageProperties HashMap of TIFF image properties. Values could be following
     *                           compression New compression.
     *                           resolutionUnit New resolution unit.
     *                           bitDepth New bit depth.
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           horizontalResolution New horizontal resolution.
     *                           verticalResolution New vertical resolution.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @param outFileName Updated TIFF image save on device with this name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated TIFF image saved on device
     */
    public static String updateTIFFImagePropertiesWithoutStorage(String localFilePath, HashMap<String, String> tiffImageProperties, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String outFilePath = null;

        if(localFilePath == null || localFilePath.length() == 0) {
            throw new IllegalArgumentException("Local file path cannot be null or empty");
        }

        if(outFileName == null || outFileName.length() == 0) {
            throw new IllegalArgumentException("Out file name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + "tiff?").buildUpon();

        if(tiffImageProperties.containsKey(TIFFImagePropertiesKeys.compression)) {
            String compression = tiffImageProperties.get(TIFFImagePropertiesKeys.compression);
            uriBuilder.appendQueryParameter(TIFFImagePropertiesKeys.compression, compression);
        }
        if(tiffImageProperties.containsKey(TIFFImagePropertiesKeys.resolutionUnit)) {
            String resolutionUnit = tiffImageProperties.get(TIFFImagePropertiesKeys.resolutionUnit);
            uriBuilder.appendQueryParameter(TIFFImagePropertiesKeys.resolutionUnit, resolutionUnit);
        }
        if(tiffImageProperties.containsKey(TIFFImagePropertiesKeys.bitDepth)) {
            String bitDepth = tiffImageProperties.get(TIFFImagePropertiesKeys.bitDepth);
            uriBuilder.appendQueryParameter(TIFFImagePropertiesKeys.bitDepth, bitDepth);
        }
        if(tiffImageProperties.containsKey(TIFFImagePropertiesKeys.newWidth)) {
            String newWidth = tiffImageProperties.get(TIFFImagePropertiesKeys.newWidth);
            uriBuilder.appendQueryParameter(TIFFImagePropertiesKeys.newWidth, newWidth);
        }
        if(tiffImageProperties.containsKey(TIFFImagePropertiesKeys.newHeight)) {
            String newHeight = tiffImageProperties.get(TIFFImagePropertiesKeys.newHeight);
            uriBuilder.appendQueryParameter(TIFFImagePropertiesKeys.newHeight, newHeight);
        }
        if(tiffImageProperties.containsKey(TIFFImagePropertiesKeys.horizontalResolution)) {
            String horizontalResolution = tiffImageProperties.get(TIFFImagePropertiesKeys.horizontalResolution);
            uriBuilder.appendQueryParameter(TIFFImagePropertiesKeys.horizontalResolution, horizontalResolution);
        }
        if(tiffImageProperties.containsKey(TIFFImagePropertiesKeys.verticalResolution)) {
            String verticalResolution = tiffImageProperties.get(TIFFImagePropertiesKeys.verticalResolution);
            uriBuilder.appendQueryParameter(TIFFImagePropertiesKeys.verticalResolution, verticalResolution);
        }
        if(tiffImageProperties.containsKey(TIFFImagePropertiesKeys.outPath)) {
            String outPath = tiffImageProperties.get(TIFFImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(TIFFImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Convert the local file to InputStream
        InputStream fileStream = new FileInputStream(localFilePath);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "POST", fileStream);

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, outFileName);

        return outFilePath;
    }

    /**
     * Update parameters of JPG image.
     * @param fileName Filename of image
     * @param jpgImageProperties HashMap of JPG image properties. Values could be following
     *                           quality Quality of image. From 0 to 100. Default is 75
     *                           compressionType Compression type.
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated JPG image saved on device
     */
    public static String updateJPGImageProperties(String fileName, HashMap<String, String> jpgImageProperties) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        String localFilePath = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + Uri.encode(fileName) + "/jpg?").buildUpon();

        if(jpgImageProperties.containsKey(JPGImagePropertiesKeys.quality)) {
            String quality = jpgImageProperties.get(JPGImagePropertiesKeys.quality);
            uriBuilder.appendQueryParameter(JPGImagePropertiesKeys.quality, quality);
        }
        if(jpgImageProperties.containsKey(JPGImagePropertiesKeys.compressionType)) {
            String compressionType = jpgImageProperties.get(JPGImagePropertiesKeys.compressionType);
            uriBuilder.appendQueryParameter(JPGImagePropertiesKeys.compressionType, compressionType);
        }
        if(jpgImageProperties.containsKey(JPGImagePropertiesKeys.fromScratch)) {
            String fromScratch = jpgImageProperties.get(JPGImagePropertiesKeys.fromScratch);
            uriBuilder.appendQueryParameter(JPGImagePropertiesKeys.fromScratch, fromScratch);
        }
        if(jpgImageProperties.containsKey(JPGImagePropertiesKeys.outPath)) {
            String outPath = jpgImageProperties.get(JPGImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(JPGImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save the stream in response to the disk
        localFilePath = Utils.saveStreamToFile(responseStream, fileName);

        return localFilePath;
    }

    /**
     * Update parameters of JPG image stored on device
     * @param localFilePath Path to file stored on device
     * @param jpgImageProperties HashMap of JPG image properties. Values could be following
     *                           quality Quality of image. From 0 to 100. Default is 75
     *                           compressionType Compression type.
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @param outFileName        Updated JPG image save on device with this name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated JPG image saved on device
     */
    public static String updateJPGImagePropertiesWithoutStorage(String localFilePath, HashMap<String, String> jpgImageProperties, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String outFilePath = null;

        if(localFilePath == null || localFilePath.length() == 0) {
            throw new IllegalArgumentException("Local file path cannot be null or empty");
        }

        if(outFileName == null || outFileName.length() == 0) {
            throw new IllegalArgumentException("Out file name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + "jpg?").buildUpon();

        if(jpgImageProperties.containsKey(JPGImagePropertiesKeys.quality)) {
            String quality = jpgImageProperties.get(JPGImagePropertiesKeys.quality);
            uriBuilder.appendQueryParameter(JPGImagePropertiesKeys.quality, quality);
        }
        if(jpgImageProperties.containsKey(JPGImagePropertiesKeys.compressionType)) {
            String compressionType = jpgImageProperties.get(JPGImagePropertiesKeys.compressionType);
            uriBuilder.appendQueryParameter(JPGImagePropertiesKeys.compressionType, compressionType);
        }
        if(jpgImageProperties.containsKey(JPGImagePropertiesKeys.fromScratch)) {
            String fromScratch = jpgImageProperties.get(JPGImagePropertiesKeys.fromScratch);
            uriBuilder.appendQueryParameter(JPGImagePropertiesKeys.fromScratch, fromScratch);
        }
        if(jpgImageProperties.containsKey(JPGImagePropertiesKeys.outPath)) {
            String outPath = jpgImageProperties.get(JPGImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(JPGImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Convert the local file to InputStream
        InputStream fileStream = new FileInputStream(localFilePath);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "POST", fileStream);

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, outFileName);

        return outFilePath;
    }

    /**
     * Update parameters of PNG image.
     * @param fileName Filename of image
     * @param pngImageProperties HashMap of PNG image properties. Values could be following
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated PNG image saved on device
     */
    public static String updatePNGImageProperties(String fileName, HashMap<String, String> pngImageProperties) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        String localFilePath = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + Uri.encode(fileName) + "/png?").buildUpon();

        if(pngImageProperties.containsKey(PNGImagePropertiesKeys.fromScratch)) {
            String fromScratch = pngImageProperties.get(PNGImagePropertiesKeys.fromScratch);
            uriBuilder.appendQueryParameter(PNGImagePropertiesKeys.fromScratch, fromScratch);
        }
        if(pngImageProperties.containsKey(PNGImagePropertiesKeys.outPath)) {
            String outPath = pngImageProperties.get(PNGImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(PNGImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save the stream in response to the disk
        localFilePath = Utils.saveStreamToFile(responseStream, fileName);

        return localFilePath;
    }

    /**
     * Update parameters of PNG image stored on device
     * @param localFilePath Path to file stored on device
     * @param pngImageProperties HashMap of PNG image properties. Values could be following
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @param outFileName        Updated PNG image save on device with this name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated PNG image saved on device
     */
    public static String updatePNGImagePropertiesWithoutStorage(String localFilePath, HashMap<String, String> pngImageProperties, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String outFilePath = null;

        if(localFilePath == null || localFilePath.length() == 0) {
            throw new IllegalArgumentException("Local file path cannot be null or empty");
        }

        if(outFileName == null || outFileName.length() == 0) {
            throw new IllegalArgumentException("Out file name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + "png?").buildUpon();

        if(pngImageProperties.containsKey(PNGImagePropertiesKeys.fromScratch)) {
            String fromScratch = pngImageProperties.get(PNGImagePropertiesKeys.fromScratch);
            uriBuilder.appendQueryParameter(PNGImagePropertiesKeys.fromScratch, fromScratch);
        }
        if(pngImageProperties.containsKey(PNGImagePropertiesKeys.outPath)) {
            String outPath = pngImageProperties.get(PNGImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(PNGImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Convert the local file to InputStream
        InputStream fileStream = new FileInputStream(localFilePath);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "POST", fileStream);

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, outFileName);

        return outFilePath;
    }

    /**
     * Update parameters of PSD image.
     * @param fileName Filename of image
     * @param psdImageProperties HashMap of PSD image properties. Values could be following
     *                           channelsCount Count of channels.
     *                           compressionMethod Compression method.
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated PSD image saved on device
     */
    public static String updatePSDImageProperties(String fileName, HashMap<String, String> psdImageProperties) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        String localFilePath = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + Uri.encode(fileName) + "/psd?").buildUpon();

        if(psdImageProperties.containsKey(PSDImagePropertiesKeys.channelsCount)) {
            String channelsCount = psdImageProperties.get(PSDImagePropertiesKeys.channelsCount);
            uriBuilder.appendQueryParameter(PSDImagePropertiesKeys.channelsCount, channelsCount);
        }
        if(psdImageProperties.containsKey(PSDImagePropertiesKeys.compressionMethod)) {
            String compressionMethod = psdImageProperties.get(PSDImagePropertiesKeys.compressionMethod);
            uriBuilder.appendQueryParameter(PSDImagePropertiesKeys.compressionMethod, compressionMethod);
        }
        if(psdImageProperties.containsKey(PSDImagePropertiesKeys.fromScratch)) {
            String fromScratch = psdImageProperties.get(PSDImagePropertiesKeys.fromScratch);
            uriBuilder.appendQueryParameter(PSDImagePropertiesKeys.fromScratch, fromScratch);
        }
        if(psdImageProperties.containsKey(PSDImagePropertiesKeys.outPath)) {
            String outPath = psdImageProperties.get(PSDImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(PSDImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "GET");

        //Save the stream in response to the disk
        localFilePath = Utils.saveStreamToFile(responseStream, fileName);

        return localFilePath;
    }

    /**
     * Update parameters of PSD image stored on device
     * @param localFilePath Path to file stored on device
     * @param psdImageProperties HashMap of PSD image properties. Values could be following
     *                           channelsCount Count of channels.
     *                           compressionMethod Compression method.
     *                           fromScratch Specifies where additional parameters we do not support should be taken from. If this is true – they will be taken from default values for standard image, if it is false – they will be saved from current image. Default is false.
     *                           outPath Path to updated file, if this is empty, response contains streamed image
     * @param outFileName        Updated PSD image save on device with this name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return A path to updated PSD image saved on device
     */
    public static String updatePSDImagePropertiesWithoutStorage(String localFilePath, HashMap<String, String> psdImageProperties, String outFileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {
        String outFilePath = null;

        if(localFilePath == null || localFilePath.length() == 0) {
            throw new IllegalArgumentException("Local file path cannot be null or empty");
        }

        if(outFileName == null || outFileName.length() == 0) {
            throw new IllegalArgumentException("Out file name cannot be null or empty");
        }

        //Build the request URI
        Uri.Builder uriBuilder = Uri.parse(IMAGING_URI + "psd?").buildUpon();

        if(psdImageProperties.containsKey(PSDImagePropertiesKeys.channelsCount)) {
            String channelsCount = psdImageProperties.get(PSDImagePropertiesKeys.channelsCount);
            uriBuilder.appendQueryParameter(PSDImagePropertiesKeys.channelsCount, channelsCount);
        }
        if(psdImageProperties.containsKey(PSDImagePropertiesKeys.compressionMethod)) {
            String compressionMethod = psdImageProperties.get(PSDImagePropertiesKeys.compressionMethod);
            uriBuilder.appendQueryParameter(PSDImagePropertiesKeys.compressionMethod, compressionMethod);
        }
        if(psdImageProperties.containsKey(PSDImagePropertiesKeys.fromScratch)) {
            String fromScratch = psdImageProperties.get(PSDImagePropertiesKeys.fromScratch);
            uriBuilder.appendQueryParameter(PSDImagePropertiesKeys.fromScratch, fromScratch);
        }
        if(psdImageProperties.containsKey(PSDImagePropertiesKeys.outPath)) {
            String outPath = psdImageProperties.get(PSDImagePropertiesKeys.outPath);
            uriBuilder.appendQueryParameter(PSDImagePropertiesKeys.outPath, outPath);
        }

        String strURL = uriBuilder.build().toString();

        //Sign the request URI
        String signedURL = Utils.sign(strURL);
        //Convert the local file to InputStream
        InputStream fileStream = new FileInputStream(localFilePath);
        //Process the request on server
        InputStream responseStream = Utils.processCommand(signedURL, "POST", fileStream);

        //Save the stream in response to the disk
        outFilePath = Utils.saveStreamToFile(responseStream, outFileName);

        return outFilePath;
    }

    /**
     * Get image properties
     * @param fileName The image name
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return An object that contains image properties
     */
    public static ImagePropertiesResponse getImageProperties(String fileName) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        ImagePropertiesResponse imgPropertiesResponse = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        //Build the request URI
        String strURL = IMAGING_URI + Uri.encode(fileName) + "/properties";

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
}
