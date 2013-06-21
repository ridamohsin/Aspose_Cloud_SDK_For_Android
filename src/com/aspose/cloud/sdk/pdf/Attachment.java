/**
 * 
 */
package com.aspose.cloud.sdk.pdf;

import java.lang.String;
/// <summary>
/// represents a single attachment in document
/// </summary>    

public class Attachment
{
    public Attachment() { }

  //  public List<LinkResponse> Links { get; set; }
    private Color Color;
    private String MimeType;
    private String Name;
    //Consider adding it as Date
    private String CreationDate;
    private String ModificationDate;
    private int Size;
    
    public Color getColor(){return Color;}
    public String getMimeType(){return MimeType;}
    public String getName(){return Name;}
    public String getCreationDate(){return CreationDate;}
    public String getModificationDate(){return ModificationDate;}
    public int getAttachmentSize(){return Size;}
  
}