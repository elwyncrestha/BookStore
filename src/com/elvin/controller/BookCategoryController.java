package com.elvin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elvin.dao.BookCategoryDao;
import com.elvin.model.BookCategory;

/**
 * Servlet implementation class BookCategoryController
 */
@WebServlet({ "/backend/book/category/add", "/backend/book/category/display/all", "/backend/book/category/edit",
		"/backend/book/category/delete"})
public class BookCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookCategoryController() {
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

		if (uri.equals(cp + "/backend/book/category/add")) {
			request.getRequestDispatcher("/addBookCategory.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/book/category/display/all")) {
			request.setAttribute("CategoryDetails", BookCategoryDao.displayAll());
			request.getRequestDispatcher("/displayBookCategories.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/book/category/edit")) {
			int categoryId = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("EditCategory", BookCategoryDao.selectById(categoryId));
			request.getRequestDispatcher("/editBookCategory.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/book/category/delete")) {
			int categoryId = Integer.parseInt(request.getParameter("id"));
			BookCategoryDao.delete(categoryId);
			response.sendRedirect(cp + "/backend/book/category/display/all");
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

		if (uri.equals(cp + "/backend/book/category/add")) {
			String categoryName = request.getParameter("categoryName");

			BookCategory bookCategory = new BookCategory(categoryName);

			boolean status = BookCategoryDao.insert(bookCategory);

			if (status) {
				response.sendRedirect(cp + "/backend/book/category/display/all");
			} else {
				request.setAttribute("ErrorMessage", "Book category insertion process failed !!!");
				request.getRequestDispatcher("/errorPage").forward(request, response);
			}
		} else if (uri.equals(cp + "/backend/book/category/edit")) {
			int id = Integer.parseInt(request.getParameter("categoryId"));
			String name = request.getParameter("categoryName");

			BookCategory bookCategory = new BookCategory(id, name);

			boolean status = BookCategoryDao.update(bookCategory);
			if (status) {
				response.sendRedirect(cp + "/backend/book/category/display/all");
			} else {
				request.setAttribute("ErrorMessage", "Book category update failed !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		}
	}

}
