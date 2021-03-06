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
				if (i != 0) {
					status = true;
					System.out.println("Book added !!!");
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

	public static ArrayList<Book> displayAll() {
		ArrayList<Book> arrayList = new ArrayList<>();
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;

		if (connection != null) {
			String sql = "select bookId,bookName,bookPrice,bookAuthor,bookPublisher,bookPublishedDate,bookImageURL,bookQuantity,bookImageName from book";
			try {
				preparedStatement = connection.prepareStatement(sql);

				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					int bookId = resultSet.getInt(1);
					String bookName = resultSet.getString(2);
					float bookPrice = Float.parseFloat(resultSet.getString(3));
					String bookAuthor = resultSet.getString(4);
					String bookPublisher = resultSet.getString(5);
					String bookPublishedDate = resultSet.getString(6);
					InputStream bookImage = resultSet.getBinaryStream(7);
					int bookQuantity = resultSet.getInt(8);
					String bookImageName = resultSet.getString(9);

					arrayList.add(new Book(bookId, bookName, bookPrice, bookAuthor, bookPublisher, bookPublishedDate,
							bookImage, bookQuantity, bookImageName));
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

	public static Book selectById(int id) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		Book book = null;

		if (connection != null) {
			String sql = "select bookId,bookName,bookPrice,bookAuthor,bookPublisher,bookPublishedDate,bookImageURL,bookQuantity,bookImageName from book where bookId=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int bookId = resultSet.getInt(1);
					String bookName = resultSet.getString(2);
					float bookPrice = Float.parseFloat(resultSet.getString(3));
					String bookAuthor = resultSet.getString(4);
					String bookPublisher = resultSet.getString(5);
					String bookPublishedDate = resultSet.getString(6);
					InputStream bookImage = resultSet.getBinaryStream(7);
					int bookQuantity = resultSet.getInt(8);
					String bookImageName = resultSet.getString(9);

					book = new Book(bookId, bookName, bookPrice, bookAuthor, bookPublisher, bookPublishedDate,
							bookImage, bookQuantity, bookImageName);
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
		return book;
	}

	public static boolean update(Book book) {
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;
		boolean status = false;

		if (connection != null) {
			String sql = null;
			if (book.getBookImageName().length() == 0) {
				sql = "update book set bookName=?,bookPrice=?,bookAuthor=?,bookPublisher=?,bookPublishedDate=?,bookQuantity=bookQuantity+? where bookId=?";
			} else {
				sql = "update book set bookName=?,bookPrice=?,bookAuthor=?,bookPublisher=?,bookPublishedDate=?,bookQuantity=bookQuantity+?,bookImageURL=?,bookImageName=? where bookId=?";
			}

			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, book.getBookName());
				preparedStatement.setFloat(2, book.getBookPrice());
				preparedStatement.setString(3, book.getBookAuthor());
				preparedStatement.setString(4, book.getBookPublisher());
				preparedStatement.setString(5, book.getBookPublishedDate());
				preparedStatement.setInt(6, book.getBookQuantity());
				if (book.getBookImageName().length() > 0) {
					preparedStatement.setBinaryStream(7, book.getBookImageURL());
					preparedStatement.setString(8, book.getBookImageName());
					preparedStatement.setInt(9, book.getBookId());
				} else {
					preparedStatement.setInt(7, book.getBookId());
				}

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
		boolean status = false;
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;

		if (connection != null) {
			String sql = "delete from book where bookId=?";
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

	public static ArrayList<Book> displayInterestedBookId(int userId) {
		ArrayList<Book> arrayList = new ArrayList<>();
		Connection connection = MyConnection.connect();
		PreparedStatement preparedStatement = null;

		if (connection != null) {
			String sql = "select b.bookId from book b, book_bookcategory bbc, bookcategory bc, usercategoryinterest uci where b.bookId=bbc.bookId and bbc.categoryId=bc.categoryId and bc.categoryId=uci.categoryId and uci.userId=? order by b.bookId asc";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, userId);

				ResultSet resultSet = preparedStatement.executeQuery();
				int testDuplicateId = 0;
				while (resultSet.next()) {
					int bookId = resultSet.getInt(1);
					if(bookId != testDuplicateId)
					{
						arrayList.add(new Book(bookId,null,0,null,null,null,null,0,null,null));
						testDuplicateId = bookId;
					}
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
}
