package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the Hyperlinks resource
    /// </summary>
    public class HyperlinksResponse extends BaseResponse
    {        
        private LinkResponse link;
        private int Count;               
        private List<LinkResponse> HyperlinkList;
        private Hyperlink Hyperlink;

        public LinkResponse getlink(){return link;}
        public int getCount(){return Count;}               
        public List<LinkResponse> getHyperlinkList(){return HyperlinkList;}  
        public Hyperlink getHyperlink(){return Hyperlink;} 
      
    }