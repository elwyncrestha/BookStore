package com.elvin.model;

public class UserCategoryInterest {
	private int userId;
	private int categoryId;

	public UserCategoryInterest(int userId, int categoryId) {
		super();
		this.userId = userId;
		this.categoryId = categoryId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}
