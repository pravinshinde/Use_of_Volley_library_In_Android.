package com.infostretch.volydemo.network.response;

import com.infostretch.volydemo.network.NetworkErrorInterface;

public interface ResponseErrorListener {
	 /**
    * Callback method that an error has been occurred with the
    * provided error code and optional user-readable message.
    */
   public void onErrorResponse(NetworkErrorInterface error);
}