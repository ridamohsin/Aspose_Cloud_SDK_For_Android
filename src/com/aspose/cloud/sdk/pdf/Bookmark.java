/**
 * 
 */
package com.aspose.cloud.sdk.pdf;

import java.lang.String;

/// <summary>
/// represents a single bookmark in document
/// </summary>

public class Bookmark
{
    public Bookmark() { }

  //  public List<LinkResponse> Links { get; set; }
    private String Title;
    private boolean Italic;
    private boolean Bold;
    private Color Color;
    
    public String getTitle(){return Title;}   
    public boolean getIsItalic(){return Italic;}
    public boolean getIsBold(){return Bold;}
    public Color getColor(){return Color;}
}