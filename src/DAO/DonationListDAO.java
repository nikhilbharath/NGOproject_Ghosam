package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.mvc.controller.DeleteFormController;

import Model.LoginBean;
import Model.NatchatramMaster;
import Model.PaymentModeMaster;
import Model.PoojaSchemeMaster;
import Model.RaasiMaster;
import Model.ReceiptForm;
import Model.TrustMaster;
import Utils.DBConnect;

public class DonationListDAO {
	final Logger log = Logger.getLogger(DonationListDAO.class); 
	public ArrayList<ReceiptForm> getList() throws IOException{
		ArrayList<ReceiptForm> a = new ArrayList<ReceiptForm>();
		
		
		DBConnect db = new DBConnect();
		String sql = "SELECT `tbl_donordetails`.`SNO`,`tbl_donordetails`."
				+ "`PoojaBookingDate`,`tbl_donordetails`.`DONOR_NAME`,`tbl_donordetails`."
				+ "`DONOR_ADDRESSLINE1`,`tbl_donordetails`.`DONOR_ADDRESSLINE2`,`tbl_donordetails`."
				+ "`DONOR_CITY`,`tbl_donordetails`.`DONOR_PIN`,`tbl_donordetails`.`CONTACT_NO`,"
				+ "`tbl_poojascheme`.`PoojaScheme`,`tbl_donordetails`.`DONOR_PAN`,`tbl_donordetails`."
				+ "`GOTHRAM`,`tbl_raasi`.`Raasi`,`tbl_natchatra`.`NATCHATRA`,`tbl_donordetails`."
				+ "`PAYMENT_DESC`,`tbl_donordetails`.`PAYMENT_DATE`,`tbl_donordetails`.`AMOUNT`,"
				+ "`tbl_login`.`EmployeeName`,`tbl_donordetails`.`BILLED_DATE`,`tbl_trust`.`TRUSTNAME`,`tbl_trust`.`TRUSTID`,`tbl_donordetails`.`RECEIPT_NO`"
				+ "FROM `db`.`tbl_donordetails` INNER JOIN "
				+ "tbl_login ON tbl_login.UserID= tbl_donordetails.BILLED_BY INNER JOIN "
				+ "tbl_natchatra ON tbl_natchatra.NATCHATRAID = tbl_donordetails.NATCHATRAM "
				+ "INNER JOIN tbl_poojascheme ON tbl_poojascheme.PoojaSchemeID = tbl_donordetails.SCHEME "
				+ "INNER JOIN tbl_raasi ON tbl_raasi.RaasiID = tbl_donordetails.RAASI "
				+ "INNER JOIN tbl_trust ON tbl_trust.TRUSTID = tbl_donordetails.TRUSTID WHERE `tbl_donordetails`.`ISDELETED` = 'N'";
		Connection con = null;
		try {
			con = db.createConnection();
			Statement st = con.createStatement();
			st.execute(sql);
			ResultSet rs = st.getResultSet();
			while (rs.next ()){

				  //Add records into data list

				ReceiptForm r1 = new ReceiptForm();
				   
					r1.setTrustID(new TrustMaster());
					r1.setScheme(new PoojaSchemeMaster());
					r1.setNatchatram(new NatchatramMaster());
					r1.setRaasi(new RaasiMaster());
					r1.setPayMode(new PaymentModeMaster());
					r1.setBilledBy(new LoginBean());
					
					//System.out.println("gyu "+Integer.getInteger(request.getParameter("muttbranch")));
					r1.getTrustID().setTrustID(rs.getInt("TRUSTID"));
					r1.getTrustID().setTrustName(rs.getString("TRUSTNAME"));
					r1.setDonar_Name(rs.getString("DONOR_NAME"));
					r1.setContact_No(rs.getLong("CONTACT_NO"));
					r1.setDonar_AddressLine1(rs.getString("DONOR_ADDRESSLINE1"));
					r1.setDonar_AddressLine2(rs.getString("DONOR_ADDRESSLINE2"));
					r1.setDonar_City(rs.getString("DONOR_CITY"));
					r1.setDonar_Pin(rs.getInt("DONOR_PIN"));
					r1.setAmount(rs.getInt("AMOUNT"));
					r1.getScheme().setPoojaScheme(rs.getString("PoojaScheme"));
					r1.getNatchatram().setNatchatramName(rs.getString("NATCHATRA"));
					r1.setGothram(rs.getString("GOTHRAM"));
					r1.getRaasi().setRaasiName(rs.getString("Raasi"));
					r1.setDonar_PAN(rs.getString("DONOR_PAN"));
					r1.setRid(rs.getLong("SNO"));
					r1.setReceiptno(rs.getString("RECEIPT_NO"));
					
					
					
					
					r1.setPaymentDescription(rs.getString("PAYMENT_DESC"));
					a.add(r1);
					
					  

				  }

			rs.close ();

			  st.close ();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e);
			db.closeConnection(con);
		}
		
		db.closeConnection(con);		
		return a;
	}
	
	public ArrayList<ReceiptForm> getEODReport(String da) throws IOException{
		
		ArrayList<ReceiptForm> aa = new ArrayList<ReceiptForm>();
		String date = null;
		if(da.equals("No")){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		//2016/11/16
		String id[] = dtf.format(localDate).split("/");
		date = id[2]+"/"+id[1]+"/"+id[0];
		System.out.println(date+" formie");
		}else{
			date = da;
		}
		DBConnect db = new DBConnect();
	String sql = "SELECT `tbl_donordetails`.`PAYMENTMODE`,`tbl_donordetails`.`AMOUNT`,`tbl_donordetails`.`PAYMENT_DATE`,`tbl_donordetails`.`TRUSTID`,`tbl_donordetails`.`RECEIPT_NO` FROM `tbl_donordetails` WHERE `tbl_donordetails`.`ISDELETED` = 'N' and `tbl_donordetails`.`PAYMENT_DATE` like '"+date+"' ";
		
		Connection con = db.createConnection();
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			ResultSet rs = st.getResultSet();
			
			while (rs.next ()){
			
				ReceiptForm wqq = new ReceiptForm();
				wqq.setTrustID(new TrustMaster());
				wqq.setPayMode(new PaymentModeMaster());
				wqq.getTrustID().setTrustID(rs.getInt("TRUSTID"));
				
				wqq.setAmount(rs.getInt("AMOUNT"));
				
				wqq.setPaymentDate(rs.getString("PAYMENT_DATE"));
				wqq.getPayMode().setPaymentModeID(rs.getInt("PAYMENTMODE"));
				wqq.setReceiptno(rs.getString("RECEIPT_NO"));
				
				aa.add(wqq);
				
			}
			rs.close();
			st.close();
			db.closeConnection(con);
			
	}catch(Exception e){
		log.fatal(e);
		db.closeConnection(con);
	}
		
		return aa;
	}

}
