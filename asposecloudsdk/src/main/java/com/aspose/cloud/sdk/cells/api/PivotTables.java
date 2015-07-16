package com.aspose.cloud.sdk.cells.api;

import android.net.Uri;

import com.aspose.cloud.sdk.cells.model.CreatePivotTableRequest;
import com.aspose.cloud.sdk.cells.model.GetPivotTableInfoByIndexRespose;
import com.aspose.cloud.sdk.cells.model.GetWorksheetPivotTablesInfoResponse;
import com.aspose.cloud.sdk.cells.model.PivotTableData;
import com.aspose.cloud.sdk.cells.model.PivotTableFieldRequest;
import com.aspose.cloud.sdk.cells.model.PivotTableStyleRequest;
import com.aspose.cloud.sdk.cells.model.PivotTablesInfo;
import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * PivotTables --- Using this class you can get worksheet pivot tables info, Get worksheet pivot table info by index,
 * Add a pivot table into worksheet, Add pivot field into pivot table, Delete worksheet pivot tables, Delete worksheet pivot table by index,
 * Update cell style for pivot table and Update style for pivot table.
 * @author   M. Sohail Ismail
 */
public class PivotTables {

    private static final String CELLS_URI = AsposeApp.BASE_PRODUCT_URI + "/cells/";

    private String fileName;
    private String worksheetName;

    public PivotTables(String fileName, String worksheetName) {
        this.fileName = Uri.encode(fileName);
        this.worksheetName = Uri.encode(worksheetName);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Get worksheet pivot tables info.
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return An object that contains worksheet pivot tables info
     */
    public PivotTablesInfo getWorksheetPivotTablesInfo() throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        PivotTablesInfo pivotTables = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(worksheetName == null || worksheetName.length() == 0) {
            throw new IllegalArgumentException("Worksheet name cannot be null or empty");
        }

        String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/pivottables";
        //sign URL
        String signedURL = Utils.sign(strURL);

        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        Gson gson = new Gson();
        GetWorksheetPivotTablesInfoResponse pivotTableInfoResponse = gson.fromJson(responseJSONString, GetWorksheetPivotTablesInfoResponse.class);
        if (pivotTableInfoResponse.getCode().equals("200") && pivotTableInfoResponse.getStatus().equals("OK")) {
            pivotTables = pivotTableInfoResponse.pivotTables;
        }

        return pivotTables;
    }

    /**
     * Add a pivot table into worksheet.
     * @param createPivotTableRequest Request to create new pivot table.
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Newly added pivot table data
     */
    public PivotTableData addAPivotTableIntoWorksheet(CreatePivotTableRequest createPivotTableRequest) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        PivotTableData pivotTable = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(worksheetName == null || worksheetName.length() == 0) {
            throw new IllegalArgumentException("Worksheet name cannot be null or empty");
        }

        if(createPivotTableRequest == null) {
            throw new IllegalArgumentException("createPivotTableRequest cannot be null");
        }

        String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/pivottables";
        //sign URL
        String signedURL = Utils.sign(strURL);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String requestJSONString = gson.toJson(createPivotTableRequest, CreatePivotTableRequest.class);

        InputStream responseStream = Utils.processCommand(signedURL, "PUT", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        GetPivotTableInfoByIndexRespose pivotTableInfoByIndexResponse = gson.fromJson(responseJSONString, GetPivotTableInfoByIndexRespose.class);
        if (pivotTableInfoByIndexResponse.getCode().equals("200") && pivotTableInfoByIndexResponse.getStatus().equals("OK")) {
            pivotTable = pivotTableInfoByIndexResponse.pivotTable;
        }

        return pivotTable;
    }

    /**
     * Delete worksheet pivot tables.
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Boolean variable that indicates whether all pivot tables deleted successfully of a worksheet
     */
    public boolean deleteWorksheetPivotTables() throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        boolean isWorksheetPivotTablesDeletedSuccessfully = false;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(worksheetName == null || worksheetName.length() == 0) {
            throw new IllegalArgumentException("Worksheet name cannot be null or empty");
        }

        String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/pivottables";
        //sign URL
        String signedURL = Utils.sign(strURL);

        InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        Gson gson = new Gson();
        BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
        if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
            isWorksheetPivotTablesDeletedSuccessfully = true;
        }

        return isWorksheetPivotTablesDeletedSuccessfully;
    }

    /**
     * Get worksheet pivot table info by index.
     * @param pivotTableIndex Pivot table index.
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return An object that contains pivot table data
     */
    public PivotTableData getWorksheetPivotTableInfoByIndex(int pivotTableIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        PivotTableData pivotTable = null;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(worksheetName == null || worksheetName.length() == 0) {
            throw new IllegalArgumentException("Worksheet name cannot be null or empty");
        }

        String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/pivottables/" + pivotTableIndex;
        //sign URL
        String signedURL = Utils.sign(strURL);

        InputStream responseStream = Utils.processCommand(signedURL, "GET");
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        Gson gson = new Gson();
        GetPivotTableInfoByIndexRespose pivotTableInfoByIndexResponse = gson.fromJson(responseJSONString, GetPivotTableInfoByIndexRespose.class);
        if (pivotTableInfoByIndexResponse.getCode().equals("200") && pivotTableInfoByIndexResponse.getStatus().equals("OK")) {
            pivotTable = pivotTableInfoByIndexResponse.pivotTable;
        }

        return pivotTable;
    }

    /**
     * Add pivot field into pivot table.
     * @param pivotTableIndex Pivot table index.
     * @param pivotFieldType Pivot field type.
     * @param pivotTableFieldRequest Object that contains field indexes.
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Boolean object that indicates whether pivot field added successfully to pivot table
     */
    public boolean addPivotFieldIntoPivotTable(int pivotTableIndex, String pivotFieldType, PivotTableFieldRequest pivotTableFieldRequest) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        boolean isPivotFieldAddedSuccessfully = false;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(worksheetName == null || worksheetName.length() == 0) {
            throw new IllegalArgumentException("Worksheet name cannot be null or empty");
        }

        if(pivotFieldType == null || pivotFieldType.length() == 0) {
            throw new IllegalArgumentException("Pivot field type cannot be null or empty");
        }

        if(pivotTableFieldRequest == null) {
            throw new IllegalArgumentException("pivotTableFieldRequest cannot be null");
        }

        String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/pivottables/" + pivotTableIndex + "/PivotField?pivotFieldType=" + pivotFieldType;
        //sign URL
        String signedURL = Utils.sign(strURL);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String requestJSONString = gson.toJson(pivotTableFieldRequest, PivotTableFieldRequest.class);

        InputStream responseStream = Utils.processCommand(signedURL, "PUT", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
        if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
            isPivotFieldAddedSuccessfully = true;
        }

        return isPivotFieldAddedSuccessfully;
    }

    /**
     * Delete worksheet pivot table by index.
     * @param pivotTableIndex Pivot table index.
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Boolean variable that indicates whether pivot table deleted successfully of worksheet
     */
    public boolean deleteWorksheetPivotTableByIndex(int pivotTableIndex) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        boolean isWorksheetPivotTableDeletedSuccessfully = false;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(worksheetName == null || worksheetName.length() == 0) {
            throw new IllegalArgumentException("Worksheet name cannot be null or empty");
        }

        String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/pivottables/" + pivotTableIndex;
        //sign URL
        String signedURL = Utils.sign(strURL);

        InputStream responseStream = Utils.processCommand(signedURL, "DELETE");
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        Gson gson = new Gson();
        BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
        if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
            isWorksheetPivotTableDeletedSuccessfully = true;
        }

        return isWorksheetPivotTableDeletedSuccessfully;
    }

    /**
     * Update cell style for pivot table.
     * @param pivotTableIndex Pivot table index.
     * @param column Column Index
     * @param row Row Index
     * @param pivotTableStyleRequest Request to update cell style of Pivot table
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Boolean variable that indicates whether cell style updated successfully for pivot table
     */
    public boolean updateCellStyleForPivotTable(int pivotTableIndex, int column, int row, PivotTableStyleRequest pivotTableStyleRequest) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        boolean isCellStyleUpdatedSuccessfully = false;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(worksheetName == null || worksheetName.length() == 0) {
            throw new IllegalArgumentException("Worksheet name cannot be null or empty");
        }

        if(pivotTableStyleRequest == null) {
            throw new IllegalArgumentException("pivotTableStyleRequest cannot be null");
        }

        String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/pivottables/" + pivotTableIndex + "/Format?column=" + column + "&row=" + row;
        //sign URL
        String signedURL = Utils.sign(strURL);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String requestJSONString = gson.toJson(pivotTableStyleRequest, PivotTableStyleRequest.class);

        InputStream responseStream = Utils.processCommand(signedURL, "POST", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
        if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
            isCellStyleUpdatedSuccessfully = true;
        }

        return isCellStyleUpdatedSuccessfully;
    }

    /**
     * Update style for pivot table.
     * @param pivotTableIndex Pivot table index.
     * @param pivotTableStyleRequest Request to update cell style of Pivot table
     * @throws java.security.InvalidKeyException If initialization fails because the provided key is null.
     * @throws java.security.NoSuchAlgorithmException If the specified algorithm (HmacSHA1) is not available by any provider.
     * @throws java.io.IOException If there is an IO error
     * @return Boolean variable that indicates whether style updated successfully for pivot table.
     */
    public boolean updateStyleForPivotTable(int pivotTableIndex, PivotTableStyleRequest pivotTableStyleRequest) throws InvalidKeyException, NoSuchAlgorithmException, IOException {

        boolean isStyleUpdatedSuccessfully = false;

        if(fileName == null || fileName.length() == 0) {
            throw new IllegalArgumentException("File name cannot be null or empty");
        }

        if(worksheetName == null || worksheetName.length() == 0) {
            throw new IllegalArgumentException("Worksheet name cannot be null or empty");
        }

        if(pivotTableStyleRequest == null) {
            throw new IllegalArgumentException("pivotTableStyleRequest cannot be null");
        }

        String strURL = CELLS_URI + fileName + "/worksheets/" + worksheetName + "/pivottables/" + pivotTableIndex + "/FormatAll";
        //sign URL
        String signedURL = Utils.sign(strURL);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String requestJSONString = gson.toJson(pivotTableStyleRequest, PivotTableStyleRequest.class);

        InputStream responseStream = Utils.processCommand(signedURL, "POST", requestJSONString);
        String responseJSONString = Utils.streamToString(responseStream);

        //Parsing JSON
        BaseResponse baseResponse = gson.fromJson(responseJSONString, BaseResponse.class);
        if (baseResponse.getCode().equals("200") && baseResponse.getStatus().equals("OK")) {
            isStyleUpdatedSuccessfully = true;
        }

        return isStyleUpdatedSuccessfully;
    }
}

