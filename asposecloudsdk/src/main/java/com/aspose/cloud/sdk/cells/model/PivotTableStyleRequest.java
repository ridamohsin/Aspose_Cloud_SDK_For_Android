package com.aspose.cloud.sdk.cells.model;

import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by muhammadsohailismail on 7/16/15.
 */
public class PivotTableStyleRequest {
    @SerializedName("Font")
    public FontModel font;
    @SerializedName("Name")
    public String name;
    public String CultureCustom;
    public String Custom;
    public ColorModel BackgroundColor;
    public ColorModel ForegroundColor;
    public boolean IsFormulaHidden;
    public boolean IsDateTime;
    public boolean IsTextWrapped;
    public boolean IsGradient;
    public boolean IsLocked;
    public boolean IsPercent;
    public boolean ShrinkToFit;
    public int IndentLevel;
    public int Number;
    public int RotationAngle;
    public String Pattern;
    public String TextDirection;
    public String VerticalAlignment;
    public String HorizontalAlignment;
    public ArrayList<PivotTableBorder> BorderCollection;
    public LinkModel link;
}
