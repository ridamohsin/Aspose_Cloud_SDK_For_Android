package com.aspose.cloud.sdk.cells;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the worksheet resource
    /// </summary>
    public class WorksheetResponse extends BaseResponse
    {
       
        private AutoShapesResponse AutoShapes;
        private CellsResponse Cells;
        private ChartsResponse Charts;
        private CommentsResponse Comments;
        private ConditionalFormattingResponse ConditionalFormattings;
        private HyperlinksResponse Hyperlinks;
        private MergedCellsResponse MergedCells;
        private OleObjectsResponse OleObjects;
        private PicturesResponse Pictures;
        private LinkResponse link;
        private ValidationsResponse Validations;
        private RowsResponse Rows;
        private ColumnsResponse Columns;
        private Worksheet Worksheet;

        public AutoShapesResponse getAutoShapes(){return AutoShapes;}
        public CellsResponse getCells(){return Cells;}
        public ChartsResponse getCharts(){return Charts;}
        public CommentsResponse getComments(){return Comments;}
        public ConditionalFormattingResponse getConditionalFormattings(){return ConditionalFormattings;}
        public HyperlinksResponse getHyperlinks(){return Hyperlinks;}
        public MergedCellsResponse getMergedCells(){return MergedCells;}
        public OleObjectsResponse getOleObjects(){return OleObjects;}
        public PicturesResponse getPictures(){return Pictures;}
        public LinkResponse getlink(){return link;}
        public ValidationsResponse getValidations(){return Validations;}
        public RowsResponse getRows(){return Rows;}
        public ColumnsResponse getColumns(){return Columns;}
        public Worksheet getWorksheet(){return Worksheet;}
    }