package com.elvin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elvin.dao.AccountDao;
import com.elvin.dao.BBCategoryDao;
import com.elvin.dao.BookDao;
import com.elvin.model.Book;
import com.elvin.utility.ActiveUser;

/**
 * Servlet implementation class SiteController
 */
@WebServlet({ "/frontend/homepage" })
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SiteController() {
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

		if (uri.equals(cp + "/frontend/homepage")) {
			// for footer admin link
			if (ActiveUser.isAdmin) {
				request.setAttribute("AdminStatus", "Yes");
			} else {
				request.setAttribute("AdminStatus", null);
			}

			// for book lists
			int userId = AccountDao.getUserId(ActiveUser.username);
			ArrayList<Book> customBookIds = BookDao.displayInterestedBookId(userId);
			ArrayList<Book> bookList = new ArrayList<>();
			for (int i = 0; i < customBookIds.size(); i++) {
				int bookId = customBookIds.get(i).getBookId();
				Book book = BookDao.selectById(bookId); // details except genres
				String bookGenres = BBCategoryDao.getGenreString(bookId); // details of genres

				// mixing both details
				bookList.add(new Book(bookId, book.getBookName(), book.getBookPrice(), book.getBookAuthor(),
						book.getBookPublisher(), book.getBookPublishedDate(), book.getBookImageURL(),
						book.getBookQuantity(), book.getBookImageName(), bookGenres));
			}

			request.setAttribute("BookDetails", bookList);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
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
