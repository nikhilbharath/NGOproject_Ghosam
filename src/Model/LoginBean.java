package Model;

public class LoginBean 
{

private int userID;
private String employeeName;
private String password;
private String userType;


public int getUserID() {
	return userID;
}
public void setUserID(int user) {
	this.userID = user;
}

public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}

}
