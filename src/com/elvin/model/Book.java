package com.elvin.model;

public class Book {
	private int bookId;
	private String bookName;
	private float bookPrice;
	private String bookAuthor;
	private String bookPublisher;
	private String bookPublishedDate;
	private String bookImageURL;
	private int bookQuantity;
	
	public Book() {}

	public Book(int bookId, String bookName, float bookPrice, String bookAuthor, String bookPublisher,
			String bookPublishedDate, String bookImageURL, int bookQuantity) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPublishedDate = bookPublishedDate;
		this.bookImageURL = bookImageURL;
		this.bookQuantity = bookQuantity;
	}

	public Book(String bookName, float bookPrice, String bookAuthor, String bookPublisher, String bookPublishedDate,
			String bookImageURL, int bookQuantity) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPublishedDate = bookPublishedDate;
		this.bookImageURL = bookImageURL;
		this.bookQuantity = bookQuantity;
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

	public String getBookImageURL() {
		return bookImageURL;
	}

	public void setBookImageURL(String bookImageURL) {
		this.bookImageURL = bookImageURL;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	
}
