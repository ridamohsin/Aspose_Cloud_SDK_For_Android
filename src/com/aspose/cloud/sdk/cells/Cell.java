package com.aspose.cloud.sdk.cells;
import java.lang.String;

public class Cell
    {
        /// <summary>
        /// Cell Class Default Constructor
        /// </summary>
        public Cell()
        {
            
        }
       
        private LinkResponse link ;
        private String Name ;
        private String Type ;
        private int Row ;
        private int Column ;
        private String Value ;
        private String Formula ;
        private boolean IsFormula ;
        private boolean IsMerged ;  
        
        
        public LinkResponse getlink(){return link;}
        public String getName(){return Name;}
        public String getType(){return Type;}
        public int getRow(){return Row;}
        public int getColumn(){return Column;}
        public String getValue(){return Value;}
        public String getFormula(){return Formula;}
        public boolean getIsFormula(){return IsFormula;}
        public boolean getIsMerged(){return IsMerged;}

    }
