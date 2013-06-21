package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    /// Represents response from the Autoshape resource
    /// </summary>
    public class AutoShapesResponse extends BaseResponse
    {
       
        private LinkResponse link ;
                
        private List<LinkResponse> AuotShapeList ;

        private AutoShape AutoShape ;
        
        
        public LinkResponse getlink(){return link;}
        
        public List<LinkResponse> getAuotShapeList(){return AuotShapeList;}
        
        public AutoShape getAutoShape(){return AutoShape;}
    }