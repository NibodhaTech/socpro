/**
 * 
 */
package com.nibodha.socpro.util;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ning.http.client.AsyncHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClient.BoundRequestBuilder;
import com.ning.http.client.Response;

@Component
public class HttpUtil {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(HttpUtil.class);

	private static AsyncHttpClient sender = new AsyncHttpClient(
			PartenerHttpConnectionConfig.getConnectionConfig());

	public void doPostAsync(String url, Map<String, String> requestParams,
			AsyncHandler<Response> responseHandler) throws IOException {

		BoundRequestBuilder builder = sender.preparePost(url);

		for (String key : requestParams.keySet()) {
			builder.addParameter(key, requestParams.get(key));
		}

		builder.execute(responseHandler);

	}

	public Response doPostSync(String url, Map<String, String> requestParams,
			AsyncHandler<Response> responseHandler) {

		BoundRequestBuilder builder = sender.preparePost(url);

		for (String key : requestParams.keySet()) {
			builder.addParameter(key, requestParams.get(key));
		}

		Future<Response> f;
		try {
			f = builder.execute(responseHandler);
			return f.get();
		} catch (Exception e) {
			LOGGER.error("Communication Exception in HTTP Sender ", e);
		}

		return null;
	}

	public Response doPostSync(String url, Map<String, String> requestParams) {

		BoundRequestBuilder builder = sender.preparePost(url);

		for (String key : requestParams.keySet()) {
			builder.addParameter(key, requestParams.get(key));
		}

		Future<Response> f;
		try {
			builder.setHeader("Content-Type", "application/json");
			// builder.setBody(requestParams.values().iterator().next());
			f = builder.execute();
			return f.get();
		} catch (Exception e) {
			LOGGER.error("Communication Exception in HTTP Sender ", e);
		}

		return null;
	}
	
	public Response doPost(String url, String json) {

		BoundRequestBuilder builder = sender.preparePost(url);		

		builder.setBody(json);
		
		Future<Response> f;
		try {
			builder.setHeader("Content-Type", "application/json");
			// builder.setBody(requestParams.values().iterator().next());
			f = builder.execute();
			return f.get();
		} catch (Exception e) {
			LOGGER.error("Communication Exception in HTTP Sender ", e);
		}

		return null;
	}

	public Response doGet(String url, Map<String, String> requestParams) {
		BoundRequestBuilder builder = sender.prepareGet(url);

		for (String key : requestParams.keySet()) {
			builder.addQueryParameter(key, requestParams.get(key));
		}

		Future<Response> f;
		try {
			f = builder.execute();
			return f.get();
		} catch (Exception e) {
			LOGGER.error("Communication Exception in HTTP Sender ", e);
		}

		return null;
	}
	
	public Response doGet(String url, Map<String, String> headers, Map<String, String> requestParams) {
		BoundRequestBuilder builder = sender.prepareGet(url);

		for (String key : requestParams.keySet()) {
			builder.addQueryParameter(key, requestParams.get(key));
		}
		
		for (String key : headers.keySet()) {
			builder.addHeader(key, headers.get(key));
		}

		Future<Response> f;
		try {
			f = builder.execute();
			return f.get();
		} catch (Exception e) {
			LOGGER.error("Communication Exception in HTTP Sender ", e);
		}

		return null;
	}

	public Response doGet(String url, Map<String, String> requestParams,
			AsyncHandler<Response> responseHandler) {

		BoundRequestBuilder builder = sender.prepareGet(url);

		for (String key : requestParams.keySet()) {
			builder.addQueryParameter(key, requestParams.get(key));
		}

		Future<Response> f;
		try {
			f = builder.execute(responseHandler);
			return f.get();
		} catch (Exception e) {
			LOGGER.error("Communication Exception in HTTP Sender ", e);
		}

		return null;
	}

	@Override
	protected void finalize() throws Throwable {
		sender.close();
		super.finalize();
	}

	public static Response doPostSync(String url, String postRequestString) {
		LOGGER.info("executing HttpUtil.doPostSync()...");
		BoundRequestBuilder builder = sender.preparePost(url);
		Future<Response> f;
		try {
			builder.setHeader("Content-Type", "application/json");
			builder.setBody(postRequestString);

			f = builder.execute();
			return f.get();
		} catch (Exception e) {
			LOGGER.error("Communication Exception in HTTP Sender ", e);
		}

		return null;
	}

}
