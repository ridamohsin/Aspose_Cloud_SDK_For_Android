package com.aspose.cloud.sdk.cells;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

    /// <summary>
    ///  Represents response from the Names resource
    /// </summary>
    public class NamesResponse extends BaseResponse
    {
       
        private LinkResponse link;
        private int Count;
        private List<Name> NameList;
        
        public LinkResponse getlink(){return link;}
        public int getCount(){return Count;}
        public List<Name> getNameList(){return NameList;}
    }