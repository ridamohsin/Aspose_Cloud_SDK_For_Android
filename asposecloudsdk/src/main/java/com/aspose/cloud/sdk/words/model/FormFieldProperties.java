package com.aspose.cloud.sdk.words.model;

/**
 * Created by muhammadsohailismail on 5/9/15.
 */
public class FormFieldProperties {

    public String Name; //Gets or sets the form field name.
    public boolean Enabled; //True if a form field is enabled.
    public String StatusText; //Returns or sets the text that's displayed in the status bar when a form field has the focus.
    public boolean OwnStatus; //Specifies the source of the text that's displayed in the status bar when a form field has the focus.
    public String HelpText; //Returns or sets the text that's displayed in a message box when the form field has the focus and the user presses F1.
    public boolean OwnHelp; //Specifies the source of the text that's displayed in a message box when a form field has the focus and the user presses F1.
    public boolean CalculateOnExit; //True if references to the specified form field are automatically updated whenever the field is exited.
    public String EntryMacro; //Returns or sets an entry macro name for the form field.
    public String ExitMacro; //Returns or sets an exit macro name for the form field.

    //FormFieldTextInputProperties
    public String TextInputFormat; //Returns or sets the text formatting for a text form field.
    public String TextInputType; //Gets or sets the type of a text form field.
    public String TextInputDefault; //Gets or sets the default string or a calculation expression of a text form field.
    public int MaxLength; //Maximum length for the text field. Zero when the length is not limited.

    //FormFieldCheckboxProperties
    public boolean IsCheckBoxExactSize; //Gets or sets the boolean value that indicates whether the size of the textbox is automatic or specified explicitly.
    public double CheckBoxSize; //Gets or sets the size of the checkbox in points. Has effect only when "IsCheckBoxExactSize" is true.
    public boolean Checked; //Gets or sets the checked status of the check box form field.

    //FormFieldDropDownProperties
    public int DropDownSelectedIndex; //Gets or sets the index specifying the currently selected item in a dropdown form field.
    public String[] DropDownItems; 	//Provides access to the items of a dropdown form field.

}
