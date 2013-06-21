/**
 * 
 */
package com.aspose.cloud.sdk.storage;

import java.util.Date;

// / <summary>
// / Represents a File part of the Folder resource response
// / </summary>
public class File {
	public File() {
	}

	// / <summary>
	// / Represents file name.
	// / </summary>
	private String Name;

	// / <summary>
	// / Indicates whether a folder or file.
	// / </summary>
	private boolean IsFolder;

	// / <summary>
	// / Represents last modification date of file or folder.
	// / </summary>
	// Need to verify
	// public Calendar ModifiedDate;
	// public String ModifiedDate;
	private Date ModifiedDate;

	// / <summary>
	// / Represents the size of the File or Folder.
	// / </summary>
	private long Size;

	public String getName() {
		return Name;
	}

	public boolean getIsFolder() {
		return IsFolder;
	}

	public Date getModifiedDate() {
		return ModifiedDate;
	}

	public long getSize() {
		return Size;
	}

}
