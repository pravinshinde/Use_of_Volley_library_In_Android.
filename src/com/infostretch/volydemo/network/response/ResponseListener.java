package com.infostretch.volydemo.network.response;

public interface ResponseListener<T> {
	/** Called when a response is received. */
	public void onResponse(T response);
}

