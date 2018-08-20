package com.elvin.model;

public class BBCategory {
	private int bookId;
	private int categoryId;
	
	public BBCategory() {
		super();
	}

	public BBCategory(int bookId, int categoryId) {
		super();
		this.bookId = bookId;
		this.categoryId = categoryId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
