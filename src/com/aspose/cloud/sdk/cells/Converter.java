package com.aspose.cloud.sdk.cells;

import java.io.FileInputStream;
import java.io.InputStream;

import android.util.Log;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;

public class Converter
{
	// / <summary>
	// / Workbook name
	// / </summary>
	public String fileName;

	// / <summary>
	// / WorkSheet Name
	// / </summary>
	public String workSheetName;

	private final static String EMPTY = "";
	private final static String TAG = "Converter";

	// / <summary>
	// / Converter Class Constructor
	// / </summary>
	public Converter()
	{

	}

	// / <summary>
	// / Converter Class Constructor
	// / </summary>
	public Converter(String fileName)
	{
		this.fileName = fileName;
	}

	// / <summary>
	// / Converter Class Constructor
	// / </summary>
	public Converter(String fileName, String worksheetName)
	{
		this.fileName = fileName;
		this.workSheetName = worksheetName;
	}
	//============================================================================
	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean autoShapeToImage(int index, String outputFileName, ImageFormat outputformat)
	{
		try
		{
			// check whether file is set or not
			if (fileName.equals(EMPTY))
				throw new Exception("No file name specified");
			else if (workSheetName.equals(EMPTY))
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/autoshapes/" + index + "?format=" + outputformat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputFileName, responseStream);
			responseStream.close();
			return response;
		}
		catch (Exception ex)
		{
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}
	//============================================================================
	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean chartToImage(int index, String outputFileName, ImageFormat outputformat)
	{
		try
		{
			// check whether file is set or not
			if (fileName.equals(EMPTY))
				throw new Exception("No file name specified");
			else if (workSheetName.equals(EMPTY))
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/charts/" + index + "?format=" + outputformat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputFileName, responseStream);
			responseStream.close();
			return response;
		}
		catch (Exception ex)
		{
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}
	//============================================================================
	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean oleObjectToImage(int index, String outputFileName, ImageFormat outputformat)
	{
		try
		{
			// check whether file is set or not
			if (fileName.equals(EMPTY))
				throw new Exception("No file name specified");
			else if (workSheetName.equals(EMPTY))
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/oleobjects/" + index + "?format=" + outputformat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputFileName, responseStream);
			responseStream.close();
			return response;
		}
		catch (Exception ex)
		{
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}
	//============================================================================
	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <param name="outputFileName"></param>
	// / <param name="outputformat"></param>
	public boolean pictureToImage(int index, String outputFileName, ImageFormat outputformat)
	{
		try
		{
			// check whether file is set or not
			if (fileName.equals(EMPTY))
				throw new Exception("No file name specified");
			else if (workSheetName.equals(EMPTY))
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/pictures/" + index + "?format=" + outputformat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputFileName, responseStream);
			responseStream.close();
			return response;
		}
		catch (Exception ex)
		{
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}
	//============================================================================
	// / <summary>
	// /
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	// / <param name="saveLocation"></param>

	public boolean worksheetToImage(String outputFileName, ImageFormat outputFormat)
	{
		try
		{
			// check whether file is set or not
			if (fileName.equals(EMPTY))
				throw new Exception("No file name specified");
			else if (workSheetName.equals(EMPTY))
				throw new Exception("No Worksheet name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "?format=" + outputFormat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputFileName, responseStream);
			responseStream.close();
			return response;
		}
		catch (Exception ex)
		{
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}
	//============================================================================
	public boolean save(String outputFileName, SaveFormat outputFormat)
	{
		try
		{
			// check whether file is set or not
			if (fileName.equals(EMPTY))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "?format=" + outputFormat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");
			boolean response = Folder.saveStreamToFile(outputFileName, responseStream);
			responseStream.close();
			return response;
		}
		catch (Exception ex)
		{
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}
	//============================================================================
	// / <summary>
	// / Convert Excel files to different file formats without using cloud storage
	// / </summary>
	// / <param name="outputFileName"></param>
	// / <param name="outputFormat"></param>
	public boolean convertLocalFile(String inputPath, String outputPath, SaveFormat outputFormat)
	{
		try
		{
			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/convert?format=" + outputFormat;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream stream = new FileInputStream(inputPath);

			// get response stream
			InputStream responseStream = Utils.processCommand(signedURI, "PUT", stream);
			boolean response = Folder.saveStreamToFile(outputPath, responseStream);

			responseStream.close();
			return response;
		}
		catch (Exception ex)
		{
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}
}