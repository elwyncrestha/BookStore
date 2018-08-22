package com.elvin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.elvin.model.BBCategory;
import com.elvin.utility.MyConnection;

public class BBCategoryDao {
	public static boolean assignCategory(BBCategory bbCategory) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;

		if (connection != null) {
			String sql = "insert into book_bookcategory(bookId,categoryid) values(?,?)";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, bbCategory.getBookId());
				preparedStatement.setInt(2, bbCategory.getCategoryId());
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

	public static String getGenreString(int bookId) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		String genreString = "";

		if (connection != null) {
			String sql = "select bc.categoryName from bookCategory bc, book_bookcategory bbc where bc.categoryId=bbc.categoryId and bbc.bookId=?";
			StringBuffer genreStringBuffer = new StringBuffer("");
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, bookId);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					String genre = resultSet.getString(1);
					genreStringBuffer.append(genre);
					if (resultSet.isLast() == false) {
						genreStringBuffer.append(", ");
					}
				}

				genreString = genreStringBuffer.toString();

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
		return genreString;
	}

	public static void deleteCategories(int bookId) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;

		if (connection != null) {
			String sql = "delete from Book_BookCategory where bookId=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, bookId);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally
			{
				try
				{
					preparedStatement.close();
					connection.close();
				} catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
