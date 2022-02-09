package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.mvc.controller.DeleteFormController;

import Model.EventMaster;
import Model.LoginBean;
import Model.NatchatramMaster;
import Model.PaymentModeMaster;
import Model.PoojaSchemeMaster;
import Model.RaasiMaster;
import Model.ReceiptForm;
import Model.TrustMaster;
import Utils.DBConnect;

public class EventDAOImpl {
	final Logger log = Logger.getLogger(DeleteFormController.class); 
	
	public ArrayList<EventMaster> getEvents() throws IOException{
		ArrayList<EventMaster> a = new ArrayList<EventMaster>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		//2016/11/16
		String id[] = dtf.format(localDate).split("/");
		DBConnect db = new DBConnect();
		String sql = "SELECT `tbl_selfevents`.`SNO`,`tbl_selfevents`.`EVENT_DATE`,`tbl_selfevents`.`EVENT_DESCRIPTION` "
				+ "FROM `tbl_selfevents` where `tbl_selfevents`.`ISDELETED` = 'N'";
			
		Connection con = db.createConnection();
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			ResultSet rs = st.getResultSet();
			int count = 1;
			while (rs.next ()){
				if(count > 3){
					break;
				}
				  //Add records into data list
				
				String idate[] = rs.getString("EVENT_DATE").split("/");
				
				if(Integer.parseInt(id[0]) <= Integer.parseInt(idate[2])){
					if(Integer.parseInt(id[1]) <= Integer.parseInt(idate[1])){
						if(Integer.parseInt(id[2]) <= Integer.parseInt(idate[0])){
							
							
							EventMaster r1 = new EventMaster();
							r1.setSno(rs.getInt("SNO"));
							r1.setEventdesc(rs.getString("EVENT_DESCRIPTION"));
				
							r1.setEventdate(rs.getString("EVENT_DATE"));
							
							a.add(r1);
							count++;
						}else{
							continue;
						}
					}else{
						continue;
					}
				}else{
					continue;
				}	
				  }

				  rs.close ();

				  st.close ();
				  
				 
				  db.closeConnection(con);  
				 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			db.closeConnection(con);
		}
		
		
		return a;
		 
	}
	
	public ArrayList<ReceiptForm> getList() throws IOException{
		ArrayList<ReceiptForm> a = new ArrayList<ReceiptForm>();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		//2016/11/16
		String id[] = dtf.format(localDate).split("/");
		
		DBConnect db = new DBConnect();
		String sql = "SELECT `tbl_donordetails`.`PoojaBookingDate`,`tbl_donordetails`.`DONOR_NAME`,"
				+ "`tbl_poojascheme`.`PoojaScheme`,`tbl_trust`.`TRUSTNAME`,`tbl_donordetails`.`RECEIPT_NO` FROM `tbl_donordetails` "
				+ "INNER JOIN tbl_poojascheme ON tbl_poojascheme.PoojaSchemeID = tbl_donordetails.SCHEME "
				+ "INNER JOIN tbl_trust ON tbl_trust.TRUSTID = tbl_donordetails.TRUSTID where `tbl_donordetails`.`ISDELETED` = 'N'";
			
		Connection con = db.createConnection();
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			ResultSet rs = st.getResultSet();
			int count = 1;
			while (rs.next ()){
				if(count > 3){
					break;
				}
				  //Add records into data list
				String idate[] = rs.getString("PoojaBookingDate").split("/");
				
				if(Integer.parseInt(id[0]) <= Integer.parseInt(idate[2])){
					if(Integer.parseInt(id[1]) <= Integer.parseInt(idate[1])){
						if(Integer.parseInt(id[2]) <= Integer.parseInt(idate[0])){
							
							ReceiptForm r1 = new ReceiptForm();
							r1.setTrustID(new TrustMaster());
							r1.setScheme(new PoojaSchemeMaster());
							
							//System.out.println("gyu "+Integer.getInteger(request.getParameter("muttbranch")));
							
							r1.getTrustID().setTrustName(rs.getString("TRUSTNAME"));
							r1.setDonar_Name(rs.getString("DONOR_NAME"));
							r1.getScheme().setPoojaScheme(rs.getString("PoojaScheme"));
							r1.setPaymentDate(rs.getString("PoojaBookingDate"));
							r1.setReceiptno(rs.getString("RECEIPT_NO"));
							
							a.add(r1);
							count++;
						}else{
							continue;
						}
					}else{
						continue;
					}
				}else{
					continue;
				}
				
				
				
				
				  }

				  rs.close ();

				  st.close ();
				  db.closeConnection(con);
				 
					  
				 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			db.closeConnection(con);
		}
		
		
		return a;
		 
	}
	
	/*public ArrayList<String> read_file(){
		ArrayList<String> list = new ArrayList<String>();
		
		try{
			
			// attach the file to FileInputStream 
		URL url = EventDAOImpl.class.getResource("filename.txt");
		File file = new File(url.getPath()); 
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  String st; 
		  while ((st = br.readLine()) != null){ 
		    list.add(st); 
		  }
		  br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	 
			return list;
			
	}
*/
	
	
	public ArrayList<ReceiptForm> getExportList(String from, String to) throws IOException {
		
ArrayList<ReceiptForm> a = new ArrayList<ReceiptForm>();
		
		
		DBConnect db = new DBConnect();
		String sql = "SELECT `tbl_donordetails`.`SNO`,`tbl_donordetails`."
				+ "`PoojaBookingDate`,`tbl_donordetails`.`DONOR_NAME`,`tbl_donordetails`."
				+ "`DONOR_ADDRESSLINE1`,`tbl_donordetails`.`DONOR_ADDRESSLINE2`,`tbl_donordetails`."
				+ "`DONOR_CITY`,`tbl_donordetails`.`DONOR_PIN`,`tbl_donordetails`.`CONTACT_NO`,"
				+ "`tbl_poojascheme`.`PoojaScheme`,`tbl_donordetails`.`DONOR_PAN`,`tbl_donordetails`."
				+ "`GOTHRAM`,`tbl_raasi`.`Raasi`,`tbl_natchatra`.`NATCHATRA`,`tbl_donordetails`."
				+ "`PAYMENT_DESC`,`tbl_donordetails`.`PAYMENT_DATE`,`tbl_donordetails`.`AMOUNT`,"
				+ "`tbl_login`.`EmployeeName`,`tbl_donordetails`.`BILLED_DATE`,`tbl_trust`.`TRUSTNAME`,`tbl_trust`.`TRUSTID`,"
				+ "`tbl_donordetails`.`BILLED_DATE`,`tbl_donordetails`.`RECEIPT_NO` FROM `tbl_donordetails` INNER JOIN "
				+ "tbl_login ON tbl_login.UserID= tbl_donordetails.BILLED_BY INNER JOIN "
				+ "tbl_natchatra ON tbl_natchatra.NATCHATRAID = tbl_donordetails.NATCHATRAM "
				+ "INNER JOIN tbl_poojascheme ON tbl_poojascheme.PoojaSchemeID = tbl_donordetails.SCHEME "
				+ "INNER JOIN tbl_raasi ON tbl_raasi.RaasiID = tbl_donordetails.RAASI "
				+ "INNER JOIN tbl_trust ON tbl_trust.TRUSTID = tbl_donordetails.TRUSTID where `tbl_donordetails`.`ISDELETED` = 'N'";
		Connection con = db.createConnection();
		try {
			Statement st = con.createStatement();
			st.execute(sql);
			ResultSet rs = st.getResultSet();
			while (rs.next ()){

				  //Add records into data list
				/*Timestamp timestamp = rs.getTimestamp("PAYMENT_DATE");  
		        //returns a LocalDateTime object which represents the same date-time value as this Timestamp  
		        String str=timestamp.toString(); 
		        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = formatter.parse(str);
				formatter.applyPattern("dd/MM/yyyy");
				String dateStr = formatter.format(date);*/
				String dateStr = rs.getString("PAYMENT_DATE");
				Date start = new SimpleDateFormat("dd/MM/yyyy")
	                    .parse(from);
	            Date end = new SimpleDateFormat("dd/MM/yyyy")
	                    .parse(to);
	            Date datee = new SimpleDateFormat("dd/MM/yyyy")
	                    .parse(dateStr);

	            if (datee.compareTo(end) > 0) {
	                continue;
	            } else if (datee.compareTo(start) < 0) {
	                continue;
	            } else {
	        		ReceiptForm r1 = new ReceiptForm();
					   
					r1.setTrustID(new TrustMaster());
					r1.setScheme(new PoojaSchemeMaster());
					r1.setNatchatram(new NatchatramMaster());
					r1.setRaasi(new RaasiMaster());
					r1.setPayMode(new PaymentModeMaster());
					r1.setBilledBy(new LoginBean());
					
					//System.out.println("gyu "+Integer.getInteger(request.getParameter("muttbranch")));
					String rno;
					if(r1.getTrustID().getTrustID() == 1){
						rno = "VG" + rs.getLong("SNO") ;
					}else{
						rno = "RS" + rs.getLong("SNO") ;
					}
					System.out.println(rno);
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
					r1.setReceiptno(rno);
					r1.setPaymentDescription(rs.getString("PAYMENT_DESC"));
					r1.setReceiptno(rs.getString("RECEIPT_NO"));
					a.add(r1);

				 
	            } 
			 }

			  rs.close ();

			  st.close ();
			  db.closeConnection(con);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		db.closeConnection(con);
	}
	
	
	return a;
}

	public void insertEvent(String event_date, String event_name) {
		DBConnect db = new DBConnect();
		Connection con = null;
		try{
		String sql = "INSERT INTO `tbl_selfevents`(`EVENT_DATE`,`EVENT_DESCRIPTION`)"
				+ "VALUES(?,?)";
		
		
		con = db.createConnection();
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, event_date);
		statement.setString(2, event_name);
		statement.executeUpdate();
		statement.close();
		db.closeConnection(con);
		}
		catch(Exception e){
			db.closeConnection(con);
		}
	}
	
	public void deleteEvent(int id) throws IOException {
		DBConnect db = new DBConnect();
		Connection con = null;
		try {
			String sql = "UPDATE `tbl_selfevents` SET ISDELETED = 'Y' WHERE SNO = ?";
			
			
			 con = db.createConnection();
			
			PreparedStatement statement;
			
				statement = con.prepareStatement(sql);
			
			
			
			statement.setInt(1, id);
			
			
			
			
			statement.executeUpdate();
			statement.close();
			db.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				db.closeConnection(con);
			}
		
		
	}
		
	}
	
		  
	


