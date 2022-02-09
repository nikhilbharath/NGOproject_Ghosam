package com.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.FormDAOImpl;
import Model.LoginBean;
import Model.NatchatramMaster;
import Model.PaymentModeMaster;
import Model.PoojaSchemeMaster;
import Model.RaasiMaster;
import Model.ReceiptForm;
import Model.TrustMaster;
import Utils.Number_Word;


/**
 * Servlet implementation class FormController
 */

public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormController() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		try {
			switch (action) {
			
			case "/Views/FormController":
				
				insertRow(request, response);
				
				break;
			case "/Views/DeleteFormController":
				deleteBook(request, response);
				break;
			
			default:
				//listBook(request, response);
				request.getRequestDispatcher("DonationList.jsp");
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		request.getRequestDispatcher("DonationList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

	protected void insertRow(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		ReceiptForm r = new ReceiptForm();
		r.setTrustID(new TrustMaster());
		r.setScheme(new PoojaSchemeMaster());
		r.setNatchatram(new NatchatramMaster());
		r.setRaasi(new RaasiMaster());
		r.setPayMode(new PaymentModeMaster());
		r.setBilledBy(new LoginBean());
		try {
		//System.out.println("gyu "+Integer.getInteger(request.getParameter("muttbranch")));
		r.getTrustID().setTrustID(Integer.parseInt(request.getParameter("muttbranch")));
		r.setDonar_Name(request.getParameter("firstname"));
		r.setContact_No(Long.parseLong(request.getParameter("contact")));
		r.setDonar_AddressLine1(request.getParameter("address1"));
		r.setDonar_AddressLine2(request.getParameter("address2"));
		r.setDonar_City(request.getParameter("city"));
		r.setDonar_Pin(Integer.parseInt(request.getParameter("pinc")));
		r.setAmount(Integer.parseInt(request.getParameter("amt")));
		r.getScheme().setPoojaSchemeID(Integer.parseInt(request.getParameter("scheme")));
		
		
		
		
		r.getPayMode().setPaymentModeID(Integer.parseInt(request.getParameter("payment")));
		
		if(!request.getParameter("star").equals("")){
			r.getNatchatram().setNatchatramID(Integer.parseInt(request.getParameter("star")));
		}else{
			r.getNatchatram().setNatchatramID(-1);
		}
		if(!request.getParameter("gothram").equals("")){
			r.setGothram(request.getParameter("gothram"));
		}else{
			r.setGothram("N/A");
		}
		if(!request.getParameter("raasi").equals("")){
			r.getRaasi().setRaasiID(Integer.parseInt(request.getParameter("raasi")));
		}else{
			r.getRaasi().setRaasiID(-1);
		}
		if(!request.getParameter("pan").equals("")){
			r.setDonar_PAN(request.getParameter("pan"));
		}else{
			r.setDonar_PAN("");
		}	
		
			
			r.setPoojaBookingDate((request.getParameter("date")));
			
			r.setPaymentDate((request.getParameter("paydate")));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		r.setPaymentDescription(request.getParameter("paydesc"));
		
		FormDAOImpl f = new FormDAOImpl();
		ReceiptForm rr = new ReceiptForm();
		
		String id = String.valueOf(f.insertBook(r));
		rr = f.getReceipt(id);
		rr.setAmountwords(Number_Word.convert(rr.getAmount()));
		if(rr.getTrustID().getTrustID() == 1){
			id = "VG" + id ;
		}else{
			id = "RS" + id ;
		}
		request.setAttribute("name", id);
		request.setAttribute("Obj", rr);
		
		try {
			request.getRequestDispatcher("PrintReceipt.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void deleteBook(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		FormDAOImpl f = new FormDAOImpl();
		f.deleteItem(id);
		response.sendRedirect("/DonationList.jsp");

	}


}
