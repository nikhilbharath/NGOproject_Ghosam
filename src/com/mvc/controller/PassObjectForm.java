package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.FormDAOImpl;
import Model.ReceiptForm;

/**
 * Servlet implementation class PassObjectForm
 */
@WebServlet("/PassObjectForm")
public class PassObjectForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassObjectForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReceiptForm r = new ReceiptForm();
		FormDAOImpl FormDAOImpl = new FormDAOImpl();
		System.out.println("helss"+request.getParameter("contact"));
		if(!request.getParameter("contact").contains("-")){
		request.setAttribute("resp", "No");
		System.out.println("hessssslss"+r.getDonar_Name());
		}else{
		r = FormDAOImpl.getReceiptObj(request.getParameter("contact").replace("_", " "));
		if(r.getContact_No() == 0 ){
			request.setAttribute("resp", "No");	
			System.out.println("hesaas"+r.getDonar_Name());
		}else{
		System.out.println("helss"+r.getDonar_Name());
		HttpSession session = request.getSession(true);
		session.setAttribute("reqObj", r);
		request.setAttribute("ra", r);
		}
		}
		request.getRequestDispatcher("BookingForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
