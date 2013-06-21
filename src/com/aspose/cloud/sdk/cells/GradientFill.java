package com.aspose.cloud.sdk.cells;

import java.util.List;

public class GradientFill
    {
        public GradientFill()
        { 
        
        }

        private GradientFillType FillType;
        private GradientDirectionType DirectionType;
        private int Angle;
        private List<GradientFillStop> GradientFillStops;
        
        
        public GradientFillType getFillType(){return FillType;}
        public GradientDirectionType getDirectionType(){return DirectionType;}
        public int getAngle(){return Angle;}
        public List<GradientFillStop> getGradientFillStops(){return GradientFillStops;}
        
    }