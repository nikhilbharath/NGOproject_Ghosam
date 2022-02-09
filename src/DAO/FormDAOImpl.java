package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;

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
import Utils.Number_Word;


public class FormDAOImpl {
	final Logger log = Logger.getLogger(DeleteFormController.class); 
	
	public NatchatramMaster n;
	public PaymentModeMaster pay;
	public PoojaSchemeMaster pooja;
	public RaasiMaster r;
	
	public NatchatramMaster getN() {
		return n;
	}

	public void setN(NatchatramMaster n) {
		this.n = n;
	}

	public PaymentModeMaster getPay() {
		return pay;
	}

	public void setPay(PaymentModeMaster pay) {
		this.pay = pay;
	}

	public PoojaSchemeMaster getPooja() {
		return pooja;
	}

	public void setPooja(PoojaSchemeMaster pooja) {
		this.pooja = pooja;
	}

	public RaasiMaster getR() {
		return r;
	}

	public void setR(RaasiMaster r) {
		this.r = r;
	}

	public TrustMaster getT() {
		return t;
	}

	public void setT(TrustMaster t) {
		this.t = t;
	}

	public TrustMaster t;
	
	public void populate_dropdowns(){
		
		NatchatramMaster nn = new NatchatramMaster();
		nn.setStarlist(getLists("select * from TBL_Natchatra","NatchatraID","Natchatra"));
		this.setN(nn);
		
		PaymentModeMaster pp = new PaymentModeMaster();
		pp.setPaylist(getLists("select * from TBL_PaymentMode","PaymentID","PaymentMode"));
		this.setPay(pp);
		
		TrustMaster tt = new TrustMaster();
		tt.setTrustlist(getLists("select * from TBL_Trust","TrustID","TrustName"));
		this.setT(tt);
		
		
		
		PoojaSchemeMaster ppp = new PoojaSchemeMaster();
		ppp.setPoojalist(getLists("select * from TBL_PoojaScheme","PoojaSchemeID","PoojaScheme"));
		this.setPooja(ppp);
	}
	
	public void getRaasi(int id){
		RaasiMaster rr = new RaasiMaster();
		rr.setRaasilist(getLists("select * from TBL_Raasi where Natchatra_ID = "+id+"","RaasiID","Raasi"));
		this.setR(rr);
	}
	
	public HashMap<Integer,String> getPoojalisst(int id){
		PoojaSchemeMaster ppp = new PoojaSchemeMaster();
		ppp.setPoojalist(getLists("select * from TBL_PoojaScheme where trust_id = "+id+"","PoojaSchemeID","PoojaScheme"));
		this.setPooja(ppp);
		return ppp.getPoojalist();
	}
	
	public HashMap<Integer,String> getLists(String sql,String id,String name){
		HashMap<Integer,String> h = new HashMap<Integer,String>();
		DBConnect db = new DBConnect();
		Connection con = db.createConnection();
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			ResultSet rs = st.getResultSet();
			while (rs.next ()){

				  //Add records into data list

				  h.put(rs.getInt(id),rs.getString(name));

				  }

				  rs.close ();

				  st.close ();
				  db.closeConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e);
			db.closeConnection(con);
		}
		return h;
		
	}
	
	public int insertBook(ReceiptForm rm) throws SQLException {
		
		String sql = "INSERT INTO tbl_donordetails (SNO, PoojaBookingDate, DONOR_NAME, DONOR_ADDRESSLINE1, "
				+ "DONOR_ADDRESSLINE2, DONOR_CITY, DONOR_PIN, CONTACT_NO, SCHEME, DONOR_PAN, GOTHRAM, RAASI, NATCHATRAM, "
				+ "PAYMENT_DESC, PAYMENT_DATE, AMOUNT, BILLED_BY, BILLED_DATE, TRUSTID, PAYMENTMODE,RECEIPT_NO) VALUES (?, ?, ? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate)); //2016/11/16
		String id[] = dtf.format(localDate).split("/");
		int size = getsize("select count(SNO) from tbl_donordetails where SNO like '"+id[0]+""+id[1]+"%'");
		int rsize = getsize("select count(SNO) from tbl_donordetails where SNO like '"+id[0]+""+id[1]+"%' AND TRUSTID = "+rm.getTrustID().getTrustID()+"");

		System.out.print(size+" kowwl");
		DBConnect db = new DBConnect();
		Connection con = null;
		int sno = 0;
		int rno = 0;
		try{
		 con = db.createConnection();
		sno = Integer.parseInt(id[0]+""+id[1]);
		rno = Integer.parseInt(id[0]+""+id[1]);
		if(size == 0){
			
			sno = (sno*1000)+1;
		}else{
			
		sno = (sno*1000) + (size + 1);
		}
		
		if(rsize == 0){
			
			rno = (rno*1000)+1;
		}else{
			
		rno = (rno*1000) + (rsize + 1);
		}
		
		String rrsize = String.valueOf(rno);
		if(rm.getTrustID().getTrustID() == 1){
			rrsize = "VG" + rrsize ;
		}else{
			rrsize = "RS" + rrsize ;
		}
		Calendar calendar = Calendar.getInstance();
	    java.sql.Timestamp Time = new java.sql.Timestamp(calendar.getTime().getTime());
	 
	    
	    
		PreparedStatement statement = con.prepareStatement(sql);
		
		
		statement.setInt(1, sno);
		statement.setString(2, rm.getPoojaBookingDate());
		statement.setString(3, rm.getDonar_Name());
		statement.setString(4, rm.getDonar_AddressLine1());
		statement.setString(5, rm.getDonar_AddressLine2());
		statement.setString(6, rm.getDonar_City());
		statement.setInt(7, rm.getDonar_Pin());
		statement.setLong(8, rm.getContact_No());
		statement.setInt(9, rm.getScheme().getPoojaSchemeID());
		statement.setString(10, rm.getDonar_PAN());
		statement.setString(11,  rm.getGothram());
		statement.setInt(12, rm.getRaasi().getRaasiID());
		statement.setInt(13, rm.getNatchatram().getNatchatramID());
		statement.setString(14, rm.getPaymentDescription());
		statement.setString(15, rm.getPaymentDate());
		statement.setInt(16, rm.getAmount());
		statement.setInt(17, 1);
		statement.setTimestamp(18, Time);
		statement.setInt(19, rm.getTrustID().getTrustID());
		statement.setInt(20, rm.getPayMode().getPaymentModeID());
		statement.setString(21, rrsize);
		
		
		
		statement.executeUpdate();
		statement.close();
		db.closeConnection(con);
		}catch(Exception e){
			log.fatal(e);
			db.closeConnection(con);
		}
		
		return sno;
		
	}
	
	
	public int getsize(String sql){
		int i =0;
		DBConnect db = new DBConnect();
		Connection con = db.createConnection();
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			ResultSet rs = st.getResultSet();
			while (rs.next ()){

				  //Add records into data list

				   i = rs.getInt(1);

				  }

				  rs.close ();

				  st.close ();
				  db.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.fatal(e);
			db.closeConnection(con);
		}
		return i;
		
	}
	
	public ReceiptForm getReceipt(String isd){
		
		int id = Integer.parseInt(isd);
		ReceiptForm r1 = new ReceiptForm();
		DBConnect db = new DBConnect();
		String sql = "SELECT `tbl_donordetails`.`SNO`,`tbl_donordetails`.`PoojaBookingDate`,"
				+ "`tbl_donordetails`.`DONOR_NAME`,`tbl_donordetails`.`DONOR_ADDRESSLINE1`,"
				+ "`tbl_donordetails`.`DONOR_ADDRESSLINE2`,`tbl_donordetails`.`DONOR_CITY`,"
				+ "`tbl_donordetails`.`DONOR_PIN`,`tbl_donordetails`.`CONTACT_NO`,"
				+ "`tbl_poojascheme`.`PoojaScheme`,`tbl_poojascheme`.`PoojaSchemeID`,"
				+ "`tbl_donordetails`.`DONOR_PAN`,`tbl_donordetails`.`GOTHRAM`,"
				+ "`tbl_raasi`.`Raasi`,`tbl_raasi`.`RaasiID`,`tbl_natchatra`.`NATCHATRA`,"
				+ "`tbl_natchatra`.`NATCHATRAID`,`tbl_donordetails`.`PAYMENT_DESC`,"
				+ "`tbl_donordetails`.`PAYMENT_DATE`,`tbl_donordetails`.`AMOUNT`,"
				+ "`tbl_paymentmode`.`PaymentID`,`tbl_paymentmode`.`PAYMENTMODE`,"
				+ "`tbl_login`.`EmployeeName`,`tbl_donordetails`.`BILLED_DATE`,"
				+ "`tbl_trust`.`TRUSTNAME`,`tbl_trust`.`TRUSTID`,`tbl_trust`.`TRUST_ADDRESSLINE1`,"
				+ "`tbl_trust`.`TRUST_ADDRESSLINE2`,`tbl_trust`.`TRUST_CITY`,`tbl_trust`.`TRUST_PIN`,`tbl_trust`.`TRUST_CONTACT`,"
				+ "`tbl_trust`.`TRUST_EMAIL`,`tbl_donordetails`.`RECEIPT_NO` FROM `tbl_donordetails` "
				+ "INNER JOIN tbl_login ON tbl_login.UserID= tbl_donordetails.BILLED_BY "
				+ "INNER JOIN tbl_natchatra ON tbl_natchatra.NATCHATRAID = tbl_donordetails.NATCHATRAM "
				+ "INNER JOIN tbl_poojascheme ON tbl_poojascheme.PoojaSchemeID = tbl_donordetails.SCHEME "
				+ "INNER JOIN tbl_raasi ON tbl_raasi.RaasiID = tbl_donordetails.RAASI "
				+ "INNER JOIN tbl_trust ON tbl_trust.TRUSTID = tbl_donordetails.TRUSTID "
				+ "INNER JOIN tbl_paymentmode ON tbl_paymentmode.PaymentID = tbl_donordetails.PAYMENTMODE "
				+ "where tbl_donordetails.SNO like "+id+" and tbl_donordetails.ISDELETED = 'N'";

		Connection con = db.createConnection();
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			ResultSet rs = st.getResultSet();
			while (rs.next ()){

				  //Add records into data list
					r1.setTrustID(new TrustMaster());
					r1.setScheme(new PoojaSchemeMaster());
					r1.setNatchatram(new NatchatramMaster());
					r1.setRaasi(new RaasiMaster());
					r1.setPayMode(new PaymentModeMaster());
					r1.setBilledBy(new LoginBean());
					
					//System.out.println("gyu "+Integer.getInteger(request.getParameter("muttbranch")));
					
					r1.getTrustID().setTrustName(rs.getString("TRUSTNAME"));
					r1.getTrustID().setTrust_AddressLine1(rs.getString("TRUST_ADDRESSLINE1"));
					r1.getTrustID().setTrust_AddressLine2(rs.getString("TRUST_ADDRESSLINE2"));
					r1.getTrustID().setTrust_City(rs.getString("TRUST_CITY"));
					r1.getTrustID().setTrust_Pin(rs.getString("TRUST_PIN"));
					r1.getTrustID().setTrust_Contact(rs.getString("TRUST_CONTACT"));
					r1.getTrustID().setTrust_Email(rs.getString("TRUST_EMAIL"));
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
					r1.getNatchatram().setNatchatramID(rs.getInt("NATCHATRAID"));
					r1.getScheme().setPoojaSchemeID(rs.getInt("PoojaSchemeID"));
					r1.getTrustID().setTrustID(rs.getInt("TRUSTID"));
					r1.getRaasi().setRaasiID(rs.getInt("RaasiID"));
					r1.getPayMode().setPaymentModeID(rs.getInt("PaymentID"));
					r1.getPayMode().setPaymentMode(rs.getString("PAYMENTMODE"));
					r1.setReceiptno(rs.getString("RECEIPT_NO"));
					
					
						
						r1.setPoojaBookingDate(rs.getString("PoojaBookingDate"));
						
						r1.setPaymentDate(rs.getString("PAYMENT_DATE"));
						
						
					
					
					r1.setPaymentDescription(rs.getString("PAYMENT_DESC"));
					
					r1.setAmountwords(Number_Word.convert(r1.getAmount()));

				  }

				  rs.close ();

				  st.close ();
				  db.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.fatal(e);
			db.closeConnection(con);
		}
		
		return r1;
	}

	public HashMap<Integer,String> getCntlist(){
		HashMap<Integer,String> a = new HashMap<Integer,String>();
		DBConnect db = new DBConnect();
		Connection con = db.createConnection();
		try {
			Statement st = con.createStatement();
			st.execute("Select SNO,CONTACT_NO,DONOR_NAME from tbl_donordetails");
			ResultSet rs = st.getResultSet();
			while (rs.next ()){

				  //Add records into data list

				  a.put(rs.getInt("SNO"),rs.getString("DONOR_NAME")+"-"+rs.getString("CONTACT_NO"));

				  }
					
				  rs.close ();

				  st.close ();
				  db.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.fatal(e);
			db.closeConnection(con);
		}
		
		
		return a;
	}
	
public int updateBook(ReceiptForm rm) {
	DBConnect db = new DBConnect();
	Connection con = null;
	String yd = rm.getReceiptno().substring(2, 8);
	System.out.println(yd+" kol");
	int rsize = 0,rno = 0 ;
	String rrsize = null;
	if(rm.getReceiptno().startsWith("RS") && rm.getTrustID().getTrustID() == 1){
		rsize = getsize("select count(SNO) from tbl_donordetails where RECEIPT_NO like '"+yd+"%' AND TRUSTID = "+rm.getTrustID().getTrustID()+"");
		System.out.println(rsize+" hereee");
		rno = Integer.parseInt(yd);
		if(rsize == 0){
			
			rno = (rno*1000)+1;
		}else{
			
		rno = (rno*1000) + (rsize + 1);
		}
		
		 rrsize = "VG" + String.valueOf(rno);
		 System.out.println(rrsize+" here");
			
	}else if(rm.getReceiptno().startsWith("VG") && rm.getTrustID().getTrustID() == 2){
		rsize = getsize("select count(SNO) from tbl_donordetails where RECEIPT_NO like '"+yd+"%' AND TRUSTID = "+rm.getTrustID().getTrustID()+"");
		System.out.println(rsize+" thereee");
		rno = Integer.parseInt(yd);
		if(rsize == 0){
			
			rno = (rno*1000)+1;
		}else{
			
		rno = (rno*1000) + (rsize + 1);
		}
		
		 rrsize = "RS" + String.valueOf(rno);
		 System.out.println(rrsize+" there");
	}else{
		
	}
		try {
		String sql = "UPDATE tbl_donordetails SET PoojaBookingDate = ?, DONOR_NAME = ?, DONOR_ADDRESSLINE1 = ?, "
				+ "DONOR_ADDRESSLINE2 = ?, DONOR_CITY = ?, DONOR_PIN = ?, CONTACT_NO = ?, SCHEME = ?, DONOR_PAN = ?, GOTHRAM = ?, RAASI = ?, NATCHATRAM = ?, "
				+ "PAYMENT_DESC = ?, PAYMENT_DATE = ?, AMOUNT = ?, TRUSTID = ?, PAYMENTMODE = ?,RECEIPT_NO = ? WHERE SNO = ?";
		
		
		
		 con = db.createConnection();
		
	
	 
	    
	    
		PreparedStatement statement;
		
			statement = con.prepareStatement(sql);
		
		
		
		statement.setInt(19, rm.getSno());
		statement.setString(18, rrsize);
		statement.setString(1, rm.getPoojaBookingDate());
		statement.setString(2, rm.getDonar_Name());
		statement.setString(3, rm.getDonar_AddressLine1());
		statement.setString(4, rm.getDonar_AddressLine2());
		statement.setString(5, rm.getDonar_City());
		statement.setInt(6, rm.getDonar_Pin());
		statement.setLong(7, rm.getContact_No());
		statement.setInt(8, rm.getScheme().getPoojaSchemeID());
		statement.setString(9, rm.getDonar_PAN());
		statement.setString(10,  rm.getGothram());
		statement.setInt(11, rm.getRaasi().getRaasiID());
		statement.setInt(12, rm.getNatchatram().getNatchatramID());
		statement.setString(13, rm.getPaymentDescription());
		statement.setString(14, rm.getPaymentDate());
		statement.setInt(15, rm.getAmount());
		statement.setInt(17, rm.getPayMode().getPaymentModeID());
		statement.setInt(16, rm.getTrustID().getTrustID());
		
		
		
		statement.executeUpdate();
		statement.close();
		db.closeConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.fatal(e);
			db.closeConnection(con);
		}
		return rm.getSno();
	}

public void deleteItem(int id) throws IOException {
	DBConnect db = new DBConnect();
	Connection con = null;
	try {
		String sql = "UPDATE tbl_donordetails SET ISDELETED = 'Y' WHERE SNO = ?";
		
		
		 con = db.createConnection();
		
		PreparedStatement statement;
		
			statement = con.prepareStatement(sql);
		
		
		
		statement.setInt(1, id);
		
		
		
		
		statement.executeUpdate();
		statement.close();
		db.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.fatal(e);
			db.closeConnection(con);
		}
	
	
}


public ReceiptForm getReceiptObj(String isd){
	
	String s[] = isd.split("-");
	ReceiptForm r1 = new ReceiptForm();
	DBConnect db = new DBConnect();
	String sql = "SELECT `tbl_donordetails`.`DONOR_NAME`,`tbl_donordetails`.`DONOR_ADDRESSLINE1`,"
			+ "`tbl_donordetails`.`DONOR_ADDRESSLINE2`,`tbl_donordetails`.`DONOR_CITY`,"
			+ "`tbl_donordetails`.`DONOR_PIN`,`tbl_donordetails`.`CONTACT_NO`,"
			+ "`tbl_donordetails`.`DONOR_PAN`,`tbl_donordetails`.`GOTHRAM`,"
			+ "`tbl_raasi`.`Raasi`,`tbl_raasi`.`RaasiID`,`tbl_natchatra`.`NATCHATRA`,"
			+ "`tbl_poojascheme`.`PoojaScheme`,`tbl_poojascheme`.`PoojaSchemeID`,"
			+ "`tbl_natchatra`.`NATCHATRAID`,`tbl_donordetails`.`RECEIPT_NO`"
			+ " FROM `tbl_donordetails` "
			+ "INNER JOIN tbl_natchatra ON tbl_natchatra.NATCHATRAID = tbl_donordetails.NATCHATRAM "
			+ "INNER JOIN tbl_raasi ON tbl_raasi.RaasiID = tbl_donordetails.RAASI "
			+ "INNER JOIN tbl_poojascheme ON tbl_poojascheme.PoojaSchemeID = tbl_donordetails.SCHEME "
			+ "where tbl_donordetails.DONOR_NAME like '"+s[0]+"' and tbl_donordetails.CONTACT_NO like '"+s[1]+"' ";
	System.out.println("ada "+s[0]+" kok "+s[1]);
	Connection con = db.createConnection();
	try {
		Statement st = con.createStatement();
		st.execute(sql);
		ResultSet rs = st.getResultSet();
		while (rs.next ()){

			  //Add records into data list

			  
			   
				r1.setTrustID(new TrustMaster());
				r1.setScheme(new PoojaSchemeMaster());
				r1.setNatchatram(new NatchatramMaster());
				r1.setRaasi(new RaasiMaster());
				r1.setPayMode(new PaymentModeMaster());
				r1.setBilledBy(new LoginBean());
				
				//System.out.println("gyu "+Integer.getInteger(request.getParameter("muttbranch")));
				
				r1.setDonar_Name(rs.getString("DONOR_NAME"));
				r1.setDonar_AddressLine1(rs.getString("DONOR_ADDRESSLINE1"));
				r1.setDonar_AddressLine2(rs.getString("DONOR_ADDRESSLINE2"));
				r1.setDonar_City(rs.getString("DONOR_CITY"));
				r1.setDonar_Pin(rs.getInt("DONOR_PIN"));
				r1.getNatchatram().setNatchatramName(rs.getString("NATCHATRA"));
				r1.setGothram(rs.getString("GOTHRAM"));
				r1.getRaasi().setRaasiName(rs.getString("Raasi"));
				r1.setDonar_PAN(rs.getString("DONOR_PAN"));
				r1.getNatchatram().setNatchatramID(rs.getInt("NATCHATRAID"));
				r1.getRaasi().setRaasiID(rs.getInt("RaasiID"));
				r1.setContact_No(rs.getLong("CONTACT_NO"));
				r1.setReceiptno(rs.getString("RECEIPT_NO"));
				r1.getScheme().setPoojaSchemeID(rs.getInt("PoojaSchemeID"));
				r1.getScheme().setPoojaScheme(rs.getString("PoojaScheme"));
				
				
			  }

			  rs.close ();

			  st.close ();
			  db.closeConnection(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		log.fatal(e);
		db.closeConnection(con);
	}
	
	return r1;
}
}


