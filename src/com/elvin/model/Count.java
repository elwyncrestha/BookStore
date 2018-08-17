package com.elvin.model;

public class Count {
	private int bookCount;
	private int bookCategoryCount;
	private int userCount;
	private int bookSalesCount;

	public Count() {
		super();
	}

	public Count(int bookCount, int bookCategoryCount, int userCount, int bookSalesCount) {
		super();
		this.bookCount = bookCount;
		this.bookCategoryCount = bookCategoryCount;
		this.userCount = userCount;
		this.bookSalesCount = bookSalesCount;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public int getBookCategoryCount() {
		return bookCategoryCount;
	}

	public void setBookCategoryCount(int bookCategoryCount) {
		this.bookCategoryCount = bookCategoryCount;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public int getBookSalesCount() {
		return bookSalesCount;
	}

	public void setBookSalesCount(int bookSalesCount) {
		this.bookSalesCount = bookSalesCount;
	}

}
