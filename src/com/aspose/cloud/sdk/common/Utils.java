
package com.aspose.cloud.sdk.common;

import groovyx.net.http.URIBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

public class Utils {

	private static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	static final Logger logger = Logger.getLogger(Utils.class);
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
	public static String sign(String data) {
		try {

			data = data.replace(" ", "%20");

			Map<String, String> query = new HashMap<String, String>(1); // UriBuilder
																		// builder=new
																		// UriBuilder();
			query.put("appSID", AsposeApp.getAppSID());

			URIBuilder uri = new URIBuilder(data);
			// uri.setPort(80);

			String url = uri.toURI().getPath();
			url = url.replace(" ", "%20");
			uri.setPath(url);
			uri.addQueryParams(query);

			url = uri.toURI().getPath();
			// String url=uri.toURI ().getPath ();
			// Remove final slash here as it can be added automatically.
			if (url.charAt(url.length() - 1) == '/') {
				String tempUrl = url.substring(0, url.length() - 1);
				uri.setPath(tempUrl);
			}
			url = uri.toURI().toString();

			// get an hmac_sha1 key from the raw key bytes
			SecretKeySpec signingKey = new SecretKeySpec(AsposeApp
					.getAppKey().getBytes(), HMAC_SHA1_ALGORITHM);

			// get an hmac_sha1 Mac instance and initialize with the signing key
			Mac mac = Mac.getInstance(HMAC_SHA1_ALGORITHM);
			mac.init(signingKey);

			// compute the hmac on input data bytes
			byte[] rawHmac = mac.doFinal(url.getBytes());
			byte newresult[] = Base64.encodeBase64(rawHmac);

			// Remove invalid symbols.
			String result = new String(newresult);
			result = result.substring(0, result.length() - 1);

			String encodedUrl = URLEncoder.encode(result, "UTF-8");
			// System.out.println("Final URL:" + uri.toURI().toString
			// ()+"&signature="+encodedUrl);
			return uri.toURI().toString() + "&signature=" + encodedUrl;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;

		}

	}

	public static String uploadFileBinary(File localFile, String uploadUrl,
			String strHttpCommand) {
		try {
			logger.info("In uploadFileBinary : " + uploadUrl);
			System.out.println("In uploadFileBinary : " + uploadUrl);

			URL url = new URL(uploadUrl);
			byte[] buf = getBytesFromFile(localFile);
			HttpURLConnection m_connection;
			m_connection = (HttpURLConnection) url.openConnection();
			String parameters = "data=some_post_data";
			m_connection.setDoOutput(true);
			m_connection.setRequestMethod("PUT");
			m_connection.setRequestProperty("Accept", "text/json");
			m_connection.setRequestProperty("Content-Type",
					"MultiPart/Form-Data");
			byte bytes[] = parameters.getBytes();
			m_connection.setRequestProperty("Content-length", "" + buf.length);
			m_connection.connect();
			java.io.OutputStream out = m_connection.getOutputStream();
			out.write(buf);
			out.flush();

			InputStream response = m_connection.getInputStream();

			String res = streamToString(response);

			return res;
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	// Returns the contents of the file in a byte array.
	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		// Get the size of the file
		long length = file.length();

		// You cannot create an array using a long type.
		// It needs to be an int type.
		// Before converting to an int type, check
		// to ensure that file is not larger than Integer.MAX_VALUE.
		if (length > Integer.MAX_VALUE) {
			// File is too large
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file "	+ file.getName());
		}

		// Close the input stream and return bytes
		is.close();
		return bytes;
	}

	public static InputStream processCommand(String strURI,
			String strHttpCommand, String strContent) {

		try {

			URL address = new URL(strURI);
			HttpURLConnection httpCon = (HttpURLConnection) address
					.openConnection();
			//httpCon.setDoOutput(true);
			httpCon.setRequestProperty("Content-Type", "application/json");
			httpCon.setRequestProperty("Accept", "text/json");
			httpCon.setRequestMethod(strHttpCommand);
			httpCon.setFixedLengthStreamingMode(strContent.length());
			OutputStreamWriter out = new OutputStreamWriter(
					httpCon.getOutputStream());
			out.write(strContent);
			out.close();
			String d = httpCon.getResponseMessage();
			logger.info(d);

			return httpCon.getInputStream();
		} catch (Exception Ex) {

			logger.error(Ex.getMessage());
			return null;
		}

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
			logger.info(d);

			return httpCon.getInputStream();
		} catch (Exception Ex) {

			logger.error(Ex.getMessage());
			return null;
		}

	}

	public static InputStream processCommand(String strURI,
			String strHttpCommand) throws Exception {

		URL address = new URL(strURI);
		HttpURLConnection httpCon = (HttpURLConnection) address
				.openConnection();
		//httpCon.setDoOutput(true);
		httpCon.setRequestProperty("Content-Type", "application/json");
		httpCon.setRequestProperty("Accept", "text/json");
		httpCon.setRequestMethod(strHttpCommand);
		if (strHttpCommand.equals("PUT") || strHttpCommand.equals("POST"))
			httpCon.setFixedLengthStreamingMode(0);
		String d = httpCon.getResponseMessage();
		logger.info(d);
		return httpCon.getInputStream();

	}

	public static InputStream processCommand(String strURI,
			String strHttpCommand, String strContent, String ContentType) {
		try {

			byte[] arr = IOUtils.toByteArray(strContent);

			URL address = new URL(strURI);
			HttpURLConnection httpCon = (HttpURLConnection) address
					.openConnection();
			//httpCon.setDoOutput(true);

			if (ContentType.toLowerCase().equals("xml"))
				httpCon.setRequestProperty("Content-Type", "application/json");
			else
				httpCon.setRequestProperty("Content-Type", "application/xml");

			httpCon.setRequestMethod(strHttpCommand);

			httpCon.setFixedLengthStreamingMode(arr.length);

			java.io.OutputStream out = httpCon.getOutputStream();
			out.write(arr);
			out.flush();

			String d = httpCon.getResponseMessage();
			logger.info(d);

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

}
