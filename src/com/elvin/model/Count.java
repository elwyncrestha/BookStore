package com.elvin.model;

public class Count {
	private int bookCount;
	private int bookCategoryCount;
	private int userCount;

	public Count() {
		super();
	}

	public Count(int bookCount, int bookCategoryCount, int userCount) {
		super();
		this.bookCount = bookCount;
		this.bookCategoryCount = bookCategoryCount;
		this.userCount = userCount;
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
}
