package com.infostretch.volydemo.util;

import android.util.Log;

public class DemoLogger {

	private static boolean logEnabled = true;

	public static void setLogEnabled(boolean logEnabled) {
		DemoLogger.logEnabled = logEnabled;
	}

	public static boolean isLogEnabled() {
		return logEnabled;
	}

	public static void v(String tag, String message) {
		Log.v(tag, message);
	}

	public static void d(String tag, String message) {
		Log.d(tag, message);
	}
}
