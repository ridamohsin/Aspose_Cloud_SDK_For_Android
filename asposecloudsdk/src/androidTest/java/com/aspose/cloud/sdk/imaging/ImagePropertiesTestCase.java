package com.aspose.cloud.sdk.imaging;

import com.aspose.cloud.sdk.imaging.api.ImageProperties;
import com.aspose.cloud.sdk.imaging.model.BMPImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.GIFImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.ImagePropertiesResponse;
import com.aspose.cloud.sdk.imaging.model.JPGCompressionTypeEnum;
import com.aspose.cloud.sdk.imaging.model.JPGImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.PNGImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.PSDCompressionMethodEnum;
import com.aspose.cloud.sdk.imaging.model.PSDImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.TIFFCompressionEnum;
import com.aspose.cloud.sdk.imaging.model.TIFFImagePropertiesKeys;
import com.aspose.cloud.sdk.imaging.model.TIFFResolutionUnitEnum;

import junit.framework.TestCase;

import java.io.File;
import java.util.HashMap;

/**
 * Created by muhammadsohailismail on 4/22/15.
 */
public class ImagePropertiesTestCase extends TestCase {

    public ImagePropertiesTestCase(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testUpdateBMPImageProperties() throws Exception {

        HashMap<String, String> bmpImageProperties = new HashMap<String, String>();
        bmpImageProperties.put(BMPImagePropertiesKeys.bitsPerPixel, String.valueOf(24));
        bmpImageProperties.put(BMPImagePropertiesKeys.horizontalResolution, String.valueOf(400));
        bmpImageProperties.put(BMPImagePropertiesKeys.verticalResolution, String.valueOf(500));
        bmpImageProperties.put(BMPImagePropertiesKeys.fromScratch, String.valueOf(true));
        bmpImageProperties.put(BMPImagePropertiesKeys.outPath, "updatedImage.bmp");

        String localFilePath = ImageProperties.updateBMPImageProperties("myImage.bmp", bmpImageProperties);
        File file = new File(localFilePath);
        assertEquals("Failed to update BMP image properties", true, file.exists());
    }

    public void testUpdateBMPImagePropertiesWithoutStorage() throws Exception {

        HashMap<String, String> bmpImageProperties = new HashMap<String, String>();
        bmpImageProperties.put(BMPImagePropertiesKeys.bitsPerPixel, String.valueOf(32));
        bmpImageProperties.put(BMPImagePropertiesKeys.horizontalResolution, String.valueOf(300));
        bmpImageProperties.put(BMPImagePropertiesKeys.verticalResolution, String.valueOf(300));

        String updatedFilePath = ImageProperties.updateBMPImagePropertiesWithoutStorage("/storage/emulated/0/AsposeFiles/myImage.bmp", bmpImageProperties, "updatedImage.bmp");
        File file = new File(updatedFilePath);
        assertEquals("Failed to update BMP specific properties without requiring the image to be present on the Cloud Storage", true, file.exists());
    }

    public void testUpdateGIFImageProperties() throws Exception {

        HashMap<String, String> gifImageProperties = new HashMap<String, String>();
        gifImageProperties.put(GIFImagePropertiesKeys.backgroundColorIndex, String.valueOf(255));
        gifImageProperties.put(GIFImagePropertiesKeys.pixelAspectRatio, String.valueOf(10));
        gifImageProperties.put(GIFImagePropertiesKeys.outPath, "updatedImage.gif");

        String localFilePath = ImageProperties.updateGIFImageProperties("sample.GIF", gifImageProperties);
        File file = new File(localFilePath);
        assertEquals("Failed to update GIF Image Properties", true, file.exists());
    }

    public void testUpdateGIFImagePropertiesWithoutStorage() throws Exception {

        HashMap<String, String> gifImageProperties = new HashMap<String, String>();
        gifImageProperties.put(GIFImagePropertiesKeys.backgroundColorIndex, String.valueOf(255));
        gifImageProperties.put(GIFImagePropertiesKeys.pixelAspectRatio, String.valueOf(10));

        String outFilePath = ImageProperties.updateGIFImagePropertiesWithoutStorage("/storage/emulated/0/AsposeFiles/sample.GIF", gifImageProperties, "updatedSample.GIF");
        File file = new File(outFilePath);
        assertEquals("Failed to update GIF specific properties without requiring the image to be present on the Cloud Storage", true, file.exists());
    }

    public void testUpdateTIFFImagePropertiesWithoutStorage() throws Exception {

        HashMap<String, String> tiffImageProperties = new HashMap<String, String>();
        tiffImageProperties.put(TIFFImagePropertiesKeys.compression, String.valueOf(TIFFCompressionEnum.CcittFax3));
        tiffImageProperties.put(TIFFImagePropertiesKeys.resolutionUnit, String.valueOf(TIFFResolutionUnitEnum.inch));
        tiffImageProperties.put(TIFFImagePropertiesKeys.bitDepth, String.valueOf(1));
        tiffImageProperties.put(TIFFImagePropertiesKeys.newWidth, String.valueOf(600));
        tiffImageProperties.put(TIFFImagePropertiesKeys.newHeight, String.valueOf(800));
        tiffImageProperties.put(TIFFImagePropertiesKeys.horizontalResolution, String.valueOf(96));
        tiffImageProperties.put(TIFFImagePropertiesKeys.verticalResolution, String.valueOf(96));

        String outFilePath = ImageProperties.updateTIFFImagePropertiesWithoutStorage("/storage/emulated/0/AsposeFiles/sample.TIF", tiffImageProperties, "updatedSample.TIF");
        File file = new File(outFilePath);
        assertEquals("Failed to update TIFF specific properties without requiring the image to be present on the Cloud Storage", true, file.exists());
    }

    public void testUpdateJPGImageProperties() throws Exception {

        HashMap<String, String> jpgImageProperties = new HashMap<String, String>();
        jpgImageProperties.put(JPGImagePropertiesKeys.quality, String.valueOf(1));
        jpgImageProperties.put(JPGImagePropertiesKeys.compressionType, String.valueOf(JPGCompressionTypeEnum.progressive));
        jpgImageProperties.put(JPGImagePropertiesKeys.outPath, "updatedImage.jpg");

        String localFilePath = ImageProperties.updateJPGImageProperties("sample.jpg", jpgImageProperties);
        File file = new File(localFilePath);
        assertEquals("Failed to update JPG Image Properties", true, file.exists());
    }

    public void testUpdateJPGImagePropertiesWithoutStorage() throws Exception {

        HashMap<String, String> jpgImageProperties = new HashMap<String, String>();
        jpgImageProperties.put(JPGImagePropertiesKeys.quality, String.valueOf(100));
        jpgImageProperties.put(JPGImagePropertiesKeys.compressionType, String.valueOf(JPGCompressionTypeEnum.baseline));

        String outFilePath = ImageProperties.updateJPGImagePropertiesWithoutStorage("/storage/emulated/0/AsposeFiles/sample.jpg", jpgImageProperties, "updatedSample.jpg");
        File file = new File(outFilePath);
        assertEquals("Failed to update JPG specific properties without requiring the image to be present on the Cloud Storage", true, file.exists());
    }

    public void testUpdatePNGImageProperties() throws Exception {

        HashMap<String, String> pngImageProperties = new HashMap<String, String>();
        pngImageProperties.put(PNGImagePropertiesKeys.fromScratch, String.valueOf(true));
        pngImageProperties.put(PNGImagePropertiesKeys.outPath, "updatedSample.png");

        String localFilePath = ImageProperties.updatePNGImageProperties("sample.png", pngImageProperties);
        File file = new File(localFilePath);
        assertEquals("Failed to update PNG Image Properties", true, file.exists());
    }

    public void testUpdatePNGImagePropertiesWithoutStorage() throws Exception {

        HashMap<String, String> pngImageProperties = new HashMap<String, String>();
        pngImageProperties.put(PNGImagePropertiesKeys.fromScratch, String.valueOf(true));

        String outFilePath = ImageProperties.updatePNGImagePropertiesWithoutStorage("/storage/emulated/0/AsposeFiles/sample.png", pngImageProperties, "updatedSample.png");
        File file = new File(outFilePath);
        assertEquals("Failed to update PNG specific properties without requiring the image to be present on the Cloud Storage", true, file.exists());
    }

    public void testUpdatePSDImageProperties() throws Exception {

        HashMap<String, String> psdImageProperties = new HashMap<String, String>();
        psdImageProperties.put(PSDImagePropertiesKeys.channelsCount, String.valueOf(3));
        psdImageProperties.put(PSDImagePropertiesKeys.compressionMethod, String.valueOf(PSDCompressionMethodEnum.rle));
        psdImageProperties.put(PSDImagePropertiesKeys.outPath, "updatedSample.psd");

        String localFilePath = ImageProperties.updatePSDImageProperties("sample.psd", psdImageProperties);
        File file = new File(localFilePath);
        assertEquals("Failed to update PSD Image Properties", true, file.exists());
    }

    public void testUpdatePSDImagePropertiesWithoutStorage() throws Exception {

        HashMap<String, String> psdImageProperties = new HashMap<String, String>();
        psdImageProperties.put(PSDImagePropertiesKeys.channelsCount, String.valueOf(3));
        psdImageProperties.put(PSDImagePropertiesKeys.compressionMethod, String.valueOf(PSDCompressionMethodEnum.rle));

        String outFilePath = ImageProperties.updatePSDImagePropertiesWithoutStorage("/storage/emulated/0/AsposeFiles/sample.psd", psdImageProperties, "updatedSample.psd");
        File file = new File(outFilePath);
        assertEquals("Failed to update PSD specific properties without requiring the image to be present on the Cloud Storage", true, file.exists());
    }

    public void testGetImageProperties() throws Exception {

        ImagePropertiesResponse imgPropertiesResponse = ImageProperties.getImageProperties("sample.TIF");
        assertNotNull("Failed to retrieve generic image properties", imgPropertiesResponse);
    }

}
