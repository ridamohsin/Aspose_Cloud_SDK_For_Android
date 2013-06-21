package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the Rows resource
    /// </summary>
    public class RowsResponse extends BaseResponse
    {
        
        private LinkResponse link;
        private int RowCount;               
        private List<LinkResponse> RowsList;
        private Row Row;
        
        public LinkResponse getLink(){return link;}
        public int getRowCount(){return RowCount;}               
        public List<LinkResponse> getRowsList(){return RowsList;}
        public Row getRow(){return Row;}
       
    }