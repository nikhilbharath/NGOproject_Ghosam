package com.mvc.controller;

import java.io.IOException;
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

/**
 * Servlet implementation class EditFormController
 */

public class EditFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFormController() {
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ReceiptForm r = new ReceiptForm();
		r.setTrustID(new TrustMaster());
		r.setScheme(new PoojaSchemeMaster());
		r.setNatchatram(new NatchatramMaster());
		r.setRaasi(new RaasiMaster());
		r.setPayMode(new PaymentModeMaster());
		r.setBilledBy(new LoginBean());
		
		//System.out.println("gyu "+Integer.getInteger(request.getParameter("muttbranch")));
		System.out.println(request.getParameter("id")+" gyaaaddda "+request.getParameter("muttbranch"));
		r.setSno(Integer.parseInt(request.getParameter("id")));
		r.getTrustID().setTrustID(Integer.parseInt(request.getParameter("muttbranch")));
		r.setDonar_Name(request.getParameter("firstname"));
		r.setContact_No(Long.parseLong(request.getParameter("contact")));
		r.setDonar_AddressLine1(request.getParameter("address1"));
		r.setDonar_AddressLine2(request.getParameter("address2"));
		r.setDonar_City(request.getParameter("city"));
		r.setDonar_Pin(Integer.parseInt(request.getParameter("pinc")));
		r.setAmount(Integer.parseInt(request.getParameter("amt")));
		r.getScheme().setPoojaSchemeID(Integer.parseInt(request.getParameter("scheme")));
		r.getNatchatram().setNatchatramID(Integer.parseInt(request.getParameter("star")));
		r.setGothram(request.getParameter("gothram"));
		r.getRaasi().setRaasiID(Integer.parseInt(request.getParameter("raasi")));
		r.setDonar_PAN(request.getParameter("pan"));
		r.getPayMode().setPaymentModeID(Integer.parseInt(request.getParameter("payment")));
		r.setReceiptno(request.getParameter("rno"));
		System.out.println("gsgihsigsiyaaaddda "+request.getParameter("amt"));
		try {
			
			r.setPoojaBookingDate((request.getParameter("date")));
			
			r.setPaymentDate((request.getParameter("paydate")));
			System.out.println(r.getPaymentDate()+"  llookokoklll");
			System.out.println(r.getPoojaBookingDate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		r.setPaymentDescription(request.getParameter("paydesc"));
		
		FormDAOImpl f = new FormDAOImpl();
		
		
		String id = null;
		
			//f.updateBook(r);
			id = String.valueOf(f.updateBook(r));
			ReceiptForm rr = new ReceiptForm();
		rr = f.getReceipt(id);
		System.out.println(rr.getRaasi().getRaasiName()+"  lojhaaajakka");
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
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
