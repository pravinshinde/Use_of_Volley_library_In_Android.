package com.infostretch.volydemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.infostretch.volydemo.model.GetResponseModel;
import com.infostretch.volydemo.model.PostRequestModel;
import com.infostretch.volydemo.model.PostResponseModel;
import com.infostretch.volydemo.network.NetworkErrorInterface;
import com.infostretch.volydemo.network.request.SampleGetRequest;
import com.infostretch.volydemo.network.request.SamplePostRequest;
import com.infostretch.volydemo.network.response.ResponseErrorListener;
import com.infostretch.volydemo.network.response.ResponseListener;
import com.infostretch.volydemo.util.DemoLogger;

public class MainActivity extends Activity implements OnClickListener {
	public static final String REQUEST_TAG = "MainVolleyActivity";
	private static final String TAG = null;
	private TextView mTxtId;
	private TextView mTxtTitle;
	private TextView mTxtBody;
	private Button mBtnPost;
	private Button mBtnGet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTxtId = (TextView) findViewById(R.id.txt_response_id);
		mTxtTitle = (TextView) findViewById(R.id.txt_response_title);
		mTxtBody = (TextView) findViewById(R.id.txt_response_body);

		mBtnPost = (Button) findViewById(R.id.btn_post_request);
		mBtnGet = (Button) findViewById(R.id.btn_get_request);
		mBtnGet.setOnClickListener(this);
		mBtnPost.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.btn_get_request:
			callGetService();
			break;

		case R.id.btn_post_request:
			callPostService();
			break;

		default:
			break;
		}
	}

	private void callPostService() {

		SamplePostRequest duLoginRequest = new SamplePostRequest();
		PostRequestModel user = new PostRequestModel();
		List<PostRequestModel> list = new ArrayList<PostRequestModel>();
		list.add(user);

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-type", "application/json");

		duLoginRequest.process(headers, list,
				new ResponseListener<PostResponseModel>() {

					@Override
					public void onResponse(final PostResponseModel response) {
						mTxtTitle.setVisibility(View.VISIBLE);
						mTxtId.setText(Integer.toString(response.getId()));
						mTxtTitle.setText(response.getTitle());
						mTxtBody.setText(response.getBody());
						System.out.println("Result:- " + response);

					}
				}, new ResponseErrorListener() {

					@Override
					public void onErrorResponse(NetworkErrorInterface error) {
						DemoLogger.d(TAG,
								"Error Message " + error.getErrorMessage());
						DemoLogger.d(TAG, "Error Code " + error.getErrorCode());

					}
				});

	}

	private void callGetService() {
		
		SampleGetRequest demoGetRequest = new SampleGetRequest();

		Map<String, String> getHeaders = new HashMap<String, String>();
		getHeaders.put("Accept", "application/json");
		getHeaders.put("Content-type", "application/json");

		demoGetRequest.process(getHeaders,
				new ResponseListener<GetResponseModel>() {

					@Override
					public void onResponse(final GetResponseModel response) {
						mTxtTitle.setVisibility(View.GONE);
						mTxtId.setText(Integer.toString(response.getId()));
						mTxtBody.setText(response.getContent());
						System.out.println("Result:- " + response);

					}
				}, new ResponseErrorListener() {

					@Override
					public void onErrorResponse(NetworkErrorInterface error) {
						DemoLogger.d(TAG,
								"Error Message " + error.getErrorMessage());
						DemoLogger.d(TAG, "Error Code " + error.getErrorCode());

					}
				});

	}

}
