package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.GetProtectionOfTheWordDocumentResponse;
import com.aspose.cloud.sdk.words.Protection;
import com.aspose.cloud.sdk.words.ProtectionTypeEnum;

import junit.framework.TestCase;

public class ProtectionTest extends TestCase {

	public ProtectionTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testProtectAWordDocument() throws Exception {
		boolean isDocumentProtectedSuccessfully = Protection.protectAWordDocument("testProtectionDocument.docx", ProtectionTypeEnum.AllowOnlyComments, "123456");
		assertEquals("Failed to protect a Word document", true, isDocumentProtectedSuccessfully);
	}
	
	public void testUnProtectAWordDocument() throws Exception {
		boolean isDocumentUnProtectedSuccessfully = Protection.unprotectAWordDocument("testProtectionDocument.docx", "123456");
		assertEquals("Failed to unprotect a Word document", true, isDocumentUnProtectedSuccessfully);
	}
	
	public void testGetTheCurrentProtectionOfTheWordDocument() throws Exception {
		GetProtectionOfTheWordDocumentResponse documentProtectionResponse = Protection.getTheCurrentProtectionOfTheWordDocument("testProtectionDocument.docx");
		assertNotNull("Failed to get the current protection of the Word document ", documentProtectionResponse);
	}
	
	public void testModifyProtectionOfTheWordDocument() throws Exception {
		GetProtectionOfTheWordDocumentResponse modifyDocumentProtectionResponse = Protection.modifyProtectionOfTheWordDocument("testProtectionDocument.docx", ProtectionTypeEnum.ReadOnly, "123456", "654321");
		assertNotNull("Failed to modify protection of the Word document", modifyDocumentProtectionResponse);
	}
}
