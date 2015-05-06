package com.aspose.cloud.sdk.email;

import com.aspose.cloud.sdk.common.LinkModel;
import com.aspose.cloud.sdk.email.api.Email;
import com.aspose.cloud.sdk.email.model.AddEmailAttachmentResponse;
import com.aspose.cloud.sdk.email.model.AddNewEmailResponse;
import com.aspose.cloud.sdk.email.model.EmailDocument;
import com.aspose.cloud.sdk.email.model.EmailDocumentProperties;
import com.aspose.cloud.sdk.email.model.EmailProperty;

import junit.framework.TestCase;

import java.io.File;
import java.util.ArrayList;

public class EmailTest extends TestCase {

	public EmailTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testConvertEmailToFormat() throws Exception {
		String localFilePath = Email.convertEmailToFormat("Message.msg", "eml");
		File file = new File(localFilePath);
		assertEquals("Failed to convert email messages back and forth between EML, MSG and MHT formats", true, file.exists());
	}

	public void testGetEmailAttachment() throws Exception {
		String localAttachmentPath = Email.getEmailAttachment("Message.msg", "License.txt");
		File file = new File(localAttachmentPath);
		assertEquals("Failed to download attachment from Message", true, file.exists());
	}
	
    public void testAddEmailAttachment() throws Exception {
        AddEmailAttachmentResponse addEmailAttachmentResponse = Email.addEmailAttachment("Leaves.eml", "facebook.png");
        assertNotNull("Failed to add attachment to a message", addEmailAttachmentResponse);
    }

    public void testAddNewEmail() throws Exception {

        EmailDocument emailDocument = new EmailDocument();
        emailDocument.links = new ArrayList<LinkModel>();
        LinkModel mLink = new LinkModel();
        mLink.href = "http://api.aspose.com/v1.1/email/newEmail.eml";
        mLink.rel = "self";
        mLink.type = null;
        mLink.title = null;

        emailDocument.links.add(mLink);

        emailDocument.emailDocumentProperties = new EmailDocumentProperties();
        emailDocument.emailDocumentProperties.link = new LinkModel();
        emailDocument.emailDocumentProperties.link.href = "http://api.aspose.com/v1.1/email/newEmail.eml/documentproperties/";
        emailDocument.emailDocumentProperties.link.rel = "self";
        emailDocument.emailDocumentProperties.link.type = null;
        emailDocument.emailDocumentProperties.link.title = null;

        emailDocument.emailDocumentProperties.emailPropertiesList = new ArrayList<EmailProperty>();
        EmailProperty mEmailProperty = new EmailProperty();
        mEmailProperty.name = "From";
        mEmailProperty.value = "ben@aspose.com";
        emailDocument.emailDocumentProperties.emailPropertiesList.add(mEmailProperty);
        mEmailProperty = new EmailProperty();
        mEmailProperty.name = "To";
        mEmailProperty.value = "marketplace@aspose.com";
        emailDocument.emailDocumentProperties.emailPropertiesList.add(mEmailProperty);
        mEmailProperty = new EmailProperty();
        mEmailProperty.name = "Subject";
        mEmailProperty.value = "Leaves Notification";
        emailDocument.emailDocumentProperties.emailPropertiesList.add(mEmailProperty);


        AddNewEmailResponse addNewEmailResponse = Email.addNewEmail("newEmail.eml", emailDocument);
        assertNotNull("Failed to add new email", addNewEmailResponse);
    }

	public void testGetEmailProperty() throws Exception {
		String propertyName = "Body";
		String propertyValue = Email.getEmailProperty("Message.msg", propertyName);
		assertNotNull("Failed to retrieve value of message property " + propertyName, propertyValue);
	}

	public void testSetEmailProperty() throws Exception {
		String propertyName = "Body";
		boolean isPropertyUpdated = Email.setEmailProperty("Message.msg", propertyName, "New body text");
		assertEquals("Failed to set value of message property " + propertyName, true, isPropertyUpdated);
	}
}
