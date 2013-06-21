package com.aspose.cloud.sdk.cells;

import com.aspose.cloud.sdk.common.BaseResponse;

    public class TextEditorResponse extends BaseResponse
    {
        private TextItemsResponse TextItems ;
        private TextItem TextItem ;
        private int Matches ;
        
        public TextItemsResponse getTextItems(){return TextItems;}
        public TextItem getTextItem(){return TextItem;}
        public int getMatches(){return Matches;}
        
        
    }