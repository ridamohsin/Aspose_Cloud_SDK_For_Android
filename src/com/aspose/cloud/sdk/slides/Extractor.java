/**
 * 
 */
package com.aspose.cloud.sdk.slides;

import java.io.InputStream;
import java.util.List;

import android.util.Log;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

// / <summary>
// / Deals with PowerPoint presentation level aspects
// / </summary>
public class Extractor {
	public Extractor(String tempfileName) {
		this.fileName = tempfileName;
		gson = new Gson();
	}

	// / <summary>
	// / Presentation name
	// / </summary>
	public String fileName;
	Gson gson = null;
	private static final String TAG = "Extractor";

	// / <summary>
	// / Gets total number of images in a presentation
	// / </summary>
	// / <returns>Total number of images</returns>
	public int getImageCount() {
		try {
			// build URI to get image count
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/images";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// / Gets total number of images in a presentation
	// / </summary>
	// / <returns>Total number of images</returns>
	public List<Image> getPresentationImages() {
		try {
			// build URI to get image count
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/images";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Gets number of images in the specified slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / <returns></returns>
	public int getImageCount(int slideNumber) {
		try {
			// build URI to get image count
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/slides/" + Integer.toString(slideNumber) + "/images";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			ImagesResponse imagesResponse = gson.fromJson(strJSON,
					ImagesResponse.class);

			return imagesResponse.getImages().getList().size();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// / Gets all shapes from the specified slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / <returns></returns>
	public List<Shape> getShapes(int slideNumber) {
		try {
			// build URI to get shapes
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/slides/" + Integer.toString(slideNumber) + "/shapes";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);
			System.out.println(strJSON);
			// Parse and deserialize the JSON to a object.
			ShapesResponse shapesResponse = gson.fromJson(strJSON,
					ShapesResponse.class);

			List<Shape> shapes = new java.util.ArrayList<Shape>();
			for (ShapeURI shapeURI : shapesResponse.getShapes().getList()) {
				// Parse the json String to JObject
				String strResponse = processURI(shapeURI.getUri().getHref());

				// Parse and deserialize the JSON to a object.
				ShapeResponse shapeResponse = gson.fromJson(strResponse,
						ShapeResponse.class);
				shapes.add(shapeResponse.getShape());
			}

			return shapes;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Gets all shapes from the specified slide
	// / </summary>
	// / <param name="slideNumber"></param>
	// / <returns></returns>
	public int getShapesCount(int slideNumber) {
		try {
			// build URI to get shapes
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/slides/" + fileName
					+ "/slides/" + Integer.toString(slideNumber) + "/shapes";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and deserialize the JSON to a object.
			ShapesResponse shapesResponse = gson.fromJson(strJSON,
					ShapesResponse.class);

			List<Shape> shapes = new java.util.ArrayList<Shape>();
			for (ShapeURI shapeURI : shapesResponse.getShapes().getList()) {
				// Parse the json String to JObject
				String strResponse = processURI(shapeURI.getUri().getHref());

				// Parse and deserialize the JSON to a object.
				ShapeResponse shapeResponse = gson.fromJson(strResponse,
						ShapeResponse.class);
				shapes.add(shapeResponse.getShape());
			}

			return shapes.size();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// / Processes URI and returns JObject
	// / </summary>
	// / <param name="strURI"></param>
	// / <returns></returns>
	private String processURI(String strURI) {
		try {
			// build URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			// Parse the json String to JObject
			return Utils.streamToString(responseStream);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}

	}

}
