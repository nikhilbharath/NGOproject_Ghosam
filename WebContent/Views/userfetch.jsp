<%@page import="java.sql.*"%>
<%@ page import="Utils.DBConnect" %>
<%
String country=request.getParameter("count");  
 String buffer="<select name='raasi' style='width:60%'><option value='-1'>Select</option>";  
 try{
	 DBConnect db = new DBConnect(); 
	 Connection con = db.createConnection();  
 Statement stmt = con.createStatement();  
 ResultSet rs = stmt.executeQuery("select * from db.tbl_raasi where Natchatra_ID like '%,"+country+",%' ");  
   while(rs.next()){
   buffer=buffer+"<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>";  
   }  
 buffer=buffer+"</select>";  
 response.getWriter().println(buffer); 
 }
 catch(Exception e){
     System.out.println(e);
 }

 %>