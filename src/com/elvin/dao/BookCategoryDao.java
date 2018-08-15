package com.elvin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.elvin.model.BookCategory;
import com.elvin.utility.MyConnection;

public class BookCategoryDao {
	public static boolean insert(BookCategory bookCategory) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;

		if (connection != null) {
			String sql = "insert into bookcategory(categoryName) values(?)";

			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, bookCategory.getCategoryName());
				int i = preparedStatement.executeUpdate();
				if (i != 0) {
					status = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}

	public static ArrayList<BookCategory> displayAll() {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		ArrayList<BookCategory> arrayList = new ArrayList<>();

		if (connection != null) {
			String sql = "select categoryId, categoryName from bookcategory";
			try {
				preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);

					arrayList.add(new BookCategory(id, name));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return arrayList;
	}

	public static BookCategory selectById(int categoryId) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		BookCategory bookCategory = null;

		if (connection != null) {
			String sql = "select categoryId, categoryName from bookcategory where categoryId=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, categoryId);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					bookCategory = new BookCategory(resultSet.getInt(1), resultSet.getString(2));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bookCategory;
	}

	public static boolean update(BookCategory bookCategory) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;

		if (connection != null) {
			String sql = "update bookcategory set categoryName=? where categoryId=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, bookCategory.getCategoryName());
				preparedStatement.setInt(2, bookCategory.getCategoryId());

				int i = preparedStatement.executeUpdate();

				if (i != 0) {
					status = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}

	public static boolean delete(int id) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;

		if (connection != null) {
			String sql = "delete from bookcategory where categoryId=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				int i = preparedStatement.executeUpdate();
				if (i != 0) {
					status = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					preparedStatement.close();
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}
}
