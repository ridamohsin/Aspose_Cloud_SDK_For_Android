/**
 * 
 */
package com.aspose.cloud.sdk.pdf;

import java.io.InputStream;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.aspose.cloud.sdk.common.Product;
import com.aspose.cloud.sdk.common.Utils;
import com.aspose.cloud.sdk.storage.Folder;
import com.google.gson.Gson;

/**
 * @author Mudassir
 * 
 */
// / <summary>
// / Deals with Annotations, Bookmarks, Attachments and Links in PDF document
// / </summary>

public class AnnotationEditor {
	public AnnotationEditor(String fileName) {
		this.fileName = fileName;
		gson = new Gson();
	}

	// / <summary>
	// / PDF document name
	// / </summary>
	public String fileName;
	static final Logger logger = Logger.getLogger(AnnotationEditor.class);

	Gson gson = null;

	// / <summary>
	// / Gets number of annotations on a specified document page
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <returns>returns number of annotations on a specified page</returns>

	public int getAnnotationsCount(int pageNumber) throws SignatureException {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/annotations";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse the json String to JObject and Deserializes the JSON to a
			// object.
			AnnotationsResponse annotationsResponse = gson.fromJson(strJSON,
					AnnotationsResponse.class);

			int count = annotationsResponse.getAnnotations().getList().size();

			return count;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// / Gets list of all the annotations on a specified document page
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <returns>List of annotations on a page</returns>

	public List<Annotation> getAllAnnotations(int pageNumber)
			throws SignatureException {
		List<Annotation> ListAnnotations = new java.util.ArrayList<Annotation>();
		int iTotalAnnotation = getAnnotationsCount(pageNumber);
		for (int index = 1; index <= iTotalAnnotation; index++) {
			ListAnnotations.add(getAnnotation(pageNumber, index));
		}
		return ListAnnotations;

	}

	// / <summary>
	// / Gets a specfied annotation on a specified document page
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="annotationIndex"></param>
	// / <returns>Selected annotation on a page</returns>

	public Annotation getAnnotation(int pageNumber, int annotationIndex) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber)
					+ "/annotations/" + Integer.toString(annotationIndex);
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse the json String to JObject and Deserializes the JSON to a
			// object.
			AnnotationResponse annotationResponse = gson.fromJson(strJSON,
					AnnotationResponse.class);

			return annotationResponse.getAnnotation();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Gets total number of Bookmarks in a Pdf document
	// / </summary>
	// / <returns>Total number of Bookmarks</returns>

	public int getBookmarksCount() {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/bookmarks/";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and Deserializes the JSON to a object.
			BookmarksResponse bookmarksResponse = gson.fromJson(strJSON,
					BookmarksResponse.class);

			int count = bookmarksResponse.getBookmarks().getList().size();

			return count;
		}

		catch (Exception e) {

			logger.error(e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// / Gets number of child bookmarks in a specfied parent bookmark
	// / </summary>
	// / <param name="iParent"></param>
	// / <returns>Toatl number of child bookmarks in a specific parent
	// bookmark</returns>

	public int getChildBookmarksCount(int iParent) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/bookmarks/" + Integer.toString(iParent) + "/bookmarks";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and Deserializes the JSON to a object.
			BookmarksResponse bookmarksResponse = gson.fromJson(strJSON,
					BookmarksResponse.class);

			int count = bookmarksResponse.getBookmarks().getList().size();

			return count;

		} catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// / Gets list of all the Bookmarks in a Pdf document
	// / </summary>
	// / <param name="getChildBookmarks"></param>
	// / <returns>List of all the Bookmarks in Pdf document</returns>

	public List<Bookmark> getAllBookmarks(boolean getChildBookmarks) {

		List<Bookmark> ListBookmarks = new ArrayList<Bookmark>();

		int iTotalBookmarks = getBookmarksCount();
		int[] ChildNum = new int[iTotalBookmarks];
		int temChildCount = 0;
		int iTotalParent = iTotalBookmarks;

		for (int iTem = 1; iTem <= iTotalParent; iTem++) {
			temChildCount = getChildBookmarksCount(iTem);
			if (temChildCount > 0) {
				iTotalParent -= temChildCount;
				ChildNum[iTem] = temChildCount;
			}
		}

		for (int index = 1; index <= iTotalParent; index++) {
			try {
				ListBookmarks.add(getBookmark(index));
			} catch (Exception ex) {
				// throw new Exception(ex.Message);
			}

		}

		if (getChildBookmarks) {
			for (int iParent = 1; iParent <= iTotalParent; iParent++) {
				for (int iChild = 1; iChild <= ChildNum[iParent]; iChild++) {
					try {
						ListBookmarks.add(getChildBookmark(iParent, iChild));
					} catch (Exception ex) {
						// throw new Exception(ex.Message);
					}

				}

			}

		}
		return ListBookmarks;

	}

	// / <summary>
	// / Gets a specfied Bookmark in a specified document page
	// / </summary>
	// / <param name="bookmarkIndex"></param>
	// / <returns>Selected Bookmark</returns>

	public Bookmark getBookmark(int bookmarkIndex) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/bookmarks/" + Integer.toString(bookmarkIndex);

			String signedURI = Utils.sign(strURI);
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and Deserializes the JSON to a object.
			BookmarkResponse bookmarkResponse = gson.fromJson(strJSON,
					BookmarkResponse.class);

			return bookmarkResponse.getBookmark();
		}

		catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	// / <summary>
	// / Gets a specfied child Bookmark for selected parent bookmark in Pdf
	// document
	// / </summary>
	// / <param name="parentBookmarkIndex"></param>
	// / <param name="childBookmarkIndex"></param>
	// / <returns>Selected child Bookmark</returns>

	public Bookmark getChildBookmark(int parentBookmarkIndex,
			int childBookmarkIndex) {
		try { // build URI to get page count

			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/bookmarks/" + Integer.toString(parentBookmarkIndex)
					+ "/bookmarks/" + Integer.toString(childBookmarkIndex);

			String signedURI = Utils.sign(strURI);
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and Deserializes the JSON to a object.
			BookmarkResponse bookmarkResponse = gson.fromJson(strJSON,
					BookmarkResponse.class);

			return bookmarkResponse.getBookmark();
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Checks whether selected bookmark is parent or child Gets a specfied
	// child Bookmark for selected parent bookmark in Pdf document
	// / </summary>
	// / <param name="bookmarkIndex"></param>
	// / <returns>True if child bookmark; false otherwise</returns>

	public boolean isChildBookmark(int bookmarkIndex) {
		try { // build URI to get page count

			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/bookmarks/" + Integer.toString(bookmarkIndex);

			String signedURI = Utils.sign(strURI);
			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and Deserializes the JSON to a object.
			BookmarkResponse bookmarkResponse = gson.fromJson(strJSON,
					BookmarkResponse.class);

			return true;
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return false;
		}
	}

	// / <summary>
	// / Gets number of attachments in the Pdf document
	// / </summary>
	// / <returns>Number of attachments in Pdf document</returns>

	public int getAttachmentsCount() {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/attachments";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and Deserializes the JSON to a object.
			AttachmentsResponse attachmentsResponse = gson.fromJson(strJSON,
					AttachmentsResponse.class);

			int count = attachmentsResponse.getAttachments().getList().size();

			return count;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// / Gets List of all the attachments in Pdf document
	// / </summary>
	// / <returns>List of attachments in a Pdf document</returns>

	public List<Attachment> getAllAttachments() {
		List<Attachment> ListAttachments = new ArrayList<Attachment>();

		int iTotalAttachments = getAttachmentsCount();

		for (int index = 1; index <= iTotalAttachments; index++) {

			ListAttachments.add(getAttachment(index));
		}
		return ListAttachments;

	}

	// / <summary>
	// / Gets selected attachment from Pdf document
	// / </summary>
	// / <param name="attachmentIndex"></param>
	// / <returns>Selected attachment at specfied index</returns>

	public Attachment getAttachment(int attachmentIndex) {
		try {

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/attachments/" + Integer.toString(attachmentIndex);
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and Deserializes the JSON to a object.
			AttachmentResponse attachmentResponse = gson.fromJson(strJSON,
					AttachmentResponse.class);

			return attachmentResponse.getAttachment();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Download the selected attachment from Pdf document
	// / </summary>
	// / <param name="outputPath"></param>
	// / <param name="attachmentIndex"></param>
	// / <returns>Saves the selected attchment on specified output
	// path</returns>

	public boolean downloadAttachment(String outputPath, int attachmentIndex) {
		try {

			Attachment FileInformation = getAttachment(attachmentIndex);

			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/attachments/" + Integer.toString(attachmentIndex)
					+ "/download";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			boolean response = Folder.saveStreamToFile(outputPath + "\\"
					+ FileInformation.getName(), responseStream);
			responseStream.close();
			return response;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		}

	}

	// / <summary>
	// / Get number of links in Pdf document page
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <returns>Get total number of links in a page</returns>

	public int getLinksCount(int pageNumber) {
		try {
			// build URI to get page count

			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/links";
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse and Deserializes the JSON to a object.
			PdfLinksResponse pdfLinksResponse = gson.fromJson(strJSON,
					PdfLinksResponse.class);

			int count = pdfLinksResponse.getLinks().getList().size();

			return count;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return -1;
		}
	}

	// / <summary>
	// / Gets list of all links in a Pdf document page
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <returns>List of links on a page</returns>

	public List<Link> getAllLinks(int pageNumber) {
		List<Link> ListLinks = new ArrayList<Link>();

		int iTotalLinks = getLinksCount(pageNumber);

		for (int index = 1; index <= iTotalLinks; index++) {

			ListLinks.add(getLink(pageNumber, index));
		}
		return ListLinks;

	}

	// / <summary>
	// / Gets selected link in a in a Pdf document page
	// / </summary>
	// / <param name="pageNumber"></param>
	// / <param name="attachmentIndex"></param>
	// / <returns>Selected link at a specified index in a specified Pdf document
	// page</returns>

	public Link getLink(int pageNumber, int attachmentIndex) {
		try {
			// build URI to get page count
			String strURI = Product.getBaseProductUri() + "/pdf/" + fileName
					+ "/pages/" + Integer.toString(pageNumber) + "/links/"
					+ Integer.toString(attachmentIndex);
			String signedURI = Utils.sign(strURI);

			InputStream responseStream = Utils.processCommand(signedURI, "GET");

			String strJSON = Utils.streamToString(responseStream);

			// Parse the json String to JObject

			// Deserializes the JSON to a object.
			PdfLinkResponse pdfLinkResponse = gson.fromJson(strJSON,
					PdfLinkResponse.class);

			// return pdfLinkResponse;
			return pdfLinkResponse.getLink();
		} catch (Exception e) {

			logger.error(e.getMessage());
			return null;
		}
	}

	/*
	 * public class CopyInputStream extends FilterInputStream { class
	 * CopyInputStream extends FilterInputStream {
	 * 
	 * private ByteArrayOutputStream _copy = new ByteArrayOutputStream();
	 * 
	 * public CopyInputStream(InputStream is) { _is = is; }
	 * 
	 * public int read() throws IOException { int got = is.read(); if (got>-1) {
	 * _copy.write((byte)got); } return got; }
	 * 
	 * public InputStream getCopy() { return new
	 * ByteArrayInputStream(copy.getBytes()); }
	 * 
	 * }
	 */

}
