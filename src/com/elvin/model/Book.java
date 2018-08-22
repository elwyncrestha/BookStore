package com.elvin.model;

import java.io.InputStream;

public class Book {
	private int bookId;
	private String bookName;
	private float bookPrice;
	private String bookAuthor;
	private String bookPublisher;
	private String bookPublishedDate;
	private InputStream bookImageURL;
	private int bookQuantity;
	private String bookImageName;
	private String bookGenre;

	public Book() {}

	// with id, without genre
	public Book(int bookId, String bookName, float bookPrice, String bookAuthor, String bookPublisher,
			String bookPublishedDate, InputStream bookImageURL, int bookQuantity, String bookImageName) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPublishedDate = bookPublishedDate;
		this.bookImageURL = bookImageURL;
		this.bookQuantity = bookQuantity;
		this.bookImageName = bookImageName;
	}

	// without id and genre
	public Book(String bookName, float bookPrice, String bookAuthor, String bookPublisher, String bookPublishedDate,
			InputStream bookImageURL, int bookQuantity, String bookImageName) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPublishedDate = bookPublishedDate;
		this.bookImageURL = bookImageURL;
		this.bookQuantity = bookQuantity;
		this.bookImageName = bookImageName;
	}
	
	// with id and genre
	public Book(int bookId, String bookName, float bookPrice, String bookAuthor, String bookPublisher,
			String bookPublishedDate, InputStream bookImageURL, int bookQuantity, String bookImageName,
			String bookGenre) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPublishedDate = bookPublishedDate;
		this.bookImageURL = bookImageURL;
		this.bookQuantity = bookQuantity;
		this.bookImageName = bookImageName;
		this.bookGenre = bookGenre;
	}

	// without id, with genre
	public Book(String bookName, float bookPrice, String bookAuthor, String bookPublisher, String bookPublishedDate,
			InputStream bookImageURL, int bookQuantity, String bookImageName, String bookGenre) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPublishedDate = bookPublishedDate;
		this.bookImageURL = bookImageURL;
		this.bookQuantity = bookQuantity;
		this.bookImageName = bookImageName;
		this.bookGenre = bookGenre;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public float getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookPublishedDate() {
		return bookPublishedDate;
	}

	public void setBookPublishedDate(String bookPublishedDate) {
		this.bookPublishedDate = bookPublishedDate;
	}

	public InputStream getBookImageURL() {
		return bookImageURL;
	}

	public void setBookImageURL(InputStream bookImageURL) {
		this.bookImageURL = bookImageURL;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	
	public String getBookImageName() {
		return bookImageName;
	}

	public void setBookImageName(String bookImageName) {
		this.bookImageName = bookImageName;
	}
	
	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	
}
