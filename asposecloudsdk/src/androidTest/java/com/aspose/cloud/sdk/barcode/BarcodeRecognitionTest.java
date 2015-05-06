package com.aspose.cloud.sdk.barcode;

import com.aspose.cloud.sdk.barcode.api.BarcodeRecognition;
import com.aspose.cloud.sdk.barcode.model.BarcodeTypeEnum;
import com.aspose.cloud.sdk.barcode.model.BinarizationHintsEnum;
import com.aspose.cloud.sdk.barcode.model.EnableChecksumEnum;
import com.aspose.cloud.sdk.barcode.model.RecognitionResponse.RecognizedBarCode;

import junit.framework.TestCase;

import java.util.ArrayList;

public class BarcodeRecognitionTest extends TestCase {

	public BarcodeRecognitionTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testReadBarcodeFromAsposeCloudStorage() throws Exception {
		ArrayList<RecognizedBarCode> barcodes = BarcodeRecognition.readBarcodeFromAsposeCloudStorage("test.png", BarcodeTypeEnum.QR);
		assertNotNull("Failed to read barcode from Aspose Cloud Storage", barcodes);
	}
	
	public void testReadBarcodeFromExternalImageURL() throws Exception {
		ArrayList<RecognizedBarCode> barcodes = BarcodeRecognition.readBarcodeFromExternalImageURL("http://bisqwit.iki.fi/barcode/t0/eEAN-13/s2.0/farial/a1/y80/x332960073452.png", BarcodeTypeEnum.code128);
		assertNotNull("Failed to read barcode from external image URL", barcodes);
	}
	
	public void testReadBarcodeFromSpecificRegionOfImage() throws Exception {
		ArrayList<RecognizedBarCode> barcodes = BarcodeRecognition.readBarcodeFromSpecificRegionOfImage("test.png",
				BarcodeTypeEnum.QR, 10, 10, 200, 100);
		assertNotNull("Failed to read barcode from specific region of image", barcodes);
	}
	
	public void testRecognizeBarcodeWithChecksumOptionFromStorage() throws Exception {
		ArrayList<RecognizedBarCode> barcodes = BarcodeRecognition.recognizeBarcodeWithChecksumOptionFromStorage("test.png",
				BarcodeTypeEnum.QR, EnableChecksumEnum.Default);
		assertNotNull("Failed to recognize barcode with checksum option from storage", barcodes);
	}
	
	public void testRecognizeSpecifiedCountOfBarcodes() throws Exception {
		ArrayList<RecognizedBarCode> barcodes = BarcodeRecognition.recognizeSpecifiedCountOfBarcodes("test.png",
				BarcodeTypeEnum.QR, 2);
		assertNotNull("Failed to recognize specified count of barcodes", barcodes);
	}

	public void testReadBarcodesByApplyingImageProcessingAlgorithm() throws Exception {
		ArrayList<RecognizedBarCode> barcodes = BarcodeRecognition.readBarcodesByApplyingImageProcessingAlgorithm("barcode.png",
				BarcodeTypeEnum.code39standard, BinarizationHintsEnum.MedianSmoothing, "MyDropboxStorage", null);
		assertNotNull("Failed to read barcodes by applying image processing algorithm", barcodes);
	}

	public void testReadBarcodeFromLocalImage() throws Exception {
		ArrayList<RecognizedBarCode> barcodes = BarcodeRecognition.
				readBarcodeFromLocalImage("/storage/emulated/0/AsposeFiles/barcode.png", null,
				BarcodeTypeEnum.code39standard, "MyDropboxStorage", null);
		assertNotNull("Failed to read barcode from local image", barcodes);
	}
}
