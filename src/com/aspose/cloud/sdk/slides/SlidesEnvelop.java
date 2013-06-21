/**
 * 
 */
package com.aspose.cloud.sdk.slides;
import java.util.List;
import java.lang.String;

/// <summary>
/// represents container part of the slides resource response
/// </summary>
public class SlidesEnvelop
{

    private List<String> AlternateLinks;
    private List<String> Links;
    private String SelfUri;
    private List<SlideResponse> SlideList;
    
    public List<String> getAlternateLinks(){return AlternateLinks;}
    public List<String> getLinks(){return Links;}
    public List<SlideResponse> getSlideList(){return SlideList;}
    public String getSelfUri(){return SelfUri;}
}