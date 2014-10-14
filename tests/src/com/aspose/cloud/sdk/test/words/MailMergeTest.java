package com.aspose.cloud.sdk.test.words;

import com.aspose.cloud.sdk.words.MailMerge;
import com.aspose.cloud.sdk.words.DocumentResponse.Document;

import junit.framework.TestCase;

public class MailMergeTest extends TestCase {

	public MailMergeTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testExecuteMailMergeTemplateAndPopulateAWordDocumentFromXMLData() throws Exception {
		String xmlData = 
				"<Orders xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"OrdersSchema.xsd\">" +
						"<Order>" +
						"<Address>" +
							"<Number>23</Number>" +
							"<Street>Nelson Street</Street>" +
							"<Suburb>Howick</Suburb>" +
							"<City>Auckland</City>" +
						"</Address>" +
						"<PhoneNumber>543 1234</PhoneNumber>" +
						"<Date>03/01/2010</Date>" +
						"<Total>14.00</Total>" +
						"<Item>" +
							"<Name>BBQ Chicken Pizza</Name>" +
							"<Price>6.00</Price>" +
							"<Quantity>1</Quantity>" +
							"<ItemTotal>6.00</ItemTotal>" +
						"</Item>" +
						"<Item>" +
							"<Name>1.5 Litre Coke</Name>" +
							"<Price>4.00</Price>" +
							"<Quantity>2</Quantity>" +
							"<ItemTotal>8.00</ItemTotal>" +
						"</Item>" +
						"</Order>" +
						"<Order>" +
						"<Address>" +
							"<Number>10</Number>" +
							"<Street>Parkville Avenue</Street>" +
							"<Suburb>Pakuranga</Suburb>" +
							"<City>Auckland</City>" +
						"</Address>" +
						"<PhoneNumber>548 7342</PhoneNumber>" +
						"<Date>05/03/2010</Date>" +
						"<Total>6.00</Total>" +
						"<Item>" +
							"<Name>Hawaiian Pizza</Name>" +
							"<Price>4.00</Price>" +
							"<Quantity>1</Quantity>" +
							"<ItemTotal>4.00</ItemTotal>" +
						"</Item>" +
						"<Item>" +
							"<Name>Fries</Name>" +
							"<Price>1.00</Price>" +
							"<Quantity>2</Quantity>" +
							"<ItemTotal>2.00</ItemTotal>" +
						"</Item>" +
						"</Order>" +
					"</Orders>"; 

		Document document = MailMerge.executeMailMergeTemplateAndPopulateAWordDocumentFromXMLData("TestMainAppendTemplate.doc", xmlData);
		assertNotNull("Failed to execute mail merge template and populate a Word document from XML data", document);
	}
}
