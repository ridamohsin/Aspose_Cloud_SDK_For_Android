package com.aspose.cloud.sdk.cells;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.LinkModel;
import com.google.gson.annotations.SerializedName;

public class ChartResponse extends BaseResponse {
	@SerializedName("Chart")
	public ChartResult chart;
	
	public class ChartResult {
		boolean AutoScaling;
	    ChartLink BackWall;
	    ChartLink CategoryAxis;
	    ChartLink ChartArea;
	    ChartLink ChartDataTable;
	    ChartLink ChartObject;
	    int DepthPercent;
	    int Elevation;
	    int FirstSliceAngle;
	    int GapDepth;
	    int GapWidth;
	    int HeightPercent;
	    boolean HidePivotFieldButtons;
	    boolean Is3D;
	    boolean IsRectangularCornered;
	    ChartLink Legend;
	    String Name;
	    ChartLink NSeries;
	    ChartLink PageSetup;
	    int Perspective;
	    String Placement;
	    ChartLink PlotArea;
	    String PlotEmptyCellsType;
	    boolean PlotVisibleCells;
	    String PrintSize;
	    boolean RightAngleAxes;
	    int RotationAngle;
	    ChartLink SecondCategoryAxis;
	    ChartLink SecondValueAxis;
	    ChartLink Shapes;
	    boolean ShowDataTable;
	    boolean ShowLegend;
	    ChartLink SideWall;
	    boolean SizeWithWindow;
	    int Style;
	    ChartLink Title;
	    String Type;
	    ChartLink ValueAxis;
	    boolean WallsAndGridlines2D;
	    LinkModel link;
	}
	
	public class ChartLink {
		public LinkModel link;
	}
}
