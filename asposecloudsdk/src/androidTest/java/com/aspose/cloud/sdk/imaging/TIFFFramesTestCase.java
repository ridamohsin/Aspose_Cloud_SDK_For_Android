package com.aspose.cloud.sdk.imaging;

import com.aspose.cloud.sdk.imaging.api.TIFFFrames;
import com.aspose.cloud.sdk.imaging.model.ImagePropertiesResponse;
import com.aspose.cloud.sdk.imaging.model.ManipulateTIFFFrameKeys;
import com.aspose.cloud.sdk.imaging.model.TIFFFrameRotateFlipMethodEnum;

import junit.framework.TestCase;

import java.io.File;
import java.util.HashMap;

/**
 * Created by muhammadsohailismail on 4/24/15.
 */
public class TIFFFramesTestCase extends TestCase {

    public TIFFFramesTestCase(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

   public void testGetTIFFFrameProperties() throws Exception {
        ImagePropertiesResponse imgPropertiesResponse = TIFFFrames.getTIFFFrameProperties("sample.TIF", 0);
        assertNotNull("Failed to retrieve properties of a specific Tiff Frame", imgPropertiesResponse);
    }

    public void testExtractFrameFromAMultiFrameTIFFImage() throws Exception {
        String outFilePath = TIFFFrames.extractFrameFromAMultiFrameTIFFImage("sample.TIF", 0, "Frame.TIF");
        File file = new File(outFilePath);
        assertEquals("Failed to extract frame from a multi-frame TIFF Image", true, file.exists());
    }

    public void testResizeATIFFFrame() throws Exception {
        String outFilePath = TIFFFrames.resizeATIFFFrame("sample.TIF", 0, 500, 500, "resizedFrame.TIF");
        File file = new File(outFilePath);
        assertEquals("Failed to resize a TIFF frame", true, file.exists());
    }

    public void testCropATIFFFrame() throws Exception {
        String outFilePath = TIFFFrames.cropATIFFFrame("sample.TIF", 0, 0, 0, 500, 500, "croppedFrame.TIF");
        File file = new File(outFilePath);
        assertEquals("Failed to crop a TIFF frame", true, file.exists());
    }

    public void testRotateFlipATIFFFrame() throws Exception {
        String outFilePath = TIFFFrames.rotateFlipATIFFFrame("sample.TIF", 0, TIFFFrameRotateFlipMethodEnum.Rotate180FlipNone, "rotateFlipFrame.TIF");
        File file = new File(outFilePath);
        assertEquals("Failed to perform a RotateFlip operation on a frame of Tiff image", true, file.exists());
    }

    public void testManipulateAFrame() throws Exception {

        HashMap<String, String> manipulateTIFFFrameParameters = new HashMap<String, String>();
        manipulateTIFFFrameParameters.put(ManipulateTIFFFrameKeys.newWidth, String.valueOf(500));
        manipulateTIFFFrameParameters.put(ManipulateTIFFFrameKeys.newHeight, String.valueOf(500));
        manipulateTIFFFrameParameters.put(ManipulateTIFFFrameKeys.saveOtherFrames, String.valueOf(true));
        manipulateTIFFFrameParameters.put(ManipulateTIFFFrameKeys.outPath, "resizedFrame.TIF");

        String outFilePath = TIFFFrames.manipulateATIFFFrame("sample.TIF", 0, manipulateTIFFFrameParameters);
        File file = new File(outFilePath);
        assertEquals("Failed to perform several operations such as RotateFlip, Resize & Crop on a frame of Tiff image", true, file.exists());
    }
}
