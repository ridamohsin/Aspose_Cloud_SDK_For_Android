package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the Comments resource
    /// </summary>
    public class CommentsResponse extends BaseResponse
    {        
        private LinkResponse link ;
        private List<LinkResponse> CommentList ;
        private Comment Comment ;
        
        public LinkResponse getlink(){return link;}
        public List<LinkResponse> getCommentList(){return CommentList;}
        public Comment getComment(){return Comment;}
    }