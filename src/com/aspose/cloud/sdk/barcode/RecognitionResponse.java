/**
 * 
 */
package com.aspose.cloud.sdk.barcode;
import java.util.List;

import com.aspose.cloud.sdk.common.BaseResponse;

public class RecognitionResponse extends BaseResponse
{
   
    private List<RecognizedBarCode> Barcodes ;
    
    public List<RecognizedBarCode> getBarcodes(){return Barcodes;}
}