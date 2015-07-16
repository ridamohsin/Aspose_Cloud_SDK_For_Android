package com.aspose.cloud.sdk.cells;

import com.aspose.cloud.sdk.cells.api.PivotTables;
import com.aspose.cloud.sdk.cells.model.CreatePivotTableRequest;
import com.aspose.cloud.sdk.cells.model.FontModel;
import com.aspose.cloud.sdk.cells.model.PivotTableData;
import com.aspose.cloud.sdk.cells.model.PivotTableFieldRequest;
import com.aspose.cloud.sdk.cells.model.PivotTableStyleRequest;
import com.aspose.cloud.sdk.cells.model.PivotTablesInfo;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by muhammadsohailismail on 7/16/15.
 */
public class PivotTablesTestCase extends TestCase {

    private PivotTables pivotTableObject;

    public PivotTablesTestCase(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        super.setUp();
        pivotTableObject = new PivotTables("pivot-tables.xls", "Sheet4");
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testGetWorksheetPivotTablesInfo() throws Exception {
        PivotTablesInfo pivotTables = pivotTableObject.getWorksheetPivotTablesInfo();
        assertNotNull("Failed to get worksheet pivottables info", pivotTables);
    }

    public void testAddAPivotTableIntoWorksheet() throws Exception {
        CreatePivotTableRequest createPivotTableRequest = new CreatePivotTableRequest();
        createPivotTableRequest.name = "SalePivotTable";
        createPivotTableRequest.sourceData = "A1:F214";
        createPivotTableRequest.destCellName = "A1";
        createPivotTableRequest.useSameSource = true;

        createPivotTableRequest.pivotFieldRows = new ArrayList<Integer>();
        createPivotTableRequest.pivotFieldRows.add(1);

        createPivotTableRequest.pivotFieldColumns = new ArrayList<Integer>();
        createPivotTableRequest.pivotFieldColumns.add(1);

        createPivotTableRequest.pivotFieldData = new ArrayList<Integer>();
        createPivotTableRequest.pivotFieldData.add(1);

        PivotTableData pivotTable = pivotTableObject.addAPivotTableIntoWorksheet(createPivotTableRequest);
        assertNotNull("Failed to add a pivot table into worksheet", pivotTable);
    }

    public void testDeleteWorksheetPivotTables() throws Exception {
        boolean isWorksheetPivotTablesDeletedSuccessfully = pivotTableObject.deleteWorksheetPivotTables();
        assertTrue("Failed to delete worksheet pivot tables", isWorksheetPivotTablesDeletedSuccessfully);
    }

    public void testGetWorksheetPivotTableInfoByIndex() throws Exception {
        PivotTableData pivotTable = pivotTableObject.getWorksheetPivotTableInfoByIndex(0);
        assertNotNull("Failed to get worksheet pivot table info by index", pivotTable);
    }

    public void testAddPivotFieldIntoPivotTable() throws Exception {
        PivotTableFieldRequest pivotTableFieldRequest = new PivotTableFieldRequest();
        pivotTableFieldRequest.data = new ArrayList<Integer>();
        pivotTableFieldRequest.data.add(1);
        pivotTableFieldRequest.data.add(2);

        boolean isPivotFieldAddedSuccessfully = pivotTableObject.addPivotFieldIntoPivotTable(0, "Row", pivotTableFieldRequest);
        assertTrue("Failed to add pivot field into pivot table", isPivotFieldAddedSuccessfully);
    }

    public void testUpdateCellStyleForPivotTable() throws Exception {
        int pivotTableIndex = 0;
        int column = 1;
        int row = 1;
        PivotTableStyleRequest pivotTableStyleRequest = new PivotTableStyleRequest();
        pivotTableStyleRequest.IsGradient = true;
        pivotTableStyleRequest.font = new FontModel();
        pivotTableStyleRequest.font.IsBold = true;

        boolean isCellStyleUpdatedSuccessfully = pivotTableObject.updateCellStyleForPivotTable(pivotTableIndex, column, row, pivotTableStyleRequest);
        assertTrue("Failed to update cell style for pivot table", isCellStyleUpdatedSuccessfully);
    }

    public void testUpdateStyleForPivotTable() throws Exception {
        int pivotTableIndex = 0;
        PivotTableStyleRequest pivotTableStyleRequest = new PivotTableStyleRequest();
        pivotTableStyleRequest.IsGradient = true;
        pivotTableStyleRequest.font = new FontModel();
        pivotTableStyleRequest.font.IsBold = true;

        boolean isStyleUpdatedSuccessfully = pivotTableObject.updateStyleForPivotTable(pivotTableIndex, pivotTableStyleRequest);
        assertTrue("Failed to update style for pivot table", isStyleUpdatedSuccessfully);
    }

    public void testDeleteWorksheetPivotTableByIndex() throws Exception {
        boolean isWorksheetPivotTableDeletedSuccessfully = pivotTableObject.deleteWorksheetPivotTableByIndex(0);
        assertTrue("Failed to delete worksheet pivot table by index", isWorksheetPivotTableDeletedSuccessfully);
    }

}
