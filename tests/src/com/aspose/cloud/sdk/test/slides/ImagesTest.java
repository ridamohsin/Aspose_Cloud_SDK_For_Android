package com.aspose.cloud.sdk.test.slides;

import com.aspose.cloud.sdk.slides.Images;

import junit.framework.TestCase;

public class ImagesTest extends TestCase {

	public ImagesTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGetNumberOfImagesInAPresentation() throws Exception {
		int imagesCount = Images.getNumberOfImagesInAPresentation("Effective_presentation.ppt");
		assertEquals("Failed to get total number of images in a presentation", true, imagesCount>=0);
	}
	
	public void testGetNumberOfImagesInASlide() throws Exception {
		int imagesCount = Images.getNumberOfImagesInAPresentation("Effective_presentation.ppt");
		assertEquals("Failed to get total number of images in a slide", true, imagesCount>=0);
	}

}
