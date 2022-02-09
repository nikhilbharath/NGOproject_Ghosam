<%@page import="java.sql.*"%>
<%@ page import="Utils.DBConnect" %>
<%
String country=request.getParameter("count");  
 String buffer="<select name='scheme' style='width:60%'><option value='-1'>Select</option>";  
 try{
 DBConnect db = new DBConnect(); 
 Connection con = db.createConnection();
 Statement stmt = con.createStatement();  
 System.out.println(country+" ij");
 ResultSet rs = stmt.executeQuery("SELECT `tbl_poojascheme`.`PoojaSchemeID`,`tbl_poojascheme`.`PoojaScheme` FROM `db`.`tbl_poojascheme` where `tbl_poojascheme`.`trust_id` like '%"+country+"%' ");  
   while(rs.next()){
   buffer=buffer+"<option value='"+rs.getInt(1)+"'>"+rs.getString(2)+"</option>";  
   }  
 buffer=buffer+"</select>";  
 response.getWriter().println(buffer); 
 }
 catch(Exception e){
     System.out.println(e);
 }

 %>