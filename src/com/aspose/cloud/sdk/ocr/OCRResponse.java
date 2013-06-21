package com.aspose.cloud.sdk.ocr;

import com.aspose.cloud.sdk.common.BaseResponse;

public class OCRResponse extends BaseResponse {

	private String Text;
	private OCREnvelop PartsInfo;

	public String getText() {
		return Text;
	}

	public OCREnvelop getPartsInfo() {
		return PartsInfo;
	}
}
