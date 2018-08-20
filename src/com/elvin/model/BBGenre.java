package com.elvin.model;

import java.io.InputStream;

public class BBGenre {
	private InputStream bookImage;
	private String bookImageName;
	private String bookName;
	private String bookGenre;

	public BBGenre() {
		super();
	}

	public BBGenre(InputStream bookImage, String bookImageName, String bookName, String bookGenre) {
		super();
		this.bookImage = bookImage;
		this.bookImageName = bookImageName;
		this.bookName = bookName;
		this.bookGenre = bookGenre;
	}

	public InputStream getBookImage() {
		return bookImage;
	}

	public void setBookImage(InputStream bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookImageName() {
		return bookImageName;
	}

	public void setBookImageName(String bookImageName) {
		this.bookImageName = bookImageName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

}
