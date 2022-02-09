package DAO;
import java.sql.Connection;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;

import org.apache.log4j.Logger;

import com.mvc.controller.DeleteFormController;

import Model.LoginBean;
import Utils.DBConnect;
 public class LoginDAO {
	 final Logger log = Logger.getLogger(LoginDAO.class); 
	 
 public String authenticateUser(LoginBean loginBean)
 {
 
String userName = loginBean.getEmployeeName(); //Keeping user entered values in temporary variables.
 String password = loginBean.getPassword();
 
Connection con = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
String userNameDB = null;
 String passwordDB = "";
 DBConnect DBConnect = new DBConnect();
 System.out.println(" okjbbnok");
try
 {
 con = DBConnect.createConnection(); //establishing connection
 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
 resultSet = statement.executeQuery("select EmployeeName,Password from tbl_login"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
 System.out.println(userName+" jij "+password );
while(resultSet.next()) // Until next row is present otherwise it return false
 {
  userNameDB = resultSet.getString("EmployeeName"); //fetch the values present in database
  passwordDB = resultSet.getString("Password");
  System.out.println(userNameDB+" jij "+passwordDB );
   if(userName.equals(userNameDB) && password.equals(passwordDB))
   {
	   
      return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
   }
 }
statement.close();
resultSet.close();
DBConnect.closeConnection(con);
}

 catch(SQLException e)
 {
 e.printStackTrace();
 DBConnect.closeConnection(con);
 }
 return "Invalid user credentials"; // Just returning appropriate message otherwise
 }
 }
