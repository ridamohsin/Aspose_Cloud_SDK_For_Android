
package com.aspose.cloud.sdk.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import android.os.Environment;
import android.util.Log;

public class Utils {
	
	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	private static final String TAG = "Utils";
	
	/**
	 * Computes RFC 2104-compliant HMAC signature. * @param data The data to be
	 * signed.
	 * 
	 * @param key
	 *            The signing key.
	 * @return The Base64-encoded RFC 2104-compliant HMAC signature.
	 * @throws java.security.SignatureException
	 *             when signature generation fails
	 */
	public static String sign (String unsignedURL) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
		
		StringBuilder mUnsignedURL = new StringBuilder(unsignedURL);
		
		//Remove any trailing '/' character
		if(mUnsignedURL.charAt(mUnsignedURL.length()-1) == '/') {
			mUnsignedURL.deleteCharAt(mUnsignedURL.length()-1);
		}
		
		if(mUnsignedURL.indexOf("?") == -1) {
			mUnsignedURL.append("?");
		} else {
			mUnsignedURL.append("&");
		}
		
		//Add appSID parameter to the query string
		mUnsignedURL.append("appSID=" + AsposeApp.APP_SID);
		
		//Calculate a hash of the current URL
		Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
		SecretKeySpec key = new SecretKeySpec((AsposeApp.APP_KEY).getBytes("UTF-8"), mac.getAlgorithm());
		mac.init(key);
	
		byte[] bytes = mac.doFinal(mUnsignedURL.toString().getBytes("UTF-8"));
	
		String urlHash = new String(Base64.encodeBase64(bytes));
		
		//Remove any trailing '=' characters
		if(urlHash.endsWith("=")) {
			urlHash = urlHash.substring(0, urlHash.length()-1);
		}
		
		//URL-encode generated string
		urlHash = URLEncoder.encode(urlHash, "utf-8");
		
		//Add the encoded value to the current URL as a signature parameter
		mUnsignedURL.append("&signature=" + urlHash);
		
		return mUnsignedURL.toString();
	}

	public static String uploadFileBinary(File localFile, String uploadUrl,
			String strHttpCommand) {
		try {
			Log.i(TAG, "In uploadFileBinary : " + uploadUrl);
			System.out.println("In uploadFileBinary : " + uploadUrl);

			URL url = new URL(uploadUrl);
			// Returns the contents of the file in a byte array.
			byte[] buf = FileUtils.readFileToByteArray(localFile);
			HttpURLConnection m_connection;
			m_connection = (HttpURLConnection) url.openConnection();
			//String parameters = "data=some_post_data";
			m_connection.setDoOutput(true);
			m_connection.setRequestMethod("PUT");
			m_connection.setRequestProperty("Accept", "text/json");
			m_connection.setRequestProperty("Content-Type",
					"MultiPart/Form-Data");
			//byte bytes[] = parameters.getBytes();
			m_connection.setRequestProperty("Content-length", "" + buf.length);
			m_connection.connect();
			java.io.OutputStream out = m_connection.getOutputStream();
			out.write(buf);
			out.flush();

			InputStream response = m_connection.getInputStream();

			String res = streamToString(response);

			return res;
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public static InputStream processCommand(String strURI,
			String strHttpCommand, String strContent) throws IOException {

		URL url = new URL(strURI);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestProperty("Content-Type", "application/json");
		httpCon.setRequestProperty("Accept", "application/json");
		httpCon.setRequestMethod(strHttpCommand);
		httpCon.setFixedLengthStreamingMode(strContent.length());
		OutputStreamWriter out = new OutputStreamWriter(
				httpCon.getOutputStream());
		out.write(strContent);
		out.close();
		
		return httpCon.getInputStream();
	}

	public static InputStream processCommand(String strURI,
			String strHttpCommand, InputStream strContent) {
		try {
			byte[] bytes = IOUtils.toByteArray(strContent);
			URL address = new URL(strURI);
			HttpURLConnection httpCon = (HttpURLConnection) address
					.openConnection();
			//httpCon.setDoOutput(true);

			httpCon.setRequestProperty("Content-Type", "multipart/form-data");// "application/x-www-form-urlencoded"
																				// );
			httpCon.setRequestMethod(strHttpCommand);

			httpCon.setFixedLengthStreamingMode(bytes.length);

			java.io.OutputStream out = httpCon.getOutputStream();
			out.write(bytes);
			out.flush();

			String d = httpCon.getResponseMessage();
			Log.i(TAG, d);

			return httpCon.getInputStream();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage());
			return null;
		}

	}

	public static InputStream processCommand(String strURI,
			String strHttpCommand)  throws IOException{

		URL address = new URL(strURI);
		HttpURLConnection httpCon = (HttpURLConnection) address
				.openConnection();
		//httpCon.setDoOutput(true);
		httpCon.setRequestProperty("Content-Type", "application/json");
		httpCon.setRequestProperty("Accept", "application/json");
		httpCon.setRequestMethod(strHttpCommand);
		if (strHttpCommand.equals("PUT") || strHttpCommand.equals("POST"))
			httpCon.setFixedLengthStreamingMode(0);
		String d = httpCon.getResponseMessage();
		Log.i(TAG, d);
		return httpCon.getInputStream();

	}

	public static InputStream processCommand(String strURI,
			String strHttpCommand, String strContent, String ContentType) {
		try {

			byte[] arr = strContent.getBytes("UTF-8");
			URL address = new URL(strURI);
			HttpURLConnection httpCon = (HttpURLConnection) address
					.openConnection();
			//httpCon.setDoOutput(true);

			if (ContentType.toLowerCase(Locale.US).equals("xml"))
				httpCon.setRequestProperty("Content-Type", "application/json");
			else
				httpCon.setRequestProperty("Content-Type", "application/xml");

			httpCon.setRequestMethod(strHttpCommand);

			httpCon.setFixedLengthStreamingMode(arr.length);

			java.io.OutputStream out = httpCon.getOutputStream();
			out.write(arr);
			out.flush();

			String d = httpCon.getResponseMessage();
			Log.i(TAG, d);

			return httpCon.getInputStream();
		} catch (Exception Ex) {
			Ex.printStackTrace();
			return null;
		}
	}
	
	public static String streamToString(InputStream stream) {
		try {
			// read it with BufferedReader
			java.io.BufferedReader br = new java.io.BufferedReader(
					new java.io.InputStreamReader(stream));

			StringBuilder sb = new StringBuilder();

			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			// System.out.println(sb.toString());

			br.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/* Checks if external storage is available for read and write */
	public static boolean isExternalStorageWritable() {
	    String state = Environment.getExternalStorageState();
	    if (Environment.MEDIA_MOUNTED.equals(state)) {
	        return true;
	    }
	    return false;
	}

	public static String saveStreamToFile(InputStream inputStream, String fileName) throws IOException {
		String filePath = null;
		
		if(isExternalStorageWritable()) {
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File (sdCard.getAbsolutePath() + "/AsposeFiles");
			if (!dir.exists()) { 
				if(!dir.mkdirs()) {
					Log.e(TAG, "Directory not created");
					return null;
				}
		    }
			
			File file = new File(dir, fileName);
			if(file.length() != 0) {
		    	//delete old file
		    	file.delete();
		    	file.createNewFile();
		    }
			
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
            int len1 = 0;
            while ((len1 = inputStream.read(buffer)) != -1) {
            	fos.write(buffer, 0, len1);
            }
            fos.flush();
            fos.close();
            
            filePath = file.getAbsolutePath();
		} 
		
		return filePath;
	}
}
