package com.infostretch.volydemo.network.request;

import java.util.Map;

import com.infostretch.volydemo.network.response.ResponseErrorListener;
import com.infostretch.volydemo.network.response.ResponseListener;


public interface DemoGetRequest<T>  {
	
	public void  process(Map<String, String> headers,ResponseListener<T> responseListener, ResponseErrorListener responseErrorListener);
	
}
