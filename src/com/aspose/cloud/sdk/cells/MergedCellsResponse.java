package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the MergedCells resource
    /// </summary>
    public class MergedCellsResponse extends BaseResponse
    {      
        private LinkResponse link ;
        private int Count ;
        private List<LinkResponse> MergedCellList ;
        private MergedCell MergedCell ;
        
        public LinkResponse getlink(){return link;}
        public int getCount(){return Count;}
        public List<LinkResponse> getMergedCellList(){return MergedCellList;}
        public MergedCell getMergedCell(){return MergedCell;}

    }