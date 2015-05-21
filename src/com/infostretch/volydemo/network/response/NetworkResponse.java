package com.infostretch.volydemo.network.response;


public class NetworkResponse<T> {

	
	private T result;
	private String Success;
	
	public T getResults() {
		return result;
	}
	
	public String getSuccess(){
		return Success;
	}
	
}
