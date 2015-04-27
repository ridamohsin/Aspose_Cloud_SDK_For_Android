package com.aspose.cloud.sdk.cells;

import com.aspose.cloud.sdk.cells.api.Images;
import com.aspose.cloud.sdk.cells.model.ValidFormatsOfWorksheet;

import junit.framework.TestCase;

import java.io.File;

public class ImagesTestCase extends TestCase {

	private Images images;
	
	public ImagesTestCase(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		images = new Images("myworkbook.xlsx", "Sheet1");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testConvertAutoShapeToImage() throws Exception {
		String localFilePath = images.convertAutoShapeToImage(0, ValidFormatsOfWorksheet.jpeg, "autoshape.jpeg");
		File file = new File(localFilePath);
		assertEquals("Failed to convert an autoshape to image", true, file.exists());
	}

}
