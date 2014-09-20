/**
 * 
 */
package com.aspose.cloud.sdk.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class  CopyInputStream
{
	private InputStream inputStream;
	private ByteArrayOutputStream copy = new ByteArrayOutputStream();

	/**
	 * 
	 */
	public CopyInputStream(InputStream is)
	{
		inputStream = is;
		
		try
		{
			copy();
		}
		catch(IOException ex)
		{
			// do nothing
		}
	}

	private int copy() throws IOException
	{
		int read = 0;
		int chunk = 0;
		byte[] data = new byte[256];
		
		while(-1 != (chunk = inputStream.read(data)))
		{
			read += data.length;
			copy.write(data, 0, chunk);
		}
		
		return read;
	}
	
	public InputStream getCopy()
	{
		return (InputStream)new ByteArrayInputStream(copy.toByteArray());
	}
}
