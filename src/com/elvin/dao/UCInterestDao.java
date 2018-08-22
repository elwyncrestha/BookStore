package com.elvin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.elvin.model.UserCategoryInterest;
import com.elvin.utility.MyConnection;

public class UCInterestDao {
	public static boolean assignInterest(UserCategoryInterest userCategoryInterest) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;

		if (connection != null) {
			String sql = "insert into UserCategoryInterest(userId,categoryId) values(?,?)";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, userCategoryInterest.getUserId());
				preparedStatement.setInt(2, userCategoryInterest.getCategoryId());
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
