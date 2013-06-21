/**
 * 
 */
package com.aspose.cloud.sdk.pdf;

import java.lang.String;

/// <summary>
/// represents a single property of the document
/// </summary>
public class DocumentProperty {
	
    public DocumentProperty() { }

 /*   public List<LinkResponse> Links;
    public boolean BuiltIn;
    public String Name ;
    public String Value ;
*/
    private boolean BuiltIn;
    private String Name ;
    private String Value ;

    public boolean getIsBuiltIn(){return BuiltIn;}
    public String getName(){return Name;}
    public String getValue(){return Value;}

    public void setIsBuiltIn(boolean BuiltIn){ this.BuiltIn=BuiltIn;}
    public void setName(String Name ){ this.Name=Name;}
    public void setValue(String Value){ this.Value=Value;}

   
}
