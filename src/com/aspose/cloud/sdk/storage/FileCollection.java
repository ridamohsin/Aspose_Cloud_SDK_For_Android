/**
 * 
 */
package com.aspose.cloud.sdk.storage;
import java.util.List;

import com.google.gson.Gson;
/// <summary>
/// represents collection of File objects
/// </summary>
public class FileCollection {

    private FileCollection() { }
    /// <summary>
    /// Represents a list fo File Objects.
    /// </summary>
    public FileCollection file;
    /// <summary>
    /// returns a list of File objects
    /// </summary>
    
    
    public static List<File> getFilesList(String strJSON)
    {
        try
        {
        //	strJSON=strJSON.replaceFirst("1327228690298-0600", "1327228690298+0600");
        	Gson gson =new GsonDateParser().createWcfGson();
            FolderResponse folderResponse = gson.fromJson(strJSON,FolderResponse.class);;
            //	files = folderResponse.Files;
            List<File> files =folderResponse.getFiles();

            return files;

        }
        catch (Exception ex)
        {
           ex.printStackTrace();
           return null;
        }
	
    }
}
