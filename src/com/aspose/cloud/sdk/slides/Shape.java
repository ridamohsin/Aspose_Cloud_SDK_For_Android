/**
 * 
 */
package com.aspose.cloud.sdk.slides;

import java.util.List;
import java.lang.String;

/// <summary>
/// represents a single property of the document
/// </summary>
public class Shape
{
    public Shape() { }

    private String AlternativeText;
    private float Height;
    private boolean Hidden;
    private String Name;
    private float Width;
    private float X;
    private float Y;
    private List<LinkResponse> Shapes;
    private FillFormatURI FillFormat;
    private LineFormatURI LineFormat; 


    public String getAlternativeText(){return AlternativeText;}
    public float getHeight(){return Height;}
    public float getWidth(){return Width;}
    public float getX(){return X;}
    public float getY(){return Y;}
    public boolean getIsHidden(){return Hidden;};
    public FillFormatURI getFillFormat(){return FillFormat;}
    public LineFormatURI getLineFormat(){return LineFormat;}
    public List<LinkResponse> getLinkResponse(){return Shapes;}
    public String getName(){return Name;}
}