package com.elvin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public static boolean validateUserLogin(String username, String password) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;

		if (connection != null) {
			String sql = "select userId from User where userUsername=? and userPassword=? and isAdmin=1";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
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

	public static ArrayList<User> retrieveAllUsers() {
		ArrayList<User> arrayList = new ArrayList<>();
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;

		if (connection != null) {
			String sql = "select userId,userFName,userLName,userAddress,userDOB,userPhoneNo,userGender,userUsername,userPassword,isAdmin from User";
			try {
				preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int userId = resultSet.getInt(1);
					String fName = resultSet.getString(2);
					String lName = resultSet.getString(3);
					String address = resultSet.getString(4);
					String dob = resultSet.getString(5);
					String phone = resultSet.getString(6);
					String gender = resultSet.getString(7);
					String username = resultSet.getString(8);
					String userPassword = resultSet.getString(9);
					boolean isAdmin = resultSet.getBoolean(10);

					arrayList.add(new User(userId, fName, lName, address, dob, phone, gender, username, userPassword,
							isAdmin));
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

	public static ArrayList<User> selectById(int userId) {
		ArrayList<User> arrayList = new ArrayList<>();
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;

		if (connection != null) {
			String sql = "select userId,userFName,userLName,userAddress,userDOB,userPhoneNo,userGender,userUsername,userPassword,isAdmin from User where userId=?";

			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, userId);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int uId = resultSet.getInt(1);
					String fName = resultSet.getString(2);
					String lName = resultSet.getString(3);
					String address = resultSet.getString(4);
					String dob = resultSet.getString(5);
					String phone = resultSet.getString(6);
					String gender = resultSet.getString(7);
					String username = resultSet.getString(8);
					String userPassword = resultSet.getString(9);
					boolean isAdmin = resultSet.getBoolean(10);

					arrayList.add(
							new User(uId, fName, lName, address, dob, phone, gender, username, userPassword, isAdmin));
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

	public static boolean updateUser(User user) {
		boolean status = false;
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;

		if (connection != null) {
			String sql = "update user set userFName=?, userLName=?, userAddress=?, userDOB=?, userPhoneNo=?, userGender=?, userUsername=?, userPassword=?, isAdmin=? where userId=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, user.getFirstName());
				preparedStatement.setString(2, user.getLastName());
				preparedStatement.setString(3, user.getAddress());
				preparedStatement.setString(4, user.getDob());
				preparedStatement.setString(5, user.getPhone());
				preparedStatement.setString(6, user.getGender());
				preparedStatement.setString(7, user.getUsername());
				preparedStatement.setString(8, user.getPassword());
				preparedStatement.setBoolean(9, user.getIsAdmin());
				preparedStatement.setInt(10, user.getUserId());

				int i = preparedStatement.executeUpdate();
				if (i != 0) {
					status = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
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
