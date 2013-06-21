/**
 * 
 */
package com.aspose.cloud.sdk.pdf;
import java.lang.String;

/// <summary>
/// represents a single annotation in document
/// </summary>

public class Annotation
{
    private Annotation() { }

  //  private List<LinkResponse> Links { get; set; }
    private Color Color;
    private String Contents;
    
    //Consider it to be of date type
    private String CreationDate;
  //  private Date CreationDate;
    private String Subject;
    private String Title;
    private String Modified;
    
    
 //   public Date getCreationDate(){return CreationDate;}
    public String getCreationDate(){return CreationDate;}
    public String getContents(){return Contents;}
    public String getSubject(){return Subject;}
    public String getTitle(){return Title;}
    public String getModified(){return Modified;}
    public Color getColor(){return Color;}
  
  //  public void setCreationDate(String date){ CreationDate=date;}
    public void setContents(String temContents){ Contents=temContents;}
    public void setSubject(String temSubject){ Subject=temSubject;}
    public void setTitle(String temTitle){ Title=temTitle;}
    public void setModified(String temModified){Modified=temModified;}
    public void setColor(Color temColor){ Color=temColor;}

}