package com.aspose.cloud.sdk.cells;
import java.util.List;

    /// <summary>
    ///  Represents response from the Document Properties resource
    /// </summary>
    public class DocumentPropertiesResponse 
    {
        public DocumentPropertiesResponse() { }
               
        private LinkResponse Link ;
        private List<DocumentProperty> DocumentPropertyList ;
        
        public LinkResponse getLink(){return Link;}
        public List<DocumentProperty> getDocumentPropertyList(){return DocumentPropertyList;}
    }