package com.aspose.cloud.sdk.cells;

import java.io.InputStream;
import java.util.List;

import org.apache.log4j.Logger;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

public class Worksheet {
	public Worksheet(String fileName, String worksheetName) {
		this.fileName = fileName;
		this.workSheetName = worksheetName;
	}

	public LinkResponse link;

	public List<LinkResponse> getCellsList(int offset, int count) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells?offset="
					+ offset + "&count=" + count;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getCellList();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	public List<LinkResponse> getRowsList(int offset, int count) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/rows?offset="
					+ offset + "&count=" + count;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getRows().getRowsList();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public List<LinkResponse> getColumnsList(int offset, int count) {
		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/columns?offset="
					+ offset + "&count=" + count;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getColumns().getColumnsList();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int getMaxColumn(int offset, int count) {
		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells?offset="
					+ offset + "&count=" + count;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getMaxColumn();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return 0;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int getMaxRow(int offset, int count) {
		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells?offset="
					+ offset + "&count=" + count;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getMaxRow();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return 0;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int getCellsCount(int offset, int count) {
		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells?offset="
					+ offset + "&count=" + count;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getCells().getCellCount();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return 0;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getAutoShapesCount() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/autoshapes";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			WorksheetResponse worksheetResponse = gson.fromJson(strJSON,
					WorksheetResponse.class);

			return worksheetResponse.getAutoShapes().getAuotShapeList().size();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public AutoShape getAutoShapeByIndex(int index) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/autoshapes/" + index;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			AutoShapesResponse autoShapesResponse = gson.fromJson(strJSON,
					AutoShapesResponse.class);

			return autoShapesResponse.getAutoShape();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <returns></returns>
	public Cell getCell(String cellName) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/" + cellName;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			CellsResponse cellsResponse = gson.fromJson(strJSON,
					CellsResponse.class);

			return cellsResponse.getCell();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <returns></returns>
	public Style getCellStyle(String cellName) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/" + cellName
					+ "/style";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			CellsResponse cellsResponse = gson.fromJson(strJSON,
					CellsResponse.class);

			return cellsResponse.getStyle();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <param name="style"></param>
	// / <returns></returns>
	public boolean setCellStyle(String cellName, Style style) {

		try {

			// check whether file is set or not
			if (fileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/" + cellName
					+ "/style";

			// sign URI
			String signedURI = Utils.sign(strURI);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(style, Style.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Chart getChartByIndex(int index) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/charts/" + index;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			ChartsResponse chartsResponse = gson.fromJson(strResponse,
					ChartsResponse.class);

			return chartsResponse.getChart();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Hyperlink getHyperlinkByIndex(int index) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/hyperlinks/" + index;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			HyperlinksResponse hyperlinksResponse = gson.fromJson(strResponse,
					HyperlinksResponse.class);

			return hyperlinksResponse.getHyperlink();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="cellName"></param>
	// / <returns></returns>
	public Comment getComment(String cellName) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/comments/" + cellName;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);
			// Deserializes the JSON to a object.
			CommentsResponse commentResponse = gson.fromJson(strResponse,
					CommentsResponse.class);

			return commentResponse.getComment();

		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public OleObject getOleObjectByIndex(int index) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/oleobjects/" + index;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			OleObjectsResponse oleObjectsResponse = gson.fromJson(strResponse,
					OleObjectsResponse.class);

			return oleObjectsResponse.getOleObject();

		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Picture getPictureByIndex(int index) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/pictures/" + index;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			PicturesResponse picturesResponse = gson.fromJson(strResponse,
					PicturesResponse.class);

			return picturesResponse.getPicture();

		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public Validation getValidationByIndex(int index) {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/validations/" + index;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			ValidationsResponse validationsResponse = gson.fromJson(
					strResponse, ValidationsResponse.class);

			return validationsResponse.getValidation();

		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="index"></param>
	// / <returns></returns>
	public MergedCell getMergedCellByIndex(int index) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/mergedCells/" + index;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			MergedCellsResponse mergedCellsResponse = gson.fromJson(
					strResponse, MergedCellsResponse.class);

			return mergedCellsResponse.getMergedCell();

		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getMergedCellsCount() {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/mergedCells";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getMergedCells().getCount();

		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getValidationsCount() {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/validations";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getValidations().getCount();

		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getPicturesCount() {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/pictures";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getPictures().getPictureList().size();
		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getOleObjectsCount() {
		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/oleobjects";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getOleObjects().getOleOjectList().size();
		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getChartsCount() {
		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/charts";

			// sign URI
			String signedURI = Utils.sign(strURI);
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getCharts().getChartList().size();
		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getCommentsCount() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/comments";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getComments().getCommentList().size();
		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public int getHyperlinksCount() {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/hyperlinks";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getHyperlinks().getCount();
		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public boolean hideWorksheet() {

		try {
			// check whether file is set or not
			if (fileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName
					+ "/visible?isVisible=false";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <returns></returns>
	public boolean unhideWorksheet() {

		try {
			// check whether file is set or not
			if (fileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName
					+ "/visible?isVisible=true";

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
	}

	public boolean moveWorksheet(String worksheetName, Position position) {
		try {
			// build URI to get page count
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName
					+ "/worksheets/" + workSheetName + "/position";
			String signedURI = Utils.sign(strURI);

			// serialize the JSON request content
			MoveWorksheet moveWorksheet = new MoveWorksheet();
			moveWorksheet.setDestinationWorksheet(worksheetName);
			moveWorksheet.setPosition(position);

			InputStream responseStream = Utils
					.processCommand(signedURI, "POST");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="formula"></param>
	// / <returns></returns>
	public String calculateFormula(String formula) {

		try {

			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName
					+ "/formulaResult?formula=" + formula;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			CalculateFormulaResponse formulaResponse = gson.fromJson(
					strResponse, CalculateFormulaResponse.class);

			return formulaResponse.getValue();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	public boolean setCellValue(String cellName, String valueType, String value) {
		try {
			// build URI to get page count
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/cells/" + cellName
					+ "?value=" + value + "&type=" + valueType;

			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}

	}

	// / <summary>
	// /
	// / </summary>
	// / <param name="offset"></param>
	// / <param name="count"></param>
	// / <returns></returns>
	public int getRowsCount(int offset, int count) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/rows?offset=" + offset
					+ "&count=" + count;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			WorksheetResponse worksheetResponse = gson.fromJson(strResponse,
					WorksheetResponse.class);

			return worksheetResponse.getRows().getRowCount();

		} catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}

	}

	public Row getRow(int rowIndex) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/rows/" + rowIndex;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			Gson gson = new Gson();

			String strResponse = Utils.streamToString(responseStream);

			// Deserializes the JSON to a object.
			RowsResponse rowsResponse = gson.fromJson(strResponse,
					RowsResponse.class);

			return rowsResponse.getRow();

		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	public boolean deleteRow(int rowIndex) {

		try {

			// check whether file is set or not
			if (fileName == "")
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/rows/" + rowIndex;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI,
					"DELETE");

			// further process JSON response
			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Parse the json string to JObject and Deserializes the JSON to a
			// object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
	}

	public boolean sortData(DataSort dataSort, String cellArea) {
		try {
			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/sort?" + cellArea;

			String signedURI = Utils.sign(strURI);

			String strJSON = "";

			Gson gson = new Gson();

			strJSON = gson.toJson(dataSort, DataSort.class);

			InputStream responseStream = Utils.processCommand(signedURI,
					"POST", strJSON);

			String strResponse = Utils.streamToString(responseStream);

			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}

	public Column getColumn(int columnIndex) {

		try {
			// check whether file is set or not
			if (fileName.equals(""))
				throw new Exception("No file name specified");

			// build URI
			String strURI = AsposeApp.BASE_PRODUCT_URI + "/cells/" + fileName;
			strURI += "/worksheets/" + workSheetName + "/columns/"
					+ columnIndex;

			// sign URI
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();

			// Deserializes the JSON to a object.
			ColumnsResponse columnsResponse = gson.fromJson(strJSON,
					ColumnsResponse.class);

			return columnsResponse.getColumn();
		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	private String workSheetName;
	private String fileName;
	private boolean isVisible;
	private boolean isSelected;
	private boolean isGridLinesVisible;
	private boolean isProtected;
	private int index;
	private String name;
	static final Logger logger = Logger.getLogger(Worksheet.class);

	public String getWorkSheetName() {
		return workSheetName;
	}

	public String getFileName() {
		return fileName;
	}

	public boolean getIsVisible() {
		return isVisible;
	}

	public boolean getIsSelected() {
		return isSelected;
	}

	public boolean getIsGridLinesVisible() {
		return isGridLinesVisible;
	}

	public boolean getIsProtected() {
		return isProtected;
	}

	public int getIndex() {
		return index;
	}

	public String getName() {
		return name;
	}

}
