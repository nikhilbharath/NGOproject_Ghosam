package Model;

import java.util.HashMap;

public class RaasiMaster {
	
	private int raasiID;
	private String raasiName;
	
	private HashMap<Integer,String> raasilist;
	
	public int getRaasiID() {
		return raasiID;
	}
	public void setRaasiID(int starID) {
		this.raasiID = starID;
	}
	public String getRaasiName() {
		return raasiName;
	}
	public void setRaasiName(String starName) {
		this.raasiName = starName;
	}
	public HashMap<Integer,String> getRaasilist() {
		return raasilist;
	}
	public void setRaasilist(HashMap<Integer,String> raasilist) {
		this.raasilist = raasilist;
	}

}
