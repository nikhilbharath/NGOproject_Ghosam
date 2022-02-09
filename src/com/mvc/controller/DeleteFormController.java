package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import DAO.FormDAOImpl;

/**
 * Servlet implementation class DeleteFormController
 */
@WebServlet("/DeleteFormController")
public class DeleteFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(DeleteFormController.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			
		int id = Integer.parseInt(request.getParameter("id"));
		FormDAOImpl f = new FormDAOImpl();
		f.deleteItem(id);
		//Book book = new Book(id);
		//bookDAO.deleteBook(book);
		response.sendRedirect("DonationList.jsp");
		}
			catch(Exception e)
			{	
			log.fatal(e);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
