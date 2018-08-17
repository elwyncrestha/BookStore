package com.elvin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elvin.dao.AccountDao;
import com.elvin.model.User;
import com.elvin.utility.ActiveUser;

/**
 * Servlet implementation class AccountController
 */
@WebServlet({ "/account/register", "/account/login", "/backend/account/display/all", "/account/logout",
		"/backend/account/edit", "/backend/account/edit/data", "/backend/account/display/info" })
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

		if (uri.equals(cp + "/account/register")) {
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} else if (uri.equals(cp + "/account/login")) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/account/display/all")) {
			request.setAttribute("UserDetails", AccountDao.retrieveAllUsers());
			request.getRequestDispatcher("/displayUsers.jsp").forward(request, response);
		} else if (uri.equals(cp + "/account/logout")) {
			HttpSession httpSession = request.getSession();
			httpSession.invalidate();
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/account/edit")) {
			request.setAttribute("UserDetails", AccountDao.retrieveAllUsers());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editUser.jsp");
			requestDispatcher.forward(request, response);
		} else if (uri.equals(cp + "/backend/account/edit/data")) {
			int userId = Integer.parseInt(request.getParameter("id"));
			ArrayList<User> arrayList = AccountDao.selectById(userId);
			request.setAttribute("UserDetails", arrayList);
			request.getRequestDispatcher("/editUserStatus.jsp").forward(request, response);
		} else if (uri.equals(cp + "/backend/account/display/info")) {
			System.out.println(ActiveUser.username);
			request.setAttribute("UserProfile", AccountDao.selectById(AccountDao.getUserId(ActiveUser.username)));
			request.getRequestDispatcher("/displayUserProfile.jsp").forward(request, response);
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

		if (uri.equals(cp + "/account/register")) {
			if (AccountDao.verifyUsername(request.getParameter("email")) == false) {
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String address = request.getParameter("address");
				String dob = request.getParameter("dob");
				String phoneNumber = request.getParameter("phoneNumber");
				String gender = request.getParameter("gender");
				String email = request.getParameter("email");
				String password = request.getParameter("password");

				User user = new User(firstName, lastName, address, dob, phoneNumber, gender, email, password, false);
				boolean status = AccountDao.createUser(user);

				if (status) {
					response.sendRedirect(cp + "/account/login");
				} else {
					request.setAttribute("ErrorMessage", "Couldn't add user !!!");
					request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("ErrorMessage", "Email already taken !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		} else if (uri.equals(cp + "/account/login")) {
			String username = request.getParameter("email");
			String password = request.getParameter("password");

			boolean status = AccountDao.validateUserLogin(username, password);
			if (status) {
				HttpSession httpSession = request.getSession();
				ActiveUser.username = username;
				httpSession.setAttribute("user", "admin");
				response.sendRedirect(cp + "/backend/admin/homepage");
			} else {
				request.setAttribute("ErrorMessage", "Login failed !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}

		} else if (uri.equals(cp + "/backend/account/edit/data")) {
			if (AccountDao.verifyUsername(request.getParameter("email")) == false) {
				int userId = Integer.parseInt(request.getParameter("id"));
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");
				String address = request.getParameter("address");
				String dob = request.getParameter("dob");
				String phoneNumber = request.getParameter("phoneNumber");
				String gender = request.getParameter("gender");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				boolean isAdmin = Boolean.parseBoolean(request.getParameter("adminStatus"));

				boolean status = AccountDao.updateUser(new User(userId, firstName, lastName, address, dob, phoneNumber,
						gender, email, password, isAdmin));

				if (status) {
					response.sendRedirect(cp + "/backend/account/display/all");
				} else {
					request.setAttribute("ErrorMessage", "User update failed !!!");
					request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("ErrorMessage", "Email already taken !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		}
	}

}
