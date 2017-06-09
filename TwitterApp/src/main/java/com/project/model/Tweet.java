package com.project.model;

import java.util.Date;




public class Tweet {
	private String id;
	private String author;
	private Date date;
	private String text;

	public Tweet() {

	}

	public Tweet(String id, String author, Date date, String text) {
		this.id = id;
		this.author = author;
		this.date = date;
		this.text = text;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}