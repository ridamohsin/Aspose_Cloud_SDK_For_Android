package com.aspose.cloud.sdk.cells;
import java.lang.String;

public class Row
    {
        /// <summary>
        /// Row Class Default Constructor
        /// </summary>
        public Row()
        {
            
        }
       
        private LinkResponse link ;
        private String Index ;
        private int GroupLevel ;
        private double Height ;
        private boolean IsHidden ;
        private boolean IsBlank ;
        private boolean IsHeightMatched ;       

        public LinkResponse getLink(){return link;}
        public String getIndex(){return Index;}
        public int getGroupLevel(){return GroupLevel;}
        public double getHeight(){return Height;}
        public boolean getIsHidden(){return IsHidden;}
        public boolean getIsBlank(){return IsBlank;}
        public boolean getIsHeightMatched(){return IsHeightMatched;}
    }