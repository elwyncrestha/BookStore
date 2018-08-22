package com.elvin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public static boolean deleteAllInterest(int userId)
	{
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;
		
		if(connection != null)
		{
			String sql = "delete from UserCategoryInterest where userId=?";
			try
			{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, userId);
				int i = preparedStatement.executeUpdate();
				
				if(i != 0)
				{
					status = true;
				}
			} catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
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
		return status;
	}
	
	public static String getInterestString(int userId)
	{
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		String interestString = "";
		
		if(connection != null)
		{
			String sql = "select bc.categoryName from BookCategory bc, UserCategoryInterest uci where bc.categoryId=uci.categoryId and uci.userId=?";
			try
			{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, userId);
				ResultSet resultSet = preparedStatement.executeQuery();
				StringBuffer stringBuffer = new StringBuffer("");
				
				while(resultSet.next())
				{
					stringBuffer.append(resultSet.getString(1));
					if(resultSet.isLast() == false)
					{
						stringBuffer.append(", ");
					}
				}
				
				interestString = stringBuffer.toString();
			} catch(SQLException e)
			{
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
		return interestString;
	}
}
