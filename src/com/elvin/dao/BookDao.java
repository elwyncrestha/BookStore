package com.elvin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.elvin.model.Book;
import com.elvin.utility.MyConnection;

public class BookDao {
	public static boolean add(Book book) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;

		if (connection != null) {
			String sql = "insert into book(bookName,bookPrice,bookAuthor,bookPublisher,bookPublishedDate,bookImageURL,bookQuantity) values(?,?,?,?,?,?,?)";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, book.getBookName());
				preparedStatement.setFloat(2, book.getBookPrice());
				preparedStatement.setString(3, book.getBookAuthor());
				preparedStatement.setString(4, book.getBookPublisher());
				preparedStatement.setString(5, book.getBookPublishedDate());
				preparedStatement.setString(6, book.getBookImageURL());
				preparedStatement.setInt(7, book.getBookQuantity());
				
				int i = preparedStatement.executeUpdate();
				if(i != 0)
				{
					status = true;
					System.out.println("Book added !!!");
				}
			} catch (SQLException e) {
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
