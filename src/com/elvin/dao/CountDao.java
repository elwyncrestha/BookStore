package com.elvin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.elvin.model.Count;
import com.elvin.utility.MyConnection;

public class CountDao {
	public static int tableRowCount(String tableName) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		int count = 0;

		if (connection != null) {
			String sql = "select COUNT(*) from "+tableName;
			try {
				preparedStatement = connection.prepareStatement(sql);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next())
				{
					count = resultSet.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				try
				{
					preparedStatement.close();
					connection.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return count;
	}
	
	public static Count dashboardCount()
	{
		Count count = new Count();
		count.setBookCount(tableRowCount("book"));
		count.setBookCategoryCount(tableRowCount("bookCategory"));
		count.setUserCount(tableRowCount("user"));
		
		return count;
	}
}
