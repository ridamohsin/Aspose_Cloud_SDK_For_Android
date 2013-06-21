package com.aspose.cloud.sdk.cells;

public class Line
    {
        public Line()
        { 
        
        }

        private LinkResponse Link ;
        private boolean IsAuto ;
        private boolean IsVisible ;
        private boolean isAutomaticColor ;
        private Color Color ;
        private double Transparency ;
        private LineType Style ;
        private WeightType WeightType ;
        private double WeightPt ;
        
        public LinkResponse getLink(){return Link;}
        public boolean getIsAuto(){return IsAuto;}
        public boolean getIsVisible(){return IsVisible;}
        public boolean getisAutomaticColor(){return isAutomaticColor;}
        public Color getColor(){return Color;}
        public double getTransparency(){return Transparency;}
        public LineType getStyle(){return Style;}
        public WeightType getWeightType(){return WeightType;}
        public double getWeightPt(){return WeightPt;}

    }