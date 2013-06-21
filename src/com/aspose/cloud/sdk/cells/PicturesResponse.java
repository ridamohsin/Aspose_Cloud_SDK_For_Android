package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the Pictures resource
    /// </summary>
    public class PicturesResponse extends BaseResponse
    {
        
        private LinkResponse link;
        private List<LinkResponse> PictureList;
        private Picture Picture;
        
        public LinkResponse getLink(){return link;}
        public List<LinkResponse> getPictureList(){return PictureList;}
        public Picture getPicture(){return Picture;}

    }