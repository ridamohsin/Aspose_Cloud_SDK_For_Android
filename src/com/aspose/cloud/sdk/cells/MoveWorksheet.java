package com.aspose.cloud.sdk.cells;
import java.lang.String;

public class MoveWorksheet
    {
        public MoveWorksheet()
        { 
        
        }

        private String DestinationWorksheet;
        private Position Position;   
        
        public String getDestinationWorksheet(){return DestinationWorksheet;}
        public Position getPosition(){return Position;}
        
        public void setDestinationWorksheet(String DestinationWorksheet){ this.DestinationWorksheet=DestinationWorksheet;}
        public void setPosition(Position Position){ this.Position=Position;}

    }