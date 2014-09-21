package com.aspose.cloud.sdk.words;

import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;
import com.google.gson.Gson;

public class Extractor {
	static final Logger logger = Logger.getLogger(Extractor.class);

	public Extractor() {
	}

	public List<Paragraph> getText(String FileName) {
		try {
			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + FileName;
			strURI += "/textItems";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			DocumentTextResponse docResponse = gson.fromJson(strJSON,
					DocumentTextResponse.class);

			return docResponse.TextItems.List;

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Gets all Drawing Objects from document
	// / </summary>
	// / <param name="FileName"></param>
	// / <param name="outputPath"></param>
	// / <returns></returns>
	public void getDrawingObjects(String FileName, String outputPath) {

		try {
			// build URI to get Drawing Objects
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + FileName
					+ "/drawingObjects";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			DrawingObjectsResponse Response = gson.fromJson(strJSON,
					DrawingObjectsResponse.class);

			for (com.aspose.cloud.sdk.words.List list : Response.DrawingObjects.List) {
				getDrawingObject(list.link.Href, outputPath);

			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	// / <summary>
	// / Get the drawing object from document
	// / </summary>
	// / <param name="strURI"></param>
	// / <param name="outputPath">C:\Output.jpg</param>
	public boolean getDrawingObject(String strURI, String outputPath) {

		try {
			// build URI to get Drawing Objects
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			DrawingObjectsResponse Response = gson.fromJson(strJSON,
					DrawingObjectsResponse.class);

			String index = Response.DrawingObject.link.Href.substring(
					Response.DrawingObject.link.Href.lastIndexOf("/") + 1)
					.toString();

			if (Response.DrawingObject.ImageDataLink != null
					&& Response.DrawingObject.OleDataLink == null) {
				// build URI to get Image
				strURI = strURI + "/imageData";// ?format=" +
												// DrawingObjectsRenderFormat.jpeg;
				outputPath = outputPath + "\\DrawingObject_" + index + "."
						+ DrawingObjectsRenderFormat.jpeg;
			} else if (Response.DrawingObject.OleDataLink != null) {
				// build URI to get OLE
				strURI = strURI + "/oleData";// format=" +
												// DrawingObjectsRenderFormat.jpeg;
				outputPath = outputPath + "\\DrawingObject__" + index + ".xlsx"; // This
																					// needs
																					// to
																					// be
																					// discuss
			} else {
				// build URI to get Image
				strURI = strURI + "?format=" + DrawingObjectsRenderFormat.jpeg;
				outputPath = outputPath + "\\DrawingObject__" + index + "."
						+ DrawingObjectsRenderFormat.jpeg;
			}

			signedURI = Utils.sign(strURI);

			responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
	}

	/*
	 * /// <summary> /// Get the List of drawing object from document ///
	 * </summary> /// <param name="FileName"></param> public Dictionary<int,
	 * String> GetDrawingObjectList(String FileName) {
	 * 
	 * try { //build URI to get Drawing Objects String strURI =
	 * AsposeApp.BASE_PRODUCT_URI + "/words/" + FileName + "/drawingObjects";
	 * 
	 * String signedURI = Utils.Sign(strURI);
	 * 
	 * Stream responseStream = Utils.ProcessCommand(signedURI, "GET");
	 * 
	 * StreamReader reader = new StreamReader(responseStream); String strJSON =
	 * reader.ReadToEnd();
	 * 
	 * //Parse the json String to JObject JObject parsedJSON =
	 * JObject.Parse(strJSON);
	 * 
	 * //Deserializes the JSON to a object. DrawingObjectsResponse Response =
	 * JsonConvert
	 * .DeserializeObject<DrawingObjectsResponse>(parsedJSON.ToString());
	 * 
	 * int index = 0; Dictionary<int, String> dObject = new Dictionary<int,
	 * String>();
	 * 
	 * foreach (Aspose.Words.List list in Response.DrawingObjects.List) {
	 * responseStream = Utils.ProcessCommand(Utils.Sign(list.link.Href), "GET");
	 * reader = new StreamReader(responseStream); strJSON = reader.ReadToEnd();
	 * parsedJSON = JObject.Parse(strJSON);
	 * 
	 * //Deserializes the JSON to a object. Response =
	 * JsonConvert.DeserializeObject
	 * <DrawingObjectsResponse>(parsedJSON.ToString());
	 * 
	 * if (Response.DrawingObject.ImageDataLink != null &&
	 * Response.DrawingObject.OleDataLink == null) { dObject.Add(index,
	 * Response.DrawingObject.ImageDataLink.Href); index++; } else if
	 * (Response.DrawingObject.OleDataLink != null) { dObject.Add(index,
	 * Response.DrawingObject.OleDataLink.Href); index++; } else {
	 * dObject.Add(index, Response.DrawingObject.RenderLinks[0].Href); index++;
	 * } }
	 * 
	 * responseStream.Close(); return dObject; } catch (Exception ex) { return
	 * null; } }
	 */
	// / <summary>
	// / Get the OLE drawing object from document
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="index"></param>
	// / <param name="renderformat"></param>
	// / <param name="outputPath"></param>
	public boolean getoleData(String FileName, int index,
			DrawingObjectsRenderFormat renderformat, String outputPath) {

		try {
			// build URI to get Image
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + FileName
					+ "/drawingObjects/" + index + "/oleData";

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
	}

	// / <summary>
	// / Get the Image drawing object from document
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="index"></param>
	// / <param name="renderformat"></param>
	// / <param name="outputPath"></param>
	public boolean getimageData(String FileName, int index,
			DrawingObjectsRenderFormat renderformat, String outputPath) {
		try {
			// build URI to get Image
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + FileName
					+ "/drawingObjects/" + index + "/ImageData";

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
	}

	// / <summary>
	// / Convert drawing object to image
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="index"></param>
	// / <param name="renderformat"></param>
	// / <param name="outputPath"></param>
	public boolean convertDrawingObject(String FileName, int index,
			DrawingObjectsRenderFormat renderformat, String outputPath) {
		try {
			// build URI to get Image
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/words/" + FileName
					+ "/drawingObjects/" + index;
			strURI = strURI + "?format=" + renderformat.toString();

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputPath,
					responseStream);
			responseStream.close();
			return response;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
	}
}