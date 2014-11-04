package com.aspose.cloud.sdk.test.cells;

import com.aspose.cloud.sdk.cells.ValidFormatsOfWorksheet;
import com.aspose.cloud.sdk.cells.Images;

import junit.framework.TestCase;

public class ImagesTest extends TestCase {

	private Images images;
	
	public ImagesTest(String name) {
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
		images.convertAutoShapeToImage(0, ValidFormatsOfWorksheet.jpeg);
	}

}
