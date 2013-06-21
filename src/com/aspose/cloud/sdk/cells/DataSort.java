package com.aspose.cloud.sdk.cells;
import java.util.List;

public class DataSort
    {
        public DataSort()
        { 
        
        }

        private boolean CaseSensitive ;
        private boolean HasHeaders ;
        private boolean SortLeftToRight ;
        private List <SortKey> KeyList ;
        
        
        public boolean getCaseSensitive(){return CaseSensitive;}
        public boolean getHasHeaders(){return HasHeaders;}
        public boolean getSortLeftToRight(){return SortLeftToRight;}
        public List <SortKey> getKeyList(){return KeyList;}

    }