package com.infostretch.volydemo.network.volly;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.infostretch.volydemo.network.Network;
import com.infostretch.volydemo.network.volly.ssl.SslHttpStack;

public class VolleyNetwork implements Network {

	private RequestQueue requestQueue;
	private Context context;
	private static VolleyNetwork network;

	private VolleyNetwork() {

	}

	public static VolleyNetwork getInstance() {
		if (null == network) {
			network = new VolleyNetwork();
		}

		return network;
	}

	@Override
	public void init(Context cnt) {
		this.context = cnt;
		this.requestQueue = Volley.newRequestQueue(context, new SslHttpStack(true));
	}

	public RequestQueue getRequestQueue() {
		return requestQueue;
	}

}
