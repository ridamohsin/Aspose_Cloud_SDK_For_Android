package com.aspose.cloud.sdk.pdf.model;

/**
 * Created by muhammadsohailismail on 5/7/15.
 */
public class StampModel {

    public boolean Background; //Indicates that the content is stamped as background.
    public StampTypeEnum Type; //The stamp type, available valuse are: Text, Image, Page, PageNumber
    public String FileName; //Image or stamp document path. Used for Image and Page stamps only.
    public String Value; 	//Stamp value, used for Text and PageNumber stamps.
    public double XIndent; //Horizontal stamp coordinate, starting from the left.
    public double YIndent; //Vertical stamp coordinate, starting from the bottom.
    public int PageIndex; 	//Stamp document page number, used for Page stamps only.
    public double Height; //Image height, used for Image stamp.
    public double Width;  //Image width, used for Image stamp.
    public double Zoom;   //Zooming factor of the stamp. Allows to scale stamp.
    public double LeftMargin; //Left margin of the stamp.
    public double RightMargin; //Right margin of the stamp.
    public double TopMargin; //Top margin of the stamp.
    public double BottomMargin; //Bottom margin of the stamp.
    public double Opacity; //A value to indicate the stamp opacity. The value is from 0.0 to 1.0. By default the value is 1.0.
    public StampRotateEnum Rotate; //This property is for set angles which are multiples of 90 degrees (0, 90, 180, 270 degrees). To set arbitrary angle use RotateAngle property. Supported values are: None, on90, on180, on270.
    public double RotateAngle; //Rotate angle of the stamp in degrees. This property allows to set arbitrary rotate angle.
    public TextAlignmentEnum TextAlignment; //Alignment of the text inside the stamp. Possible values are: None, Left, Center, Right.
    public VerticalAlignmentEnum VerticalAlignment; //Vertical alignment of stamp on page. The value is from the set: None, Top, Center, Bottom.
    public String HorizontalAlignment;
    public int StartingNumber; //The number of starting page. Other pages will be numbered starting from this value. Used for ﻿PageNumber stamps only.
    public TextStateModel TextState;  //The stamp text state, used for Text and PageNumber stamps only.
}
