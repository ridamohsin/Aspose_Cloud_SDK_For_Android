package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the worksheets resource
    /// </summary>
    public class WorksheetsResponse extends BaseResponse
    {

        private List<Worksheet> WorksheetList;
        private LinkResponse Link ;
        
        public List<Worksheet> getWorksheetList(){return WorksheetList;}
        public LinkResponse getLink(){return Link;}

    }