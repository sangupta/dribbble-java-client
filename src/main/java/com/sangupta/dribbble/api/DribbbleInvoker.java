/**
 *
 * dribbble-java-client: Java Client for Dribbble.com API
 * Copyright (c) 2012, Sandeep Gupta
 * 
 * http://www.sangupta/projects/dribbble-java-client
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.dribbble.api;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.util.EntityUtils;

/**
 * @author sangupta
 *
 */
public class DribbbleInvoker {
	
	/**
	 * My private logger
	 */
	private static Logger logger = Logger.getLogger("com.sangupta.dribbble.api.DribbbleInvoker");
	
	/**
	 * Host name for Dribbble API end points
	 */
	private static final String DRIBBBLE_END_POINT = "http://api.dribbble.com/";
	
	/** 
	 * Create an HttpClient with the ThreadSafeClientConnManager.
     * This connection manager must be used if more than one thread will
     * be using the HttpClient.
     */
	private static final ThreadSafeClientConnManager HTTP_CONNECTION_MANAGER;
	
	/**
	 * Our reference to initialized {@link HttpClient}.
	 */
	private static HttpClient httpClient = null;
	
	/**
	 * Max rate limited requests for Dribbble.com
	 */
	private static final int MAX_REQUESTS_PER_MINUTE = 60;
	
	/**
	 * Holds the minute identifier
	 */
	private static long currentRunningMinute = 0;
	
	/**
	 * Holds the number of hits that we have made in this minute
	 */
	private static int currentMinuteHitCount = 0;
	
	/**
	 * Initialize the connection manager and create the client
	 */
	static {
		HTTP_CONNECTION_MANAGER = new ThreadSafeClientConnManager();
    	httpClient = new DefaultHttpClient(HTTP_CONNECTION_MANAGER);
	}

	/**
	 * Invoke the final end-point for Dribbble maintaining rate-limiting connections.
	 * 
	 * @param endPoint
	 * @param params
	 * @return
	 */
	public static String invokeEndPoint(String endPoint, String params, boolean throwException) {
		// build the final URL to hit upon
		if(endPoint == null || endPoint.trim().length() == 0) {
			throw new IllegalArgumentException("Dribbble endpoint cannot be null.");
		}
		
		String url = DRIBBBLE_END_POINT + endPoint;
		if(params != null && params.trim().length() > 0) {
			url += "?" + params;
		}
		
		// check for rate limiting now
		// calculations are kept out to make the critical
		// block faster
		long millis = System.currentTimeMillis();
		long seconds = millis / 1000;
		long minute = seconds / 60;
		
		boolean proceed = checkRateLimit(minute, throwException);
		
		if(!proceed) {
			return null;
		}
		
		// go ahead and hit the URL
		String response = hit(url);
		
		// return back the response
		return response;
	}
	
	/**
	 * Method that checks for rate-limit quota for Dribbble.com currently
	 * set as 60 per minute.
	 */
	private static synchronized boolean checkRateLimit(long minute, boolean throwException) {
		if(minute == currentRunningMinute) {
			// we are for the same minute
			currentMinuteHitCount++;
			if(currentMinuteHitCount > MAX_REQUESTS_PER_MINUTE) {
				if(throwException) {
					throw new DribbbleApiRateLimitException("Over the limit of 60 requests/minute... slow dow.");
				}
				
				return false;
			}
			
			return true;
		}
		
		// we are on switchover minute
		currentRunningMinute = minute;
		currentMinuteHitCount = 1;
		
		return true;
	}

	/**
	 * Hit the URL endpoint and return the response body if the status code is HTTP 200.
	 * 
	 * @param url
	 * @return
	 */
	private static String hit(String url) {
		HttpGet httpGet = new HttpGet();
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			final HttpEntity entity = httpResponse.getEntity();

			// check for success code of HTTP 200
			int responseCode = httpResponse.getStatusLine().getStatusCode();
			if(responseCode != 200) {
				// consume the entity to release connection
				EntityUtils.consume(entity);
				
				// return null response
				return null;
			}
			
			// consume the entity
			String response = EntityUtils.toString(entity);
			return response;
		} catch (ClientProtocolException e) {
			logger.log(Level.WARNING, "Unable to hit dribbble endpoint: " + url, e);
		} catch (IOException e) {
			logger.log(Level.WARNING, "Unable to hit dribbble endpoint: " + url, e);
		}
		
		return null;
	}
}
