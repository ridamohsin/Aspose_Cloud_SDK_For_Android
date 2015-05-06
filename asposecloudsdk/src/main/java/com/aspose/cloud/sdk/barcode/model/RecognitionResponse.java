package com.aspose.cloud.sdk.barcode.model;

import com.aspose.cloud.sdk.common.BaseResponse;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RecognitionResponse extends BaseResponse {
	@SerializedName("Barcodes")
	public ArrayList<RecognizedBarCode> barcodes;
	
	public class RecognizedBarCode {
		public String BarcodeType ;
		public String BarcodeValue;
		public ArrayList<String> Region;
		public String Checksum;
    }
}
