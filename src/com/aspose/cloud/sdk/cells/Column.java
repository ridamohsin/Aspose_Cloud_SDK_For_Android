package com.aspose.cloud.sdk.cells;
import java.lang.String;

public class Column
    {
        /// <summary>
        /// Column Class Default Constructor
        /// </summary>
        public Column()
        {
            
        }
       
        private LinkResponse link ;
        private String Index ;
        private int GroupLevel ;
        private double Width ;
        private boolean IsHidden ;       
        
        public LinkResponse getlink(){return link;}
        public String getIndex(){return Index;}
        public int getGroupLevel(){return GroupLevel;}
        public double getWidth(){return Width;}
        public boolean getIsHidden(){return IsHidden;}    

    }