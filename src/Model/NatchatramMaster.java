package Model;

import java.util.HashMap;

public class NatchatramMaster {

	private int natchatramID;
	private String natchatramName;
	
	private HashMap<Integer,String> starlist;
	
	public int getNatchatramID() {
		return natchatramID;
	}
	public void setNatchatramID(int natchatramID) {
		this.natchatramID = natchatramID;
	}
	public String getNatchatramName() {
		return natchatramName;
	}
	public void setNatchatramName(String natchatramName) {
		this.natchatramName = natchatramName;
	}
	public HashMap<Integer,String> getStarlist() {
		return starlist;
	}
	public void setStarlist(HashMap<Integer,String> starlist) {
		this.starlist = starlist;
	}
	
}
