package com.elvin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
