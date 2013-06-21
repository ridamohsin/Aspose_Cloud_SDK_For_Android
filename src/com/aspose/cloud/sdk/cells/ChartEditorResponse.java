package com.aspose.cloud.sdk.cells;

import com.aspose.cloud.sdk.common.BaseResponse;

	/// <summary>
    ///  Represents response from the Charts resource
    /// </summary>
    public class ChartEditorResponse extends BaseResponse
    {

        private ChartArea ChartArea ;

        private FillFormat FillFormat ;

        private Line Line ;
        
        public ChartArea getChartArea(){return ChartArea;}

        public FillFormat getFillFormat(){return FillFormat;}

        public Line getLine(){return Line;}

    }