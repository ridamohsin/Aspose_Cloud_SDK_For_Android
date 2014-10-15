/**
 * 
 */
package com.aspose.cloud.sdk.storage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SignatureException;
import java.util.List;

import android.os.Environment;
import android.util.Log;

import com.aspose.cloud.sdk.common.AsposeApp;
import com.aspose.cloud.sdk.common.BaseResponse;
import com.aspose.cloud.sdk.common.Utils;
import com.google.gson.Gson;

public class Folder {

	private static final String strURIFolder = AsposeApp.BASE_PRODUCT_URI + "/storage/folder/";
	private static final String strURIFile = AsposeApp.BASE_PRODUCT_URI + "/storage/file/";
	private static final String strURIExist = AsposeApp.BASE_PRODUCT_URI + "/storage/exist/";
	private static final String strURIDisc = AsposeApp.BASE_PRODUCT_URI + "/storage/disc/";
	
	private static final String TAG = "Folder";
	
	// / <summary>
	// / Retrives the list of files and folders under the specified folder. Use
	// empty string to specify root folder.
	// / </summary>
	// / <param name="strFolder"></param>
	// / <returns></returns>
	public List<com.aspose.cloud.sdk.storage.File> getFilesList(
			String strFolder) {
		try {
			// StreamReader reader = new StreamReader(Common.
			// Utils.ProcessCommand(CommonUtils.Sign(this.strURIFolder +
			// strFolder), "GET") );
			// further process JSON response
			String strJSON = Utils.streamToString(Utils.processCommand(
					Utils.sign(this.strURIFolder + strFolder), "GET"));

			return FileCollection.getFilesList(strJSON);
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Deletes a file from the storage. Use "FolderName/FileName" to specify a
	// file under specific folder.
	// / </summary>
	// / <param name="strFileName"></param>
	public boolean deleteFile(String strFileName) throws Exception {
		try {
			InputStream responseStream = Utils.processCommand(
					Utils.sign(this.strURIFile + strFileName), "DELETE");

			String strResponse = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;

		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			ex.printStackTrace();
			return false;
		}
	}

	// / <summary>
	// / Deletes an empty folder from the storage. Use
	// "FolderName/SubFolderName" for sub folders.
	// / </summary>
	// / <param name="strFolderName"></param>
	public boolean deleteFolder(String strFolderName) throws Exception {
		try {
			InputStream responseStream = Utils.processCommand(
					Utils.sign(this.strURIFolder + strFolderName), "DELETE");

			String strResponse = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			BaseResponse baseResponse = gson.fromJson(strResponse,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}

	// / <summary>
	// / Uploads a file from your local machine to specified folder / subfolder
	// on Aspose storage.
	// / </summary>
	// / <param name="strFile"></param>
	// / <param name="strFolder"></param>
	public boolean uploadFile(String strFile, String strFolder)
			throws Exception 
			{
		try {
			File localFile = new File(strFile);
			String strRemoteFileName = localFile.getName();
			String strURIRequest = this.strURIFile
					+ (strFolder.equals("") ? "" : strFolder + "/")
					+ strRemoteFileName;
			String strURISigned = Utils.sign(strURIRequest);

			String strResponse = Utils.uploadFileBinary(localFile,
					strURISigned, "PUT");

			if (strResponse.contains("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}

	// / <summary>
	// / Creates a folder under the specified folder. If no path specified,
	// creates a folder under the root folder.
	// / </summary>
	// / <param name="strFolder"></param>
	public boolean createFolder(String strFolder) throws Exception {
		try {
			String strURIRequest = this.strURIFolder + strFolder;
			String strURISigned = Utils.sign(strURIRequest);
			Utils.processCommand(strURISigned, "PUT");
			InputStream responseStream = Utils.processCommand(strURISigned,
					"PUT");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse and Deserializes the JSON to a object.
			BaseResponse baseResponse = gson.fromJson(strJSON,
					BaseResponse.class);

			if (baseResponse.getCode().equals("200")
					&& baseResponse.getStatus().equals("OK"))
				return true;
			else
				return false;
		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			return false;
		}
	}

	// / <summary>
	// / Checks whether file or folder exists on the Aspose storage.
	// / </summary>
	// / <param name="strFolderOrFile"></param>
	// / <returns></returns>
	public FileExist fileExist(String strFolderOrFile) {
		try {
			String strURIRequest = this.strURIExist + strFolderOrFile;
			String strURISigned = Utils.sign(strURIRequest);

			InputStream responseStream = Utils.processCommand(strURISigned,
					"GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			ExistResponse existResponse = gson.fromJson(strJSON,
					ExistResponse.class);

			return existResponse.getFileExist();

		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Provides the total / free disc size in bytes for your app.
	// / </summary>
	// / <returns></returns>
	public DiscUsage getDiscUsage() {
		try {
			InputStream responseStream = Utils.processCommand(
					Utils.sign(this.strURIDisc), "GET");

			String strJSON = Utils.streamToString(responseStream);

			Gson gson = new Gson();
			// Parse the json string to JObject
			DiscResponse discResponse = gson.fromJson(strJSON, DiscResponse.class);

			return discResponse.getDiscUsage();

		} catch (Exception ex) {
			Log.e(TAG, ex.getMessage());
			return null;
		}
	}

	// / <summary>
	// / Get file from Aspose server
	// / </summary>
	// / <param name="fileName">file name on the server</param>
	// / <returns></returns>
	public static InputStream getFile(String fileName) {
		try {
			return Utils.processCommand(Utils.sign(Folder.strURIFile + fileName), "GET");
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}

	}

	// / <summary>
	// / Get file output file name and input stream as arguments and saves file
	// on disk
	// / </summary>

	// / <returns></returns>

	public static boolean saveStreamToFile(String fileNameWithPath,
			InputStream inputStream) {
		OutputStream out;
		try {

			File file = new File(Environment.getExternalStorageDirectory()
					+ "/AsposeCovertedFiles");
			if (!file.exists()) {
				if (file.mkdir()) {
					System.out.println("New Folder is created");
				}
			}
			out = new FileOutputStream(file + "/" + fileNameWithPath);

			int read = 0;
			byte[] bytes = new byte[8192];

			while ((read = inputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			inputStream.close();
			out.flush();
			out.close();
			return true;
//			// write the inputStream to a FileOutputStream
//			OutputStream out = new FileOutputStream(new File(fileNameWithPath));
//
//			int read = 0;
//			byte[] bytes = new byte[8192];
//
//			while ((read = inputStream.read(bytes)) != -1) {
//				out.write(bytes, 0, read);
//			}
//
//			inputStream.close();
//			out.flush();
//			out.close();
//			return true;

		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
			return false;
		}
	}

}
