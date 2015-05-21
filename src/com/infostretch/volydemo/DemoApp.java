package com.infostretch.volydemo;

import com.infostretch.volydemo.network.volly.VolleyNetwork;
import com.infostretch.volydemo.util.DemoLogger;

import android.app.Application;
import android.content.Context;

public class DemoApp extends Application{
	
	public static final String TAG = "DemoApp";
	private static Context demoApp;
	public static final String BASE_URL = "http://10.12.43.165/dailyuse/services/";
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		DemoLogger.d(TAG, "initializing app");
		demoApp = this;
		VolleyNetwork.getInstance().init(demoApp);
	}

	public static Context getDailyUseAppContext() {
		return demoApp;
	}

}
