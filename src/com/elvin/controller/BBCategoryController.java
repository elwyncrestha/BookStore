package com.elvin.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elvin.dao.BBCategoryDao;
import com.elvin.dao.BookCategoryDao;
import com.elvin.dao.BookDao;
import com.elvin.model.BBCategory;
import com.elvin.model.BBGenre;
import com.elvin.model.Book;

/**
 * Servlet implementation class BBCategoryController
 */
@WebServlet({ "/backend/bbc/assign", "/backend/bbc/display", "/backend/bbc/load/one" })
public class BBCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BBCategoryController() {
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

		if (uri.equals(cp + "/backend/bbc/assign")) {
			request.setAttribute("BookDetails", BookDao.displayAll());
			request.getRequestDispatcher("/assignBookGenre.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/bbc/load/one")) {
			int bookId = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("BookDetails", BookDao.displayAll());
			request.setAttribute("BBCDetails", BookDao.selectById(bookId));
			request.setAttribute("CategoryDetails", BookCategoryDao.displayAll());
			request.getRequestDispatcher("/assignBookGenre.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/bbc/display")) {
			ArrayList<Book> bookList = BookDao.displayAll();
			ArrayList<BBGenre> bookGenreList = new ArrayList<>();
			
			for(int i = 0; i < bookList.size(); i ++)
			{
				int bookId = bookList.get(i).getBookId();
				String bookGenre = BBCategoryDao.getGenreString(bookId);
				InputStream bookImage = bookList.get(i).getBookImageURL();
				String bookImageName = bookList.get(i).getBookImageName();
				String bookName = bookList.get(i).getBookName();
				
				bookGenreList.add(new BBGenre(bookImage,bookImageName,bookName,bookGenre));
			}
			
			request.setAttribute("GenreDetails", bookGenreList);
			request.getRequestDispatcher("/displayBookGenre.jsp").forward(request, response);
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

		if (uri.equals(cp + "/backend/bbc/assign")) {
			boolean status = false;
			int bookId = Integer.parseInt(request.getParameter("bookId"));
			String[] categoryIdArray = request.getParameterValues("categoryId");
			for (int i = 0; i < categoryIdArray.length; i++) {
				int categoryId = Integer.parseInt(categoryIdArray[i]);
				status = BBCategoryDao.assignCategory(new BBCategory(bookId, categoryId));
			}

			if (status) {
				response.sendRedirect(cp + "/backend/bbc/display");
			} else {
				request.setAttribute("ErrorMessage", "Book category assign failed !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		}
	}

}
