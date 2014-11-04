package com.aspose.cloud.sdk.cells;
import java.lang.String;

import com.google.gson.annotations.SerializedName;

public class WorksheetMovingRequest {
	@SerializedName("DestinationWorksheet")
	public String destinationWorksheet;
	@SerializedName("Position")
	public PositionEnum position;    
}