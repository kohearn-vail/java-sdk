package com.vailsys.freeclimb.api;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;
import static javax.xml.bind.DatatypeConverter.printBase64Binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;
import com.vailsys.freeclimb.KnownSizeInputStream;

/**
 * The APIRequester is the base class for various *Requester classes which each
 * wrap a portion of the FreeClimb API. This class abstracts away the messiness
 * that can be directly interacting with the API over HTTP to reduce code
 * duplication in these child Requesters and ease their development.
 */
public class APIRequester {
	/** The URL of the FreeClimb API */
	protected static String FREECLIMB_URL = "https://www.freeclimb.com/apiserver";

	/**
	 * Type object representing the {@code HashMap<String,String>} used by
	 * {@code APIRequester.GET(String, HashMap<String, String>)}. For use with GSON
	 * conversions.
	 **/
	public static final Type GETMapType = new TypeToken<HashMap<String, String>>() {
	}.getType();

	private String credAccountId;
	private String credApiKey;
	private String encodedAuth;
	private String freeclimbUrl;

	/**
	 * Create a new APIRequester.
	 *
	 * @param credAccountId The accountId to use to authenticate requests.
	 * @param credApiKey The apiKey to use to authenticate requests.
	 */
	protected APIRequester(String credAccountId, String credApiKey) {
		this.credAccountId = credAccountId;
		this.credApiKey = credApiKey;
		this.encodedAuth = printBase64Binary((credAccountId + ":" + credApiKey).getBytes(StandardCharsets.UTF_8));
		this.freeclimbUrl = APIRequester.FREECLIMB_URL;
	}

	/** @return the accountId being used for authentication */
	protected String getCredentialAccountId() {
		return this.credAccountId;
	}

	/** @return the apiKey being used for authentication */
	protected String getCredentialApiKey() {
		return this.credApiKey;
	}

	/** @return the url being used for the FreeClimb API */
	public String getFreeClimbUrl() {
		return this.freeclimbUrl;
	}

	/**
	 * Allows developers using the SDK to change which instance of the FreeClimb API
	 * that the APIRequester points to.
	 *
	 * @param newUrl The new URL to use in place of the default
	 *               APIRequester.FREECLIMB_URL
	 */
	public void setFreeClimbUrl(String newUrl) {
		this.freeclimbUrl = newUrl;
	}

	private static final String pathJoiner = "/";

	protected static String constructPath(String... parts) {
		StringBuilder sb = new StringBuilder(parts.length);
		return buildPath(sb, parts);
	}

	protected static String constructAbsolutePath(String... parts) {
		StringBuilder sb = new StringBuilder(parts.length);
		sb.append(pathJoiner);
		return buildPath(sb, parts);
	}

	private static String buildPath(StringBuilder sb, String[] parts) {
		int i;
		for (i = 0; i < parts.length - 1; i++) {
			sb.append(parts[i]);
			sb.append(pathJoiner);
		}
		sb.append(parts[i]);
		return sb.toString();
	}

	/**
	 * Converts a {@code HashMap<String, String>} into a HTTP GET query string to
	 * append to a URL. For example: {@literal mapToQueryString({"key": "value",
	 * "key1": "value1"}) -> "?key=value&key1=value1"}
	 *
	 * @param query A HashMap to use to build the GET query string.
	 * @return the query string.
	 * @throws FreeClimbSDKException when the encoding is unsupported.
	 */
	public static String mapToQueryString(HashMap<String, String> query) throws FreeClimbSDKException {
		StringBuilder pathAndQuery = new StringBuilder();
		if (query != null) {
			pathAndQuery.append("?");
			for (String key : query.keySet()) {
				pathAndQuery.append(key);
				pathAndQuery.append("=");
				try {
					pathAndQuery.append(URLEncoder.encode(query.get(key), "UTF-8"));
				} catch (UnsupportedEncodingException uee) {
					throw new FreeClimbSDKException(uee);
				}
				pathAndQuery.append("&");
			}
			pathAndQuery.deleteCharAt(pathAndQuery.length() - 1);
		}
		return pathAndQuery.toString();
	}

	/**
	 * Make an HTTP GET request to the FreeClimb API
	 *
	 * @param path The URI path to make a request to. This path may also contain GET
	 *             query parameters.
	 *
	 * @return A string containing the HTTP response body of the request.
	 * @throws FreeClimbException when the request fails.
	 */
	protected String GET(String path) throws FreeClimbException {
		HttpURLConnection con = establishConnection("GET", path);
		return readResponse(con);
	}

	/**
	 * Make an HTTP GET request to the FreeClimb API
	 *
	 * @param path  The URI path to make a request to.
	 * @param query A HashMap to use to build the GET query string.
	 *
	 * @return A string containing the HTTP response body of the request.
	 * @throws FreeClimbException when the request fails.
	 */
	protected String GET(String path, HashMap<String, String> query) throws FreeClimbException {
		return this.GET(path + mapToQueryString(query));
	}

	/**
	 * Make an HTTP GET request to the FreeClimb API.
	 *
	 * @param path The URI path to make a request to. This path may also contain GET
	 *             query parameters.
	 *
	 * @return A KnownSizeInputStream built from the InputStream to read the
	 *         response body from the request. The length of the stream is the
	 *         Content-Length headers report of the size of the response.
	 * @throws FreeClimbException when the request fails.
	 */
	protected KnownSizeInputStream GETStream(String path) throws FreeClimbException {
		HttpURLConnection con = establishConnection("GET", path);
		return new KnownSizeInputStream(this.returnResponseStream(con), con.getContentLength());
	}

	/**
	 * Make an HTTP GET request to the FreeClimb API
	 *
	 * @param path  The URI path to make a request to.
	 * @param query A HashMap to use to build the GET query string.
	 *
	 * @return A KnownSizeInputStream built from the InputStream to read the
	 *         response body from the request. The length of the stream is the
	 *         Content-Length headers report of the size of the response.
	 * @throws FreeClimbException when the request fails.
	 */
	protected KnownSizeInputStream GETStream(String path, HashMap<String, String> query) throws FreeClimbException {
		return this.GETStream(path + mapToQueryString(query));
	}

	/**
	 * Make a HTTP POST request to the FreeClimb API.
	 *
	 * @param path    The URI path to make a request to.
	 * @param payload The JSON payload to send in the body of the request.
	 *
	 * @return A string containing the HTTP response body of the request.
	 * @throws FreeClimbException when the request fails.
	 */
	protected String POST(String path, String payload) throws FreeClimbException {
		HttpURLConnection con = establishConnection("POST", path);
		OutputStream os = sendPayload(con, payload);
		String resp = readResponse(con);

		try {
			os.close();
		} catch (IOException ioe) {
			throw new FreeClimbConnectionException("Could not send request to FreeClimb API: " + ioe.getMessage(), ioe);
		}

		return resp;
	}

	/**
	 * Make a HTTP DELETE request to the FreeClimb API.
	 *
	 * @param path The URI path to make a request to.
	 * @throws FreeClimbException when the request fails.
	 */
	protected void DELETE(String path) throws FreeClimbException {
		HttpURLConnection con = establishConnection("DELETE", path);
		readResponse(con);
	}

	/**
	 * Establish a HTTP connection to the FreeClimb API at the path provided using
	 * the provided HTTP method.
	 *
	 * @param method HTTP method to use (GET,POST,DELETE, etc.).
	 * @param path   The URI path to make a request to.
	 *
	 * @return an object representing the HTTP connection
	 */
	private HttpURLConnection establishConnection(String method, String path) throws FreeClimbException {
		URL url;
		try {
			url = new URL(this.freeclimbUrl + path);
		} catch (MalformedURLException mue) {
			throw new FreeClimbSDKException("Could not understand builtin FreeClimb URL and path: " + mue.getMessage(),
					mue);
		}

		HttpURLConnection con;
		try {
			con = (HttpURLConnection) url.openConnection();
		} catch (IOException ioe) {
			throw new FreeClimbConnectionException(
					"Could not initiate connection to FreeClimb API servers:" + ioe.getMessage(), ioe);
		}

		con.setDoOutput(true);
		con.setRequestProperty("Authorization", "Basic " + this.encodedAuth);

		try {
			con.setRequestMethod(method);
		} catch (ProtocolException pe) {
		}

		return con;
	}

	/**
	 * Send the provided payload in the body of an established connection.
	 *
	 * @param con     An existing HTTP connection established through
	 *                APIRequester.establishConneciton()
	 * @param payload The payload to send in the body of the request.
	 *
	 * @return the OutputStream used to send the payload for later closing.
	 */
	private OutputStream sendPayload(HttpURLConnection con, String payload) throws FreeClimbException {
		OutputStream os;
		try {
			os = con.getOutputStream();
			if (payload != null) {
				os.write(payload.getBytes());
			}
		} catch (IOException ioe) {
			throw new FreeClimbConnectionException("Could not send request to FreeClimb API: " + ioe.getMessage(), ioe);
		}
		return os;
	}

	/**
	 * Read the response to a HTTP request.
	 *
	 * @param con a completed HTTP connection waiting for the response body to be
	 *            read.
	 *
	 * @return a string containing the response body of the request
	 */
	private String readResponse(HttpURLConnection con) throws FreeClimbException {
		StringBuilder sb = new StringBuilder();
		int code;

		try {
			code = con.getResponseCode();
			if (con.getContentLength() > 0 || (con.getHeaderField("Transfer-Encoding") != null
					&& con.getHeaderField("Transfer-Encoding").equals("chunked"))) {
				BufferedReader br = new BufferedReader(new InputStreamReader(this.returnResponseStream(con, code)));

				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}

				br.close();
			}
		} catch (IOException e) {
			throw new FreeClimbConnectionException("Could not read response from FreeClimb API: " + e.getMessage(), e);
		}

		if (!(code >= 200 && code < 300)) {
			throw new FreeClimbErrorResponseException(gson.fromJson(sb.toString(), FreeClimbError.class));
		}

		return sb.toString();
	}

	/**
	 * Returns the raw InputStream from the HTTP connection primarily for use with
	 * downloading and streaming Recordings.
	 *
	 * @param con  The HTTP connection object for the request
	 * @param code The HTTP status response code for the request.
	 *
	 * @return The raw InputStream representing the response body from the HTTP
	 *         request.
	 */
	private InputStream returnResponseStream(HttpURLConnection con, int code) throws FreeClimbConnectionException {
		InputStream is;
		try {
			if (code >= 200 && code < 300) {
				is = con.getInputStream();
			} else {
				is = con.getErrorStream();
			}
		} catch (IOException e) {
			throw new FreeClimbConnectionException(
					"Could not retrieve InputStream from the HttpURLConnection: " + e.getMessage(), e);
		}
		return is;
	}

	/**
	 * Returns the raw InputStream from the HTTP connection primarily for use with
	 * downloading and streaming Recordings.
	 *
	 * @param con The HTTP connection object for the request
	 *
	 * @return The raw InputStream representing the response body from the HTTP
	 *         request.
	 */
	private InputStream returnResponseStream(HttpURLConnection con) throws FreeClimbConnectionException {
		InputStream is;
		try {
			is = this.returnResponseStream(con, con.getResponseCode());
		} catch (IOException e) {
			throw new FreeClimbConnectionException(
					"Could not retrieve InputStream from the HttpURLConnection: " + e.getMessage(), e);
		}
		return is;
	}
}
