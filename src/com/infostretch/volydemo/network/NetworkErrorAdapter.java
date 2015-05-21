package com.infostretch.volydemo.network;

import android.text.TextUtils;

import com.android.volley.VolleyError;

public class NetworkErrorAdapter implements NetworkErrorInterface {

	private VolleyError error;

	public NetworkErrorAdapter(VolleyError error) {
		this.error = error;
	}

	@Override
	public String getErrorMessage() {
		String message = null;
		if (null != error.networkResponse) {
			message = new String(error.networkResponse.data);
		}

		if (TextUtils.isEmpty(message)) {
			message = error.getMessage();
		}
		return message;
	}

	@Override
	public int getErrorCode() {
		int errorCode = -1;
		if (null != error.networkResponse) {
			errorCode = error.networkResponse.statusCode;
		}
		return errorCode;
	}

}
