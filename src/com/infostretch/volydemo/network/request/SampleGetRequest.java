package com.infostretch.volydemo.network.request;

import java.util.Map;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.infostretch.volydemo.model.GetResponseModel;
import com.infostretch.volydemo.network.NetworkErrorAdapter;
import com.infostretch.volydemo.network.response.ResponseErrorListener;
import com.infostretch.volydemo.network.response.ResponseListener;
import com.infostretch.volydemo.network.volly.VolleyNetwork;
import com.infostretch.volydemo.network.volly.request.GsonGetObjectRequest;
import com.infostretch.volydemo.network.volly.request.GsonGetRequest;

public class SampleGetRequest implements DemoGetRequest<GetResponseModel> {
	private static String requestUrl;
	private GsonGetRequest<GetResponseModel> volleyLoginRequest;

	public SampleGetRequest() {
		requestUrl = "http://rest-service.guides.spring.io/greeting";
	}

	@Override
	public void process(Map<String, String> headers,
			final ResponseListener<GetResponseModel> responseListener,
			final ResponseErrorListener responseErrorListener) {

		volleyLoginRequest = new GsonGetObjectRequest<GetResponseModel>(requestUrl,
				GetResponseModel.class,null, new Listener<GetResponseModel>() {

					@Override
					public void onResponse(GetResponseModel response) {
						responseListener.onResponse(response);

					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

						responseErrorListener
								.onErrorResponse(new NetworkErrorAdapter(error));

					}
				});
		VolleyNetwork.getInstance().getRequestQueue().add(volleyLoginRequest);

	}

}
