package com.infostretch.volydemo.network.request;

import java.util.List;
import java.util.Map;

import com.infostretch.volydemo.network.response.ResponseErrorListener;
import com.infostretch.volydemo.network.response.ResponseListener;

public interface DemoPostRequest<T, M> {

	public void process(Map<String, String> headers,List<T> object,ResponseListener<M> responseListener,
			ResponseErrorListener responseErrorListener);

}

