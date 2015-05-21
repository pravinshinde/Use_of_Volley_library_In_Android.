package com.infostretch.volydemo.network.volly.request;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class GsonPostRequest<T, M> extends JsonRequest<M> {

	private final static Gson gson = new Gson();
	private Class<M> returnTypeClass;
	private Map<String, String> headers;

	public GsonPostRequest(String url, T object, Map<String, String> headers,
			Class<M> returnTypeClass, Listener<M> listener,
			ErrorListener errorListener) {
		super(Method.POST, url, gson.toJson(object), listener, errorListener);
		init(headers, returnTypeClass);

	}

	public GsonPostRequest(String url, Map<String, String> headers,
			Class<M> returnTypeClass, Listener<M> listener,
			ErrorListener errorListener) {
		super(Method.POST, url, "", listener, errorListener);
		init(headers, returnTypeClass);

	}

	private void init(Map<String, String> headers, Class<M> returnTypeClass) {
		if (headers == null) {
			headers = new HashMap<String, String>();
		}
		this.headers = headers;
		if (!this.headers.containsKey("Content-Type")) {
			this.headers.put("Content-Type", "application/json");
		}

		this.returnTypeClass = returnTypeClass;
	}

	@Override
	protected Response<M> parseNetworkResponse(NetworkResponse response) {
		try {
			String json = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
			return Response.success(gson.fromJson(json, returnTypeClass),HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JsonSyntaxException e) {
			return Response.error(new ParseError(e));
		}
	}

	@Override
	public Map<String, String> getHeaders() throws AuthFailureError {
		return this.headers;
	}

}
