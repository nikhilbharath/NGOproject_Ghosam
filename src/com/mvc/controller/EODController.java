package com.mvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.DonationListDAO;
import Model.ReceiptForm;

/**
 * Servlet implementation class EODController
 */

public class EODController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EODController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.isEmpty())
            return false;
        return true;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print(request.getParameter("date")+" jikoj");
		int vcash = 0;
		int rcash = 0;
		int vcheque = 0;
		int rcheque = 0;
		int vneft = 0;
		int rneft = 0;
		int vimps = 0;
		int rimps = 0;
		int vupi = 0;
		int rupi = 0;
		String date = request.getParameter("date");
		System.out.println(date+" koljjj");
		DonationListDAO d = new DonationListDAO();
		ArrayList<ReceiptForm> a = new ArrayList<ReceiptForm>();
		if(isNullOrEmpty(date)){
			date = "No";
		a = d.getEODReport(date);
		}else{
			a = d.getEODReport(date);
		}

			Date date1 = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date= formatter.format(date1);


		for(ReceiptForm r : a){
			
			date = r.getPaymentDate();
			
			if(r.getTrustID().getTrustID() == 1){
				
				if(r.getPayMode().getPaymentModeID() == 1){
					vcash = vcash + r.getAmount();
				}else if(r.getPayMode().getPaymentModeID() == 2){
					vcheque = vcheque + r.getAmount();
				}else if(r.getPayMode().getPaymentModeID() == 3){
					vneft = vneft + r.getAmount();
				}else if(r.getPayMode().getPaymentModeID() == 4){
					vimps = vimps + r.getAmount();
				}else if(r.getPayMode().getPaymentModeID() == 5){
					vupi = vupi + r.getAmount();
				}
				
			}else if(r.getTrustID().getTrustID() == 2){
				if(r.getPayMode().getPaymentModeID() == 1){
					rcash = rcash + r.getAmount();
				}else if(r.getPayMode().getPaymentModeID() == 2){
					rcheque = rcheque + r.getAmount();
				}else if(r.getPayMode().getPaymentModeID() == 3){
					rneft = rneft + r.getAmount();
				}else if(r.getPayMode().getPaymentModeID() == 4){
					rimps = rimps + r.getAmount();
				}else if(r.getPayMode().getPaymentModeID() == 5){
					rupi = rupi + r.getAmount();
				}
				
			}
			System.out.println(date);
		}
		
		request.setAttribute("vcash", vcash);
		request.setAttribute("vcheque", vcheque);
		request.setAttribute("vneft", vneft);
		request.setAttribute("vimps", vimps);
		request.setAttribute("rcash", rcash);
		request.setAttribute("vupi", vupi);
		request.setAttribute("rcheque", rcheque);
		request.setAttribute("rneft", rneft);
		request.setAttribute("rimps", rimps);
		request.setAttribute("rupi", rupi);
		request.setAttribute("date", date);
		
			try {
				request.getRequestDispatcher("EODreport.jsp").forward(request, response);
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
