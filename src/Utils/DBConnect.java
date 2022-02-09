package Utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

 
public class DBConnect {
 public Connection createConnection()
 {
	 Connection con = null;
	 try{

 Properties prop = readPropertiesFile("credentials.properties");
 String hostname  = prop.getProperty("hostname");
 String port = prop.getProperty("port");
 String dbname = prop.getProperty("dbname");
 String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname; //MySQL URL and followed by the database name
 
 String username =  prop.getProperty("username"); //MySQL username
 //String password = "Rayar1970"; //MySQL password

 String password = prop.getProperty("password"); //MySQL password


	 Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection(url, username, password);
	System.out.println("Printing connection object "+con);
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} //attempting to connect to MySQL database
 
	 return con; 
 
 
 }
 
 public void closeConnection(Connection con){
	 try{
		 con.close();
	 }catch(Exception e){
		 
	 }
 }
 
 private Properties readPropertiesFile(String fileName) throws IOException {
	
     
     InputStream inputStream = null;
     Properties prop = null;
     try {
      /*  fis = new FileInputStream(fileName);
        prop = new Properties();
        prop.load(fis);*/
    	 
    	prop = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
			}
     } catch(FileNotFoundException fnfe) {
        fnfe.printStackTrace();
     } catch(IOException ioe) {
        ioe.printStackTrace();
     } finally {
    	 inputStream.close();
     }
     return prop;
  }

}
