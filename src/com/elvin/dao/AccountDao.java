package com.elvin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.elvin.model.User;
import com.elvin.utility.MyConnection;

public class AccountDao {

	public static boolean createUser(User user) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;

		if (connection != null) {
			String insertSQL = "insert into User(userFName,userLName,userAddress,userDOB,userPhoneNo,userGender,userUsername,userPassword,isAdmin) values(?,?,?,?,?,?,?,?,?)";
			try {
				preparedStatement = connection.prepareStatement(insertSQL);
				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
				preparedStatement.setString(3, user.getAddress());
				preparedStatement.setString(4, user.getDob());
				preparedStatement.setString(5, user.getPhone());
				preparedStatement.setString(6, String.valueOf(user.getGender()));
				preparedStatement.setString(7, user.getUsername());
				preparedStatement.setString(8, user.getPassword());
				preparedStatement.setBoolean(9, user.getIsAdmin());

				int i = preparedStatement.executeUpdate();
				if (i != 0) {
					System.out.println("User added successfully !!!");
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

	public static boolean validateUserLogin(String username, String password)
	{
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;
		
		if(connection != null)
		{
			String sql = "select userId from User where userUsername=? and userPassword=?";
			try
			{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				if(resultSet.next())
				{
					status = true;
				}
			}
			catch(SQLException e)
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
}
