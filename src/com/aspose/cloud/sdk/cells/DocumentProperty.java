package com.aspose.cloud.sdk.cells;
import java.lang.String;

public class DocumentProperty
    {
        public DocumentProperty()
        {
        }

        public DocumentProperty(String propName, String propValue)
        {
            Name = propName;
            Value = propValue;
        }

        private LinkResponse Link ;
        private String Name ;
        private String Value;
        private boolean BuiltIn ;
        
        
        public LinkResponse getLink(){return Link;}
        public boolean getIsBuiltIn(){return BuiltIn;}
        public String getName(){return Name;}
        public String getValue(){return Value;}

        public void setIsBuiltIn(boolean BuiltIn){ this.BuiltIn=BuiltIn;}
        public void setName(String Name ){ this.Name=Name;}
        public void setValue(String Value){ this.Value=Value;}


    }