package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EventDAOImpl;
import Model.ReceiptForm;

/**
 * Servlet implementation class ExportList
 */
@WebServlet("/ExportList")
public class ExportList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExportList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("from")+" avlothan");
		System.out.println(request.getParameter("to"));
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		EventDAOImpl e = new EventDAOImpl();
		ArrayList<ReceiptForm> export = new ArrayList<ReceiptForm>();
		export = e.getExportList(from,to);
		
		request.setAttribute("data", export); 
		  
	       // Creating a RequestDispatcher object to dispatch 
	       // the request the request to another resource 
	         RequestDispatcher rd =  
	             request.getRequestDispatcher("Export.jsp"); 
	  
	       // The request will be forwarded to the resource  
	       // specified, here the resource is a JSP named, 
	       // "stdlist.jsp" 
	          rd.forward(request, response); 
	             
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
