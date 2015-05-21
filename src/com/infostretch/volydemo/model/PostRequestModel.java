package com.infostretch.volydemo.model;

public class PostRequestModel {
	String title;
	String body;
	
	public PostRequestModel()
	{
		title = "This is my first post!";
		body = "Hello Pravin!";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	

}
