package com.aspose.cloud.sdk.pdf;

import com.aspose.cloud.sdk.pdf.api.Watermark;
import com.aspose.cloud.sdk.pdf.model.StampModel;
import com.aspose.cloud.sdk.pdf.model.StampRotateEnum;
import com.aspose.cloud.sdk.pdf.model.StampTypeEnum;
import com.aspose.cloud.sdk.pdf.model.TextAlignmentEnum;
import com.aspose.cloud.sdk.pdf.model.TextStateModel;
import com.aspose.cloud.sdk.pdf.model.VerticalAlignmentEnum;
import com.aspose.cloud.sdk.pdf.model.ColorModel;

import junit.framework.TestCase;

/**
 * Created by muhammadsohailismail on 5/7/15.
 */
public class WatermarkTest extends TestCase {

    public WatermarkTest(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testAddTextStampToAPDFPage() throws Exception {
        StampModel myStamp = new StampModel();
        myStamp.Type = StampTypeEnum.Text;
        myStamp.Background = true;
        myStamp.BottomMargin = 2;
        myStamp.HorizontalAlignment = "Left";
        myStamp.LeftMargin = 3;
        myStamp.Opacity = 0.5;
        myStamp.RightMargin = 0;
        myStamp.Rotate = StampRotateEnum.on270;
        myStamp.RotateAngle = 45;
        myStamp.TopMargin = 4;
        myStamp.VerticalAlignment = VerticalAlignmentEnum.Bottom;
        myStamp.XIndent = 2;
        myStamp.YIndent = 2.5;
        myStamp.Zoom = 1.5;
        myStamp.TextAlignment = TextAlignmentEnum.None;
        myStamp.Value = "Aspose Text Stamp";

        TextStateModel textState = new TextStateModel();
        textState.FontSize = 14;
        textState.Font = "Arial";

        ColorModel foregroundColor = new ColorModel();
        foregroundColor.A = 0;
        foregroundColor.R = 255;
        foregroundColor.G = 0;
        foregroundColor.B = 0;

        textState.ForegroundColor = foregroundColor;

        ColorModel backgroundColor = new ColorModel();
        backgroundColor.A = 0;
        backgroundColor.R = 0;
        backgroundColor.G = 0;
        backgroundColor.B = 255;

        textState.BackgroundColor = backgroundColor;
        textState.FontStyle = "Italic";

        myStamp.TextState = textState;

        myStamp.Width = 0;
        myStamp.Height = 0;
        myStamp.PageIndex = 0;
        myStamp.StartingNumber = 0;

        boolean isTextStampAddedSuccessfully = Watermark.addTextStampToAPDFPage("myPDF.pdf", 1, myStamp, "MyDropboxStorage", null);
        assertTrue("Failed to insert watermark text as stamp to a PDF page", isTextStampAddedSuccessfully);
    }

    public void testAddImageStampToAPDFPage() throws Exception {

        StampModel myStamp = new StampModel();
        myStamp.Type = StampTypeEnum.Image;
        myStamp.Background = true;
        myStamp.BottomMargin = 0;
        myStamp.HorizontalAlignment = "None";
        myStamp.LeftMargin = 0;
        myStamp.Opacity = 1;
        myStamp.RightMargin = 0;
        myStamp.Rotate = StampRotateEnum.None;
        myStamp.RotateAngle = 0;
        myStamp.TopMargin = 0;
        myStamp.VerticalAlignment = VerticalAlignmentEnum.None;
        myStamp.XIndent = 100;
        myStamp.YIndent = 100;
        myStamp.Zoom = 1;
        myStamp.TextAlignment = TextAlignmentEnum.None;
        myStamp.FileName = "sample.jpg";

        myStamp.Width = 200;
        myStamp.Height = 200;
        myStamp.PageIndex = 0;
        myStamp.StartingNumber = 0;

        boolean isImageStampAddedSuccessfully = Watermark.addImageStampToAPDFPage("myPDF.pdf", 1, myStamp, "MyDropboxStorage", null);
        assertTrue("Failed to insert watermark image as stamp to a PDF page", isImageStampAddedSuccessfully);
    }

    public void testAddPDFPageAsStampToAPDFPage() throws Exception {

        StampModel myStamp = new StampModel();
        myStamp.Type = StampTypeEnum.Page;
        myStamp.Background = true;
        myStamp.BottomMargin = 0;
        myStamp.HorizontalAlignment = "None";
        myStamp.LeftMargin = 0;
        myStamp.Opacity = 1;
        myStamp.RightMargin = 0;
        myStamp.Rotate = StampRotateEnum.None;
        myStamp.RotateAngle = 0;
        myStamp.TopMargin = 0;
        myStamp.VerticalAlignment = VerticalAlignmentEnum.None;
        myStamp.XIndent = 100;
        myStamp.YIndent = 100;
        myStamp.Zoom = 1;
        myStamp.TextAlignment = TextAlignmentEnum.None;
        myStamp.FileName = "handouts.pdf";
        myStamp.Width = 0;
        myStamp.Height = 0;
        myStamp.PageIndex = 1;
        myStamp.StartingNumber = 0;

        boolean isPDFPageAsStampAddedSuccessfully = Watermark.addPDFPageAsStampToAPDFPage("myPDF.pdf", 1, myStamp, "MyDropboxStorage", null);
        assertTrue("Failed to add PDF page as stamp to a PDF Page", isPDFPageAsStampAddedSuccessfully);
    }

    public void testAddPageNumberStampToAPDFPage() throws Exception {

        StampModel myStamp = new StampModel();
        myStamp.Type = StampTypeEnum.PageNumber;
        myStamp.Background = false;
        myStamp.BottomMargin = 25;
        myStamp.HorizontalAlignment = "Center";
        myStamp.LeftMargin = 0;
        myStamp.Opacity = 1;
        myStamp.RightMargin = 0;
        myStamp.Rotate = StampRotateEnum.None;
        myStamp.RotateAngle = 0;
        myStamp.TopMargin = 0;
        myStamp.VerticalAlignment = VerticalAlignmentEnum.None;
        myStamp.XIndent = 0;
        myStamp.YIndent = 0;
        myStamp.Zoom = 1;
        myStamp.TextAlignment = TextAlignmentEnum.None;
        myStamp.Value = "Page 3 of 6";

        TextStateModel textState = new TextStateModel();
        textState.FontSize = 14;
        textState.Font = "Arial";

        ColorModel foregroundColor = new ColorModel();
        foregroundColor.A = 255;
        foregroundColor.R = 165;
        foregroundColor.G = 42;
        foregroundColor.B = 42;

        textState.ForegroundColor = foregroundColor;

        textState.FontStyle = "Bold";

        myStamp.TextState = textState;

        myStamp.Width = 0;
        myStamp.Height = 0;
        myStamp.PageIndex = 0;
        myStamp.StartingNumber = 1;

        boolean isPDFPageAsStampAddedSuccessfully = Watermark.addPageNumberStampToAPDFPage("myPDF.pdf", 3, myStamp, "MyDropboxStorage", null);
        assertTrue("Failed to add PDF page as stamp to a PDF Page", isPDFPageAsStampAddedSuccessfully);
    }

}
