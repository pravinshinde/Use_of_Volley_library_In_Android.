package com.infostretch.volydemo.network.response;

import com.infostretch.volydemo.network.NetworkErrorInterface;

public class NetworkError implements NetworkErrorInterface {

	private String code;
	private String message;
	
	@Override
	public String getErrorMessage() {
		return message;
	}
	@Override
	public int getErrorCode() {
		return Integer.valueOf(code);
	}
	
}
