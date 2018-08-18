package com.elvin.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.elvin.model.Book;
import com.elvin.utility.MyConnection;

public class BookDao {
	public static boolean add(Book book) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;

		if (connection != null) {
			String sql = "insert into book(bookName,bookPrice,bookAuthor,bookPublisher,bookPublishedDate,bookImageURL,bookQuantity,bookImageName) values(?,?,?,?,?,?,?,?)";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, book.getBookName());
				preparedStatement.setFloat(2, book.getBookPrice());
				preparedStatement.setString(3, book.getBookAuthor());
				preparedStatement.setString(4, book.getBookPublisher());
				preparedStatement.setString(5, book.getBookPublishedDate());
				preparedStatement.setBinaryStream(6, book.getBookImageURL());
				preparedStatement.setInt(7, book.getBookQuantity());
				preparedStatement.setString(8, book.getBookImageName());
				
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
	
	public static ArrayList<Book> displayAll()
	{
		ArrayList<Book> arrayList = new ArrayList<>();
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;

		if (connection != null) {
			String sql = "select bookId,bookName,bookPrice,bookAuthor,bookPublisher,bookPublishedDate,bookImageURL,bookQuantity,bookImageName from book";
			try {
				preparedStatement = connection.prepareStatement(sql);
				
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next())
				{
					int bookId = resultSet.getInt(1);
					String bookName = resultSet.getString(2);
					float bookPrice = Float.parseFloat(resultSet.getString(3));
					String bookAuthor = resultSet.getString(4);
					String bookPublisher = resultSet.getString(5);
					String bookPublishedDate = resultSet.getString(6);
					InputStream bookImage = resultSet.getBinaryStream(7);
					int bookQuantity = resultSet.getInt(8);
					String bookImageName = resultSet.getString(9);
					
					arrayList.add(new Book(bookId,bookName,bookPrice,bookAuthor,bookPublisher,bookPublishedDate,bookImage,bookQuantity,bookImageName));
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
		return arrayList;
	}
	
	public static Book selectById(int id)
	{
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		Book book = null;
		
		if(connection != null)
		{
			String sql = "select bookId,bookName,bookPrice,bookAuthor,bookPublisher,bookPublishedDate,bookImageURL,bookQuantity,bookImageName from book where bookId=?";
			try
			{
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next())
				{
					int bookId = resultSet.getInt(1);
					String bookName = resultSet.getString(2);
					float bookPrice = Float.parseFloat(resultSet.getString(3));
					String bookAuthor = resultSet.getString(4);
					String bookPublisher = resultSet.getString(5);
					String bookPublishedDate = resultSet.getString(6);
					InputStream bookImage = resultSet.getBinaryStream(7);
					int bookQuantity = resultSet.getInt(8);
					String bookImageName = resultSet.getString(9);
					System.out.println("Book Found : "+bookImageName);
					
					book = new Book(bookId,bookName,bookPrice,bookAuthor,bookPublisher,bookPublishedDate,bookImage,bookQuantity,bookImageName);
				}
			}
			catch(SQLException e)
			{
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
		return book;
	}
}
