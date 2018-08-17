package com.elvin.controller;

import java.io.File;
import java.io.IOException;

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
@WebServlet({ "/backend/book/add", "/backend/book/display/all", "/backend/book/edit/all" })
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
			String bookName = null;
			float bookPrice = 0;
			String bookAuthor = null;
			String bookPublisher = null;
			String bookPublishedDate = null;
			String bookImageURL = null;
			int bookQuantity = 0;
			
			// gets absolute path of the web application
			String appPath = request.getServletContext().getRealPath("");
			System.out.println(appPath);

			// constructs path of the directory to save uploaded file
			String savePath = appPath + SAVE_DIR;
			//String savePath = appPath + File.separator + SAVE_DIR;
			System.out.println(savePath);

			// creates the save directory if it does not exists
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}

			for (Part part : request.getParts()) {
				if (part.getName().equals("bookName")){
	                bookName = request.getParameter("bookName");
	            }
	            else if (part.getName().equals("bookPrice")){
	                bookPrice = Float.parseFloat(request.getParameter("bookPrice"));
	            }
	            else if(part.getName().equals("bookAuthor"))
	            {
	            	bookAuthor = request.getParameter("bookAuthor");
	            }
	            else if(part.getName().equals("bookPublisher"))
	            {
	            	bookPublisher = request.getParameter("bookPublisher");
	            }
	            else if(part.getName().equals("bookPublishedDate"))
	            {
	            	bookPublishedDate = request.getParameter("bookPublishedDate");
	            }
	            else if(part.getName().equals("bookQuantity"))
	            {
	            	bookQuantity = Integer.parseInt(request.getParameter("bookQuantity"));
	            }
	            else if (part.getName().equals("bookImageURL")) {
	                String fileName = extractFileName(part);
	                //refines the fileName in case it is an absolute path
	                fileName = new File(fileName).getName();

	                part.write(savePath + File.separator + fileName);
	                bookImageURL = savePath + File.separator + fileName;
	            }
			}
			boolean status = BookDao.add(new Book(bookName,bookPrice,bookAuthor,bookPublisher,bookPublishedDate,bookImageURL,bookQuantity));
			
			if(status)
			{
				response.sendRedirect("/backend/book/display/all");
			}
			else
			{
				request.setAttribute("ErrorMessage", "Book addition process failed !!!");
				request.getRequestDispatcher("/errorPage.jsp").forward(request, response);
			}
		}
	}

	private static final String SAVE_DIR = "bookImages";

	private String extractFileName(Part part) {
		String contentDisplay = part.getHeader("content-disposition");
		String[] items = contentDisplay.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
