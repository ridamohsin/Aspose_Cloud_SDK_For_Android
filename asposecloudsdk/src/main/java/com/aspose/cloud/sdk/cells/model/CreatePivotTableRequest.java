package com.aspose.cloud.sdk.cells.model;

import java.util.ArrayList;

/**
 * Created by muhammadsohailismail on 7/16/15.
 */
public class CreatePivotTableRequest {
    public String name;
    public String sourceData;
    public String destCellName;
    public boolean useSameSource;
    public ArrayList<Integer> pivotFieldRows; //Array of Integers
    public ArrayList<Integer> pivotFieldColumns; //Array of Integers
    public ArrayList<Integer> pivotFieldData; //Array of Integers
}
