package com.aspose.cloud.sdk.words;

import com.aspose.cloud.sdk.words.api.ParagraphLevelFormFields;
import com.aspose.cloud.sdk.words.model.FormFieldProperties;
import com.aspose.cloud.sdk.words.model.FormFieldTypeEnum;

import junit.framework.TestCase;

/**
 * Created by muhammadsohailismail on 5/9/15.
 */
public class ParagraphLevelFormFieldsTestCase extends TestCase {

    public ParagraphLevelFormFieldsTestCase(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetFormFieldsFromAParagraphInTheWordDocument() throws Exception {
        ParagraphLevelFormFields.getFormFieldsFromAParagraphInTheWordDocument("formfieldsdocument.docx", 0, 1, 0);
    }

    public void testAddFormFieldsToAParagraphInTheWordDocument() throws Exception {

        FormFieldProperties formFieldProperties = new FormFieldProperties();
        formFieldProperties.Name = "Checkbox 1";
        formFieldProperties.Enabled = true;
        formFieldProperties.StatusText = "Status Text";
        formFieldProperties.OwnStatus = true;
        formFieldProperties.HelpText = "Help Text";
        formFieldProperties.OwnHelp = true;
        formFieldProperties.CalculateOnExit = false;
        formFieldProperties.EntryMacro = null;
        formFieldProperties.ExitMacro = null;
        formFieldProperties.IsCheckBoxExactSize = true;
        formFieldProperties.CheckBoxSize = 50;
        formFieldProperties.Checked = true;

        ParagraphLevelFormFields.addFormFieldsToAParagraphInTheWordDocument("myworddocument.doc", 0, 0, formFieldProperties, FormFieldTypeEnum.FormFieldCheckboxProperties);
    }
}
