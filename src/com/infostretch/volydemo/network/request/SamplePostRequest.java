package com.infostretch.volydemo.network.request;

import java.util.List;
import java.util.Map;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.infostretch.volydemo.model.PostRequestModel;
import com.infostretch.volydemo.model.PostResponseModel;
import com.infostretch.volydemo.network.NetworkErrorAdapter;
import com.infostretch.volydemo.network.response.ResponseErrorListener;
import com.infostretch.volydemo.network.response.ResponseListener;
import com.infostretch.volydemo.network.volly.VolleyNetwork;
import com.infostretch.volydemo.network.volly.request.GsonPostRequest;

public class SamplePostRequest implements DemoPostRequest<PostRequestModel, PostResponseModel> {
	private static String requestUrl;
	private GsonPostRequest<PostRequestModel, PostResponseModel> volleyLoginRequest;

	public SamplePostRequest() {
		requestUrl = "http://jsonplaceholder.typicode.com/posts";
	}

	@Override
	public void process(Map<String, String> headers, List<PostRequestModel> object,
			final ResponseListener<PostResponseModel> responseListener,
			final ResponseErrorListener responseErrorListener) {

		volleyLoginRequest = new GsonPostRequest<PostRequestModel, PostResponseModel>(
				requestUrl, object.get(0), headers, PostResponseModel.class,
				new Listener<PostResponseModel>() {

					@Override
					public void onResponse(PostResponseModel response) {
						responseListener.onResponse(response);

					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

						responseErrorListener
								.onErrorResponse(new NetworkErrorAdapter(
										error));

					}
				});

		VolleyNetwork.getInstance().getRequestQueue().add(volleyLoginRequest);

	}

}
