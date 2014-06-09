package com.example.commentsapp;

import com.loopj.android.http.*;

public class CommentClient {

	public CommentClient() {
		// TODO Auto-generated constructor stub
	}
	
	  private static final String BASE_URL = "http://commentsapi.herokuapp.com/public/";

	  private static AsyncHttpClient client = new AsyncHttpClient();
	  
	  

	  public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
	      client.get(getAbsoluteUrl(url), params, responseHandler);
	  }

	  public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
	      client.post(getAbsoluteUrl(url), params, responseHandler);
	  }

	  private static String getAbsoluteUrl(String relativeUrl) {
	      return BASE_URL + relativeUrl;
	  }

}
