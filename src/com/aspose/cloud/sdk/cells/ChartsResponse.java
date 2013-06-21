package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the Charts resource
    /// </summary>
    public class ChartsResponse extends BaseResponse
    {        
        private LinkResponse link ;

        private List<LinkResponse> ChartList ;

        private Chart Chart ;
        
        public LinkResponse getlink() {return link;}

        public List<LinkResponse> getChartList(){return ChartList;}

        public Chart getChart(){return Chart;}

    }