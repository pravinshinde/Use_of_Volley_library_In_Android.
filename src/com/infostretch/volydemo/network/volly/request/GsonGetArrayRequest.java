package com.infostretch.volydemo.network.volly.request;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class GsonGetArrayRequest<T> extends GsonGetRequest<List<T>> {

	public GsonGetArrayRequest(String url, Map<String, String> headers,
			Listener<List<T>> listener, ErrorListener errorListener) {
		super(url, headers, listener, errorListener);
	}

	@Override
	protected Response<List<T>> parseNetworkResponse(NetworkResponse response) {
		try {
			String json = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers));
			Type collectionType = new TypeToken<List<T>>() {
			}.getType();
			List<T> parsedResponse = gson.fromJson(json, collectionType);
			return Response.success(parsedResponse,
					HttpHeaderParser.parseCacheHeaders(response));
		} catch (UnsupportedEncodingException e) {
			return Response.error(new ParseError(e));
		} catch (JsonSyntaxException e) {
			return Response.error(new ParseError(e));
		}
	}

}
