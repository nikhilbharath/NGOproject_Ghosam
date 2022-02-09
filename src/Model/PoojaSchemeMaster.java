package Model;

import java.util.HashMap;

public class PoojaSchemeMaster {
	
	
	private int PoojaSchemeID;
	private String PoojaScheme;
	
	private HashMap<Integer,String> poojalist;
	
	public int getPoojaSchemeID() {
		return PoojaSchemeID;
	}
	public void setPoojaSchemeID(int poojaSchemeID) {
		PoojaSchemeID = poojaSchemeID;
	}
	public String getPoojaScheme() {
		return PoojaScheme;
	}
	public void setPoojaScheme(String poojaScheme) {
		PoojaScheme = poojaScheme;
	}
	public HashMap<Integer,String> getPoojalist() {
		return poojalist;
	}
	public void setPoojalist(HashMap<Integer,String> poojalist) {
		this.poojalist = poojalist;
	}

}
