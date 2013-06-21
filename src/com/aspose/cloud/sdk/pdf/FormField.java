/**
 * 
 */
package com.aspose.cloud.sdk.pdf;

import java.lang.String;

/// <summary>
/// represents a single property of the document
/// </summary>
public class FormField
{
    public FormField() { }

 //   public List<LinkResponse> Links { get; set; }
    private String Name;
    private String[] SelectedItems;
    private int Type ;
    private String[] Values;
    
    public String getName(){return Name;}
    public int getType(){return Type;}
    public String[] getValues(){return Values;}
    public String[] getSelectedItems(){return SelectedItems;}
       

}