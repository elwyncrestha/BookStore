package com.elvin.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elvin.utility.MyConnection;


/**
 * Servlet implementation class ImageController
 */
@WebServlet("/images/*")
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	public ImageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookImageName = request.getPathInfo().substring(1);
		
		try
		{
			Connection connection = MyConnection.connect();
			String SQL_FIND = "select bookImageURL from book b where b.bookImageName = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND);
			preparedStatement.setString(1, bookImageName);
			
			try(ResultSet resultSet = preparedStatement.executeQuery())
			{
				if(resultSet.next())
				{
					byte[] bookImage = resultSet.getBytes("bookImageURL");
					response.setContentType(getServletContext().getMimeType(bookImageName));
					response.setContentLength(bookImage.length);
					response.getOutputStream().write(bookImage);
				}else
				{
					response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404.
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
