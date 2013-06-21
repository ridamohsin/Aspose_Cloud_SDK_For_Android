/**
 * 
 */
package com.aspose.cloud.sdk.slides;

import java.lang.String;
import java.util.List;

// / <summary>
// / represents container part of the slides resource response
// / </summary>
public class TextItemsEnvelop {

	private List<String> AlternateLinks;
	private List<ShapeURI> Links;
	private UriResponse SelfUri;
	private List<TextItem> Items;

	public List<String> getAlternateLinks() {
		return AlternateLinks;
	}

	public List<ShapeURI> getLinks() {
		return Links;
	}

	public List<TextItem> getItems() {
		return Items;
	}

	public UriResponse getSelfUri() {
		return SelfUri;
	}
}