package com.elvin.controller;

import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.elvin.dao.BookDao;
import com.elvin.model.Book;

/**
 * Servlet implementation class BookController
 */
@WebServlet({ "/backend/book/add", "/backend/book/display/all", "/backend/book/edit/all", "/backend/book/edit","/backend/book/delete" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();

		if (uri.equals(cp + "/backend/book/add")) {
			request.getRequestDispatcher("/addBook.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/book/display/all")) {
			request.setAttribute("BookDetails", BookDao.displayAll());
			request.getRequestDispatcher("/displayBooks.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/book/edit/all")) {
			request.getRequestDispatcher("/editBook.jsp").forward(request, response);
		}else if(uri.equals(cp+"/backend/book/delete"))
		{
			int id = Integer.parseInt(request.getParameter("id"));
			boolean status = BookDao.delete(id);
			if(status)
			{
				response.sendRedirect(cp+"/backend/book/display/all");
			}
			else
			{
				request.setAttribute("ErrorMessage", "Book deletion failed !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cp = request.getContextPath();

		if (uri.equals(cp + "/backend/book/add")) {
			// variables
			String bookName = request.getParameter("bookName");
			float bookPrice = Float.parseFloat(request.getParameter("bookPrice"));
			String bookAuthor = request.getParameter("bookAuthor");
			String bookPublisher = request.getParameter("bookPublisher");
			String bookPublishedDate = request.getParameter("bookPublishedDate");
			int bookQuantity = Integer.parseInt(request.getParameter("bookQuantity"));
			InputStream bookImage = null;

			Part filePart = request.getPart("bookImageURL");
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			bookImage = filePart.getInputStream();

			boolean status = BookDao.add(new Book(bookName, bookPrice, bookAuthor, bookPublisher, bookPublishedDate,
					bookImage, bookQuantity, fileName));

			if (status) {
				response.sendRedirect(cp + "/backend/book/display/all");
			} else {
				request.setAttribute("ErrorMessage", "Book addition process failed !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		} else if (uri.equals(cp + "/backend/book/edit/all")) {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			request.setAttribute("EditBookDetails", BookDao.selectById(bookId));
			request.getRequestDispatcher("/editBook.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/book/edit")) {
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			String bookName = request.getParameter("bookName");
			float bookPrice = Float.parseFloat(request.getParameter("bookPrice"));
			String bookAuthor = request.getParameter("bookAuthor");
			String bookPublisher = request.getParameter("bookPublisher");
			String bookPublishedDate = request.getParameter("bookPublishedDate");
			int bookQuantity = Integer.parseInt(request.getParameter("bookQuantity"));
			InputStream bookImage = null;
			String fileName = null;

			Part filePart = request.getPart("bookImageURL");
			fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			bookImage = filePart.getInputStream();

			boolean status = BookDao.update(new Book(bookId, bookName, bookPrice, bookAuthor, bookPublisher,
					bookPublishedDate, bookImage, bookQuantity, fileName));
			if (status) {
				response.sendRedirect(cp + "/backend/book/display/all");
			} else {
				request.setAttribute("ErrorMessage", "Book update failed !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		}
	}
}
