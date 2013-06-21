package com.aspose.cloud.sdk.words;

import java.io.InputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.aspose.cloud.sdk.common.Product;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;

public class MailMerge {
	static final Logger logger = Logger.getLogger(MailMerge.class);

	// / <summary>
	// / Execute mail merge without regions.
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="strXML"></param>
	// / <param name="saveformat"></param>
	// / <param name="output"></param>

	public void executeMailMerege(String fileName, String strXML,
			SaveFormat saveformat, String outputPath) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + fileName
					+ "/executeMailMerge";

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strXML, "xml");

			String strJSON = Utils.streamToString(responseStream);

			InputSource source = new InputSource(new StringReader(strJSON));

			// Parse the input document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder = factory
					.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(source);

			NodeList nodes = doc.getElementsByTagName("FileName");
			String DocName = nodes.item(0).getChildNodes().item(0)
					.getNodeValue();

			// build URI
			strURI = Product.getBaseProductUri() + "/words/" + DocName;
			strURI += "?format=" + saveformat;

			// sign URI
			signedURI = Utils.sign(strURI);

			// get response stream
			responseStream = Utils.processCommand(signedURI, "GET");

			Folder.saveStreamToFile(outputPath, responseStream);
			responseStream.close();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	// / <summary>
	// / Execute mail merge with regions.
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="strXML"></param>
	// / <param name="saveformat"></param>
	// / <param name="output"></param>
	public void executeMailMeregewithRegions(String FileName, String strXML,
			SaveFormat saveformat, String outputPath) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/executeMailMerge?withRegions=true";

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strXML, "xml");

			// further process JSON response
			String strResponse = Utils.streamToString(responseStream);

			InputSource source = new InputSource(new StringReader(strResponse));

			// Parse the input document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder = factory
					.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(source);

			NodeList nodes = doc.getElementsByTagName("FileName");
			String DocName = nodes.item(0).getChildNodes().item(0)
					.getNodeValue();

			// build URI
			strURI = Product.getBaseProductUri() + "/words/" + DocName;
			strURI += "?format=" + saveformat;

			// sign URI
			signedURI = Utils.sign(strURI);

			// get response stream
			responseStream = Utils.processCommand(signedURI, "GET");

			Folder.saveStreamToFile(outputPath, responseStream);
			responseStream.close();

		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	// / <summary>
	// / Execute mail merge template.
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="strXML"></param>
	// / <param name="saveformat"></param>
	// / <param name="output"></param>
	public void executeTemplate(String FileName, String strXML,
			SaveFormat saveformat, String outputPath) {
		try {
			// build URI to get Image
			String strURI = Product.getBaseProductUri() + "/words/" + FileName
					+ "/executeTemplate";

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strXML, "xml");

			String strJSON = Utils.streamToString(responseStream);

			InputSource source = new InputSource(new StringReader(strJSON));

			// Parse the input document
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			javax.xml.parsers.DocumentBuilder builder = factory
					.newDocumentBuilder();
			org.w3c.dom.Document doc = builder.parse(source);

			NodeList nodes = doc.getElementsByTagName("FileName");
			String DocName = nodes.item(0).getChildNodes().item(0)
					.getNodeValue();

			// build URI
			strURI = Product.getBaseProductUri() + "/words/" + DocName;
			strURI += "?format=" + saveformat;

			// sign URI
			signedURI = Utils.sign(strURI);

			// get response stream
			responseStream = Utils.processCommand(signedURI, "GET");

			Folder.saveStreamToFile(outputPath, responseStream);
			responseStream.close();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

}
