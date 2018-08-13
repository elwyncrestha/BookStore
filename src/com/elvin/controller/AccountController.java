package com.elvin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elvin.dao.AccountDao;
import com.elvin.model.User;

/**
 * Servlet implementation class AccountController
 */
@WebServlet({ "/backend/account/register", "/backend/account/login","/backend/account/display/all"})
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountController() {
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

		if (uri.equals(cp + "/backend/account/register")) {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/account/login")) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if(uri.equals(cp+"/backend/account/display/all"))
		{
			request.setAttribute("UserDetails", AccountDao.retrieveAllUsers());
			request.getRequestDispatcher("/displayUsers.jsp").forward(request, response);
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

		if (uri.equals(cp + "/backend/account/register")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String dob = request.getParameter("dob");
			String phoneNumber = request.getParameter("phoneNumber");
			char gender = request.getParameter("gender").charAt(0);
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			User user = new User(firstName, lastName, address, dob, phoneNumber, gender, email, password, false);
			boolean status = AccountDao.createUser(user);

			if (status) {
				response.sendRedirect(cp + "/backend/account/login");
			} else {
				request.setAttribute("ErrorMessage", "Couldn't add user !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		} else if (uri.equals(cp + "/backend/account/login")) {
			String username = request.getParameter("email");
			String password = request.getParameter("password");
			
			boolean status = AccountDao.validateUserLogin(username, password);
			if(status)
			{
				response.sendRedirect(cp+"/backend/admin/homepage");
			}
			else
			{
				request.setAttribute("ErrorMessage", "Login failed !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
			
		}
	}

}
