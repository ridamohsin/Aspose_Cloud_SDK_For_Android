package com.aspose.cloud.sdk.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the TextItems resource
    /// </summary>
    public class TextItemsResponse
    {
        public TextItemsResponse() { }       
        private LinkResponse link;     
        private List<TextItem> TextItemList;
        
        public LinkResponse getLink(){return link;}   
        public List<TextItem> getTextItemList(){return TextItemList;}
        
        
    }