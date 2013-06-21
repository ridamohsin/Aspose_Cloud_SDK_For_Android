package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the OleObjects resource
    /// </summary>
    public class OleObjectsResponse extends BaseResponse
    {        
        private LinkResponse link ;
        private List<LinkResponse> OleOjectList ;
        private OleObject OleObject ;

        public LinkResponse getLink(){return link;}
        public List<LinkResponse> getOleOjectList(){return OleOjectList;}
        public OleObject getOleObject(){return OleObject;}
    }